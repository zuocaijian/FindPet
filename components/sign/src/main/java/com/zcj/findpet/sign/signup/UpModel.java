package com.zcj.findpet.sign.signup;

import com.zcj.net.RestClient;
import com.zcj.net.callback.ISuccess;

/**
 * Datetime: 2018/4/8 14:37
 * Author: zcj
 */
class UpModel implements UpContract.Model {

    @Override
    public void signUp(String name, String email, String phone, String password, ISuccess success) {
        RestClient.builder()
                .url("sign_up")
                .params("name", name)
                .params("email", email)
                .params("phone", phone)
                .params("password", password)
                .success(success)
                .build()
                .post();
    }
}
