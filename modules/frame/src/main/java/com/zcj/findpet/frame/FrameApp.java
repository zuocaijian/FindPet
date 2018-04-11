package com.zcj.findpet.frame;

import android.app.Application;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.zcj.findpet.core.app.Awesome;
import com.zcj.findpet.core.service.IAppInitService;
import com.zcj.findpet.frame.icon.FontFrameModule;

/**
 * Created by zcj on 2018/4/6 10:06
 */
@Route(path = "/frame/app")
public final class FrameApp implements IAppInitService {

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
