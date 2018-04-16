package com.zcj.findpet.sign.signup.setpassword;

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
 * Created by zcj on 2018/4/14 18:47
 */
@Route(path = "/sign/setPasswordFragment")
public class SetPasswordDelegate extends AwesomeDelegate implements PasswordContract.View {

    @BindView(R2.id.title_bar)
    //@BindView(R.id.title_bar)
            TitleBar mTitleBar;

    private PasswordContract.Presenter mPresenter;

    @Override
    public Object setLayout() {
        return R.layout.delegate_set_password;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        mPresenter = new PasswordPresenter(getContext(), this);
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
