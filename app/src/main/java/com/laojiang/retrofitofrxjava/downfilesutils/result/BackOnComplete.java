package com.laojiang.retrofitofrxjava.downfilesutils.result;

import com.laojiang.retrofitofrxjava.downfilesutils.action.FinalDownFileResult;
import com.laojiang.retrofitofrxjava.downfilesutils.downfiles.DownInfo;

/**
 * 类介绍（必填）：
 * Created by Jiang on 2017/3/22 10:00.
 */

public abstract class BackOnComplete extends FinalDownFileResult {
    @Override
    public void onSuccess(DownInfo downInfo) {

    }

    @Override
    public void onErroe(Throwable e) {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onPause() {

    }
}
