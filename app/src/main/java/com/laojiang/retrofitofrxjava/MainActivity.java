package com.laojiang.retrofitofrxjava;

import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.laojiang.retrofithttp.weight.downfilesutils.FinalDownFiles;
import com.laojiang.retrofithttp.weight.downfilesutils.action.FinalDownFileResult;
import com.laojiang.retrofithttp.weight.downfilesutils.downfiles.DownInfo;
import com.laojiang.retrofithttp.weight.downfilesutils.manage.HttpDownManager;
import com.laojiang.retrofithttp.weight.ui.RJRetrofitHttp;
import com.laojiang.retrofithttp.weight.ui.RetrofitOfRxJavaCallBack;
import com.laojiang.retrofithttp.weight.ui.pushfile.PushFileManage;
import com.laojiang.retrofithttp.weight.weight.ApiFunction;
import com.laojiang.retrofithttp.weight.weight.ApiSubscriber;
import com.laojiang.retrofitofrxjava.bean.ESLoginBean;
import com.laojiang.retrofitofrxjava.bean.PushFileBean;

import java.io.File;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Retrofit;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private static final String STR_URL = "http://www.meetyuu.com/mobileServer/";
    private HttpDownManager manager;
    private TextView textView;
    private DownInfo apkApi;
    private ProgressBar progressBar2;
    private DownInfo apkApi2;
    private TextView textView2;
    private HttpDownManager manager2;
    private FinalDownFiles finalDownFiles;
    private Button btDown;
    private Button btPause;
    private Button btStop;
    private ProgressBar progressBar;
    private boolean isPause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        Button pushFIle = (Button) findViewById(R.id.push_file);
        btDown = (Button) findViewById(R.id.bt_start);
        btPause = (Button) findViewById(R.id.bt_pause);
        btStop = (Button) findViewById(R.id.bt_end);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        btDown.setOnClickListener(this);
        btPause.setOnClickListener(this);
        btStop.setOnClickListener(this);

        pushFIle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initPush();
            }
        });
        init();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        finalDownFiles.stopAll();
    }

    /**
     * 上传文件
     */
    private void initPush() {
        final PushFileManage pushFileManage = new PushFileManage(this, true, new File("/storage/emulated/0/DCIM/Camera/IMG_20170202_094844.jpg"), "file", "image/jpg");
        final MultipartBody.Part part = pushFileManage.pushFileBackPart();

        final RequestBody uid = RequestBody.create(MediaType.parse("text/plain"), "72");
        final RequestBody key = RequestBody.create(MediaType.parse("text/plain"), "45ab2fbbdd5ac8aec951f219f33fb5cc");
        RJRetrofitHttp pBR = RJRetrofitHttp.load(this,
                "http://sss/cloudapi/teacher/", new RetrofitOfRxJavaCallBack() {
                    @Override
                    public void callBack(Retrofit retrofit) {
                        retrofit.create(RetrofitService.class)
                                .uploadImage(uid, key, part)
                                .subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new ApiSubscriber<PushFileBean>() {
                                    @Override
                                    protected void onError(String msg, int code) {
                                        Log.i("失败的信息==", msg);
                                    }

                                    @Override
                                    protected void onSuceess(PushFileBean pushFileBean) {
                                        Log.i("输出信息==", pushFileBean.toString());
                                    }
                                });
                    }
                }).start();
    }

    /**
     * c37d4e1edf827e851d8aa9e4a7ff3059
     * <p>
     * 9969171b881c7f74c32558e11b86936f
     * https://api.douban.com/v2/movie/
     */
    private void init() {

        RJRetrofitHttp ss = RJRetrofitHttp.load(this, STR_URL, new RetrofitOfRxJavaCallBack() {
            @Override
            public void callBack(Retrofit retrofit) {
                retrofit.create(RetrofitService.class)
                        .esLogin("jianghongli", "123456")
                        .map(new ApiFunction<ESLoginBean.ResultEntity>())
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new ApiSubscriber<ESLoginBean.ResultEntity>() {
                            @Override
                            protected void onError(String msg, int code) {

                            }

                            @Override
                            protected void onSuceess(ESLoginBean.ResultEntity resultEntity) {
                                Log.i("登录成功==", resultEntity.toString());
                            }
                        });
                Call.Factory factory = retrofit.callFactory();
            }
        }).start();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_start:
                btPause.setEnabled(true);
                String[] downUrl = new String[]{"http://dl.download.csdn.net/down11/20170503/2195972fbbe868b8c91b01533c324782.zip?response-content-disposition=attachment%3Bfilename%3D%22JDK1.6%20%E6%BA%90%E7%A0%81_%E5%85%A8%E5%8C%85%EF%BC%88%E5%8C%85%E5%90%ABsun%E5%8C%85%EF%BC%89.zip%22&OSSAccessKeyId=9q6nvzoJGowBj4q1&Expires=1493795832&Signature=oyfoO1O4A7j2frzGgdDqriy8f%2BI%3D"};
                finalDownFiles = new FinalDownFiles(false, this, downUrl[0],
                        getOutUrlStr(), new FinalDownFileResult() {
                    @Override
                    public void onLoading(long readLength, long countLength) {
                        super.onLoading(readLength, countLength);
                        progressBar.setMax((int) countLength);
                        progressBar.setProgress((int) readLength);
                    }

                    @Override
                    public void onCompleted() {
                        super.onCompleted();
                        btPause.setEnabled(false);
                        finalDownFiles.setStop();
                    }

                    @Override
                    public void onErroe(String message, int code) {
                        super.onErroe(message, code);
                        Log.i("出错==", message.toString() + "\n" + code);
                        //当网络连接断开的时候 code为-5
                        if (code == -5) {
                            finalDownFiles.setPause();
                            btPause.setText("继续");
                            isPause = true;
                        }
                    }

                });
                DownInfo downInfo = finalDownFiles.getDownInfo();
                downInfo.setConnectionTime(3);
                break;
            case R.id.bt_pause:
                if (isPause) {
                    btPause.setText("暂停");
                    if (finalDownFiles != null)
                        finalDownFiles.setRestart();
                    isPause = false;
                } else {
                    if (finalDownFiles != null)
                        finalDownFiles.setPause();
                    btPause.setText("继续");
                    isPause = true;
                }
                break;
            case R.id.bt_end:
                if (finalDownFiles != null) {
                    finalDownFiles.setStop();
                    btPause.setEnabled(false);
                }
                break;
        }
    }

    @NonNull
    private String getOutUrlStr() {
        return Environment.getExternalStorageDirectory() + "/bjhj/accessory/izaodao_app.apk";
    }

}
