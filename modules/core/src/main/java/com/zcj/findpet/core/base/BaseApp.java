package com.zcj.findpet.core.base;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.zcj.findpet.core.Awesome;

/**
 * Created by cj_zu on 2018/4/3.
 */

public class BaseApp extends Application {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Awesome.init(this)
                .withIcon(new FontAwesomeModule())
                .withApiHost("http://127.0.0.1/")
                .configured();
    }
}
