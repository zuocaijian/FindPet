package com.zcj.findpet.core.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.ContentFrameLayout;
import android.view.WindowManager;

import com.alibaba.android.arouter.launcher.ARouter;
import com.zcj.findpet.core.R;
import com.zcj.findpet.core.delegate.AwesomeDelegate;

import me.yokeyword.fragmentation.SupportActivity;

/**
 * Created by zcj on 2018/4/6 8:46
 */
public abstract class ProxyActivity extends SupportActivity {

    public abstract AwesomeDelegate setRootDelegate();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ARouter.getInstance().inject(this);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        initContainer(savedInstanceState);
    }

    private void initContainer(@Nullable Bundle savedInstanceState) {
        final ContentFrameLayout container = new ContentFrameLayout(this);
        container.setId(R.id.delegate_container);
        setContentView(container);
        if (savedInstanceState == null) {
            loadRootFragment(R.id.delegate_container, setRootDelegate());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.gc();
        System.runFinalization();
    }
}
