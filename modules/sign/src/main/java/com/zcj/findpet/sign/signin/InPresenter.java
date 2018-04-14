package com.zcj.findpet.sign.signin;

import android.content.Context;

/**
 * Datetime: 2018/4/8 15:06
 * Author: zcj
 */
class InPresenter implements InContract.Presenter {

    private InContract.View mView;
    private InContract.Model mModel;

    private Context mContext;

    public InPresenter(Context context, InContract.View view) {
        this.mContext = context;
        this.mView = view;
        this.mModel = new InModel();
    }

    @Override
    public void start() {
        mView.setTitle("得宠");
    }
}
