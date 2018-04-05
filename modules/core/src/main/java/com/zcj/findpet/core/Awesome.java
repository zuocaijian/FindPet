package com.zcj.findpet.core;

import android.content.Context;

import java.util.WeakHashMap;

public final class Awesome {
    public static Configurator init(Context context) {
        getConfigurations().put(ConfigType.APPLICATION_CONTEXT.name(), context.getApplicationContext());
        return Configurator.getInstance();
    }

    private static WeakHashMap<String, Object> getConfigurations() {
        return Configurator.getInstance().getAwesomeConfigs();
    }
}
