package com.zcj.ui.custom;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zcj.ui.R2;

import butterknife.BindView;

/**
 * Created by zcj on 2018/4/14 0:30
 */
public class TitleBar extends RelativeLayout {

    @BindView(R2.id.tv_title)
    TextView mTvTitle;

    private Context mContext;

    public TitleBar(@NonNull Context context) {
        this(context, null);
    }

    public TitleBar(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TitleBar(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        this.mContext = context;
        init();
    }

    private void init() {
        setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
        setGravity(Gravity.CENTER_VERTICAL);
    }

    public void setTitle(String title) {
        mTvTitle.setText(title);
    }

    public void setTitle(@StringRes int titleResId) {
        mTvTitle.setText(titleResId);
    }
}
