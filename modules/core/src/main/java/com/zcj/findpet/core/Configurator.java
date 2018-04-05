package com.zcj.findpet.core;

import java.util.WeakHashMap;

public class Configurator {

    private static final WeakHashMap<String, Object> AWESOME_CONFIGS = new WeakHashMap<>();

    private Configurator() {
        AWESOME_CONFIGS.put(ConfigType.CONFIG_READY.name(), false);
    }

    public static Configurator getInstance() {
        return InstanceHolder.sHolder;
    }

    final WeakHashMap<String, Object> getAwesomeConfigs() {
        return AWESOME_CONFIGS;
    }

    private static class InstanceHolder {
        public static Configurator sHolder = new Configurator();
    }

    public final void configured() {
        AWESOME_CONFIGS.put(ConfigType.CONFIG_READY.name(), true);
    }

    public final Configurator withApiHost(String host) {
        AWESOME_CONFIGS.put(ConfigType.API_HOST.name(), host);
        return this;
    }

    public void checkConfiguration() {
        final boolean isReady = (boolean) AWESOME_CONFIGS.get(ConfigType.CONFIG_READY.name());
        if (!isReady) {
            throw new RuntimeException("Configuration is not ready, call configured");
        }
    }

    @SuppressWarnings("unchecked")
    final <T> T getConfiguration(Enum<ConfigType> key) {
        checkConfiguration();
        return (T) AWESOME_CONFIGS.get(key.name());
    }
}
