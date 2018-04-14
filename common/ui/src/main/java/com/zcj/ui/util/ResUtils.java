package com.zcj.ui.util;

import android.content.Context;
import android.support.annotation.ArrayRes;
import android.support.annotation.ColorRes;
import android.support.annotation.StringRes;

/**
 * Created by zcj on 2018/4/14 15:56
 */
public class ResUtils {

    public static int getColor(Context context, @ColorRes int colorResId) {
        return context.getResources().getColor(colorResId);
    }

    public static String getString(Context context, @StringRes int stringResId) {
        return context.getResources().getString(stringResId);
    }

    public static String getString(Context context, @StringRes int stringResId, Object... formatArgs) {
        return context.getResources().getString(stringResId, formatArgs);
    }

    public static String[] getStringArr(Context context, @ArrayRes int stringArrResId) {
        return context.getResources().getStringArray(stringArrResId);
    }
}
