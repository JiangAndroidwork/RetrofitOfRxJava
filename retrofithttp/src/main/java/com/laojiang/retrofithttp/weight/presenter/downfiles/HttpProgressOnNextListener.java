package com.laojiang.retrofithttp.weight.presenter.downfiles;

/**
 * 类介绍（必填）：请求结果 回调处理
 * Created by Jiang on 2017/3/21 15:16.
 */

public abstract class HttpProgressOnNextListener<T> {
    /**
     * 成功后回调方法
     * @param t
     */
    public abstract void onNext(T t);

    /**
     * 开始下载
     */
    public abstract void onStart();

    /**
     * 完成下载
     */
    public abstract void onComplete();


    /**
     * 下载进度
     * @param readLength
     * @param countLength
     */
    public abstract void updateProgress(long readLength, long countLength);

    /**
     * 失败或者错误方法
     * 主动调用，更加灵活
     *
     */
    public  void onError(String message,int code){

    }

    /**
     * 暂停下载
     */
    public void onPuase(){

    }

    /**
     * 停止下载销毁
     */
    public void onStop(){

    }
}
