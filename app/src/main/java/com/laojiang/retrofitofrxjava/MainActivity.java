package com.laojiang.retrofitofrxjava;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.laojiang.retrofithttp.weight.ui.ProgressBarOfRetrofit;
import com.laojiang.retrofithttp.weight.ui.RetrofitOfRxJavaCallBack;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

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

    private void init() {
        ProgressBarOfRetrofit pbr = new ProgressBarOfRetrofit(this, "http://cloud.bjhj.com.cn/cloudapi/parents/", new RetrofitOfRxJavaCallBack() {
        @Override
        public void callBack(Retrofit backService, final AlertDialog dialog) {
            RetrofitMethodsInterface rmi = backService.create(RetrofitMethodsInterface.class);
            rmi.getRetrofitData("c37d4e1edf827e851d8aa9e4a7ff3059")
                    .delay(5, TimeUnit.SECONDS)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<TestBean>() {
                        @Override
                        public void onSubscribe(Subscription s) {
                            s.request(Long.MAX_VALUE);
                        }

                        @Override
                        public void onNext(TestBean testBeanRxCacheResult) {

                            Log.i("http请求","获取数据="+testBeanRxCacheResult);
                        }

                        @Override
                        public void onError(Throwable t) {
                            Log.i("http请求","出现错误="+t.getMessage());
                            dialog.dismiss();
                        }

                        @Override
                        public void onComplete() {
                            dialog.dismiss();
                        }
                    });

        }
    });
    }



}
