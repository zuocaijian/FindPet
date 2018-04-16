package com.zcj.findpet.sign.signup.setpassword;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.content.Context;
import android.support.annotation.NonNull;

import com.zcj.ui.util.ResUtils;

/**
 * Created by zcj on 2018/4/14 18:51
 */
public class PasswordPresenter implements PasswordContract.Presenter {

    private final PasswordContract.View VIEW;

    private final Context CONTEXT;

    public PasswordPresenter(Context context, PasswordContract.View view) {
        CONTEXT = context;
        VIEW = view;
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
