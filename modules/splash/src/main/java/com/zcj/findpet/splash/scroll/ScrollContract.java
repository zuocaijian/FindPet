package com.zcj.findpet.splash.scroll;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.zcj.findpet.core.mvp.BaseContract;
import com.zcj.findpet.core.mvp.BaseModel;
import com.zcj.findpet.core.mvp.BasePresenter;
import com.zcj.findpet.core.mvp.BaseView;

import java.util.List;

/**
 * Datetime: 2018/4/8 11:41
 * Author: zcj
 */
interface ScrollContract extends BaseContract<ScrollContract.Presenter, ScrollContract.View, ScrollContract.Model> {

    interface Presenter extends BasePresenter<View> {
        void itemClick(int position);

        void pageSelected(int position);
    }

    interface View extends BaseView<Presenter> {
        void setScrollPages(CBViewHolderCreator holderCreator,
                            List datas,
                            int[] pageIndicatorId,
                            ConvenientBanner.PageIndicatorAlign align,
                            boolean canLoop);

        void goMain();
    }

    interface Model extends BaseModel {
        void setIsFirstLauncher(boolean isFirst);
    }
}
