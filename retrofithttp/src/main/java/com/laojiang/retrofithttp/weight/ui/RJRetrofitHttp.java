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

public class RJRetrofitHttp implements PBRViewInterface {
    private ProgressBar mProgress;
    private AlertDialog mDownloadDialog;
    private boolean isShowprogress = false;

    public AlertDialog getmDownloadDialog() {
        return mDownloadDialog;
    }

    private Context context;
    private RetrofitOfRxJavaCallBack callBack;
    private String url;
    private ProgressBarCancel progressBarCancel;
    private boolean isCache;//是否缓存
    private static RJRetrofitHttp rjRetrofitHttp;

    private RJRetrofitHttp() {

    }

    private static class SingleFactory {
        public static RJRetrofitHttp RJRetrofitHttp = new RJRetrofitHttp();

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

    public static RJRetrofitHttp load(Context context, String url, RetrofitOfRxJavaCallBack callBack) {
        char c = url.charAt(url.length() - 1);

        if (!(c + "").equals("/")) {
            throw new ApiException(-1, "路径必须以/结尾");

        }

        if (rjRetrofitHttp == null) {
            synchronized (RJRetrofitHttp.class) {
                if (rjRetrofitHttp == null) {
                    rjRetrofitHttp = SingleFactory.RJRetrofitHttp;
                }
            }

        }
        rjRetrofitHttp.setCallBack(callBack);
        rjRetrofitHttp.setUrl(url);
        rjRetrofitHttp.setContext(context);

        return rjRetrofitHttp;
    }

    /**
     * 单例模式
     *
     * @return
     */
    public static RJRetrofitHttp load() {
        if (rjRetrofitHttp != null) {
            return rjRetrofitHttp;
        }
        return null;
    }

    /**
     * 开始获取数据
     *
     * @param isCache 是否缓存
     */
    @Override
    public RJRetrofitHttp start(boolean isCache) {
        RetrofitPresenter retrofitPresenter = new RetrofitPresenter(isCache, context, rjRetrofitHttp.url, this);
        retrofitPresenter.getData();
        return this;
    }

    public RJRetrofitHttp start() {
        RetrofitPresenter retrofitPresenter = new RetrofitPresenter(false, context, rjRetrofitHttp.url, this);

        retrofitPresenter.getData();
        return this;
    }
    public RJRetrofitHttp start(long timeOut) {
        RetrofitPresenter retrofitPresenter = new RetrofitPresenter(false, context, rjRetrofitHttp.url, this);
        retrofitPresenter.setTimeOut(timeOut);
        retrofitPresenter.getData();
        return this;
    }
    /**
     * 显示弹窗
     */
    @Override
    public void showProgressBar() {
        if (mDownloadDialog != null) {
            mDownloadDialog.dismiss();
            mDownloadDialog = null;
        }
        // 构造软件下载对话框
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("正在加载...");
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
        if (mDownloadDialog != null) {
            mDownloadDialog.dismiss();
            mDownloadDialog = null;
        }
    }

    /**
     * 获取Retrofit并设置回调
     *
     * @param backService
     */
    @Override
    public void setData(Retrofit backService) {
        callBack.callBack(backService);
    }

    /**
     * 获取是否显示进度条的状态
     *
     * @return
     */
    @Override
    public boolean isShowProgress() {
        return isShowprogress;
    }

    /**
     * 设置是否显示 进度条
     *
     * @param isShow
     */
//    public RJRetrofitHttp setProgressState(boolean isShow) {
//        isShowprogress = isShow;
//        return this;
//    }

}
