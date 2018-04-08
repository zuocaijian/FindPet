package com.zcj.findpet.sign.signin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.zcj.findpet.core.app.Awesome;
import com.zcj.findpet.core.delegate.AwesomeDelegate;
import com.zcj.findpet.sign.R;

/**
 * Created by zcj on 2018/4/7 1:08
 */
@Route(path = "/sign/signInFragment")
public class SignInDelegate extends AwesomeDelegate implements InContract.View {

    private InContract.Presenter mPresenter;

    @Override
    public Object setLayout() {
        return R.layout.delegate_sign_in;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        mPresenter = new InPresenter(getContext(), this);
        mPresenter.start();
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
