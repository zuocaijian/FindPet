package com.zcj.findpet.main;

import com.alibaba.android.arouter.launcher.ARouter;
import com.zcj.findpet.core.base.BaseApp;
import com.zcj.findpet.core.service.IModuleInitService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zcj on 2018/4/6 2:37
 */
public class MainApp extends BaseApp {

    private final List<IModuleInitService> MODULE_INIT_SERVICES = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();

        IModuleInitService frameModuleService = (IModuleInitService) ARouter.getInstance().build("/frame/module").navigation();
        MODULE_INIT_SERVICES.add(frameModuleService);
        IModuleInitService personalModuleService = (IModuleInitService) ARouter.getInstance().build("/personal/module").navigation();
        MODULE_INIT_SERVICES.add(personalModuleService);
        IModuleInitService signModuleService = (IModuleInitService) ARouter.getInstance().build("/sign/module").navigation();
        MODULE_INIT_SERVICES.add(signModuleService);
        IModuleInitService splashModuleService = (IModuleInitService) ARouter.getInstance().build("/splash/module").navigation();
        MODULE_INIT_SERVICES.add(splashModuleService);
        IModuleInitService payModuleService = (IModuleInitService) ARouter.getInstance().build("/pay/module").navigation();
        MODULE_INIT_SERVICES.add(payModuleService);

        initModules();
    }

    private void initModules() {
        for (IModuleInitService moduleInitService : MODULE_INIT_SERVICES) {
            if (moduleInitService != null) {
                moduleInitService.onAppCreate(this);
            }
        }
    }
}
