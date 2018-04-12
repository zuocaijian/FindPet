package com.zcj.findpet.splash.countdown;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.zcj.findpet.core.app.Awesome;
import com.zcj.findpet.core.delegate.AwesomeDelegate;
import com.zcj.findpet.splash.R2;
import com.zcj.findpet.splash.scroll.SplashScrollDelegate;

import butterknife.BindView;
import butterknife.OnClick;
import me.yokeyword.fragmentation.ISupportFragment;

/**
 * Created by zcj on 2018/4/6 9:42
 */
@Route(path = "/splash/countdownFragment")
public class SplashCountdownDelegate extends AwesomeDelegate implements CountdownContract.View {

    @BindView(R2.id.tv_launcher_timer)
    //@BindView(R.id.tv_launcher_timer)
    AppCompatTextView mTvTimer;

    private CountdownContract.Presenter mPresenter;

    @OnClick(R2.id.tv_launcher_timer)
    //@OnClick(R.id.tv_launcher_timer)
    void timerAction() {
        mPresenter.terminateCountDown();
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_splash;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        mPresenter = new CountdownPresenter(getContext(), this);
        mPresenter.start();
    }

    @Override
    public boolean isTvNull() {
        return mTvTimer == null;
    }

    @Override
    public void updateCountdown(String countdown) {
        mTvTimer.setText(countdown);
    }

    @Override
    public void goScroll() {
        startWithPop(new SplashScrollDelegate());
    }

    @Override
    public void goSignIn() {
        // TODO: 2018/4/8 测试
        startWithPop((ISupportFragment) ARouter.getInstance().build("/sign/signUpFragment").navigation());
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
