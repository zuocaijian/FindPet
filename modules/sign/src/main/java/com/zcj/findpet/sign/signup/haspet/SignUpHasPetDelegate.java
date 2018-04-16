package com.zcj.findpet.sign.signup.haspet;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.zcj.findpet.core.app.Awesome;
import com.zcj.findpet.core.delegate.AwesomeDelegate;
import com.zcj.findpet.core.views.TitleBar;
import com.zcj.findpet.sign.R;
import com.zcj.findpet.sign.R2;

import butterknife.BindView;

/**
 * Created by zcj on 2018/4/14 17:23
 */
@Route(path = "/sign/signUpHasPetFragment")
public class SignUpHasPetDelegate extends AwesomeDelegate implements HasPetContract.View {

    @BindView(R2.id.title_bar)
    //@BindView(R.id.title_bar)
            TitleBar mTitleBar;

    private HasPetContract.Presenter mPresenter;

    @Override
    public Object setLayout() {
        return R.layout.delegate_sign_up_has_pet;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        mPresenter = new HasPetPresenter(getContext(), this);
        getLifecycle().addObserver(mPresenter);
        mPresenter.start();
    }

    @Override
    public void setTitle(String title) {
        mTitleBar.setTitle(title);
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
