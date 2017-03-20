package com.laojiang.retrofithttp.weight.model;

/**
 * 类介绍（必填）：progress回调接口
 * Created by Jiang on 2017/3/20 9:23.
 */

public interface UploadProgressListener {
    //上传进度
    void onProgress(long currentBytesCount, long totalBytesCount);
}
