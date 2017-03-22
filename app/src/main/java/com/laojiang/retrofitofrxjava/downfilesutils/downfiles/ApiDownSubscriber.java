package com.laojiang.retrofitofrxjava.downfilesutils.downfiles;

import com.laojiang.retrofithttp.weight.model.downfiles.DownloadProgressListener;
import com.laojiang.retrofithttp.weight.presenter.downfiles.HttpProgressOnNextListener;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.lang.ref.WeakReference;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;

/**
 * 类介绍（必填）：订阅者 处理，对progressbar的处理
 * Created by Jiang on 2017/3/21 15:05.
 */

public class ApiDownSubscriber<T> implements Subscriber<T>,DownloadProgressListener {
    //弱引用结果回调
    private WeakReference<HttpProgressOnNextListener> mSubscriberOnNextListener;
    /*下载数据*/
    private DownInfo downInfo;
private Subscription subscription;
    public ApiDownSubscriber(DownInfo downInfo) {
        this.mSubscriberOnNextListener = new WeakReference<>(downInfo.getListener());
        this.downInfo = downInfo;
        if(mSubscriberOnNextListener.get()!=null){
            mSubscriberOnNextListener.get().onStart();
        }
        downInfo.setState(DownState.START);
    }

    @Override
    public void onSubscribe(Subscription s) {
        this.subscription = s;
        s.request(Long.MAX_VALUE);

    }
    public void setCancel(){
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
        if(mSubscriberOnNextListener.get()!=null){
            mSubscriberOnNextListener.get().onError(t);
        }
        downInfo.setState(DownState.ERROR);
    }

    /**
     * 订阅完成
     */
    @Override
    public void onComplete() {

        if(mSubscriberOnNextListener.get()!=null){
            mSubscriberOnNextListener.get().onComplete();
        }
        downInfo.setState(DownState.FINISH);
    }

    @Override
    public void update(long read, long count, boolean done) {
        if(downInfo.getCountLength()>count){
            read=downInfo.getCountLength()-count+read;
        }else{
            downInfo.setCountLength(count);
        }
        downInfo.setReadLength(read);
        if (mSubscriberOnNextListener.get() != null) {
            /*接受进度消息，造成UI阻塞，如果不需要显示进度可去掉实现逻辑，减少压力*/
            Flowable.just(read).observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<Long>() {
                        @Override
                        public void accept(Long aLong) throws Exception {
                             /*如果暂停或者停止状态延迟，不需要继续发送回调，影响显示*/
                            if(downInfo.getState()==DownState.PAUSE||downInfo.getState()==DownState.STOP)return;
                            downInfo.setState(DownState.DOWN);
                            mSubscriberOnNextListener.get().updateProgress(aLong,downInfo.getCountLength());
                        }

                    });
        }
    }
}
