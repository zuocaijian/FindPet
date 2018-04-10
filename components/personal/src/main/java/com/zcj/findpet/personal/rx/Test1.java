package com.zcj.findpet.personal.rx;

import android.annotation.SuppressLint;

import com.zcj.net.RestClient;
import com.zcj.net.callback.ISuccess;
import com.zcj.net.rx.RxRestClient;

import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * 场景一：使用flatMap注册成功后自动登录
 * Datetime: 2018/4/10 9:42
 * Author: zcj
 */
public class Test1 {

    public Test1() {
    }

    private void register() {
        RestClient.builder()
                .url("register")
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        //注册成功之后再调用登录接口
                        //login();
                    }
                })
                .build()
                .post();
    }

    private void login() {
        //登录
        RestClient.builder()
                .url("login")
                .params("name", "name")
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        //登录成功
                    }
                })
                .build()
                .get();
    }

    @SuppressLint("CheckResult")
    private void rx() {
        RxRestClient.builder()
                .url("register")
                .build()
                .post()
                .flatMap(new Function<String, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(String s) throws Exception {
                        //注册成功之后再调用登陆接口
                        return RxRestClient.builder()
                                .url("login")
                                .params("name", "name")
                                .build()
                                .get();
                    }
                })
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        //登录成功
                    }
                });
    }
}
