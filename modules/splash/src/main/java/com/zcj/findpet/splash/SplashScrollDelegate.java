package com.zcj.findpet.splash;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.zcj.findpet.core.delegate.AwesomeDelegate;
import com.zcj.findpet.core.util.AwesomePreference;
import com.zcj.ui.launcher.LauncherHolderCreator;
import com.zcj.ui.launcher.ScrollLauncherTag;

import java.util.ArrayList;

/**
 * Created by zcj on 2018/4/6 23:02
 */
public class SplashScrollDelegate extends AwesomeDelegate implements OnItemClickListener {

    private ConvenientBanner<Integer> mConvenientBanner = null;
    private final ArrayList<Integer> INTEGERS = new ArrayList<>();

    private void initBanner() {
        INTEGERS.clear();
        INTEGERS.add(R.drawable.launcher_01);
        INTEGERS.add(R.drawable.launcher_02);
        INTEGERS.add(R.drawable.launcher_03);
        INTEGERS.add(R.drawable.launcher_04);
        INTEGERS.add(R.drawable.launcher_05);

        mConvenientBanner.setPages(new LauncherHolderCreator(), INTEGERS)
                .setPageIndicator(new int[]{R.drawable.dot_normal, R.drawable.dot_focus})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                .setOnItemClickListener(this)
                .setCanLoop(false);
    }

    @Override
    public Object setLayout() {
        mConvenientBanner = new ConvenientBanner<>(getContext());
        return mConvenientBanner;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        initBanner();
    }

    @Override
    public void onItemClick(int position) {
        //如果点击最后一个
        if (position == INTEGERS.size() - 1) {
            AwesomePreference.setAppFlag(ScrollLauncherTag.HAS_FIRST_LAUNCHER_APP.name(), true);
            // TODO: 2018/4/6  检查用户是否已经登录
        }
    }
}
