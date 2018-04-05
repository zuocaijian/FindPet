package com.zcj.findpet.frame;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

import com.zcj.findpet.core.base.BaseFragment;


/**
 * Created by cj_zu on 2018/4/5.
 */

public class MainFragment extends BaseFragment {
    public static final String ARG_POSITION = "arg_position";

    TextView mTv;

    private String mPos;

    public static MainFragment newInstance(int position) {
        Bundle args = new Bundle();
        args.putString(ARG_POSITION, String.valueOf(position));
        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public MainFragment() {
    }

    @Override
    protected int initViewId() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initView() {
        super.initView();
        mTv = mView.findViewById(R.id.tv);
    }

    @Override
    protected void process() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            mPos = arguments.getString(ARG_POSITION);
        }

        if (!TextUtils.isEmpty(mPos)) {
            mTv.setText(mPos);
        }
    }
}
