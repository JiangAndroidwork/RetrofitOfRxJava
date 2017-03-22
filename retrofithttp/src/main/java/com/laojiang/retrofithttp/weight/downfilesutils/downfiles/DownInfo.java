package com.laojiang.retrofithttp.weight.downfilesutils.downfiles;

import com.laojiang.retrofithttp.weight.presenter.downfiles.HttpProgressOnNextListener;
import com.laojiang.retrofithttp.weight.downfilesutils.HttpService;

/**
 * 类介绍（必填）：下载信息
 * Created by Jiang on 2017/3/21 .
 */

public class DownInfo {
    /*存储位置*/
    private String savePath;
    /*下载url*/
    private String url;
    /*基础url*/
    private String baseUrl;
    /*文件总长度*/
    private long countLength;
    /*下载长度*/
    private long readLength;
    /*下载唯一的HttpService*/
    private HttpService service;
    /*回调监听*/
    private HttpProgressOnNextListener listener;
    /*超时设置*/
    private  int DEFAULT_TIMEOUT = 6;
    /*下载状态*/
    private DownState state;

    @Override
    public String toString() {
        return "DownInfo{" +
                "savePath='" + savePath + '\'' +
                ", url='" + url + '\'' +
                ", baseUrl='" + baseUrl + '\'' +
                ", countLength=" + countLength +
                ", readLength=" + readLength +
                ", service=" + service +
                ", listener=" + listener +
                ", DEFAULT_TIMEOUT=" + DEFAULT_TIMEOUT +
                ", state=" + state +
                '}';
    }

    public DownInfo(String url, HttpProgressOnNextListener listener) {
        setUrl(url);
        setBaseUrl(getBasUrl(url));
        setListener(listener);
    }

    public DownState getState() {
        return state;
    }

    public void setState(DownState state) {
        this.state = state;
    }

    public DownInfo(String url) {
        setUrl(url);
        setBaseUrl(getBasUrl(url));
    }

    public int getConnectionTime() {
        return DEFAULT_TIMEOUT;
    }

    public void setConnectionTime(int DEFAULT_TIMEOUT) {
        this.DEFAULT_TIMEOUT = DEFAULT_TIMEOUT;
    }

    public HttpProgressOnNextListener getListener() {
        return listener;
    }

    public void setListener(HttpProgressOnNextListener listener) {
        this.listener = listener;
    }

    public HttpService getService() {
        return service;
    }

    public void setService(HttpService service) {
        this.service = service;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSavePath() {
        return savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public long getCountLength() {
        return countLength;
    }

    public void setCountLength(long countLength) {
        this.countLength = countLength;
    }


    public long getReadLength() {
        return readLength;
    }

    public void setReadLength(long readLength) {
        this.readLength = readLength;
    }

    /**
     * 读取baseurl
     * @param url
     * @return
     */
    protected String getBasUrl(String url) {
        String head = "";
        int index = url.indexOf("://");
        if (index != -1) {
            head = url.substring(0, index + 3);
            url = url.substring(index + 3);
        }
        index = url.indexOf("/");
        if (index != -1) {
            url = url.substring(0, index + 1);
        }
        return head + url;
    }
}
