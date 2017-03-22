package com.laojiang.retrofitofrxjava.downfilesutils.manage;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.laojiang.retrofitofrxjava.downfilesutils.HttpService;
import com.laojiang.retrofitofrxjava.downfilesutils.downfiles.ApiDownSubscriber;
import com.laojiang.retrofitofrxjava.downfilesutils.downfiles.DownInfo;
import com.laojiang.retrofitofrxjava.downfilesutils.downfiles.DownState;
import com.laojiang.retrofitofrxjava.downfilesutils.downfiles.DownloadInterceptor;
import com.laojiang.retrofitofrxjava.downfilesutils.exception.HttpTimeException;
import com.laojiang.retrofitofrxjava.downfilesutils.exception.RetryWhenNetworkException;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * http下载处理类
 * Created by WZG on 2016/7/16.
 */
public class HttpDownManager {
    /*记录下载数据*/
    private Set<DownInfo> downInfos;
    /*回调sub队列*/
    private HashMap<String,ApiDownSubscriber> subMap;
    /*单利对象*/
    private volatile static HttpDownManager INSTANCE;

    private HttpDownManager(){
        downInfos=new HashSet<>();
        subMap=new HashMap<>();
    }

    /**
     * 获取单例
     * @return
     */
    public static HttpDownManager getInstance() {
        if (INSTANCE == null) {
            synchronized (HttpDownManager.class) {
                if (INSTANCE == null) {
                    INSTANCE = new HttpDownManager();
                }
            }
        }
        return INSTANCE;
    }


    /**
     * 开始下载
     */
    public void startDown(final DownInfo info){
        /*正在下载不处理*/
        if(info==null||subMap.get(info.getUrl())!=null){
            return;
        }
        /*添加回调处理类*/
        ApiDownSubscriber subscriber=new ApiDownSubscriber(info);
        /*记录回调sub*/
        subMap.put(info.getUrl(),subscriber);
        /*获取service，多次请求公用一个sercie*/
        HttpService httpService;
        if(downInfos.contains(info)){
            httpService=info.getService();
        }else{
            DownloadInterceptor interceptor = new DownloadInterceptor(subscriber);
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            //手动创建一个OkHttpClient并设置超时时间
            builder.connectTimeout(info.getConnectionTime(), TimeUnit.SECONDS);
            builder.addInterceptor(interceptor);

            Retrofit retrofit = new Retrofit.Builder()
                    .client(builder.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .baseUrl(info.getBaseUrl())
                    .build();
            httpService= retrofit.create(HttpService.class);
            info.setService(httpService);
        }
        /*得到rx对象-上一次下載的位置開始下載*/
        httpService.download("bytes=" + info.getReadLength() + "-",info.getUrl())
                /*指定线程*/
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                   /*失败后的retry配置*/
                .retryWhen(new RetryWhenNetworkException())
                /*读取下载写入文件*/
                .map(new Function<ResponseBody, DownInfo>() {
                    @Override
                    public DownInfo apply(ResponseBody responseBody) throws Exception {
                        try {
                            writeCache(responseBody,new File(info.getSavePath()),info);
                        } catch (IOException e) {
                            /*失败抛出异常*/
                            throw new HttpTimeException(e.getMessage());
                        }
                        return info;
                    }
                })
                /*回调线程*/
                .observeOn(AndroidSchedulers.mainThread())
                /*数据回调*/
                .subscribe(subscriber);

    }


    /**
     * 停止下载
     */
    public void stopDown(DownInfo info){
        if(info==null)return;
        info.setState(DownState.STOP);
        info.getListener().onStop();
        if(subMap.containsKey(info.getUrl())) {
            ApiDownSubscriber subscriber=subMap.get(info.getUrl());
            subscriber.setCancel();
            subMap.remove(info.getUrl());
        }
        /*同步数据库*/
    }


    /**
     * 删除
     * @param info
     */
    public void deleteDown(DownInfo info){
        stopDown(info);
         /*删除数据库信息和本地文件*/
    }


    /**
     * 暂停下载
     * @param info
     */
    public void pause(DownInfo info){
        if(info==null)return;
        info.setState(DownState.PAUSE);
        info.getListener().onPuase();
        if(subMap.containsKey(info.getUrl())){
            ApiDownSubscriber subscriber=subMap.get(info.getUrl());
            subscriber.setCancel();//取消订阅
            subMap.remove(info.getUrl());
        }
        /*这里需要讲info信息写入到数据中，可自由扩展，用自己项目的数据库*/
    }

    /**
     * 停止全部下载
     */
    public void stopAllDown(){
        for (DownInfo downInfo : downInfos) {
            stopDown(downInfo);
        }
        subMap.clear();
        downInfos.clear();
    }

    /**
     * 暂停全部下载
     */
    public void pauseAll(){
        for (DownInfo downInfo : downInfos) {
            pause(downInfo);
        }
        subMap.clear();
        downInfos.clear();
    }


    /**
     * 返回全部正在下载的数据
     * @return
     */
    public Set<DownInfo> getDownInfos() {
        return downInfos;
    }


    /**
     * 写入文件
     * @param file
     * @param info
     * @throws IOException
     */
    public void writeCache(ResponseBody responseBody,File file,DownInfo info) throws IOException{
        if (!file.getParentFile().exists())
            file.getParentFile().mkdirs();
        long allLength;
        if (info.getCountLength()==0){
            allLength=responseBody.contentLength();
        }else{
            allLength=info.getCountLength();
        }
            FileChannel channelOut = null;
            RandomAccessFile randomAccessFile = null;
            randomAccessFile = new RandomAccessFile(file, "rwd");
            channelOut = randomAccessFile.getChannel();
            MappedByteBuffer mappedBuffer = channelOut.map(FileChannel.MapMode.READ_WRITE,
                    info.getReadLength(),allLength-info.getReadLength());
            byte[] buffer = new byte[1024*8];
            int len;
            int record = 0;
            while ((len = responseBody.byteStream().read(buffer)) != -1) {
                mappedBuffer.put(buffer, 0, len);
                record += len;
            }
            responseBody.byteStream().close();
                if (channelOut != null) {
                    channelOut.close();
                }
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
    }

}
