package com.laojiang.retrofithttp.weight.ui.pushfile;

import android.widget.ProgressBar;

import okhttp3.MultipartBody;

/**
 * 类介绍（必填）：
 * Created by Jiang on 2017/3/20 9:48.
 */

public interface PushFileInterface {
    void showProgress();
    void dissmissProgress();
     ProgressBar getProgress();
    MultipartBody.Part pushFileBackPart();
}
