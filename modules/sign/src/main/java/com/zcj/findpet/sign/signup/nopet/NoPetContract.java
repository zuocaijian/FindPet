package com.zcj.findpet.sign.signup.nopet;

import com.zcj.findpet.core.mvp.BaseContract;
import com.zcj.findpet.core.mvp.BaseModel;
import com.zcj.findpet.core.mvp.BasePresenter;
import com.zcj.findpet.core.mvp.BaseView;

/**
 * Created by zcj on 2018/4/14 18:23
 */
public interface NoPetContract extends BaseContract<NoPetContract.Presenter, NoPetContract.View, NoPetContract.Model> {

    interface Presenter extends BasePresenter<View> {
        void signUp();
    }

    interface View extends BaseView<Presenter> {
        void setTitle(String title);

        String getNickName();

        String getPhone();

        String getCaptcha();

        String getEmail();

        String getPetType();

        String getPetVariety();

        void goSetPassword();
    }

    interface Model extends BaseModel {
    }
}
