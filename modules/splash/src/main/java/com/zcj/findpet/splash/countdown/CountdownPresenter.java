package com.zcj.findpet.splash.countdown;

import android.content.Context;

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

    private CountdownContract.View mView;
    private CountdownContract.Model mModel;

    private final Context mContext;

    private Timer mTimer = null;
    private int mCountDown = 5;

    public CountdownPresenter(Context context, CountdownContract.View view) {
        this.mContext = context;
        this.mView = view;
        mModel = new CountdownModel();
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
        mModel.testRestClient(mContext, new ISuccess() {
            @Override
            public void onSuccess(String response) {
                mView.showToast(response, false);
            }
        }, new IFailure() {
            @Override
            public void onFailure() {
                mView.showToast("failure", false);
            }
        }, new IError() {
            @Override
            public void onError(int code, String msg) {
                mView.showToast("error", false);
            }
        });
    }

    @Override
    public void testRxGet() {
        mModel.testRxGet(mContext, new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                mView.showToast("start", false);
            }

            @Override
            public void onNext(String s) {
                mView.showToast(s, false);
            }

            @Override
            public void onError(Throwable e) {
                mView.showToast("error", false);
            }

            @Override
            public void onComplete() {
                mView.showToast("complete", false);
            }
        });
    }

    @Override
    public void testRxRestClient() {
        mModel.testRxRestClient(mContext, new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                mView.showToast("start", false);
            }

            @Override
            public void onNext(String s) {
                mView.showToast(s, false);
            }

            @Override
            public void onError(Throwable e) {
                mView.showToast("error", false);
            }

            @Override
            public void onComplete() {
                mView.showToast("complete", false);
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
                if (!mView.isTvNull()) {
                    mView.updateCountdown(MessageFormat.format("跳过\n{0}s", mCountDown));
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
        if (mModel.isFirstLauncherApp()) {
            mView.goScroll();
        } else {
            mView.goMain();
        }
    }
}
