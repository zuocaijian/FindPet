package com.zcj.net.download;

import com.zcj.net.RestCreator;
import com.zcj.net.callback.IError;
import com.zcj.net.callback.IFailure;
import com.zcj.net.callback.IRequest;
import com.zcj.net.callback.ISuccess;

import java.util.WeakHashMap;

/**
 * Created by zcj on 2018/4/6 16:12
 */
public class DownloadHandler {
    private final String URL;
    private static final WeakHashMap<String, Object> PARAMS = RestCreator.getParams();
    private final String DOWNLOAD_DIR;
    private final String EXTENSION;
    private final String NAME;
    private final IRequest REQUEST;
    private final ISuccess SUCCESS;
    private final IFailure FAILURE;
    private final IError ERROR;

    public DownloadHandler(String url,
                           String downloadDir,
                           String extension,
                           String name,
                           IRequest request,
                           ISuccess success,
                           IFailure failure,
                           IError error) {
        URL = url;
        DOWNLOAD_DIR = downloadDir;
        EXTENSION = extension;
        NAME = name;
        REQUEST = request;
        SUCCESS = success;
        FAILURE = failure;
        ERROR = error;
    }

    public final void handleDownload() {
        if(REQUEST != null){
            REQUEST.onRequestStart();
        }

        RestCreator.getRestService().download(URL, PARAMS).enqueue();
    }
}
