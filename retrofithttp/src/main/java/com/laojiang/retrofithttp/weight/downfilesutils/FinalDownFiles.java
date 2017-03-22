package com.laojiang.retrofithttp.weight.downfilesutils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.laojiang.retrofithttp.R;
import com.laojiang.retrofithttp.weight.downfilesutils.action.FinalDownFileResult;
import com.laojiang.retrofithttp.weight.downfilesutils.action.OperaDownFileManage;
import com.laojiang.retrofithttp.weight.downfilesutils.downfiles.DownInfo;
import com.laojiang.retrofithttp.weight.downfilesutils.manage.HttpDownManager;
import com.laojiang.retrofithttp.weight.presenter.downfiles.HttpProgressOnNextListener;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;


/**
 * 类介绍（必填）：最终文件下载封装类
 * Created by Jiang on 2017/3/22 7:57.
 */

public class FinalDownFiles  extends HttpProgressOnNextListener<DownInfo> implements OperaDownFileManage {
    private HttpDownManager manager;
    private Context context;
    private AlertDialog mDownloadDialog;
    private String outUrlStr;
    private String fileUrlStr;
    private DownInfo downInfo;
    private ProgressBar mProgress;
    private FinalDownFileResult fileResult;//返回结果接口
    private TextView tvState;
    private boolean isPause;

    /**
     * 构造方法
     * @param isShow 是否显示弹窗
     * @param context 上下文
     * @param fileUrlStr 文件网络url
     * @param outUrlStr  输出本地路径
     * @param fileResult  回调结果
     */
    public FinalDownFiles(boolean isShow,Context context,String fileUrlStr,String outUrlStr,FinalDownFileResult fileResult) {
        this.fileResult = fileResult;
        this.fileUrlStr = fileUrlStr;
        this.outUrlStr = outUrlStr;
        this.context = context;
        // 构造软件下载对话框
        if (isShow) {
            initProgressBar(context);
        }
        //初始化文件下载
        initManage();

    }

    /**
     *
     * @param isShow
     * @param context
     * @param outUrlStr
     * @param fileUrlStr
     */
    public FinalDownFiles(boolean isShow,Context context, String outUrlStr, String fileUrlStr) {
        this.context = context;
        this.outUrlStr = outUrlStr;
        this.fileUrlStr = fileUrlStr;
        // 构造软件下载对话框
        if (isShow) {
            initProgressBar(context);
        }
        //初始化文件下载
        initManage();
    }

    /**
     * 初始化
     */
    private void initManage() {
        manager = HttpDownManager.getInstance();
        //初始化信息
        downInfo = new DownInfo(fileUrlStr);
        File outFile = new File(outUrlStr);
        if (!outFile.exists()){
            try {
                outFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        downInfo.setSavePath(outFile.getAbsolutePath());
        downInfo.setListener(this);
        manager.startDown(downInfo);
    }

    /**
     * 初始化弹窗
     * @param context
     */
    private void initProgressBar(Context context) {
        if (mDownloadDialog!=null){
            mDownloadDialog.dismiss();
            mDownloadDialog=null;
        }
        // 构造软件下载对话框
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("正在下载");
        // 给下载对话框增加进度条
        final LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.dialog_progress_down_file, null);
        mProgress = (ProgressBar) v.findViewById(R.id.progressBar3);
        tvState = (TextView) v.findViewById(R.id.tv_state);
        builder.setView(v);
        // 取消下载
        builder.setNegativeButton(R.string.soft_update_cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                try {//利用反射机制 控制 点击之后弹框是否关闭

                    Field field = dialog.getClass().getSuperclass().getDeclaredField("mShowing");

                    field.setAccessible(true);

                    field.set(dialog,true);//true表示要关闭

                } catch (Exception e) {

                    e.printStackTrace();

                }
                manager.stopDown(downInfo);
//                if (isPause){
//                    Log.i("重新开始",downInfo.toString());
//                    manager.startDown(downInfo);
//                    isPause = false;
//                }else {
//                    manager.pause(downInfo);
//                    isPause=true;
//                }
            }
        });

        mDownloadDialog = builder.create();
        mDownloadDialog.setCanceledOnTouchOutside(false);
        mDownloadDialog.show();
    }

    @Override
    public void onNext(DownInfo baseDownEntity) {
        Toast.makeText(context,baseDownEntity.getSavePath(),Toast.LENGTH_SHORT).show();
        fileResult.onSuccess(baseDownEntity);
    }

    @Override
    public void onStart() {
        if (tvState!=null)
        tvState.setText("开始");

        fileResult.onStart();
    }

    @Override
    public void onComplete() {
    if (mDownloadDialog!=null){
        mDownloadDialog.dismiss();

    }
        fileResult.onCompleted();
    }

    @Override
    public void onError(Throwable e) {
        super.onError(e);
        fileResult.onErroe(e);
        if (mDownloadDialog!=null){
            mDownloadDialog.dismiss();
        }
    }

    @Override
    public void onPuase() {
        super.onPuase();
        fileResult.onPause();
        if (tvState!=null)
        tvState.setText("暂停");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("停止","...");
        if (mDownloadDialog!=null){
            mDownloadDialog.dismiss();
        }
        fileResult.onStop();
    }

    @Override
    public void updateProgress(long readLength, long countLength) {
        fileResult.onLoading(readLength,countLength);
        mProgress.setMax((int) countLength);
        mProgress.setProgress((int) readLength);
        Log.i("正在下载==",readLength+"");
    }

    /**
     * 设置暂停
     */
    @Override
    public void setPause() {
        manager.pause(downInfo);
    }

    /**
     * 设置停止
     */
    @Override
    public void setStop() {
manager.stopDown(downInfo);

    }

    /**
     * 全部停止
     */
    @Override
    public void stopAll() {
        manager.stopAllDown();
    }

    /**
     * 删除
     */
    @Override
    public void deleteDown() {
manager.deleteDown(downInfo);
    }

    @Override
    public void setRestart() {
        if (downInfo!=null)
        manager.startDown(downInfo);
    }


}
