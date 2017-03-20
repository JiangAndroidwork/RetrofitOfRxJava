package com.laojiang.retrofitofrxjava.bean;

/**
 * 类介绍（必填）：
 * Created by Jiang on 2017/3/20 10:55.
 */

public class PushFileBean {
    @Override
    public String toString() {
        return "PushFileBean{" +
                "code='" + code + '\'' +
                ", msg=" + msg +
                ", result=" + result +
                '}';
    }

    /**
     * code : 1
     * msg : null
     * result : null
     */

    private String code;
    private Object msg;
    private Object result;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
