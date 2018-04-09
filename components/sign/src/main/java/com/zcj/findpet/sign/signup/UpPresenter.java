package com.zcj.findpet.sign.signup;

import android.content.Context;
import android.text.TextUtils;
import android.util.Patterns;

import com.zcj.net.callback.ISuccess;

/**
 * Datetime: 2018/4/8 14:34
 * Author: zcj
 */
class UpPresenter implements UpContract.Presenter {

    private UpContract.View mView;
    private UpContract.Model mModel;

    private final Context mContext;

    public UpPresenter(Context context, UpContract.View view) {
        this.mContext = context;
        this.mView = view;
        this.mModel = new UpModel();
    }

    @Override
    public void signUp() {
        if (checkForm()) {
            mModel.signUp(mView.getName(), mView.getEmail(), mView.getPhone(), mView.getPassword(), new ISuccess() {
                @Override
                public void onSuccess(String response) {
                    mView.showToast("sign in success", false);
                }
            });
        }
    }

    @Override
    public void start() {
    }

    private boolean checkForm() {
        final String name = mView.getName();
        final String email = mView.getEmail();
        final String phone = mView.getPhone();
        final String password = mView.getPassword();
        final String rePassword = mView.getRePassword();

        boolean isPass = true;

        if (TextUtils.isEmpty(name)) {
            mView.nameError("请输入姓名");
            isPass = false;
        } else {
            mView.nameError(null);
        }

        if (TextUtils.isEmpty(email) || Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            mView.emailError("错误的邮箱格式");
            isPass = false;
        } else {
            mView.emailError(null);
        }

        if (TextUtils.isEmpty(phone) || phone.length() != 11) {
            mView.phoneError("手机号码错误");
            isPass = false;
        } else {
            mView.phoneError(null);
        }

        if (TextUtils.isEmpty(password) || password.length() < 6) {
            mView.passwordError("请填写至少6位数密码");
            isPass = false;
        } else {
            mView.passwordError(null);
        }

        if (TextUtils.isEmpty(rePassword) || rePassword.length() < 6 || !TextUtils.equals(password, rePassword)) {
            mView.rePasswordError("密码验证错误");
            isPass = false;
        } else {
            mView.rePasswordError(null);
        }

        return isPass;
    }
}
