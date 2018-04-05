package com.zcj.findpet.frame.icon;

import com.joanzapata.iconify.Icon;

/**
 * Created by zcj on 2018/4/6 2:51
 */
public enum  FrameIcons implements Icon{
    icon_fanhui('\ue6b0'),
    icon_fanhui1('\ue78a'),
    icon_icon_('\ue617');

    private char character;

    FrameIcons(char character){
        this.character = character;
    }

    @Override
    public String key() {
        return this.name().replace('_', '-');
    }

    @Override
    public char character() {
        return this.character;
    }
}
