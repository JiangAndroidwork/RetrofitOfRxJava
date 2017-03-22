package com.laojiang.retrofitofrxjava;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.laojiang.retrofithttp.weight.ui.ProgressBarOfRetrofit;
import com.laojiang.retrofithttp.weight.ui.RetrofitOfRxJavaCallBack;
import com.laojiang.retrofithttp.weight.ui.pushfile.PushFileManage;
import com.laojiang.retrofithttp.weight.weight.ApiSubscriber;
import com.laojiang.retrofitofrxjava.bean.PushFileBean;
import com.laojiang.retrofitofrxjava.bean.TestHomeWork;
import com.laojiang.retrofitofrxjava.downfilesutils.FinalDownFiles;
import com.laojiang.retrofitofrxjava.downfilesutils.HttpService;
import com.laojiang.retrofitofrxjava.downfilesutils.action.FinalDownFileResult;
import com.laojiang.retrofitofrxjava.downfilesutils.downfiles.DownInfo;
import com.laojiang.retrofitofrxjava.downfilesutils.manage.HttpDownManager;

import java.io.File;
import java.util.concurrent.TimeUnit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Retrofit;


public class MainActivity extends AppCompatActivity {


    private static final String STR_URL = "http://sss/cloudapi/teacher/";
    private HttpDownManager manager;
    private TextView textView;
    private ProgressBar progressBar;
    private DownInfo apkApi;
    private ProgressBar progressBar2;
    private DownInfo apkApi2;
    private TextView textView2;
    private HttpDownManager manager2;
    private FinalDownFiles finalDownFiles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = HttpDownManager.getInstance();
        manager2 = HttpDownManager.getInstance();
        textView = (TextView) findViewById(R.id.textView);
        Button pushFIle = (Button) findViewById(R.id.push_file);
        Button downFile = (Button) findViewById(R.id.down_file);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        downFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inidown();
            }
        });
        pushFIle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initPush();
            }
        });



    }



    private void inidown() {
        String[] downUrl=new String[]{"http://www.izaodao.com/app/izaodao_app.apk",
                "http://download.fir.im/v2/app/install/572eec6fe75e2d7a05000008?download_token=572bcb03dad2eed7c758670fd23b5ac4"};


        finalDownFiles = new FinalDownFiles(this,downUrl[0], Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)+
                "/test"+0 + ".apk",new FinalDownFileResult(){
            @Override
            public void onStop() {
                super.onStop();
                Log.i("结束了一切","是的没错");
            }
        });
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
                "http://114.215.142.151/cloudapi/teacher/", new RetrofitOfRxJavaCallBack() {
                    @Override
                    public void callBack(Retrofit retrofit) {
                        retrofit.create(HttpService.class)
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
                retrofit.create(HttpService.class)
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
}
