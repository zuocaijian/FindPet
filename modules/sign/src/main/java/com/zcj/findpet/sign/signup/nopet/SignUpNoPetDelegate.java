package com.zcj.findpet.sign.signup.nopet;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.zcj.findpet.core.app.Awesome;
import com.zcj.findpet.core.delegate.AwesomeDelegate;
import com.zcj.findpet.core.views.TitleBar;
import com.zcj.findpet.sign.R;
import com.zcj.findpet.sign.R2;

import butterknife.BindView;
import butterknife.OnClick;
import me.yokeyword.fragmentation.ISupportFragment;

/**
 * Created by zcj on 2018/4/14 17:23
 */
@Route(path = "/sign/signUpNoPetFragment")
public class SignUpNoPetDelegate extends AwesomeDelegate implements NoPetContract.View {

    @BindView(R2.id.title_bar)
    //@BindView(R.id.title_bar)
            TitleBar mTitleBar;
    @BindView(R2.id.et_nickname)
    //@BindView(R.id.et_nickname)
            EditText mEtNickname;
    @BindView(R2.id.et_phone)
    //@BindView(R.id.et_phone)
            EditText mEtPhone;
    @BindView(R2.id.et_captcha)
    //@BindView(R.id.et_captcha)
            EditText mEtCaptcha;
    @BindView(R2.id.et_email)
    //@BindView(R.id.et_email)
            EditText mEtEmail;
    @BindView(R2.id.et_pet_type)
    //@BindView(R.id.et_pet_type)
            EditText mEtPetType;
    @BindView(R2.id.et_pet_variety)
    //@BindView(R.id.et_pet_variety)
            EditText mEtPetVariety;

    private NoPetContract.Presenter mPresenter;

    @OnClick(R2.id.tv_sign_up)
        //@OnClick(R.id.tv_sign_up)
    void signUpAction() {
        mPresenter.signUp();
    }

    @OnClick(R2.id.tv_sign_in)
        //@OnClick(R.id.tv_sign_in)
    void signInAction() {
        startWithPopTo((ISupportFragment) ARouter.getInstance().build("/sign/signInFragment").navigation(),
                ((ISupportFragment) ARouter.getInstance().build("/sign/signInFragment").navigation()).getClass(),
                true);
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_sign_up_no_pet;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        mPresenter = new NoPetPresenter(getContext(), this);
        getLifecycle().addObserver(mPresenter);
        mPresenter.start();
    }

    @Override
    public void setTitle(String title) {
        mTitleBar.setTitle(title);
    }

    @Override
    public String getNickName() {
        return mEtNickname.getText().toString().trim();
    }

    @Override
    public String getPhone() {
        return mEtPhone.getText().toString().trim();
    }

    @Override
    public String getCaptcha() {
        return mEtCaptcha.getText().toString().trim();
    }

    @Override
    public String getEmail() {
        return mEtEmail.getText().toString().trim();
    }

    @Override
    public String getPetType() {
        return mEtPetType.getText().toString().trim();
    }

    @Override
    public String getPetVariety() {
        return mEtPetVariety.getText().toString().trim();
    }

    @Override
    public void goSetPassword() {
        start((ISupportFragment) ARouter.getInstance().build("/sign/setPasswordFragment").navigation());
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
