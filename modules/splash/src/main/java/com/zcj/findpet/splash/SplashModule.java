package com.zcj.findpet.splash;

import android.app.Application;
import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.zcj.findpet.core.service.IModuleLifeService;

/**
 * Datetime: 2018/4/11 15:31
 * Author: zcj
 */
@Route(path = "/splash/module")
public class SplashModule implements IModuleLifeService {

    @Override
    public void onAppCreate(Application app) {
    }

    @Override
    public void init(Context context) {
    }
}
