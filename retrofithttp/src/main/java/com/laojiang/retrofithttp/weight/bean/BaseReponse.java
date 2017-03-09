package com.laojiang.retrofithttp.weight.bean;

/**
 * 类介绍（必填）：
 * Created by Jiang on 2017/3/9 9:24.
 * http://localhost:8080/retrofit.json
 * {
 "code" : "1",
 "msg" : null,
 "result" : [ {
 "name" : "实发",
 "value" : 100.0,
 "type" : 5
 }, {
 "name" : "应发",
 "value" : 200.0,
 "type" : 4
 }, {
 "name" : "应扣",
 "value" : 300.0,
 "type" : 3
 }, {
 "name" : "补贴",
 "value" : 400.0,
 "type" : 1
 }, {
 "name" : "补助",
 "value" : 500.0,
 "type" : 1
 }, {
 "name" : "保险",
 "value" : 0.0,
 "type" : 2
 } ]
 }
 */

public class BaseReponse {
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
