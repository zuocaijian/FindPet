package com.zcj.findpet.splash.scroll;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.content.Context;
import android.support.annotation.NonNull;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.zcj.findpet.splash.R;
import com.zcj.ui.launcher.LauncherHolderCreator;

import java.util.ArrayList;

/**
 * Datetime: 2018/4/8 11:44
 * Author: zcj
 */
class ScrollPresenter implements ScrollContract.Presenter {

    private final ScrollContract.View VIEW;
    private final ScrollContract.Model MODEL;

    private final Context CONTEXT;
    private final ArrayList<Integer> INTEGERS = new ArrayList<>();

    public ScrollPresenter(Context context, ScrollContract.View view) {
        this.CONTEXT = context;
        this.VIEW = view;
        MODEL = new ScrollModel();
    }

    @Override
    public void start() {
        INTEGERS.clear();
        INTEGERS.add(R.drawable.launcher_01);
        INTEGERS.add(R.drawable.launcher_02);
        INTEGERS.add(R.drawable.launcher_03);
        INTEGERS.add(R.drawable.launcher_04);
        INTEGERS.add(R.drawable.launcher_05);

        VIEW.setScrollPages(new LauncherHolderCreator(), INTEGERS,
                new int[]{R.drawable.dot_normal, R.drawable.dot_focus},
                ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL,
                false);
    }

    @Override
    public void itemClick(int position) {
        //如果点击最后一个
        if (position == INTEGERS.size() - 1) {
            VIEW.goMain();
        }
    }

    @Override
    public void pageSelected(int position) {
        if (position == INTEGERS.size() - 1) {
            MODEL.setIsFirstLauncher(false);
        }
    }

    @Override
    public void onLifeCycleChanged(@NonNull LifecycleOwner owner, @NonNull Lifecycle.Event event) {
    }

    @Override
    public void onCreate(@NonNull LifecycleOwner owner) {
    }

    @Override
    public void onStart(@NonNull LifecycleOwner owner) {
    }

    @Override
    public void onResume(@NonNull LifecycleOwner owner) {
    }

    @Override
    public void onPause(@NonNull LifecycleOwner owner) {
    }

    @Override
    public void onStop(@NonNull LifecycleOwner owner) {
    }

    @Override
    public void onDestroy(@NonNull LifecycleOwner owner) {
    }
}
