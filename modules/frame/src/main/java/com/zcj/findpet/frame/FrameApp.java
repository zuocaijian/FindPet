package com.zcj.findpet.frame;

import android.app.Application;

import com.zcj.findpet.core.app.Awesome;
import com.zcj.findpet.core.app.IAppInitTask;
import com.zcj.findpet.frame.icon.FontFrameModule;

/**
 * Created by zcj on 2018/4/6 10:06
 */
public final class FrameApp implements IAppInitTask {

    @Override
    public final void onAppCreate(Application app) {
        Awesome.init(app)
                .withIcon(new FontFrameModule())
                .configured();
    }

    public static FrameApp getInstance() {
        return InstanceHolder.sInstance;
    }

    private FrameApp() {
    }

    private static class InstanceHolder {
        public static FrameApp sInstance = new FrameApp();
    }
}
