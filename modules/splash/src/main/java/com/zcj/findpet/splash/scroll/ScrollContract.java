package com.zcj.findpet.splash.scroll;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.zcj.findpet.core.base.mvp.BaseContract;
import com.zcj.findpet.core.base.mvp.BaseModel;
import com.zcj.findpet.core.base.mvp.BasePresenter;
import com.zcj.findpet.core.base.mvp.BaseView;

import java.util.List;

/**
 * Datetime: 2018/4/8 11:41
 * Author: zcj
 */
interface ScrollContract extends BaseContract<ScrollContract.Presenter, ScrollContract.View, ScrollContract.Model> {

    interface View extends BaseView<Presenter> {
        void setScrollPages(CBViewHolderCreator holderCreator,
                            List datas,
                            int[] pageIndicatorId,
                            ConvenientBanner.PageIndicatorAlign align,
                            boolean canLoop);

        void goMain();
    }

    interface Presenter extends BasePresenter<View> {
        void itemClick(int position);

        void pageSelected(int position);
    }

    interface Model extends BaseModel {
        void setIsFirstLauncher(boolean isFirst);
    }
}
