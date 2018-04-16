package com.zcj.findpet.sign.signup.choose;

import com.zcj.findpet.core.mvp.BaseModel;
import com.zcj.findpet.core.mvp.BasePresenter;
import com.zcj.findpet.core.mvp.BaseView;

/**
 * Created by zcj on 2018/4/14 17:15
 */
public interface ChooseContract<P extends ChooseContract.Presenter, V extends ChooseContract.View, M extends ChooseContract.Model> {

    interface Presenter extends BasePresenter<View> {
    }

    interface View extends BaseView<Presenter> {
        void setTitle(String title);
    }

    interface Model extends BaseModel {
    }
}
