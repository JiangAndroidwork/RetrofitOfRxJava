package com.laojiang.retrofitofrxjava.application;

import android.app.Application;

/**
 * 类介绍（必填）：
 * Created by Jiang on 2017/3/9 14:03.
 */

public class MyApplication extends Application{
    private MyApplication application;
    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }
    public MyApplication getInstance(){
        return application;
    }
}
