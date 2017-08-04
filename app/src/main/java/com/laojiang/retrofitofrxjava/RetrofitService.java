package com.laojiang.retrofitofrxjava;

import com.laojiang.retrofithttp.weight.bean.BaseReponseResult;
import com.laojiang.retrofitofrxjava.bean.GetInfo;
import com.laojiang.retrofitofrxjava.bean.PushFileBean;
import com.laojiang.retrofitofrxjava.bean.TestBean;
import com.laojiang.retrofitofrxjava.bean.TestHomeWork;
import com.laojiang.retrofitofrxjava.bean.TestHttp;

import java.util.List;

import io.reactivex.Flowable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * 类介绍（必填）：同意http请求接口文档
 * Created by Jiang on 2017/3/22 14:58.
 */

public interface RetrofitService {
    @GET("getGradeExams")
    Flowable<TestBean> getRetrofitDatas(@Query("accessToken") String accessToken);
    @GET("top250")
    Flowable<TestHttp> getRetrofitData(@Query("start") int start, @Query("count") int count);
    @GET("examGetMyInfo")
    Flowable<BaseReponseResult<List<GetInfo.ResultEntity>>> getExamGetMyInfo(@Query("accessToken") String accessToken);
    @GET("getHomeworkClass")
    Flowable<TestHomeWork> getHomeWork(@Query("accessToken") String accessToken);
    /*上传文件*/
    @Multipart
    @POST("classalbumUpload")
    Flowable<PushFileBean> uploadImage(@Part("albumId") RequestBody albumId, @Part("accessToken") RequestBody accessToken, @Part MultipartBody.Part file);
}
