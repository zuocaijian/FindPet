package com.zcj.findpet.core.base;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;

import com.zcj.findpet.core.swipeback.app.SwipeBackActivity;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;

/**
 * Created by cj_zu on 2018/4/3.
 */

public abstract class BaseActivity extends SwipeBackActivity {

    protected BaseActivity mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initViewId());
        ButterKnife.bind(this);
        mContext = this;
        AppManager.getInstance().push(this);
        if (registerEventBus()) {
            EventBus.getDefault().register(mContext);
        }
        setSwipeBackEnable(Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT
                && enableSwipeBack());
        initView();
        initListener();
        process(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getInstance().pop();
        if (registerEventBus()) {
            EventBus.getDefault().unregister(mContext);
        }
    }

    protected boolean registerEventBus() {
        return false;
    }

    protected boolean enableSwipeBack() {
        return false;
    }

    protected void initView(){}

    protected void initListener(){}

    public abstract @LayoutRes
    int initViewId();

    public abstract void process(Bundle savedInstanceState);
}
