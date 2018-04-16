package com.zcj.findpet.sign.signup.setpassword;

import com.zcj.findpet.core.mvp.BaseContract;
import com.zcj.findpet.core.mvp.BaseModel;
import com.zcj.findpet.core.mvp.BasePresenter;
import com.zcj.findpet.core.mvp.BaseView;

/**
 * Created by zcj on 2018/4/14 18:48
 */
public interface PasswordContract extends BaseContract<PasswordContract.Presenter, PasswordContract.View, PasswordContract.Model> {

    interface Presenter extends BasePresenter<View> {
    }

    interface View extends BaseView<Presenter> {
        void setTitle(String title);
    }

    interface Model extends BaseModel {
    }
}
