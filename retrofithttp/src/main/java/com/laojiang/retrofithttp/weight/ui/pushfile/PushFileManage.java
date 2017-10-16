package com.laojiang.retrofithttp.weight.ui.pushfile;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;

import com.laojiang.retrofithttp.R;
import com.laojiang.retrofithttp.weight.presenter.pushfile.PushFilePresenter;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;

/**
 * 类介绍（必填）:上传文件 view
 * Created by Jiang on 2017/3/20 9:44.
 */

public class PushFileManage implements PushFileInterface {

    private Context context;
    private AlertDialog mDownloadDialog;
    private ProgressBar mProgress;
    private final PushFilePresenter pushFilePresenter;
    private File file;
    private String request;
    private String fileType;
    private boolean isShowProgress = false;//
    private CancelCallBack cancelListener;
    public PushFileManage(Context context,boolean isShowProgress, File file, String request, String fileType) {
        this.isShowProgress = isShowProgress;
        this.file = file;
        this.request = request;
        this.fileType = fileType;
        this.context = context;
        if (isShowProgress){
            showProgress();
        }
        pushFilePresenter = new PushFilePresenter(this);
    }
    @Override
    public void showProgress() {
        if (mDownloadDialog != null) {
            mDownloadDialog.dismiss();
            mDownloadDialog = null;
        }
        // 构造软件下载对话框
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(R.string.soft_updating_file);
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
                if (cancelListener!=null){
                    cancelListener.onCancelListener();
                }
            }
        });
        mDownloadDialog = builder.create();
        mDownloadDialog.setCanceledOnTouchOutside(false);
        mDownloadDialog.show();
    }

    @Override
    public void dissmissProgress() {
        if (mDownloadDialog != null)
            mDownloadDialog.dismiss();
    }

    @Override
    public boolean isShowProgress() {
        return isShowProgress;
    }

    @Override
    public ProgressBar getProgress() {
        return mProgress;
    }

    /**
     * 开始
     * discrete-type := "text" / "image" / "audio" / "video" /application" / extension-token
     * for exsample:image/jpeg
     */
    @Override
    public MultipartBody.Part pushFileBackPart() {
        return pushFilePresenter.startModel(file, request, MediaType.parse(fileType));
    }
    public void setCancelListener(CancelCallBack cancelListener){
        this.cancelListener = cancelListener;
    }
    public interface CancelCallBack{
        void onCancelListener();
    }
}
