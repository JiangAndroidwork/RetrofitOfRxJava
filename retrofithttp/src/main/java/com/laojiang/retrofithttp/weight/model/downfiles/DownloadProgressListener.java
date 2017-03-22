package com.laojiang.retrofithttp.weight.model.downfiles;

/**
 * 类介绍（必填）：成功回调处理
 * Created by Jiang on 2017/3/21 15:11.
 */

public interface DownloadProgressListener {
    /**
     * 加载的进度
     * @param read  已读取长度
     * @param count 总长度
     * @param done 是否更新
     */
    void update(long read, long count, boolean done);
}
