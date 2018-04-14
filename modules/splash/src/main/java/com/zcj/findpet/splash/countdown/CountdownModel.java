package com.zcj.findpet.splash.countdown;

import android.content.Context;

import com.zcj.findpet.core.util.AwesomePreference;
import com.zcj.net.RestClient;
import com.zcj.net.RestCreator;
import com.zcj.net.callback.IError;
import com.zcj.net.callback.IFailure;
import com.zcj.net.callback.ISuccess;
import com.zcj.net.rx.RxRestClient;
import com.zcj.ui.launcher.ScrollLauncherTag;

import java.util.WeakHashMap;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Datetime: 2018/4/8 11:00
 * Author: zcj
 */
class CountdownModel implements CountdownContract.Model {

    @Override
    public boolean isFirstLauncherApp() {
        return !AwesomePreference.getAppFlag(ScrollLauncherTag.HAS_FIRST_LAUNCHER_APP.name());
    }

    @Override
    public void testRestClient(Context context, ISuccess success, IFailure failure, IError error) {
        RestClient.builder()
                .url("http://127.0.0.1/index")
                //.params("", "")
                .loader(context)
                .success(success)
                .failure(failure)
                .error(error)
                .build()
                .get();
    }

    @Override
    public void testRxGet(Context context, Observer<String> observer) {
        final String url = "index.php";
        final WeakHashMap<String, Object> params = new WeakHashMap<>();

        final Observable<String> observable = RestCreator.getRxRestService().get(url, params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        observable.subscribe(observer);
    }

    @Override
    public void testRxRestClient(Context context, Observer<String> observer) {
        RxRestClient.builder()
                .url("index.php")
                //.params("", "")
                .build()
                .get()
                .subscribe(observer);
    }
}
