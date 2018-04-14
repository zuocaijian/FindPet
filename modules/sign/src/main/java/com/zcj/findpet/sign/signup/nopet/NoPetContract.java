package com.zcj.findpet.sign.signup.nopet;

import com.zcj.findpet.core.base.mvp.BaseModel;
import com.zcj.findpet.core.base.mvp.BasePresenter;
import com.zcj.findpet.core.base.mvp.BaseView;

/**
 * Created by zcj on 2018/4/14 18:23
 */
public interface NoPetContract {
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

    interface Presenter extends BasePresenter<View> {
        void signUp();
    }

    interface Model extends BaseModel {

    }
}
