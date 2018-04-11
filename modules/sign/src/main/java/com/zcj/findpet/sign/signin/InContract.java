package com.zcj.findpet.sign.signin;

import com.zcj.findpet.core.base.mvp.BaseModel;
import com.zcj.findpet.core.base.mvp.BasePresenter;
import com.zcj.findpet.core.base.mvp.BaseView;

/**
 * Datetime: 2018/4/8 15:04
 * Author: zcj
 */
interface InContract {

    interface View extends BaseView<Presenter> {
    }

    interface Presenter extends BasePresenter<View> {
    }

    interface Model extends BaseModel {
    }
}
