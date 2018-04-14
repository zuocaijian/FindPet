package com.zcj.findpet.frame;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationViewPager;
import com.zcj.findpet.core.base.BaseActivity;
import com.zcj.findpet.core.base.BaseFragment;
import com.zcj.ui.util.ResUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cj_zu on 2018/4/5.
 */

@Route(path = "/frame/mainActivity")
public class MainActivity extends BaseActivity {

    AHBottomNavigationViewPager mMainViewPager;
    FloatingActionButton mFloatingButton;
    AHBottomNavigation mBottomNavigation;

    private MainViewPagerAdapter mAdapter;
    private List<AHBottomNavigationItem> mBottomItems = new ArrayList<>();
    private List<BaseFragment> mFragments = new ArrayList<>();

    private String[] mBottomNavTitles;
    private int[] mBottomNavDrawables;

    @Override
    public int initViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        super.initView();
        mMainViewPager = (AHBottomNavigationViewPager) findViewById(R.id.view_pager);
        mFloatingButton = (FloatingActionButton) findViewById(R.id.floating_action_button);
        mBottomNavigation = (AHBottomNavigation) findViewById(R.id.bottom_navigation);
    }

    @Override
    public void process(Bundle savedInstanceState) {
        mBottomNavTitles = ResUtils.getStringArr(mContext, R.array.frame_bottom_nav_title);
        mBottomNavDrawables = new int[]{
                R.drawable.frame_star,
                R.drawable.frame_search,
                R.drawable.frame_love,
                R.drawable.frame_me
        };
        initBottomNavigation();
    }

    @SuppressWarnings("deprecation")
    private void initBottomNavigation() {
        AHBottomNavigationItem item;
        mBottomItems.clear();
        mFragments.clear();
        for (int i = 0; i < 4; i++) {
            item = new AHBottomNavigationItem(mBottomNavTitles[i], mBottomNavDrawables[i]);
            mBottomItems.add(item);
            mFragments.add(MainFragment.newInstance(i));
        }

        mBottomNavigation.addItems(mBottomItems);
        mBottomNavigation.setDefaultBackgroundColor(mContext.getResources().getColor(R.color.core_white));
        mBottomNavigation.setOnTabSelectedListener(new MainTabSelectedListener());
        mBottomNavigation.setBehaviorTranslationEnabled(true);
        mBottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);
        mBottomNavigation.setAccentColor(ResUtils.getColor(mContext, R.color.core_theme_color));

        mAdapter = new MainViewPagerAdapter(getSupportFragmentManager(), mFragments);
        mMainViewPager.setAdapter(mAdapter);
    }

    private class MainTabSelectedListener implements AHBottomNavigation.OnTabSelectedListener {

        @Override
        public boolean onTabSelected(int position, boolean wasSelected) {
            if (position == mBottomItems.size() - 1) {
                ARouter.getInstance()
                        .build("/main/mainActivity")
                        .withString("target", "/sign/signInFragment")
                        .navigation();
                return false;
            } else {
                mMainViewPager.setCurrentItem(position, false);
                return true;
            }
        }
    }
}
