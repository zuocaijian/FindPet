package com.zcj.findpet.splash.scroll;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.zcj.findpet.core.app.Awesome;
import com.zcj.findpet.core.delegate.AwesomeDelegate;

import java.util.List;

import me.yokeyword.fragmentation.ISupportFragment;

/**
 * Created by zcj on 2018/4/6 23:02
 */
public class SplashScrollDelegate extends AwesomeDelegate implements ScrollContract.View,
        OnItemClickListener, ViewPager.OnPageChangeListener {

    private ScrollContract.Presenter mPresenter;

    private ConvenientBanner<Integer> mConvenientBanner = null;

    @Override
    public Object setLayout() {
        mConvenientBanner = new ConvenientBanner<>(getContext());
        return mConvenientBanner;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        mPresenter = new ScrollPresenter(getContext(), this);
        mPresenter.start();
    }

    @Override
    public void onItemClick(int position) {
        mPresenter.itemClick(position);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
        mPresenter.pageSelected(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }

    @SuppressWarnings("unchecked")
    @Override
    public void setScrollPages(CBViewHolderCreator holderCreator, List datas,
                               int[] pageIndicatorId,
                               ConvenientBanner.PageIndicatorAlign align,
                               boolean canLoop) {
        mConvenientBanner.setPages(holderCreator, datas)
                .setPageIndicator(pageIndicatorId)
                .setPageIndicatorAlign(align)
                .setOnItemClickListener(this)
                .setOnPageChangeListener(this)
                .setCanLoop(canLoop);
    }

    @Override
    public void goSignIn() {
        // TODO: 2018/4/8 测试
        start((ISupportFragment) ARouter.getInstance().build("/sign/signUpFragment").navigation());
    }

    @Override
    public void goMain() {
        ARouter.getInstance().build("/frame/mainActivity").navigation();
    }

    @Override
    public void showLoading() {
    }

    @Override
    public void hideLoading() {
    }

    @Override
    public void showToast(String msg, boolean isLong) {
        Toast.makeText(Awesome.getApplicationContext(), msg, isLong ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT).show();
    }
}
