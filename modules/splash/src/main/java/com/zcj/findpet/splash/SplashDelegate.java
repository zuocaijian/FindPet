package com.zcj.findpet.splash;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.zcj.findpet.core.delegate.AwesomeDelegate;
import com.zcj.net.RestClient;
import com.zcj.net.callback.IError;
import com.zcj.net.callback.IFailure;
import com.zcj.net.callback.ISuccess;

/**
 * Created by zcj on 2018/4/6 9:42
 */
public class SplashDelegate extends AwesomeDelegate {

    @Override
    public Object setLayout() {
        return R.layout.delegate_splash;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }

    private void testRestClient() {
        RestClient.builder()
                .url("")
                .params("", "")
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {

                    }
                })
                .failure(new IFailure() {
                    @Override
                    public void onFailure() {

                    }
                })
                .error(new IError() {
                    @Override
                    public void onError(int code, String msg) {

                    }
                })
                .build();
    }
}
