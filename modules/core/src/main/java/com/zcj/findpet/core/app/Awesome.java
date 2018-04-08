package com.zcj.findpet.core.app;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import java.util.HashMap;

/**
 * Created by zcj on 2018/4/6 2:37
 */
public final class Awesome {
    public static Configurator init(Context context) {
        getConfigurations().put(ConfigKeys.APPLICATION_CONTEXT, context.getApplicationContext());
        getConfigurations().put(ConfigKeys.MAIN_HANDLER, new Handler(Looper.getMainLooper()));
        return Configurator.getInstance();
    }

    public static Configurator getConfigurator() {
        return Configurator.getInstance();
    }

    public static <T> T getConfiguration(Object key) {
        return getConfigurator().getConfiguration(key);
    }

    public static Context getApplicationContext() {
        return (Context) getConfigurations().get(ConfigKeys.APPLICATION_CONTEXT);
    }

    public static Handler getMainHandler() {
        return (Handler) getConfigurations().get(ConfigKeys.MAIN_HANDLER);
    }

    private static HashMap<Object, Object> getConfigurations() {
        return Configurator.getInstance().getAwesomeConfigs();
    }
}
