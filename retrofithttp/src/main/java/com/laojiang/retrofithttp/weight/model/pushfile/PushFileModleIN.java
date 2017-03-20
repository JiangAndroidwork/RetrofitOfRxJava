package com.laojiang.retrofithttp.weight.model.pushfile;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;

/**
 * 类介绍（必填）：
 * Created by Jiang on 2017/3/20 10:03.
 */

public interface PushFileModleIN  {
    void setRequestBody(File file, MediaType mediaType,String request,PushFileModelBackData backData);
    MultipartBody.Part getMultipartBodyPart();
}
