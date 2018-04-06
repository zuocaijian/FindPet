package com.zcj.net.download;

import android.os.AsyncTask;
import android.text.TextUtils;

import com.zcj.net.callback.IRequest;
import com.zcj.net.callback.ISuccess;

import java.io.File;
import java.io.InputStream;

import okhttp3.ResponseBody;

/**
 * Created by zcj on 2018/4/6 16:16
 */
public class SaveFileTask extends AsyncTask<Object, Void, File> {

    private static final String DEFAULT_DOWNLOAD_DIR = "down_loads";

    private final IRequest REQUEST;
    private final ISuccess SUCCESS;

    public SaveFileTask(IRequest request, ISuccess success) {
        REQUEST = request;
        SUCCESS = success;
    }

    @Override
    protected File doInBackground(Object... objects) {
        String downloadDir = (String) objects[0];
        String extension = (String) objects[1];
        final String name = (String) objects[2];
        final ResponseBody body = (ResponseBody) objects[3];
        final InputStream is = body.byteStream();
        if (TextUtils.isEmpty(downloadDir)) {
            downloadDir = DEFAULT_DOWNLOAD_DIR;
        }
        if (TextUtils.isEmpty(extension)) {
            extension = "";
        }
        if (TextUtils.isEmpty(name)) {

        }
        return null;
    }
}
