package com.zcj.findpet.core.base;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.alibaba.android.arouter.launcher.ARouter;
import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.zcj.findpet.core.R;
import com.zcj.findpet.core.app.Awesome;
import com.zcj.findpet.core.app.ConfigKeys;
import com.zcj.image.ImageLoader;
import com.zcj.image.strategy.GlideLoader;
import com.zcj.net.Interceptors.BaseInterceptor;
import com.zcj.net.Interceptors.DebugInterceptor;
import com.zcj.net.RestCreator;

import java.util.List;

/**
 * Created by cj_zu on 2018/4/3.
 */

public class BaseApp extends Application {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onCreate() {
        super.onCreate();
        Awesome.init(this)
                .withIcon(new FontAwesomeModule())
                .withApiHost("http://127.0.0.1/")
                .withInterceptor(new DebugInterceptor("index", R.raw.test))
                .configured();

        //初始化ARouter
        //noinspection ConstantIfStatement,ConstantConditions
        if (true) { // TODO: 2018/4/8 如果是debug模式才开启
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init((Application) Awesome.getConfiguration(ConfigKeys.APPLICATION));
        //初始化图片加载器
        ImageLoader.init((Application) Awesome.getConfiguration(ConfigKeys.APPLICATION), GlideLoader.getInstance());
        //必须在使用网络框架前对网络框架初始化
        RestCreator.init(Awesome.getApplicationContext(), (String) Awesome.getConfiguration(ConfigKeys.API_HOST),
                (List<BaseInterceptor>) Awesome.getConfiguration(ConfigKeys.INTERCEPTORS));
    }
}
