package com.laojiang.retrofithttp.weight.downfilesutils.exception;

import android.util.Log;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import io.reactivex.Flowable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;

/**
 * 类介绍（必填）：条件
 * Created by Jiang on 2017/3/21 16:50.
 */
public class RetryWhenNetworkException implements Function<Flowable<?extends Throwable>, Flowable<?>> {
//    retry次数
    private int count = 3;
//    延迟
    private long delay = 3000;
//    叠加延迟
    private long increaseDelay = 3000;

    public RetryWhenNetworkException() {

    }

    public RetryWhenNetworkException(int count, long delay) {
        this.count = count;
        this.delay = delay;
    }

    public RetryWhenNetworkException(int count, long delay, long increaseDelay) {
        this.count = count;
        this.delay = delay;
        this.increaseDelay = increaseDelay;
    }



    @Override
    public Flowable<?> apply(Flowable<? extends Throwable> flowable) throws Exception {
        return flowable
                .zipWith(Flowable.range(1,count+1), new BiFunction<Throwable, Integer, Wrappers>() {
                    @Override
                    public Wrappers apply(Throwable throwable, Integer integer) throws Exception {
                        return  new Wrappers(throwable, integer);
                    }
                }).flatMap(new Function<Wrappers, Flowable<?>>() {


            @Override
            public Flowable<?> apply(Wrappers wrapper) throws Exception {
                if ((wrapper.throwable instanceof ConnectException
                        || wrapper.throwable instanceof SocketTimeoutException
                        || wrapper.throwable instanceof TimeoutException)
                        && wrapper.index < count + 1) { //如果超出重试次数也抛出错误，否则默认是会进入onCompleted
                    Log.e("tag","retry---->"+wrapper.index);
                    return Flowable.timer(delay + (wrapper.index - 1) * increaseDelay, TimeUnit.MILLISECONDS);

                }
                return Flowable.error(wrapper.throwable);
            }
        });
    }

    private class Wrappers {
        private int index;
        private Throwable throwable;

        public Wrappers(Throwable throwable, int index) {
            this.index = index;
            this.throwable = throwable;
        }
    }

}
