package com.zcj.findpet.core.wechat.generetors;

import com.zcj.annotaions.AppRegisterGenerator;
import com.zcj.findpet.core.wechat.template.AppRegisterTemplate;

/**
 * Created by zcj on 2018/4/14 11:45
 */
@AppRegisterGenerator(
        packageName = "com.zcj.findpet",
        registerTemplate = AppRegisterTemplate.class
)
public interface AppRegisterEntry {
}
