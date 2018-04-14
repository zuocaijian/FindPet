package com.zcj.findpet.sign.signup.haspet;

import com.zcj.findpet.core.base.mvp.BaseModel;
import com.zcj.findpet.core.base.mvp.BasePresenter;
import com.zcj.findpet.core.base.mvp.BaseView;

/**
 * Created by zcj on 2018/4/14 18:09
 */
public interface HasPetContract {

    interface View extends BaseView<Presenter> {
        void setTitle(String title);
    }

    interface Presenter extends BasePresenter<View> {

    }

    interface Model extends BaseModel {

    }
}
