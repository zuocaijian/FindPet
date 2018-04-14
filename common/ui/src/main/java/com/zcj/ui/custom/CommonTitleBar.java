package com.zcj.ui.custom;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.zcj.ui.R;
import com.zcj.ui.R2;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zcj on 2018/4/14 0:30
 */
public abstract class CommonTitleBar extends FrameLayout {

    @BindView(R2.id.tv_title)
    TextView mTvTitle;

    protected Context mContext;

    public CommonTitleBar(@NonNull Context context) {
        this(context, null);
    }

    public CommonTitleBar(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CommonTitleBar(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        this.mContext = context;
        init();
    }

    private void init() {
        initView();
    }

    private void initView() {
        View view = View.inflate(mContext, R.layout.ui_view_title_bar, this);
        ButterKnife.bind(this, view);
    }

    public void setTitle(String title) {
        mTvTitle.setText(title);
    }

    public void setTitle(@StringRes int titleResId) {
        mTvTitle.setText(titleResId);
    }
}
