package com.zcj.findpet.personal.me;

import android.widget.ImageView;

import com.zcj.findpet.core.mvp.BaseContract;
import com.zcj.findpet.core.mvp.BaseModel;
import com.zcj.findpet.core.mvp.BasePresenter;
import com.zcj.findpet.core.mvp.BaseView;

/**
 * Datetime: 2018/4/10 9:53
 * Author: zcj
 */
public interface MeContract extends BaseContract<MeContract.Presenter, MeContract.View, MeContract.Model> {

    interface Presenter extends BasePresenter<View> {
        void testRx();

        void loadImg(ImageView view);
    }

    interface View extends BaseView<Presenter> {
    }

    interface Model extends BaseModel {
    }
}
