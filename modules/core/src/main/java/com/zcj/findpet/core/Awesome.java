package com.zcj.findpet.core;

import android.content.Context;

import java.util.WeakHashMap;

/**
 * Created by zcj on 2018/4/6 2:37
 */
public final class Awesome {
    public static Configurator init(Context context) {
        getConfigurations().put(ConfigType.APPLICATION_CONTEXT.name(), context.getApplicationContext());
        return Configurator.getInstance();
    }

    private static WeakHashMap<String, Object> getConfigurations() {
        return Configurator.getInstance().getAwesomeConfigs();
    }
}
