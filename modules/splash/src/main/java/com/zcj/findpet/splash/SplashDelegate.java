package com.zcj.findpet.splash;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.zcj.findpet.core.delegate.AwesomeDelegate;

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
}
