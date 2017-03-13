package com.laojiang.retrofitofrxjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.laojiang.retrofithttp.weight.ui.ProgressBarOfRetrofit;
import com.laojiang.retrofithttp.weight.ui.RetrofitOfRxJavaCallBack;
import com.laojiang.retrofithttp.weight.weight.ApiFunction;
import com.laojiang.retrofithttp.weight.weight.ApiSubscriber;
import com.laojiang.retrofitofrxjava.bean.GetInfo;

import java.util.List;
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
     *
     * https://api.douban.com/v2/movie/
     *
     * http://cloud.bjhj.com.cn/cloudapi/teacher/
     */
    private void init() {

        ProgressBarOfRetrofit ss = ProgressBarOfRetrofit.getInstance(this, "http://cloud.bjhj.com.cn/cloudapi/teacher/",new RetrofitOfRxJavaCallBack() {
            @Override
            public void callBack(Retrofit retrofit) {
                retrofit.create(RetrofitMethodsInterface.class)
                        .getExamGetMyInfo("9969171b881c7f74c32558e11b86936f")
                        .delay(5, TimeUnit.SECONDS)
                        .map(new ApiFunction<List<GetInfo.ResultEntity>>())
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new ApiSubscriber<List<GetInfo.ResultEntity>>() {
                            @Override
                            protected void onError(String msg) {
                                    Log.i("出错==",msg.toString());
                            }

                            @Override
                            protected void onSuceess(List<GetInfo.ResultEntity> resultEntities) {
                                Log.i("输出结果--",resultEntities.toString());
                            }
                        });
            }
        });

     ss.setStart(false);

    }



}
