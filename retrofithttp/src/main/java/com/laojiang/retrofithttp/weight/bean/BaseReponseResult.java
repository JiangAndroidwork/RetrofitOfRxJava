package com.laojiang.retrofithttp.weight.bean;

/**
 * 类介绍（必填）：对过程进行封装只返回result结果的超类
 * Created by Jiang on 2017/3/9 9:24.
 *
 */

public class BaseReponseResult<T>{

    @Override
    public String toString() {
        return "BaseReponseResult{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
    private T result;

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    private String code;
    private String msg;
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
