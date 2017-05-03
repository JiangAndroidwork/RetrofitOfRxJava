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
import com.laojiang.retrofithttp.weight.ui.ProgressBarOfRetrofit;
import com.laojiang.retrofithttp.weight.ui.RetrofitOfRxJavaCallBack;
import com.laojiang.retrofithttp.weight.ui.pushfile.PushFileManage;
import com.laojiang.retrofithttp.weight.weight.ApiSubscriber;
import com.laojiang.retrofitofrxjava.bean.PushFileBean;
import com.laojiang.retrofitofrxjava.bean.TestHomeWork;

import java.io.File;
import java.util.concurrent.TimeUnit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Retrofit;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private static final String STR_URL = "http://sss/cloudapi/teacher/";
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
//        init();
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
        final PushFileManage pushFileManage = new PushFileManage(this,new File("/storage/emulated/0/DCIM/Camera/IMG_20170202_094844.jpg"),"file","image/jpg");
        final MultipartBody.Part part = pushFileManage.pushFileBackPart();

        final RequestBody uid= RequestBody.create(MediaType.parse("text/plain"), "72");
        final RequestBody key = RequestBody.create(MediaType.parse("text/plain"), "45ab2fbbdd5ac8aec951f219f33fb5cc");
        ProgressBarOfRetrofit pBR = ProgressBarOfRetrofit.getInstance(this,
                "http://sss/cloudapi/teacher/", new RetrofitOfRxJavaCallBack() {
                    @Override
                    public void callBack(Retrofit retrofit) {
                        retrofit.create(RetrofitService.class)
                                .uploadImage(uid,key,part)
                                .subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new ApiSubscriber<PushFileBean>() {
                                    @Override
                                    protected void onError(String msg, int code) {
                                        Log.i("失败的信息==",msg);
                                    }

                                    @Override
                                    protected void onSuceess(PushFileBean pushFileBean) {
                                Log.i("输出信息==",pushFileBean.toString());
                                    }
                                });
                    }
                });
        pBR.setProgressState(false);
        pBR.setStart(false);
    }

    /**
     * c37d4e1edf827e851d8aa9e4a7ff3059
     *
     *9969171b881c7f74c32558e11b86936f
     * https://api.douban.com/v2/movie/
     *
     *
     */
    private void init() {

        ProgressBarOfRetrofit ss = ProgressBarOfRetrofit.getInstance(this,STR_URL,new RetrofitOfRxJavaCallBack() {
            @Override
            public void callBack(Retrofit retrofit) {
                retrofit.create(RetrofitService.class)
                        .getHomeWork("9969171b881c7f74c32558e11b86936f")
                        .delay(5, TimeUnit.SECONDS)
//                       .map(new ApiFunction<List<TestHomeWork.ResultEntity>>())
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new ApiSubscriber<TestHomeWork>() {
                            @Override
                            protected void onError(String msg,int code) {
                                Log.i("错误==",msg.toString());
                            }

                            @Override
                            protected void onSuceess(TestHomeWork testHomeWork) {
                                Log.i("输出数据--",testHomeWork.toString());
                            }
                        });

            }
        });
        ss.setProgressState(false);
        ss.setStart(false);

        }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_start:
                String[] downUrl=new String[]{"http://www.izaodao.com/app/izaodao_app.apk"};
                finalDownFiles = new FinalDownFiles(false,this,downUrl[0],
                        getOutUrlStr(),new FinalDownFileResult(){
                    @Override
                    public void onLoading(long readLength, long countLength) {
                        super.onLoading(readLength, countLength);
                        progressBar.setMax((int)countLength);
                        progressBar.setProgress((int)readLength);
                    }

                    @Override
                    public void onCompleted() {
                        super.onCompleted();
                        btPause.setEnabled(false);
                    }
                });
                break;
            case R.id.bt_pause:
                if (isPause){
                    btPause.setText("暂停");
                    if (finalDownFiles!=null)
                        finalDownFiles.setRestart();
                    isPause = false;
                }else {
                    if (finalDownFiles!=null)
                        finalDownFiles.setPause();
                    btPause.setText("继续");
                    isPause = true;
                }
                break;
            case R.id.bt_end:
                if (finalDownFiles!=null){
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
