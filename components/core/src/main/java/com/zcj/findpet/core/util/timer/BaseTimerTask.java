package com.zcj.findpet.core.util.timer;

import java.util.TimerTask;

/**
 * Created by zcj on 2018/4/6 22:09
 */
public class BaseTimerTask extends TimerTask {

    private ITimerListener mITimerListener = null;

    public BaseTimerTask(ITimerListener listener) {
        this.mITimerListener = listener;
    }

    @Override
    public void run() {
        if (mITimerListener != null) {
            mITimerListener.onTimer();
        }
    }
}
