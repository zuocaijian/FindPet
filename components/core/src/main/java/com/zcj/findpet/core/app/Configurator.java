package com.zcj.findpet.core.app;

import com.joanzapata.iconify.IconFontDescriptor;
import com.joanzapata.iconify.Iconify;
import com.zcj.net.Interceptors.BaseInterceptor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by zcj on 2018/4/6 2:37
 */
public class Configurator {

    private static final HashMap<Object, Object> AWESOME_CONFIGS = new HashMap<>();
    private static final List<IconFontDescriptor> ICONS = new ArrayList<>();
    private static final List<BaseInterceptor> INTERCEPTORS = new ArrayList<>();

    private Configurator() {
        AWESOME_CONFIGS.put(ConfigKeys.CONFIG_READY, false);
    }

    public static Configurator getInstance() {
        return InstanceHolder.sHolder;
    }

    final HashMap<Object, Object> getAwesomeConfigs() {
        return AWESOME_CONFIGS;
    }

    private static final class InstanceHolder {
        public static Configurator sHolder = new Configurator();
    }

    public final void configured() {
        initIcons();
        AWESOME_CONFIGS.put(ConfigKeys.CONFIG_READY, true);
    }

    public final Configurator withApiHost(String host) {
        AWESOME_CONFIGS.put(ConfigKeys.API_HOST, host);
        return this;
    }

    public final Configurator withInterceptor(BaseInterceptor interceptor) {
        INTERCEPTORS.add(interceptor);
        AWESOME_CONFIGS.put(ConfigKeys.INTERCEPTORS, INTERCEPTORS);
        return this;
    }

    public final Configurator withInterceptors(List<BaseInterceptor> interceptors) {
        INTERCEPTORS.addAll(interceptors);
        AWESOME_CONFIGS.put(ConfigKeys.INTERCEPTORS, INTERCEPTORS);
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
        final boolean isReady = (boolean) AWESOME_CONFIGS.get(ConfigKeys.CONFIG_READY);
        if (!isReady) {
            throw new RuntimeException("Configuration is not ready, call configured");
        }
    }

    @SuppressWarnings("unchecked")
    final <T> T getConfiguration(Object key) {
        checkConfiguration();
        final Object value = AWESOME_CONFIGS.get(key);
        if (value == null) {
            throw new NullPointerException(key.toString() + " IS NULL");
        }
        return (T) value;
    }
}
