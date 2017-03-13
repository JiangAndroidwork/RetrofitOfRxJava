package com.laojiang.retrofitofrxjava;


import com.laojiang.retrofithttp.weight.bean.BaseReponse;
import com.laojiang.retrofitofrxjava.bean.GetInfo;
import com.laojiang.retrofitofrxjava.bean.TestBean;
import com.laojiang.retrofitofrxjava.bean.TestHttp;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 类介绍（必填）：
 * Created by Jiang on 2017/3/9 10:15.
 */

public interface RetrofitMethodsInterface  {
    @GET("getGradeExams")
    Flowable<TestBean> getRetrofitData(@Query("classId") int classId, @Query("accessToken") String accessToken);
    @GET("top250")
    Flowable<TestHttp> getRetrofitData(@Query("start") int start, @Query("count") int count);

    @GET("getCourseListApp")
    Flowable<BaseReponse<List<TestBean.ResultEntity>>> getRequest(@Query("accessToken") String accessToken,
                                                                  @Query("weekly") int weekly);
    @GET("examGetMyInfo")
    Flowable<BaseReponse<List<GetInfo.ResultEntity>>> getExamGetMyInfo(@Query("accessToken") String accessToken);
}
