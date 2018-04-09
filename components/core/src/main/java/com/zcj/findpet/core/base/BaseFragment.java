package com.zcj.findpet.core.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;

/**
 * Created by cj_zu on 2018/4/3.
 */

public abstract class BaseFragment extends Fragment {

    protected Context mContext;

    protected View mView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (registerEventBus()) {
            EventBus.getDefault().register(this);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(initViewId(), null);
        ButterKnife.bind(this, mView);
        initView();
        initListener();
        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        process();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (registerEventBus()){
            EventBus.getDefault().unregister(this);
        }
    }

    protected boolean registerEventBus() {
        return false;
    }

    protected void initView(){}

    protected void initListener(){}

    protected abstract @LayoutRes
    int initViewId();

    protected abstract void process();
}
