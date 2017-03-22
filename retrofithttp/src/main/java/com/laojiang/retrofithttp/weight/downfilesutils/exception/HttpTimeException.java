package com.laojiang.retrofithttp.weight.downfilesutils.exception;

/**
 *
 *  类介绍（必填）：自定义错误信息，统一处理返回处理
 * Created by Jiang on 2017/3/21 16:50.
 */
public class HttpTimeException extends RuntimeException {

    public static final int NO_DATA = 0x2;

    public HttpTimeException(int resultCode) {
        this(getApiExceptionMessage(resultCode));
    }

    public HttpTimeException(String detailMessage) {
        super(detailMessage);
    }

    /**
     * 转换错误数据
     *
     * @param code
     * @return
     */
    private static String getApiExceptionMessage(int code) {
        String message = "";
        switch (code) {
            case NO_DATA:
                message = "无数据";
                break;
            default:
                message = "error";
                break;

        }
        return message;
    }
}

