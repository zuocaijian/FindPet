package com.zcj.findpet.sign.signup.nopet;

import android.content.Context;
import android.text.TextUtils;
import android.util.Patterns;

import com.zcj.ui.util.ResUtils;

/**
 * Created by zcj on 2018/4/14 18:29
 */
public class NoPetPresenter implements NoPetContract.Presenter {

    private final NoPetContract.View VIEW;

    private final Context CONTEXT;

    public NoPetPresenter(Context context, NoPetContract.View view) {
        CONTEXT = context;
        VIEW = view;
    }

    @Override
    public void signUp() {
        final String nickname = VIEW.getNickName();
        final String phone = VIEW.getPhone();
        final String captcha = VIEW.getCaptcha();
        final String email = VIEW.getEmail();
        final String petType = VIEW.getPetType();
        final String petVariety = VIEW.getPetVariety();

        if (TextUtils.isEmpty(nickname)) {
            VIEW.showToast("请输入您的昵称", false);
            return;
        }
        if (TextUtils.isEmpty(phone) || phone.length() != 11) {
            VIEW.showToast("请输入您的手机号码", false);
            return;
        }
        if (TextUtils.isEmpty(captcha)) {
            VIEW.showToast("请输入验证码", false);
            return;
        }
        if (TextUtils.isEmpty(email)) {
            VIEW.showToast("请输入您的邮箱地址", false);
            return;
        }
        if (TextUtils.isEmpty(email) || Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            VIEW.showToast("请输入正确的邮箱地址", false);
            return;
        }
        if (TextUtils.isEmpty(petType)) {
            VIEW.showToast("请输入您喜欢的宠物类型", false);
            return;
        }
        if (TextUtils.isEmpty(petVariety)) {
            VIEW.showToast("请输入您喜欢的宠物品种", false);
            return;
        }

        // TODO: 2018/4/14 请求接口注册
        VIEW.goSetPassword();
    }

    @Override
    public void start() {
        VIEW.setTitle(ResUtils.getString(CONTEXT, com.zcj.findpet.core.R.string.core_app_name));
    }
}
