package com.zcj.findpet.core.service;

import android.app.Application;

import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * Created by zcj on 2018/4/6 10:05
 */
public interface IModuleInitService extends IProvider{
    void onAppCreate(Application app);
}
