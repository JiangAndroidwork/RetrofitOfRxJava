package com.laojiang.retrofithttp.weight.weight;

/**
 * 类介绍（必填）：运行时异常
 * Created by Jiang on 2017/3/9 8:26.
 */
public class ApiException extends RuntimeException {
    @Override
    public String toString() {
        return "ApiException{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }

    private int code;
    private String msg;

    public ApiException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
