package com.zcj.findpet.core.app;

import com.joanzapata.iconify.IconFontDescriptor;
import com.joanzapata.iconify.Iconify;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by zcj on 2018/4/6 2:37
 */
public class Configurator {

    private static final HashMap<String, Object> AWESOME_CONFIGS = new HashMap<>();
    private static final List<IconFontDescriptor> ICONS = new ArrayList<>();

    private Configurator() {
        AWESOME_CONFIGS.put(ConfigType.CONFIG_READY.name(), false);
    }

    public static Configurator getInstance() {
        return InstanceHolder.sHolder;
    }

    final HashMap<String, Object> getAwesomeConfigs() {
        return AWESOME_CONFIGS;
    }

    private static class InstanceHolder {
        public static Configurator sHolder = new Configurator();
    }

    public final void configured() {
        initIcons();
        AWESOME_CONFIGS.put(ConfigType.CONFIG_READY.name(), true);
    }

    public final Configurator withApiHost(String host) {
        AWESOME_CONFIGS.put(ConfigType.API_HOST.name(), host);
        return this;
    }

    private void initIcons() {
        if (ICONS.size() > 0) {
            final Iconify.IconifyInitializer initializer = Iconify.with(ICONS.get(0));
            for (int i = 1; i < ICONS.size(); i++) {
                initializer.with(ICONS.get(i));
            }
        }
    }

    public final Configurator withIcon(IconFontDescriptor descriptor) {
        ICONS.add(descriptor);
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
