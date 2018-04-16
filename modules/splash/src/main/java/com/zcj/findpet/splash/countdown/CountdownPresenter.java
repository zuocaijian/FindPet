package com.zcj.findpet.splash.countdown;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.content.Context;
import android.support.annotation.NonNull;

import com.zcj.findpet.core.app.Awesome;
import com.zcj.findpet.core.util.timer.BaseTimerTask;
import com.zcj.findpet.core.util.timer.ITimerListener;
import com.zcj.net.callback.IError;
import com.zcj.net.callback.IFailure;
import com.zcj.net.callback.ISuccess;

import java.text.MessageFormat;
import java.util.Timer;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Datetime: 2018/4/8 10:29
 * Author: zcj
 */
class CountdownPresenter implements CountdownContract.Presenter, ITimerListener {

    private final CountdownContract.View VIEW;
    private final CountdownContract.Model MODEL;

    private final Context CONTEXT;

    private Timer mTimer = null;
    private int mCountDown = 5;

    public CountdownPresenter(Context context, CountdownContract.View view) {
        this.CONTEXT = context;
        this.VIEW = view;
        MODEL = new CountdownModel();
    }

    @Override
    public void terminateCountDown() {
        if (mTimer != null) {
            mTimer.cancel();
            mTimer = null;
            checkIsShowScroll();
        }
    }

    @Override
    public void testRestClient() {
        MODEL.testRestClient(CONTEXT, new ISuccess() {
            @Override
            public void onSuccess(String response) {
                VIEW.showToast(response, false);
            }
        }, new IFailure() {
            @Override
            public void onFailure() {
                VIEW.showToast("failure", false);
            }
        }, new IError() {
            @Override
            public void onError(int code, String msg) {
                VIEW.showToast("error", false);
            }
        });
    }

    @Override
    public void testRxGet() {
        MODEL.testRxGet(CONTEXT, new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                VIEW.showToast("start", false);
            }

            @Override
            public void onNext(String s) {
                VIEW.showToast(s, false);
            }

            @Override
            public void onError(Throwable e) {
                VIEW.showToast("error", false);
            }

            @Override
            public void onComplete() {
                VIEW.showToast("complete", false);
            }
        });
    }

    @Override
    public void testRxRestClient() {
        MODEL.testRxRestClient(CONTEXT, new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                VIEW.showToast("start", false);
            }

            @Override
            public void onNext(String s) {
                VIEW.showToast(s, false);
            }

            @Override
            public void onError(Throwable e) {
                VIEW.showToast("error", false);
            }

            @Override
            public void onComplete() {
                VIEW.showToast("complete", false);
            }
        });
    }

    @Override
    public void start() {
        mTimer = new Timer();
        final BaseTimerTask task = new BaseTimerTask(this);
        mTimer.schedule(task, 0, 1000);
    }

    @Override
    public void onTimer() {
        Awesome.getMainHandler().post(new Runnable() {
            @Override
            public void run() {
                if (!VIEW.isTvNull()) {
                    VIEW.updateCountdown(MessageFormat.format("跳过\n{0}s", mCountDown));
                    mCountDown--;
                    if (mCountDown < 0) {
                        terminateCountDown();
                    }
                }
            }
        });
    }

    //判断是否显示滑动启动页
    private void checkIsShowScroll() {
        if (MODEL.isFirstLauncherApp()) {
            VIEW.goScroll();
        } else {
            VIEW.goMain();
        }
    }

    @Override
    public void onLifeCycleChanged(@NonNull LifecycleOwner owner, @NonNull Lifecycle.Event event) {
    }

    @Override
    public void onCreate(@NonNull LifecycleOwner owner) {
    }

    @Override
    public void onStart(@NonNull LifecycleOwner owner) {
    }

    @Override
    public void onResume(@NonNull LifecycleOwner owner) {
    }

    @Override
    public void onPause(@NonNull LifecycleOwner owner) {
    }

    @Override
    public void onStop(@NonNull LifecycleOwner owner) {
    }

    @Override
    public void onDestroy(@NonNull LifecycleOwner owner) {
    }
}
