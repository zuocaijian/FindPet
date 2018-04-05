package com.zcj.findpet.frame;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.zcj.findpet.core.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cj_zu on 2018/4/5.
 */
public class MainViewPagerAdapter extends FragmentPagerAdapter {

    private List<BaseFragment> fragments = new ArrayList<>();
    private BaseFragment currentFragment;

    public MainViewPagerAdapter(FragmentManager fm, List<BaseFragment> fragments) {
        super(fm);
        this.fragments = fragments;
        currentFragment = fragments.get(0);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        if (currentFragment != object) {
            currentFragment = (BaseFragment) object;
        }
        super.setPrimaryItem(container, position, object);
    }
}
