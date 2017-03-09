package com.laojiang.retrofithttp.weight.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;

import com.laojiang.retrofithttp.R;
import com.laojiang.retrofithttp.weight.presenter.RetrofitPresenter;

import retrofit2.Retrofit;


/**
 * 类介绍（必填）：UI 带有ProgressBar的 弹窗
 * Created by Jiang on 2017/3/9 8:26.
 */

public  class ProgressBarOfRetrofit  implements PBRViewInterface {
    private  ProgressBar mProgress;
    private  AlertDialog mDownloadDialog;
    private Context context;
    private RetrofitOfRxJavaCallBack callBack;
private String url;
    private final RetrofitPresenter retrofitPresenter;

    public ProgressBarOfRetrofit(Context context, String url, RetrofitOfRxJavaCallBack callBack) {
        this.callBack = callBack;
        this.url = url;
        this.context = context;
        retrofitPresenter = new RetrofitPresenter(context,url,this,mDownloadDialog);
        retrofitPresenter.getData();
    }

    @Override
    public void showProgressBar() {
        // 构造软件下载对话框
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(R.string.soft_updating);
        // 给下载对话框增加进度条
        final LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.dialog_softupdate_progress, null);
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

    @Override
    public void disMissProgressBar() {
        if (mDownloadDialog!=null){
            mDownloadDialog.dismiss();
        }
    }

    @Override
    public void setData(Retrofit backService, AlertDialog dialog) {
            callBack.callBack(backService,mDownloadDialog);
    }


}
