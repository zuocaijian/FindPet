package com.zcj.findpet.main;

import com.zcj.findpet.core.activities.ProxyActivity;
import com.zcj.findpet.core.delegate.AwesomeDelegate;
import com.zcj.findpet.splash.SplashDelegate;

/**
 * Created by zcj on 2018/4/6 9:54
 */
public class MainActivity extends ProxyActivity {

    @Override
    public AwesomeDelegate setRootDelegate() {
        return new SplashDelegate();
    }
}
