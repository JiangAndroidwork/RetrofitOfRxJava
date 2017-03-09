package com.laojiang.retrofitofrxjava;


import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 类介绍（必填）：
 * Created by Jiang on 2017/3/9 10:15.
 */

public interface RetrofitMethodsInterface  {
    @GET("getGradeExams")
    Flowable<TestBean> getRetrofitData(@Query("accessToken") String accessToken);
}
