package com.zcj.findpet.personal.me;

import com.zcj.findpet.core.base.mvp.BaseModel;
import com.zcj.findpet.core.base.mvp.BasePresenter;
import com.zcj.findpet.core.base.mvp.BaseView;

/**
 * Datetime: 2018/4/10 9:53
 * Author: zcj
 */
public interface MeContract {

    interface View extends BaseView<Presenter> {
    }

    interface Presenter extends BasePresenter<View> {
        void testRx();

        void release();
    }

    interface Model extends BaseModel {
    }
}
