package com.zcj.findpet.core.wechat.generetors;

import com.zcj.annotaions.PayEntryGenerator;
import com.zcj.findpet.core.wechat.template.WXPayEntryTemplate;

/**
 * Created by zcj on 2018/4/14 11:45
 */
@PayEntryGenerator(
        packageName = "com.zcj.findpet",
        payEntryTemplate = WXPayEntryTemplate.class
)
public interface WeChatPayEntry {
}
