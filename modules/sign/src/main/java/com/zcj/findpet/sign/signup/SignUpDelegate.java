package com.zcj.findpet.sign.signup;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.Toast;

import com.zcj.findpet.core.app.Awesome;
import com.zcj.findpet.core.delegate.AwesomeDelegate;
import com.zcj.findpet.sign.R;
import com.zcj.findpet.sign.R2;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by zcj on 2018/4/7 0:19
 */
public class SignUpDelegate extends AwesomeDelegate implements UpContract.View {

    @BindView(R2.id.edit_sign_up_name)
    AppCompatEditText mName = null;
    @BindView(R2.id.edit_sign_up_email)
    AppCompatEditText mEmail = null;
    @BindView(R2.id.edit_sign_up_phone)
    AppCompatEditText mPhone = null;
    @BindView(R2.id.edit_sign_up_password)
    AppCompatEditText mPassword = null;
    @BindView(R2.id.edit_sign_up_re_password)
    AppCompatEditText mRePassword = null;

    private UpContract.Presenter mPresenter;

    @OnClick(R2.id.btn_sign_up)
    void signUpAction() {
        mPresenter.signUp();
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_sign_up;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        mPresenter = new UpPresenter(getContext(), this);
        mPresenter.start();
    }

    @Override
    public String getName() {
        return mName.getText().toString().trim();
    }

    @Override
    public String getEmail() {
        return mEmail.getText().toString().trim();
    }

    @Override
    public String getPhone() {
        return mEmail.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return mPassword.getText().toString().trim();
    }

    @Override
    public String getRePassword() {
        return mRePassword.getText().toString().trim();
    }

    @Override
    public void nameError(String msg) {
        mName.setError(msg);
    }

    @Override
    public void emailError(String msg) {
        mEmail.setError(msg);
    }

    @Override
    public void phoneError(String msg) {
        mPhone.setError(msg);
    }

    @Override
    public void passwordError(String msg) {
        mPassword.setError(msg);
    }

    @Override
    public void rePasswordError(String msg) {
        mRePassword.setError(msg);
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
