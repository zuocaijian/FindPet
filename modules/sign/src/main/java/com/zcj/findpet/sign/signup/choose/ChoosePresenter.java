package com.zcj.findpet.sign.signup.choose;

import android.content.Context;

import com.zcj.ui.util.ResUtils;

/**
 * Created by zcj on 2018/4/14 17:18
 */
public class ChoosePresenter implements ChooseContract.Presenter {

    private ChooseContract.View VIEW;

    private final Context CONTEXT;

    public ChoosePresenter(Context context, ChooseContract.View view) {
        this.CONTEXT = context;
        this.VIEW = view;
    }

    @Override
    public void start() {
        VIEW.setTitle(ResUtils.getString(CONTEXT, com.zcj.findpet.core.R.string.core_app_name));
    }
}
