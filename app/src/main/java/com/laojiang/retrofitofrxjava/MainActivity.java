package com.laojiang.retrofitofrxjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.laojiang.retrofithttp.weight.ui.ProgressBarOfRetrofit;
import com.laojiang.retrofithttp.weight.ui.RetrofitOfRxJavaCallBack;
import com.laojiang.retrofithttp.weight.weight.ApiSubscriber;

import java.util.concurrent.TimeUnit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    /**
     * c37d4e1edf827e851d8aa9e4a7ff3059
     * "http://cloud.bjhj.com.cn/cloudapi/parents/"
     */
    private void init() {

        ProgressBarOfRetrofit ss = ProgressBarOfRetrofit.getInstance(this, "http://cloud.bjhj.com.cn/cloudapi/parents/",new RetrofitOfRxJavaCallBack() {
            @Override
            public void callBack(Retrofit retrofit) {
                retrofit.create(RetrofitMethodsInterface.class)
                        .getRetrofitData("c37d4e1edf827e851d8aa9e4a7ff3059")
                        .delay(5, TimeUnit.SECONDS)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new ApiSubscriber<TestBean>() {
                            @Override
                            protected void onError(String msg) {
                                Log.i("错误==",msg.toString());
                            }

                            @Override

                            protected void onSuceess(TestBean testBean) {
                                Log.i("输出数据==",testBean.toString());

                            }
                        });
            }
        });

     ss.setStart(false);

    }



}
