package com.zcj.findpet.personal.rx;

import android.util.Pair;

import com.zcj.net.RestClient;
import com.zcj.net.callback.ISuccess;
import com.zcj.net.rx.RxRestClient;

import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;

/**
 * 场景二：使用zip对并发的请求做处理
 * 获取接口1，获取接口2，获取接口3...，有一个失败则视为全部失败，全部成功则更新界面
 * Datetime: 2018/4/10 11:30
 * Author: zcj
 */
public class Test2 {

    public Test2() {
    }

    boolean isApi1Succ = false;
    boolean isApi2Succ = false;

    private void api1() {
        RestClient.builder()
                .url("api1")
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        //或者是api2()
                        isSucc();
                    }
                })
                .build()
                .get();
    }

    private void api2() {
        RestClient.builder()
                .url("api2")
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        isSucc();
                    }
                })
                .build()
                .get();
    }

    private void isSucc() {
        if (isApi1Succ && isApi2Succ) {
            //更新界面
        }
    }

    @SuppressWarnings("CheckResult")
    private void rx() {
        Observable.zip(RxRestClient
                        .builder()
                        .url("api1")
                        .build()
                        .get(),
                RxRestClient
                        .builder()
                        .url("api1")
                        .build()
                        .get(),
                new BiFunction<String, String, Pair<String, String>>() {
                    @Override
                    public Pair<String, String> apply(String s, String s2) throws Exception {
                        return Pair.create(s, s2);
                    }
                })
                .subscribe(new Consumer<Pair<String, String>>() {
                    @Override
                    public void accept(Pair<String, String> stringStringPair) throws Exception {
                        //更新界面
                    }
                });
    }
}
