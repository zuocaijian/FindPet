package com.zcj.findpet.splash.countdown;

import android.content.Context;

import com.zcj.findpet.core.base.mvp.BaseContract;
import com.zcj.findpet.core.base.mvp.BaseModel;
import com.zcj.findpet.core.base.mvp.BasePresenter;
import com.zcj.findpet.core.base.mvp.BaseView;
import com.zcj.net.callback.IError;
import com.zcj.net.callback.IFailure;
import com.zcj.net.callback.ISuccess;

import io.reactivex.Observer;

/**
 * Datetime: 2018/4/8 10:16
 * Author: zcj
 */
interface CountdownContract extends BaseContract<CountdownContract.Presenter, CountdownContract.View, CountdownContract.Model> {

    interface View extends BaseView<Presenter> {
        boolean isTvNull();

        void updateCountdown(String countdown);

        void goScroll();

        void goSignIn();

        void goMain();
    }

    interface Presenter extends BasePresenter<View> {
        void terminateCountDown();

        // TODO: 2018/4/8 测试
        void testRestClient();

        void testRxGet();

        void testRxRestClient();
    }

    interface Model extends BaseModel {
        boolean isSignIn();

        boolean isFirstLauncherApp();

        // TODO: 2018/4/8 测试
        void testRestClient(Context context, ISuccess success, IFailure failure, IError error);

        void testRxGet(Context context, Observer<String> observer);

        void testRxRestClient(Context context, Observer<String> observer);
    }
}
