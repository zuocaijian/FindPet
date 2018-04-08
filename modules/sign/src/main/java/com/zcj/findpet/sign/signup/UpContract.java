package com.zcj.findpet.sign.signup;

import com.zcj.findpet.core.base.mvp.BaseContract;
import com.zcj.findpet.core.base.mvp.BaseModel;
import com.zcj.findpet.core.base.mvp.BasePresenter;
import com.zcj.findpet.core.base.mvp.BaseView;
import com.zcj.net.callback.ISuccess;

/**
 * Datetime: 2018/4/8 14:30
 * Author: zcj
 */
interface UpContract extends BaseContract<UpContract.Presenter, UpContract.View, UpContract.Model> {

    interface View extends BaseView<Presenter> {
        String getName();

        String getEmail();

        String getPhone();

        String getPassword();

        String getRePassword();

        void nameError(String msg);

        void emailError(String msg);

        void phoneError(String msg);

        void passwordError(String msg);

        void rePasswordError(String msg);
    }

    interface Presenter extends BasePresenter<View> {
        void signUp();
    }

    interface Model extends BaseModel {
        void signUp(String name, String email, String phone, String password, ISuccess success);
    }
}
