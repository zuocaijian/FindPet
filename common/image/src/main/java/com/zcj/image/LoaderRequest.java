package com.zcj.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;

import java.io.File;

/**
 * Datetime: 2018/4/10 14:23
 * Author: zcj
 */
public class LoaderRequest {
    public int placeholderResId;
    public Drawable placeholder;
    public int errorResId;
    public boolean isCenterCrop;
    public boolean isCenterInside;
    public boolean skipCache;
    public boolean needCache; // 是否缓存到本地
    public Bitmap.Config config = Bitmap.Config.RGB_565;
    public int targetWidth;
    public int targetHeight;
    public float bitmapAngle; //圆角角度
    public float degrees; //旋转角度.注意:picasso针对三星等本地图片，默认旋转回0度，即正常位置。此时不需要自己rotate
    public View targetView;//targetView展示图片
    public ILoadCallback callBack;
    public String url;
    public File file;
    public int drawableResId;
    public Uri uri;
    public Context context;

    public LoaderRequest(String url) {
        this.url = url;
    }

    public LoaderRequest(Uri uri) {
        this.uri = uri;
    }

    public LoaderRequest(int drawableResId) {
        this.drawableResId = drawableResId;
    }

    public LoaderRequest(File file) {
        this.file = file;
    }

    public void into(View targetView) {
        this.targetView = targetView;
        ImageLoader.getInstance().loadImage(this);
    }

    public void bitmap(ILoadCallback callBack) {
        this.callBack = callBack;
        ImageLoader.getInstance().loadImage(this);
    }

    public LoaderRequest with(Context context) {
        this.context = context;
        return this;
    }

    public LoaderRequest placeholder(int placeholderResId) {
        this.placeholderResId = placeholderResId;
        return this;
    }

    public LoaderRequest placeholder(Drawable placeholder) {
        this.placeholder = placeholder;
        return this;
    }

    public LoaderRequest error(int errorResId) {
        this.errorResId = errorResId;
        return this;
    }

    public LoaderRequest centerCrop() {
        isCenterCrop = true;
        return this;
    }

    public LoaderRequest centerInside() {
        isCenterInside = true;
        return this;
    }

    public LoaderRequest config(Bitmap.Config config) {
        this.config = config;
        return this;
    }

    public LoaderRequest resize(int targetWidth, int targetHeight) {
        this.targetWidth = targetWidth;
        this.targetHeight = targetHeight;
        return this;
    }

    public LoaderRequest angle(float bitmapAngle) {
        this.bitmapAngle = bitmapAngle;
        return this;
    }

    public LoaderRequest skipCache(boolean skipCache) {
        this.skipCache = skipCache;
        return this;
    }

    public LoaderRequest needCache(boolean needCache) {
        this.needCache = needCache;
        return this;
    }

    public LoaderRequest rotate(float degrees) {
        this.degrees = degrees;
        return this;
    }
}