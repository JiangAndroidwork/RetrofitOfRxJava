package com.laojiang.retrofithttp.weight.weight;

import com.laojiang.retrofithttp.weight.bean.BaseReponseResult;

import io.reactivex.functions.Function;

/**
 * 类介绍（必填）：
 * Created by Jiang on 2017/3/13 13:12.
 */

public class ApiFunction<T> implements Function<BaseReponseResult<T>,T> {
    @Override
    public T apply(BaseReponseResult<T> tBaseReponse) throws Exception {
        if (tBaseReponse.getCode()!=1){
            throw new ApiException(tBaseReponse.getCode(),tBaseReponse.getMsg());
        }
        return tBaseReponse.getResult();
    }
}
