package com.laojiang.retrofithttp.weight.presenter.pushfile;

import android.widget.ProgressBar;

import com.laojiang.retrofithttp.weight.model.pushfile.PushFileModel;
import com.laojiang.retrofithttp.weight.model.pushfile.PushFileModelBackData;
import com.laojiang.retrofithttp.weight.ui.pushfile.PushFileInterface;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;

/**
 * 类介绍（必填）：
 * Created by Jiang on 2017/3/20 9:54.
 */

public class PushFilePresenter implements PushFilePresenterIN, PushFileModelBackData {
    private PushFileModel pushFileModel = new PushFileModel();
    private PushFileInterface pushFileInterface;
    private final ProgressBar progress;

    public PushFilePresenter(PushFileInterface pushFileInterface) {
        this.pushFileInterface = pushFileInterface;
        progress = pushFileInterface.getProgress();
    }


    @Override
    public MultipartBody.Part startModel(File file, String request, MediaType mediaType) {
        pushFileModel.setRequestBody(file, mediaType, request, this);
        MultipartBody.Part part = pushFileModel.getMultipartBodyPart();
        return part;
    }

    @Override
    public void getProgressState(long currentBytesCount, long totalBytesCount) {
        if (progress != null) {
            progress.setMax((int) totalBytesCount);
            progress.setProgress((int) currentBytesCount);
        }
        if (currentBytesCount >= totalBytesCount) {
            pushFileInterface.dissmissProgress();
        }
    }
}
