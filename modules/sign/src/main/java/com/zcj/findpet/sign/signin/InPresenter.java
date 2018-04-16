package com.zcj.findpet.sign.signin;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.content.Context;
import android.support.annotation.NonNull;

import com.zcj.ui.util.ResUtils;

/**
 * Datetime: 2018/4/8 15:06
 * Author: zcj
 */
class InPresenter implements InContract.Presenter {

    private final InContract.View VIEW;
    private final InContract.Model MODEL;

    private final Context CONTEXT;

    public InPresenter(Context context, InContract.View view) {
        this.CONTEXT = context;
        this.VIEW = view;
        this.MODEL = new InModel();
    }

    @Override
    public void start() {
        VIEW.setTitle(ResUtils.getString(CONTEXT, com.zcj.findpet.core.R.string.core_app_name));
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
