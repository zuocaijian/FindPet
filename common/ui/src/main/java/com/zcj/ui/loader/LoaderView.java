package com.zcj.ui.loader;

import android.content.Context;
import android.support.v7.app.AppCompatDialog;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.wang.avi.AVLoadingIndicatorView;
import com.zcj.ui.R;
import com.zcj.ui.util.DimenUtils;

import java.util.ArrayList;

/**
 * Created by zcj on 2018/4/6 12:36
 */
public class LoaderView {

    private static final int LOADER_SIZE_SCALE = 4;
    private static final int LOADER_OFFSET_SCALE = 10;
    private static final String DEFAULT_LOADER = LoaderStyle.BallClipRotatePulseIndicator.name();

    private static final ArrayList<AppCompatDialog> LOADERS = new ArrayList<>();

    public static void showLoading(Context context, String type) {
        final AppCompatDialog dialog = new AppCompatDialog(context, R.style.dialog);

        final AVLoadingIndicatorView avLoadingIndicatorView = LoaderCreator.create(context, type);
        dialog.setContentView(avLoadingIndicatorView);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);

        int deviceWidth = DimenUtils.getScreenWidth(context);
        int deviceHeight = DimenUtils.getScreenHeight(context);

        final Window window = dialog.getWindow();
        if (window != null) {
            WindowManager.LayoutParams lp = window.getAttributes();
            lp.width = deviceWidth / LOADER_SIZE_SCALE;
            lp.height = lp.width;
            lp.gravity = Gravity.CENTER;
        }
        LOADERS.add(dialog);
        dialog.show();
    }

    public static void showLoading(Context context, Enum<LoaderStyle> type) {
        showLoading(context, type.name());
    }

    public static void showLoading(Context context) {
        showLoading(context, DEFAULT_LOADER);
    }

    public static void stopLoading() {
        for (AppCompatDialog dialog : LOADERS) {
            if (dialog != null && dialog.isShowing()) {
                dialog.cancel();
            }
        }
    }
}
