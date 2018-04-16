package com.zcj.findpet.sign.signup.haspet;

import com.zcj.findpet.core.mvp.BaseContract;
import com.zcj.findpet.core.mvp.BaseModel;
import com.zcj.findpet.core.mvp.BasePresenter;
import com.zcj.findpet.core.mvp.BaseView;

/**
 * Created by zcj on 2018/4/14 18:09
 */
public interface HasPetContract extends BaseContract<HasPetContract.Presenter, HasPetContract.View, HasPetContract.Model> {

    interface Presenter extends BasePresenter<View> {
    }

    interface View extends BaseView<Presenter> {
        void setTitle(String title);
    }

    interface Model extends BaseModel {
    }
}
