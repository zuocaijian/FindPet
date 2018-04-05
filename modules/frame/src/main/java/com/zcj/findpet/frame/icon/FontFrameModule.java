package com.zcj.findpet.frame.icon;

import com.joanzapata.iconify.Icon;
import com.joanzapata.iconify.IconFontDescriptor;

/**
 * Created by zcj on 2018/4/6 2:49
 */
public class FontFrameModule implements IconFontDescriptor {

    @Override
    public String ttfFileName() {
        return "iconfont.ttf";
    }

    @Override
    public Icon[] characters() {
        return FrameIcons.values();
    }
}
