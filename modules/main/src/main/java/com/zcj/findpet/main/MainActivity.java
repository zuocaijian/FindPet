package com.zcj.findpet.main;

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
    public void setActivityTheme() {
        if (TextUtils.isEmpty(mRootDelegate)) {
            setTheme(R.style.CoreSplashTheme);
        } else {
            setTheme(R.style.AppTheme);
        }
    }

    @Override
    public AwesomeDelegate setRootDelegate() {
        if (TextUtils.isEmpty(mRootDelegate)) {
            mRootDelegate = "/splash/countdownFragment";
        }

        return (AwesomeDelegate) ARouter.getInstance()
                .build(mRootDelegate)
                .navigation();
    }
}
