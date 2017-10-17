package com.laojiang.retrofithttp.weight.ui.pushfile;

import android.widget.ProgressBar;

import com.laojiang.retrofithttp.weight.model.pushfile.PushFileModelBackData;

import okhttp3.MultipartBody;

/**
 * 类介绍（必填）：
 * Created by Jiang on 2017/3/20 9:48.
 */

public interface PushFileInterface {
    void showProgress();

    void dissmissProgress();
    boolean isShowProgress();
    ProgressBar getProgress();
    PushFileModelBackData getProgressData();//获取上传文件的进度 接口
    MultipartBody.Part pushFileBackPart();
}
