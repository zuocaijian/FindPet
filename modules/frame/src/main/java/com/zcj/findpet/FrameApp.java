package com.zcj.findpet;

import com.zcj.findpet.core.Awesome;
import com.zcj.findpet.core.base.BaseApp;
import com.zcj.findpet.frame.icon.FontFrameModule;

/**
 * Created by zcj on 2018/4/6 2:37
 */
public class FrameApp extends BaseApp {
    @Override
    public void onCreate() {
        super.onCreate();
        Awesome.init(this)
                .withIcon(new FontFrameModule())
                .configured();
    }
}
