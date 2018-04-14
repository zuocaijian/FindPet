package com.zcj.findpet.main;

import com.alibaba.android.arouter.launcher.ARouter;
import com.zcj.findpet.core.base.BaseApp;
import com.zcj.findpet.core.service.IModuleLifeService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zcj on 2018/4/6 2:37
 */
public class MainApp extends BaseApp {

    private final List<IModuleLifeService> MODULE_INIT_SERVICES = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();

        IModuleLifeService frameModuleService = (IModuleLifeService) ARouter.getInstance().build("/frame/module").navigation();
        MODULE_INIT_SERVICES.add(frameModuleService);
        IModuleLifeService personalModuleService = (IModuleLifeService) ARouter.getInstance().build("/personal/module").navigation();
        MODULE_INIT_SERVICES.add(personalModuleService);
        IModuleLifeService signModuleService = (IModuleLifeService) ARouter.getInstance().build("/sign/module").navigation();
        MODULE_INIT_SERVICES.add(signModuleService);
        IModuleLifeService splashModuleService = (IModuleLifeService) ARouter.getInstance().build("/splash/module").navigation();
        MODULE_INIT_SERVICES.add(splashModuleService);
        IModuleLifeService payModuleService = (IModuleLifeService) ARouter.getInstance().build("/pay/module").navigation();
        MODULE_INIT_SERVICES.add(payModuleService);

        initModules();
    }

    private void initModules() {
        for (IModuleLifeService moduleInitService : MODULE_INIT_SERVICES) {
            if (moduleInitService != null) {
                moduleInitService.onAppCreate(this);
            }
        }
    }
}
