package com.laojiang.retrofithttp.weight.downfilesutils.downfiles;

import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;
import com.laojiang.retrofithttp.weight.model.downfiles.DownloadProgressListener;
import com.laojiang.retrofithttp.weight.presenter.downfiles.HttpProgressOnNextListener;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.lang.ref.WeakReference;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;

/**
 * 类介绍（必填）：订阅者 处理，对progressbar的处理
 * Created by Jiang on 2017/3/21 15:05.
 */

public class ApiDownSubscriber<T> implements Subscriber<T>, DownloadProgressListener {
    //HTTP的状态码
    private static final int HTTP_BAD_REQUEST = 400;
    private static final int HTTP_FORBIDDEN = 403;
    private static final int HTTP_NOT_FOUND = 404;
    private static final int HTTP_TIMEOUT = 408;
    private static final int HTTP_INTERNAL_SERVER_ERROR = 500;
    //出错提示
    private static final String MSG_NETWORK_ERROR = "网络错误";
    private static final String MSG_NETWORK_CONNECTION_ERROR = "网络连接不可用，请检查或稍后重试";
    private static final String MSG_UNKNOWN_ERROR = "Ops，好像出错了~";
    private static final String MSG_TIME_OUT = "网络请求超时";
    private static final String MSG_SERVER_ERROR = "服务器错误";
    private static final String MSG_NOT_FOUND = "访问的地址不存在";
    private static final String MSG_FORBIDDEN = "服务器拒绝请求";
    private static final String MSG_BAD_REQUEST = "请求参数错误";
    //弱引用结果回调
    private WeakReference<HttpProgressOnNextListener> mSubscriberOnNextListener;
    /*下载数据*/
    private DownInfo downInfo;
    private Subscription subscription;

    public ApiDownSubscriber(DownInfo downInfo) {
        this.mSubscriberOnNextListener = new WeakReference<>(downInfo.getListener());
        this.downInfo = downInfo;
        if (mSubscriberOnNextListener.get() != null) {
            mSubscriberOnNextListener.get().onStart();
        }
        downInfo.setState(DownState.START);
    }

    @Override
    public void onSubscribe(Subscription s) {
        this.subscription = s;
        s.request(Long.MAX_VALUE);

    }

    public void setCancel() {
        subscription.cancel();
    }

    @Override
    public void onNext(T t) {
        if (mSubscriberOnNextListener.get() != null) {
            mSubscriberOnNextListener.get().onNext(t);
        }
    }

    @Override
    public void onError(Throwable t) {
        resolveException(t);

        downInfo.setState(DownState.ERROR);
    }

    /**
     * 订阅完成
     */
    @Override
    public void onComplete() {

        if (mSubscriberOnNextListener.get() != null) {
            mSubscriberOnNextListener.get().onComplete();
        }
        downInfo.setState(DownState.FINISH);
    }

    @Override
    public void update(long read, long count, boolean done) {
        if (downInfo.getCountLength() > count) {
            read = downInfo.getCountLength() - count + read;
        } else {
            downInfo.setCountLength(count);
        }
        downInfo.setReadLength(read);
        if (mSubscriberOnNextListener.get() != null) {
            //不需要进度可以去掉，减少阻塞。
            Flowable.just(read).observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<Long>() {
                        @Override
                        public void accept(Long aLong) throws Exception {
                             /*如果暂停或者停止状态延迟，不需要继续发送回调，影响显示*/
                            if (downInfo.getState() == DownState.PAUSE || downInfo.getState() == DownState.STOP)
                                return;
                            downInfo.setState(DownState.DOWN);
                            mSubscriberOnNextListener.get().updateProgress(aLong, downInfo.getCountLength());
                        }

                    });
        }
    }
    private void resolveException(Throwable e) {
        Throwable throwable = e;
        //获取最根源的异常
        while (throwable.getCause() != null) {
            e = throwable;
            throwable = throwable.getCause();
        }

         if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;

            switch (httpException.code()) {
                case HTTP_BAD_REQUEST:
                    if (mSubscriberOnNextListener.get() != null) {
                        mSubscriberOnNextListener.get().onError(MSG_BAD_REQUEST,HTTP_BAD_REQUEST);
                    }
                case HTTP_FORBIDDEN:
                    if (mSubscriberOnNextListener.get() != null) {
                        mSubscriberOnNextListener.get().onError(MSG_FORBIDDEN,HTTP_FORBIDDEN);
                    }
                case HTTP_NOT_FOUND:
                    if (mSubscriberOnNextListener.get() != null) {
                        mSubscriberOnNextListener.get().onError(MSG_NOT_FOUND,HTTP_NOT_FOUND);
                    }
                case HTTP_INTERNAL_SERVER_ERROR:
                    if (mSubscriberOnNextListener.get() != null) {
                        mSubscriberOnNextListener.get().onError(MSG_SERVER_ERROR,HTTP_INTERNAL_SERVER_ERROR);
                    }
                    break;
                case HTTP_TIMEOUT:
                    if (mSubscriberOnNextListener.get() != null) {
                        mSubscriberOnNextListener.get().onError(MSG_TIME_OUT,HTTP_TIMEOUT);
                    }
                    break;
                default:
                    if (mSubscriberOnNextListener.get() != null) {
                        mSubscriberOnNextListener.get().onError(MSG_NETWORK_ERROR,-1);
                    }
                    break;
            }
        } else if (e instanceof SocketTimeoutException) {
             if (mSubscriberOnNextListener.get() != null) {
                 mSubscriberOnNextListener.get().onError(MSG_TIME_OUT,-1);
             }
        } else if (e instanceof ConnectException) {
             if (mSubscriberOnNextListener.get() != null) {
                 mSubscriberOnNextListener.get().onError(MSG_NETWORK_ERROR,-2);
             }
        } else if (e instanceof UnknownHostException) {
             if (mSubscriberOnNextListener.get() != null) {
                 mSubscriberOnNextListener.get().onError(MSG_NETWORK_CONNECTION_ERROR,404);
             }
        } else if (e instanceof SocketException) {
             if (mSubscriberOnNextListener.get() != null) {
                 mSubscriberOnNextListener.get().onError(MSG_SERVER_ERROR,-4);
             }
        } else if (e.getMessage()!=null){
             if (mSubscriberOnNextListener.get() != null) {
                 mSubscriberOnNextListener.get().onError(e.getMessage(),-5);
             }
        }
    }
}
