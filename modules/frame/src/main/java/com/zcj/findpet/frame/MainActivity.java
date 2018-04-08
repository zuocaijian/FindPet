package com.zcj.findpet.frame;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationViewPager;
import com.zcj.findpet.core.base.BaseActivity;
import com.zcj.findpet.core.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cj_zu on 2018/4/5.
 */
public class MainActivity extends BaseActivity {

    AHBottomNavigationViewPager mMainViewPager;
    FloatingActionButton mFloatingButton;
    AHBottomNavigation mBottomNavigation;

    private MainViewPagerAdapter mAdapter;
    private List<AHBottomNavigationItem> mBottomItems = new ArrayList<>();
    private List<BaseFragment> mFragments = new ArrayList<>();

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
        initBottomNavigation();
    }

    @SuppressWarnings("deprecation")
    private void initBottomNavigation() {
        AHBottomNavigationItem item;
        mBottomItems.clear();
        mFragments.clear();
        for (int i = 0; i < 4; i++) {
            item = new AHBottomNavigationItem("" + i, R.drawable.ic_content_add, R.color.theme_color);
            mBottomItems.add(item);
            mFragments.add(MainFragment.newInstance(i));
        }

        mBottomNavigation.addItems(mBottomItems);
        mBottomNavigation.setDefaultBackgroundColor(mContext.getResources().getColor(R.color.white));
        mBottomNavigation.setOnTabSelectedListener(new MainTabSelectedListener());
        mBottomNavigation.setBehaviorTranslationEnabled(true);

        mAdapter = new MainViewPagerAdapter(getSupportFragmentManager(), mFragments);
        mMainViewPager.setAdapter(mAdapter);
    }

    private class MainTabSelectedListener implements AHBottomNavigation.OnTabSelectedListener {

        @Override
        public boolean onTabSelected(int position, boolean wasSelected) {
            mMainViewPager.setCurrentItem(position, false);
            return true;
        }
    }
}
