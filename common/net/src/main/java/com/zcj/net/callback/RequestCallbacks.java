package com.zcj.net.callback;

import android.os.Handler;

import com.zcj.ui.LoaderStyle;
import com.zcj.ui.LoaderView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by zcj on 2018/4/6 11:44
 */
public class RequestCallbacks implements Callback<String> {
    private final IRequest REQUEST;
    private final ISuccess SUCCESS;
    private final IFailure FAILURE;
    private final IError ERROR;
    private final LoaderStyle LOADER_STYLE;
    // TODO: 2018/4/6 测试用，延迟关闭LoadingView
    private static final Handler HANDLER = new Handler();
    private static final int DELAY_TIME = 2000;

    public RequestCallbacks(IRequest request,
                            ISuccess success,
                            IFailure failure,
                            IError error,
                            LoaderStyle loaderStyle) {
        REQUEST = request;
        SUCCESS = success;
        FAILURE = failure;
        ERROR = error;
        LOADER_STYLE = loaderStyle;
    }

    @Override
    public void onResponse(Call<String> call, Response<String> response) {
        if (response.isSuccessful()) {
            if (call.isExecuted()) {
                if (SUCCESS != null) {
                    SUCCESS.onSuccess(response.body());
                }
            }
        } else {
            if (ERROR != null) {
                ERROR.onError(response.code(), response.message());
            }
        }

        stopLoading();
    }

    @Override
    public void onFailure(Call<String> call, Throwable t) {
        if (FAILURE != null) {
            FAILURE.onFailure();
        }

        if (REQUEST != null) {
            REQUEST.onRequestEnd();
        }

        stopLoading();
    }

    private void stopLoading() {
        if (LOADER_STYLE != null) {
            HANDLER.postDelayed(new Runnable() {
                @Override
                public void run() {
                    LoaderView.stopLoading();
                }
            }, DELAY_TIME);
        }
    }
}
