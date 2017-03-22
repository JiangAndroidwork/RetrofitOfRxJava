package com.laojiang.retrofithttp.weight.downfilesutils;

import io.reactivex.Flowable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * 类介绍（必填）：service接口Retrofit
 * Created by Jiang on 2017/3/9 10:15.
 */
public interface HttpService {

    /*断点续传下载接口*/
    @Streaming
    @GET
    Flowable<ResponseBody> download(@Header("RANGE") String start, @Url String url);

}
