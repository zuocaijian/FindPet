package com.zcj.findpet.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.zcj.findpet.core.activities.ProxyActivity;
import com.zcj.findpet.core.delegate.AwesomeDelegate;

/**
 * Created by zcj on 2018/4/6 9:54
 */
@Route(path = "/main/mainActivity")
public class MainActivity extends ProxyActivity {

    @Autowired(name = "target")
    String mRootDelegate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }

    @Override
    public AwesomeDelegate setRootDelegate() {
        return (AwesomeDelegate) ARouter.getInstance()
                .build(TextUtils.isEmpty(mRootDelegate) ? "/splash/countdownFragment" : mRootDelegate)
                .navigation();
    }
}
