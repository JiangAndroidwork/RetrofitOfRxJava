package com.laojiang.retrofithttp.weight.model;

import android.content.Context;

/**
 * 类介绍（必填）：
 * Created by Jiang on 2017/3/9 9:28.
 */

public interface RHInterface {
    void getHttpData(boolean isCache,Context context, RetrofitCallBackInterface backInterface, String url);
}
