package com.zcj.findpet.frame;

import android.app.Application;
import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.zcj.findpet.core.app.Awesome;
import com.zcj.findpet.core.service.IModuleLifeService;
import com.zcj.findpet.frame.icon.FontFrameModule;

/**
 * Created by zcj on 2018/4/6 10:06
 */
@Route(path = "/frame/module")
public final class FrameModule implements IModuleLifeService {

    @Override
    public final void onAppCreate(Application app) {
        Awesome.init(app)
                .withIcon(new FontFrameModule())
                .configured();
    }

    @Override
    public void init(Context context) {
    }
}
