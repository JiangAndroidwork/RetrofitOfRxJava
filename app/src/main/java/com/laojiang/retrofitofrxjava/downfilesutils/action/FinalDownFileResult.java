package com.laojiang.retrofitofrxjava.downfilesutils.action;

import com.laojiang.retrofitofrxjava.downfilesutils.downfiles.DownInfo;

/**
 * 类介绍（必填）：
 * Created by Jiang on 2017/3/22 9:15.
 */

public  class FinalDownFileResult {
   public  void onSuccess(DownInfo downInfo){}
   public   void onCompleted(){}
    public   void onErroe(Throwable e){}
    public  void onStart(){}
    public  void onPause(){}
    public void onStop(){}
    public void onLoading(long readLength, long countLength){}
}
