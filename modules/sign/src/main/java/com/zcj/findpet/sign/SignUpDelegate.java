package com.zcj.findpet.sign;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatEditText;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.zcj.findpet.core.delegate.AwesomeDelegate;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by zcj on 2018/4/7 0:19
 */
public class SignUpDelegate extends AwesomeDelegate {

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

    private boolean checkForm() {
        final String name = mName.getText().toString().trim();
        final String email = mEmail.getText().toString().trim();
        final String phone = mPhone.getText().toString().trim();
        final String password = mPassword.getText().toString().trim();
        final String rePassword = mRePassword.getText().toString().trim();

        boolean isPass = true;

        if (TextUtils.isEmpty(name)) {
            mName.setError("请输入姓名");
            isPass = false;
        } else {
            mName.setError(null);
        }

        if (TextUtils.isEmpty(email) || Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            mEmail.setError("错误的邮箱格式");
            isPass = false;
        } else {
            mEmail.setError(null);
        }

        if (TextUtils.isEmpty(phone) || phone.length() != 11) {
            mPhone.setError("手机号码错误");
            isPass = false;
        } else {
            mPhone.setError(null);
        }

        if (TextUtils.isEmpty(password) || password.length() < 6) {
            mPassword.setError("请填写至少6位数密码");
            isPass = false;
        } else {
            mPassword.setError(null);
        }

        if (TextUtils.isEmpty(rePassword) || rePassword.length() < 6 || !TextUtils.equals(password, rePassword)) {
            mPassword.setError("密码验证错误");
            isPass = false;
        } else {
            mPassword.setError(null);
        }

        return isPass;
    }

    @OnClick(R2.id.btn_sign_up)
    void signUpAction() {
        if (checkForm()) {
            /*RestClient.builder()
                    .url("sign_up")
                    //.params("")
                    .success(new ISuccess() {
                        @Override
                        public void onSuccess(String response) {

                        }
                    })
                    .build()
                    .post();*/
            Toast.makeText(getContext(), "验证通过", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_sign_up;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
