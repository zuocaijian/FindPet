package com.zcj.findpet.personal.rx;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.jakewharton.rxbinding2.widget.RxTextView;
import com.zcj.net.RestClient;
import com.zcj.net.callback.ISuccess;
import com.zcj.net.rx.RxRestClient;

import java.util.concurrent.TimeUnit;

import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;

/**
 * 场景四：搜索优化
 * 1、避免无意义的请求
 * 2、避免两次网络请求结果顺序错乱
 * Datetime: 2018/4/10 12:30
 * Author: zcj
 */
public class Test4 {

    public Test4() {
    }

    private EditText mEtKey;

    public void etMonitor() {
        mEtKey.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                String key = mEtKey.getText().toString().trim();
                if (key.length() > 0) {
                    // 请求搜索接口，成功后把结果显示到界面上.
                    //search(key);
                }
            }
        });
    }

    private void search(String key) {
        RestClient
                .builder()
                .url("search")
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        //显示搜索结果
                        mEtKey.setText(response);
                    }
                })
                .build()
                .get();

    }

    @SuppressWarnings("CheckResult")
    private void rx() {
        RxTextView
                .textChanges(mEtKey)
                .debounce(500, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread())
                .subscribeOn(AndroidSchedulers.mainThread())
                .filter(new Predicate<CharSequence>() {
                    @Override
                    public boolean test(CharSequence charSequence) throws Exception {
                        return charSequence.length() > 0;
                    }
                }) //过滤用户关键字
                //.flatMap //替换为switchMap操作符，只发射最近一次请求
                .switchMap(new Function<CharSequence, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(CharSequence charSequence) throws Exception {
                        return RxRestClient
                                .builder()
                                .url("search")
                                .build()
                                .get();
                    }
                })
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        //显示搜索结果
                        mEtKey.setText(s);
                    }
                });
    }
}
