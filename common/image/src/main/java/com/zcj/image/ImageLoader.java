package com.zcj.image;

import android.app.Application;
import android.net.Uri;

import java.io.File;

/**
 * Datetime: 2018/4/10 14:19
 * Author: zcj
 */
public class ImageLoader {

    private static Application sApp;
    private static volatile ILoader sLoader;

    private ImageLoader() {
    }

    public static ImageLoader getInstance() {
        if (sApp == null || sLoader == null) {
            throw new RuntimeException("must init ImageLoader before use!");
        }
        return InstanceHolder.HOLDER;
    }

    private static class InstanceHolder {
        public static final ImageLoader HOLDER = new ImageLoader();
    }

    public static void init(Application app, ILoader loader) {
        sApp = app;
        sLoader = loader;
    }

    public Application getApplication() {
        return sApp;
    }

    public LoaderRequest load(String url) {
        return new LoaderRequest(url);
    }

    public LoaderRequest load(Uri uri) {
        return new LoaderRequest(uri);
    }

    public LoaderRequest load(int drawableResId) {
        return new LoaderRequest(drawableResId);
    }

    public LoaderRequest load(File file) {
        return new LoaderRequest(file);
    }

    public void clearMemoryCache() {
        sLoader.clearMemoryCache();
    }

    public void clearDiskCache() {
        sLoader.clearDiskCache();
    }

    void loadImage(LoaderRequest request) {
        sLoader.loadImage(request);
    }
}
