package com.laojiang.retrofithttp.weight.ui;

import retrofit2.Retrofit;


/**
 * 类介绍（必填）：UIProgressBar动作接口
 * Created by Jiang on 2017/3/9 8:28.
 */

public interface PBRViewInterface  {
    void setStart(boolean isCache);
    void showProgressBar();
    void disMissProgressBar();
    void setData(Retrofit backService);
    boolean isShowProgress();
}
