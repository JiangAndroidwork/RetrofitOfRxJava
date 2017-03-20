package com.laojiang.retrofithttp.weight.model.pushfile;

import com.laojiang.retrofithttp.weight.model.UploadProgressListener;
import com.laojiang.retrofithttp.weight.weight.ProgressRequestBody;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * 类介绍（必填）：
 * Created by Jiang on 2017/3/20 9:55.
 */

public class PushFileModel implements PushFileModleIN{


    private MultipartBody.Part part;

    @Override
    public void setRequestBody(File file, MediaType mediaType, String request, PushFileModelBackData backData) {

        RequestBody requestBody=RequestBody.create(mediaType,file);
        part = MultipartBody.Part.createFormData(request,file.getName(),
                new ProgressRequestBody(requestBody, new UploadProgressListener() {
                    @Override
                    public void onProgress(long currentBytesCount, long totalBytesCount) {
                        backData.getProgressState(currentBytesCount,totalBytesCount);
                    }
                }));
    }

    @Override
    public MultipartBody.Part getMultipartBodyPart() {
        return part;
    }

}
