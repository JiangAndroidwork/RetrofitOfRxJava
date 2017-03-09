package com.laojiang.retrofithttp.weight.presenter;

import android.app.AlertDialog;
import android.content.Context;

import com.laojiang.retrofithttp.weight.model.RetrofitCallBackInterface;
import com.laojiang.retrofithttp.weight.model.RetrofitHttp;
import com.laojiang.retrofithttp.weight.ui.PBRViewInterface;

import retrofit2.Retrofit;


/**
 * 类介绍（必填）：retrofit控制器
 * Created by Jiang on 2017/3/9 8:55.
 */

public class RetrofitPresenter implements RPInterface, RetrofitCallBackInterface {
    private String url;
    private AlertDialog dialog;
    private PBRViewInterface uiInterface;
    private RetrofitHttp retrofitHttp = new RetrofitHttp();
    private Context context;

    public RetrofitPresenter(Context context,String url, PBRViewInterface uiInterface, AlertDialog dialog){
        this.context = context;
        this.context = context;
        this.url = url;
        this.uiInterface = uiInterface;
        this.dialog = dialog;
    }
    /**
     * 获取数据
     */
    @Override
    public void getData() {
        uiInterface.showProgressBar();
        retrofitHttp.getHttpData(context,this,url);
    }

    @Override
    public void setCallBackService(Retrofit backService) {
        uiInterface.setData(backService,dialog);
    }
}
