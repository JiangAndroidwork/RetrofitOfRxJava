package com.laojiang.retrofithttp.weight.model;


import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 类介绍（必填）：获取数据实体
 * Created by Jiang on 2017/3/9 9:11.
 */

public class RetrofitHttp implements RHInterface {
    private Context mContext;
    private static final long DEFAULT_TIMEOUT = 5;

    @Override
    public void getHttpData(boolean isCache, final Context context, RetrofitCallBackInterface backInterface, String url) {
        this.mContext = context;

        OkHttpClient mHttpClient = new OkHttpClient();

        Request request = new Request.Builder().url(url)
                .build();
        mHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
//成功获取数据
                if (response.isSuccessful()){
                    String json = response.body().toString();
                    Log.i("RetrofitHttp", "onResponse() returned: " + json);
                }
            }
        });
        File httpCacheDirectory = new File(context.getCacheDir(), "responses");
        int cacheSize = 10 * 1024 * 1024; // 10 M
        Cache cache = new Cache(httpCacheDirectory, cacheSize);

        //手动创建一个OkHttpClient并设置超时时间
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        //判断是否设置缓存
        if (isCache) {
            httpClientBuilder.addInterceptor(REWRITE_CACHE_CONTROL_INTERCEPTOR);
            httpClientBuilder.cache(cache);
        }


        OkHttpClient build = httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .build();
        //Retrofit加载http
        Retrofit retrofit = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        //回调接口
        backInterface.setCallBackService(retrofit);

    }

    Interceptor REWRITE_CACHE_CONTROL_INTERCEPTOR = chain -> {

        CacheControl.Builder cacheBuilder = new CacheControl.Builder();
        cacheBuilder.maxAge(0, TimeUnit.SECONDS);
        cacheBuilder.maxStale(365, TimeUnit.DAYS);
        CacheControl cacheControl = cacheBuilder.build();

        Request request = chain.request();
        if (!NetUtils.isNetworkAvailable(mContext)) {
            request = request.newBuilder()
                    .cacheControl(cacheControl)
                    .build();

        }
        Response originalResponse = chain.proceed(request);
        if (NetUtils.isNetworkAvailable(mContext)) {
            int maxAge = 0; // read from cache
            return originalResponse.newBuilder()
                    .removeHeader("Pragma")
                    .header("Cache-Control", "public ,max-age=" + maxAge)
                    .build();
        } else {
            int maxStale = 60 * 60 * 24 * 28; //
            return originalResponse.newBuilder()
                    .removeHeader("Pragma")
                    .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                    .build();

        }
    };
}
