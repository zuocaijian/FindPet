package com.zcj.findpet.core.wechat.generetors;

import com.zcj.annotaions.EntryGenerator;
import com.zcj.findpet.core.wechat.template.WXEntryTemplate;

/**
 * Created by zcj on 2018/4/14 11:43
 */
@EntryGenerator(
        packageName = "com.zcj.findpet",
        entryTemplate = WXEntryTemplate.class
)
public interface WeChatEntry {
}
