package com.zcj.image.strategy;

import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.zcj.image.ILoader;
import com.zcj.image.ImageLoader;
import com.zcj.image.LoaderRequest;

/**
 * Datetime: 2018/4/10 14:47
 * Author: zcj
 */
public class GlideLoader implements ILoader {

    private GlideLoader() {
    }

    public static GlideLoader getInstance() {
        return InstanceHolder.HOLDER;
    }

    private static class InstanceHolder {
        public static final GlideLoader HOLDER = new GlideLoader();
    }

    @Override
    public void loadImage(final LoaderRequest request) {
        RequestManager requestManager = Glide.with(request.context);
        RequestBuilder builder = null;
        RequestOptions options = null;
        if (!TextUtils.isEmpty(request.url)) {
            builder = requestManager.load(request.url);
        } else if (request.uri != null) {
            builder = requestManager.load(request.uri);
        } else if (request.file != null) {
            builder = requestManager.load(request.file);
        } else if (request.drawableResId > 0) {
            builder = requestManager.load(request.drawableResId);
        }

        if (builder == null) {
            throw new NullPointerException("requestBuilder must not be null");
        }

        if (request.isCenterCrop) {
            options = RequestOptions.centerCropTransform();
        } else if (request.isCenterInside) {
            options = RequestOptions.centerInsideTransform();
        } else {
            options = new RequestOptions();
        }

        if (request.errorResId != 0) {
            options = options.error(request.errorResId);
        }
        if (request.placeholderResId != 0) {
            options = options.placeholder(request.placeholderResId);
        }
        if (request.placeholder != null) {
            options = options.placeholder(request.placeholder);
        }
        if (request.skipCache) {
            options = options.skipMemoryCache(true);
        }
        if (request.needCache) {
            options = options.diskCacheStrategy(DiskCacheStrategy.ALL);
        } else {
            options = options.diskCacheStrategy(DiskCacheStrategy.NONE);
        }
        if (request.bitmapAngle != 0) {
            // TODO: 2018/4/10
        }
        if (request.degrees != 0) {
            // TODO: 2018/4/10
        }
        if (request.config != null) {
            // TODO: 2018/4/10
        }

        builder = builder.apply(options);

        if (request.callBack != null) {
            builder = builder.listener(new RequestListener() {
                @Override
                public boolean onLoadFailed(@Nullable GlideException e, Object model,
                                            Target target, boolean isFirstResource) {
                    request.callBack.onBitmapFailed(e);
                    return false;
                }

                @Override
                public boolean onResourceReady(Object resource, Object model,
                                               Target target, DataSource dataSource,
                                               boolean isFirstResource) {
                    request.callBack.onBitmapLoaded((Bitmap) resource);
                    return false;
                }
            });
        }

        if (request.targetView instanceof ImageView) {
            builder.into((ImageView) request.targetView);
        } else {
            // TODO: 2018/4/10
        }
    }

    @Override
    public void clearMemoryCache() {
        Glide.get(ImageLoader.getInstance().getApplication().getApplicationContext()).clearDiskCache();
    }

    @Override
    public void clearDiskCache() {
        Glide.get(ImageLoader.getInstance().getApplication().getApplicationContext()).clearDiskCache();
    }
}
