package com.laojiang.retrofithttp.weight.presenter.pushfile;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;

/**
 * 类介绍（必填）：
 * Created by Jiang on 2017/3/20 10:13.
 */

public interface PushFilePresenterIN {

    MultipartBody.Part startModel(File file, String request, MediaType mediaType);
}
