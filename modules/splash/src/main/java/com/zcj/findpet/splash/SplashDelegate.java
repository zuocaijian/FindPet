package com.zcj.findpet.splash;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.zcj.findpet.core.app.Awesome;
import com.zcj.findpet.core.delegate.AwesomeDelegate;
import com.zcj.net.RestClient;
import com.zcj.net.RestCreator;
import com.zcj.net.callback.IError;
import com.zcj.net.callback.IFailure;
import com.zcj.net.callback.ISuccess;
import com.zcj.net.rx.RxRestClient;

import java.util.WeakHashMap;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

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
        testRestClient();
        testRxGet();
        testRxRestClient();
    }

    // TODO: 2018/4/6 测试网络框架
    private void testRestClient() {
        RestClient.builder()
                .url("http://127.0.0.1/index")
                //.params("", "")
                .loader(getContext())
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        Toast.makeText(getContext(), response, Toast.LENGTH_LONG).show();
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
                .build()
                .get();
    }

    // TODO: 2018/4/6 测试网络框架
    private void testRxGet() {
        final String url = "index.php";
        final WeakHashMap<String, Object> params = new WeakHashMap<>();

        final Observable<String> observable = RestCreator.getRxRestService().get(url, params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        observable.subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Toast.makeText(Awesome.getApplicationContext(), "开始", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNext(String s) {
                Toast.makeText(Awesome.getApplicationContext(), s, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(Awesome.getApplicationContext(), "错误", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onComplete() {
                Toast.makeText(Awesome.getApplicationContext(), "结束", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // TODO: 2018/4/6 测试网络框架
    private void testRxRestClient() {
        RxRestClient.builder()
                .url("index.php")
                //.params("", "")
                .build()
                .get()
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Toast.makeText(Awesome.getApplicationContext(), "开始", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNext(String s) {
                        Toast.makeText(Awesome.getApplicationContext(), s, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(Awesome.getApplicationContext(), "错误", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onComplete() {
                        Toast.makeText(Awesome.getApplicationContext(), "结束", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
