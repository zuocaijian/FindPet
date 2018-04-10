package com.zcj.findpet.personal.me;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.zcj.findpet.core.app.Awesome;
import com.zcj.findpet.core.delegate.AwesomeDelegate;
import com.zcj.findpet.personal.R;
import com.zcj.findpet.personal.R2;

import butterknife.OnClick;

/**
 * Datetime: 2018/4/10 9:52
 * Author: zcj
 */
public class MeDelegate extends AwesomeDelegate implements MeContract.View {

    private MeContract.Presenter mPresenter;

    @OnClick(R2.id.btn)
    void onClick() {
        mPresenter.testRx();
    }

    @Override
    public Object setLayout() {
        return R.layout.deletgate_me;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        mPresenter = new MePresenter(getContext(), this);
        mPresenter.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.release();
    }

    @Override
    public void showLoading() {
    }

    @Override
    public void hideLoading() {
    }

    @Override
    public void showToast(String msg, boolean isLong) {
        Toast.makeText(Awesome.getApplicationContext(), msg, isLong ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT).show();
    }
}
