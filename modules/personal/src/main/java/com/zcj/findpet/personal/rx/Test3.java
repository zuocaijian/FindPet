package com.zcj.findpet.personal.rx;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 场景三：定时器
 * Datetime: 2018/4/10 11:43
 * Author: zcj
 */
public class Test3 {

    public Test3() {
    }

    @SuppressLint("HandlerLeak")
    private static Handler sHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0x1:
                    //刷新UI
                    break;
                //...
                default:
                    break;
            }
        }
    };

    private long mLastTime;

    private void timer() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (System.currentTimeMillis() - mLastTime >= 500) {
                    mLastTime = System.currentTimeMillis();
                    //task.run();
                    sHandler.sendEmptyMessage(0x1);
                }
            }
        }).start();
    }

    @SuppressWarnings("CheckResult")
    private void rx() {
        Observable.interval(0, 500, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        //刷新UI
                    }
                });
    }
}
