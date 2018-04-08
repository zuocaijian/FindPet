package com.zcj.findpet.splash.scroll;

import com.zcj.findpet.core.util.AwesomePreference;
import com.zcj.ui.launcher.ScrollLauncherTag;

/**
 * Datetime: 2018/4/8 11:44
 * Author: zcj
 */
class ScrollModel implements ScrollContract.Model {

    @Override
    public boolean isSignIn() {
        return false;
    }

    @Override
    public void setIsFirstLauncher(boolean isFirst) {
        AwesomePreference.setAppFlag(ScrollLauncherTag.HAS_FIRST_LAUNCHER_APP.name(), !isFirst);
    }
}
