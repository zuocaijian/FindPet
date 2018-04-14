package com.zcj.findpet.core.views;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.zcj.findpet.core.R;
import com.zcj.ui.custom.CommonTitleBar;
import com.zcj.ui.util.ResUtils;

/**
 * Created by zcj on 2018/4/14 15:54
 */
public class TitleBar extends CommonTitleBar {

    public TitleBar(@NonNull Context context) {
        this(context, null);
    }

    public TitleBar(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TitleBar(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    private void init() {
        setBackgroundColor(ResUtils.getColor(mContext, R.color.core_theme_color));
    }
}
