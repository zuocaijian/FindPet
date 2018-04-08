package com.zcj.findpet.splash.scroll;

import android.content.Context;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.zcj.findpet.splash.R;
import com.zcj.ui.launcher.LauncherHolderCreator;

import java.util.ArrayList;

/**
 * Datetime: 2018/4/8 11:44
 * Author: zcj
 */
public class ScrollPresenter implements ScrollContract.Presenter {

    private ScrollContract.View mView;
    private ScrollContract.Model mModel;

    private final Context mContext;
    private final ArrayList<Integer> INTEGERS = new ArrayList<>();

    public ScrollPresenter(Context context, ScrollContract.View view) {
        this.mContext = context;
        this.mView = view;
        mModel = new ScrollModel();
    }

    @Override
    public void start() {
        INTEGERS.clear();
        INTEGERS.add(R.drawable.launcher_01);
        INTEGERS.add(R.drawable.launcher_02);
        INTEGERS.add(R.drawable.launcher_03);
        INTEGERS.add(R.drawable.launcher_04);
        INTEGERS.add(R.drawable.launcher_05);

        mView.setScrollPages(new LauncherHolderCreator(), INTEGERS,
                new int[]{R.drawable.dot_normal, R.drawable.dot_focus},
                ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL,
                false);
    }

    @Override
    public void itemClick(int position) {
        //如果点击最后一个
        if (position == INTEGERS.size() - 1) {
            if (mModel.isSignIn()) {
                mView.goMain();
            } else {
                mView.goSignIn();
            }
        }
    }

    @Override
    public void pageSelected(int position) {
        if (position == INTEGERS.size() - 1) {
            mModel.setIsFirstLauncher(false);
        }
    }
}
