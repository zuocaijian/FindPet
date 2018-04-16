package com.zcj.findpet.sign.signin;

import com.zcj.findpet.core.mvp.BaseContract;
import com.zcj.findpet.core.mvp.BaseModel;
import com.zcj.findpet.core.mvp.BasePresenter;
import com.zcj.findpet.core.mvp.BaseView;

/**
 * Datetime: 2018/4/8 15:04
 * Author: zcj
 */
interface InContract extends BaseContract<InContract.Presenter, InContract.View, InContract.Model> {

    interface Presenter extends BasePresenter<View> {
    }

    interface View extends BaseView<Presenter> {
        void setTitle(String title);
    }

    interface Model extends BaseModel {
    }
}
