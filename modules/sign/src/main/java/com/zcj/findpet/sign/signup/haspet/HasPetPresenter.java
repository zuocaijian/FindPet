package com.zcj.findpet.sign.signup.haspet;

import android.content.Context;

import com.zcj.ui.util.ResUtils;

/**
 * Created by zcj on 2018/4/14 18:12
 */
public class HasPetPresenter implements HasPetContract.Presenter {

    private final HasPetContract.View VIEW;

    private final Context CONTEXT;

    public HasPetPresenter(Context context, HasPetContract.View view) {
        CONTEXT = context;
        VIEW = view;
    }

    @Override
    public void start() {
        VIEW.setTitle(ResUtils.getString(CONTEXT, com.zcj.findpet.core.R.string.core_app_name));
    }
}
