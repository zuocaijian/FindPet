package com.zcj.findpet.pay;

import android.app.Application;
import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.zcj.findpet.core.service.IModuleLifeService;

/**
 * Created by zcj on 2018/4/14 11:37
 */
@Route(path = "/pay/module")
public class PayModule implements IModuleLifeService {

    @Override
    public void onAppCreate(Application app) {

    }

    @Override
    public void init(Context context) {

    }
}
