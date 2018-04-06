package com.zcj.findpet.main;

import com.zcj.findpet.core.base.BaseApp;
import com.zcj.findpet.frame.FrameApp;

/**
 * Created by zcj on 2018/4/6 2:37
 */
public class MainApp extends BaseApp {
    @Override
    public void onCreate() {
        super.onCreate();
        FrameApp.getInstance().onAppCreate(this);
    }
}
