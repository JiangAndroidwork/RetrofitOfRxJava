package com.laojiang.retrofithttp.weight.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;

import com.laojiang.retrofithttp.R;
import com.laojiang.retrofithttp.weight.presenter.RetrofitPresenter;
import com.laojiang.retrofithttp.weight.weight.ApiException;

import retrofit2.Retrofit;


/**
 * 类介绍（必填）：UI 带有ProgressBar的 弹窗
 * Created by Jiang on 2017/3/9 8:26.
 */

public  class ProgressBarOfRetrofit  implements PBRViewInterface {
    private  ProgressBar mProgress;
    private  AlertDialog mDownloadDialog;
    private boolean isShowprogress = true;

    public AlertDialog getmDownloadDialog() {
        return mDownloadDialog;
    }

    private Context context;
    private RetrofitOfRxJavaCallBack callBack;
private String url;
    private ProgressBarCancel progressBarCancel;
    private boolean isCache;//是否缓存
    private static ProgressBarOfRetrofit progressBarOfRetrofit;

    private ProgressBarOfRetrofit(){

    }
    private   static class SingleFactory{
        public  static ProgressBarOfRetrofit progressBarOfRetrofit = new ProgressBarOfRetrofit();

    }

    private void setContext(Context context) {
        this.context = context;
    }

    private void setCallBack(RetrofitOfRxJavaCallBack callBack) {
        this.callBack = callBack;
    }

    private void setUrl(String url) {
        this.url = url;
    }

    private void setCache(boolean cache) {
        isCache = cache;
    }

    public static ProgressBarOfRetrofit getInstance(Context context,String url, RetrofitOfRxJavaCallBack callBack){
        char c = url.charAt(url.length() - 1);

        if (!(c+"").equals("/")){
            throw new ApiException(-1,"路径必须以/结尾");

        }

        if (progressBarOfRetrofit==null) {
            synchronized (ProgressBarOfRetrofit.class) {
                if (progressBarOfRetrofit == null) {
                    progressBarOfRetrofit = SingleFactory.progressBarOfRetrofit;
                }
            }

        }
        progressBarOfRetrofit.setCallBack(callBack);
        progressBarOfRetrofit.setUrl(url);
        progressBarOfRetrofit.setContext(context);
        return progressBarOfRetrofit;
    }

    /**
     * 单例模式
     * @return
     */
    public static ProgressBarOfRetrofit getInstance(){
    if (progressBarOfRetrofit!=null) {
        return progressBarOfRetrofit;
    }
    return null;
}

    /**
     * 开始获取数据
     * @param isCache 是否缓存
     */
    @Override
    public void setStart(boolean isCache) {
        RetrofitPresenter retrofitPresenter = new RetrofitPresenter(isCache, context, progressBarOfRetrofit.url, this);
        retrofitPresenter.getData();
    }

    /**
     * 显示弹窗
     */
    @Override
    public void showProgressBar() {
        if (mDownloadDialog!=null){
            mDownloadDialog.dismiss();
            mDownloadDialog=null;
        }
        // 构造软件下载对话框
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(R.string.soft_updating);
        // 给下载对话框增加进度条
        final LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.dialog_progress, null);
        mProgress = (ProgressBar) v.findViewById(R.id.update_progress);
        builder.setView(v);
        // 取消下载
        builder.setNegativeButton(R.string.soft_update_cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();

            }
        });
        mDownloadDialog = builder.create();
        mDownloadDialog.setCanceledOnTouchOutside(false);



        mDownloadDialog.show();
    }

    /**
     * 取消进度条
     */
    @Override
    public void disMissProgressBar() {
        if (mDownloadDialog!=null){
            mDownloadDialog.dismiss();
            mDownloadDialog=null;
        }
    }

    /**
     * 获取Retrofit并设置回调
     * @param backService
     */
    @Override
    public void setData(Retrofit backService) {
            callBack.callBack(backService);
    }

    /**
     * 获取是否显示进度条的状态
     * @return
     */
    @Override
    public boolean isShowProgress() {
        return isShowprogress;
    }

    /**
     * 设置是否显示 进度条
     * @param isShow
     */
    public void setProgressState(boolean isShow){
        isShowprogress = isShow;

    }

}
