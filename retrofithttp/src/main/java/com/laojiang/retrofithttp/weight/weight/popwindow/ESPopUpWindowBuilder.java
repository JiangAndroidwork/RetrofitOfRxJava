package com.laojiang.retrofithttp.weight.weight.popwindow;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;

/**
 * 类介绍（必填）：popupwindow
 * Created by Jiang on 2017/8/4 .
 */

public class ESPopUpWindowBuilder {
    private Context context;
    private MyPopupWindow popupWindow;
    private int windowWidth = ViewGroup.LayoutParams.WRAP_CONTENT;
    private int windowHeight = ViewGroup.LayoutParams.WRAP_CONTENT;
    private View diyView;

    public MyPopupWindow getPopupWindow() {
        return popupWindow;
    }

    /**
     *
     * @param context
     * @param view 自定义view
     */
    public ESPopUpWindowBuilder(Context context, View view) {
        this.context = context;
        this.diyView = view;
        init();
    }

    private void init() {
        if (popupWindow == null) {
            popupWindow = new MyPopupWindow(context);
        }
        popupWindow.setHeight(windowHeight);
        popupWindow.setWidth(windowWidth);
        popupWindow.setContentView(diyView);
    }
    public ESPopUpWindowBuilder setAllScreen(){
        popupWindow.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        return this;
    }
    //设置宽度填充
    public ESPopUpWindowBuilder setFullWidthScreen(){
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        return this;
    }
    public ESPopUpWindowBuilder setViewHeight(int height){
        popupWindow.setHeight(height);
        return this;
    }
    public ESPopUpWindowBuilder setBackGroundDrawable(Drawable drawable) {
        popupWindow.setBackgroundDrawable(drawable);
        return this;
    }

    public ESPopUpWindowBuilder setOutsideTouchable(boolean isCan) {
        popupWindow.setOutsideTouchable(isCan);
        return this;
    }

    public ESPopUpWindowBuilder setCanFocusable(boolean isCan) {
        popupWindow.setFocusable(isCan);
        return this;
    }

//    public ESPopUpWindowBuilder setBackAlpha(float alpha){
//        WindowManager.LayoutParams lp = context.getWindow().getAttributes();
//        context.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
//        lp.alpha = alpha;
//        context.getWindow().setAttributes(lp);
//        return this;
//    }

    public ESPopUpWindowBuilder showAsDropDown(View view){
        popupWindow.showAsDropDown(view);
        return this;
    }
    public ESPopUpWindowBuilder showAsDropDown(View view, int xoff, int yoff){
        popupWindow.showAsDropDown(view,xoff,yoff);
        return this;
    }
    public ESPopUpWindowBuilder showAsDropDown(View view, int xoff, int yoff, int gravity){
        popupWindow.showAsDropDown(view,xoff,yoff,gravity);
        return this;
    }
    //设置 父
    public ESPopUpWindowBuilder showAtLocation(View parent, int gravity, int x, int y){
        popupWindow.showAtLocation(parent,gravity,x,y);
        return this;
    }
    public void dissMiss(){
        popupWindow.dismiss();
    }
}
