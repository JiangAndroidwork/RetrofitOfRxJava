package com.laojiang.retrofithttp.weight.ui;

import android.app.AlertDialog;

import retrofit2.Retrofit;


/**
 * 类介绍（必填）：UIProgressBar动作接口
 * Created by Jiang on 2017/3/9 8:28.
 */

public interface PBRViewInterface  {
    void showProgressBar();
    void disMissProgressBar();
    void setData(Retrofit backService, AlertDialog dialog);
}
