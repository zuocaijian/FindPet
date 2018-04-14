package com.zcj.findpet.sign.signup.setpassword;

import android.content.Context;

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
}
