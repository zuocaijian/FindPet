package com.zcj.findpet.core.mvp;

/**
 * Datetime: 2018/4/8 9:58
 * Author: zcj
 */
public interface BaseView<P extends BasePresenter> {

    //void setPresenter(T presenter);

    void showLoading();

    void hideLoading();

    void showToast(String msg, boolean isLong);
}
