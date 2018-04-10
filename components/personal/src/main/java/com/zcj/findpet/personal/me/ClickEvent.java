package com.zcj.findpet.personal.me;

/**
 * Datetime: 2018/4/10 10:04
 * Author: zcj
 */
public class ClickEvent {
    private String mDescription;

    public ClickEvent(int index) {
        this.mDescription = "第 " + index + " 次点击";
    }

    public String getDescription() {
        return mDescription;
    }
}
