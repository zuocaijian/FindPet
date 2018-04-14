package com.zcj.findpet.sign.signup.choose;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.zcj.findpet.core.app.Awesome;
import com.zcj.findpet.core.delegate.AwesomeDelegate;
import com.zcj.findpet.core.views.TitleBar;
import com.zcj.findpet.sign.R;

import butterknife.BindView;
import butterknife.OnClick;
import me.yokeyword.fragmentation.ISupportFragment;

import com.zcj.findpet.sign.R2;

/**
 * Created by zcj on 2018/4/14 17:02
 */
@Route(path = "/sign/chooseSignUpTypeFragment")
public class ChooseSignUpTypeDelegate extends AwesomeDelegate implements ChooseContract.View {

    @BindView(R2.id.title_bar)
    //@BindView(R.id.title_bar)
    TitleBar mTitleBar;

    private ChooseContract.Presenter mPresenter;

    @OnClick(R2.id.fl_has_pet)
    //@OnClick(R.id.fl_has_pet)
    void hasPetAction() {
        start((ISupportFragment) ARouter.getInstance().build("/sign/signUpHasPetFragment").navigation());
    }

    @OnClick(R2.id.fl_no_pet)
    //@OnClick(R.id.fl_no_pet)
    void noPetAction() {
        start((ISupportFragment) ARouter.getInstance().build("/sign/signUpNoPetFragment").navigation());
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_choose_sign_up;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, android.view.View rootView) {
        mPresenter = new ChoosePresenter(getContext(), this);
        mPresenter.start();
    }

    @Override
    public void setTitle(String title) {
        mTitleBar.setTitle(title);
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
