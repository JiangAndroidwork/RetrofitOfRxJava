package com.laojiang.retrofithttp.weight.weight;

import com.laojiang.retrofithttp.weight.bean.BaseReponse;

import io.reactivex.functions.Function;

/**
 * 类介绍（必填）：
 * Created by Jiang on 2017/3/13 13:12.
 */

public class ApiFunction<T> implements Function<BaseReponse<T>,T> {
    @Override
    public T apply(BaseReponse<T> tBaseReponse) throws Exception {
        if (!tBaseReponse.getCode().equals("1")){
            throw new ApiException(Integer.parseInt(tBaseReponse.getCode()),tBaseReponse.getMsg());
        }
        return tBaseReponse.getResult();
    }
}
