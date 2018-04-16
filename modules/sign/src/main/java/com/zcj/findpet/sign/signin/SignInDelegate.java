package com.zcj.findpet.sign.signin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.zcj.findpet.core.app.Awesome;
import com.zcj.findpet.core.delegate.AwesomeDelegate;
import com.zcj.findpet.sign.R;
import com.zcj.findpet.sign.R2;
import com.zcj.ui.custom.CommonTitleBar;

import butterknife.BindView;
import butterknife.OnClick;
import me.yokeyword.fragmentation.ISupportFragment;

/**
 * Created by zcj on 2018/4/7 1:08
 */
@Route(path = "/sign/signInFragment")
public class SignInDelegate extends AwesomeDelegate implements InContract.View {

    @BindView(R2.id.title_bar)
    //@BindView(R.id.title_bar)
            CommonTitleBar mTitleBar;

    private InContract.Presenter mPresenter;

    @OnClick(R2.id.tv_sign_in)
        //@OnClick(R.id.tv_sign_in)
    void signInAction() {
        getProxyActivity().finish();
    }

    @OnClick(R2.id.tv_sign_up)
        //@OnClick(R.id.tv_sign_up)
    void signUpAction() {
        start((ISupportFragment) ARouter.getInstance().build("/sign/chooseSignUpTypeFragment").navigation());
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_sign_in;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        mPresenter = new InPresenter(getContext(), this);
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
