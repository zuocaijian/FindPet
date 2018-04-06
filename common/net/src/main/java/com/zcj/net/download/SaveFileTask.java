package com.zcj.net.download;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;

import com.zcj.net.callback.IRequest;
import com.zcj.net.callback.ISuccess;
import com.zcj.util.file.FileUtils;

import java.io.File;
import java.io.InputStream;

import okhttp3.ResponseBody;

/**
 * Created by zcj on 2018/4/6 16:16
 */
public class SaveFileTask extends AsyncTask<Object, Void, File> {

    private static final String DEFAULT_DOWNLOAD_DIR = "down_loads";

    private final Context CONTEXT;
    private final IRequest REQUEST;
    private final ISuccess SUCCESS;

    public SaveFileTask(Context context, IRequest request, ISuccess success) {
        CONTEXT = context;
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
            return FileUtils.writeToDisk(is, downloadDir, extension.toUpperCase(), extension);
        } else {
            return FileUtils.writeToDisk(is, downloadDir, name);
        }
    }

    @Override
    protected void onPostExecute(File file) {
        super.onPostExecute(file);
        if (SUCCESS != null) {
            SUCCESS.onSuccess(file.getPath());
        }
        if (REQUEST != null) {
            REQUEST.onRequestEnd();
        }

        autoInstallApk(file);
    }

    private void autoInstallApk(File file) {
        if (FileUtils.getExtension(file.getName()).equals("apk")) {
            final Intent install = new Intent();
            install.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            install.setAction(Intent.ACTION_VIEW);
            install.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
            CONTEXT.getApplicationContext().startActivity(install);
        }
    }
}
