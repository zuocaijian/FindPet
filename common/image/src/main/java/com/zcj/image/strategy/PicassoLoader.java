package com.zcj.image.strategy;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.squareup.picasso.LruCache;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import com.squareup.picasso.Target;
import com.squareup.picasso.Transformation;
import com.zcj.image.ILoadCallback;
import com.zcj.image.ILoader;
import com.zcj.image.ImageLoader;
import com.zcj.image.LoaderRequest;

import java.io.File;

/**
 * Datetime: 2018/4/10 17:01
 * Author: zcj
 */
public class PicassoLoader implements ILoader {
    private final String PICASSO_CACHE = "picasso-cache";

    private PicassoLoader() {
    }

    public static PicassoLoader getInstance() {
        return InstanceHolder.HOLDER;
    }

    private static class InstanceHolder {
        public static final PicassoLoader HOLDER = new PicassoLoader();
    }

    private static class PicassoHolder {
        public static final Picasso HOLDER = new Picasso.Builder(ImageLoader.getInstance().getApplication())
                .memoryCache(LruCacheHolder.HOLDER)
                .build();
    }

    private static class LruCacheHolder {
        public static final LruCache HOLDER = new LruCache(ImageLoader.getInstance().getApplication());
    }

    @Override
    public void clearMemoryCache() {
        LruCacheHolder.HOLDER.clear();
    }

    @Override
    public void clearDiskCache() {
        File diskFile = new File(ImageLoader.getInstance().getApplication().getCacheDir(), PICASSO_CACHE);
        if (diskFile.exists()) {
            //这边自行写删除代码
            //FileUtil.deleteFile(diskFile);
        }
    }

    @Override
    public void loadImage(LoaderRequest options) {
        RequestCreator requestCreator = null;
        if (options.url != null) {
            requestCreator = PicassoHolder.HOLDER.load(options.url);
        } else if (options.file != null) {
            requestCreator = PicassoHolder.HOLDER.load(options.file);
        } else if (options.drawableResId != 0) {
            requestCreator = PicassoHolder.HOLDER.load(options.drawableResId);
        } else if (options.uri != null) {
            requestCreator = PicassoHolder.HOLDER.load(options.uri);
        }

        if (requestCreator == null) {
            throw new NullPointerException("requestCreator must not be null");
        }
        if (options.targetHeight > 0 && options.targetWidth > 0) {
            requestCreator.resize(options.targetWidth, options.targetHeight);
        }
        if (options.isCenterInside) {
            requestCreator.centerInside();
        } else if (options.isCenterCrop) {
            requestCreator.centerCrop();
        }
        if (options.config != null) {
            requestCreator.config(options.config);
        }
        if (options.errorResId != 0) {
            requestCreator.error(options.errorResId);
        }
        if (options.placeholderResId != 0) {
            requestCreator.placeholder(options.placeholderResId);
        }
        if (options.bitmapAngle != 0) {
            requestCreator.transform(new PicassoTransformation(options.bitmapAngle));
        }
        if (options.skipCache) {
            requestCreator.memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE);
            requestCreator.networkPolicy(NetworkPolicy.NO_CACHE, NetworkPolicy.NO_STORE);
        }
        if (options.degrees != 0) {
            requestCreator.rotate(options.degrees);
        }

        if (options.targetView instanceof ImageView) {
            requestCreator.into(((ImageView) options.targetView));
        } else if (options.callBack != null) {
            requestCreator.into(new PicassoTarget(options.callBack));
        }
    }

    class PicassoTarget implements Target {
        ILoadCallback callBack;

        protected PicassoTarget(ILoadCallback callBack) {
            this.callBack = callBack;
        }

        @Override
        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
            if (this.callBack != null) {
                this.callBack.onBitmapLoaded(bitmap);
            }
        }

        @Override
        public void onBitmapFailed(Exception e, Drawable errorDrawable) {
            if (this.callBack != null) {
                this.callBack.onBitmapFailed(e);
            }
        }

        @Override
        public void onPrepareLoad(Drawable placeHolderDrawable) {

        }
    }

    class PicassoTransformation implements Transformation {
        private float bitmapAngle;

        protected PicassoTransformation(float corner) {
            this.bitmapAngle = corner;
        }

        @Override
        public Bitmap transform(Bitmap source) {
            float roundPx = bitmapAngle;//圆角的横向半径和纵向半径
            Bitmap output = Bitmap.createBitmap(source.getWidth(),
                    source.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(output);
            final int color = 0xff424242;
            final Paint paint = new Paint();
            final Rect rect = new Rect(0, 0, source.getWidth(), source.getHeight());
            final RectF rectF = new RectF(rect);
            paint.setAntiAlias(true);
            canvas.drawARGB(0, 0, 0, 0);
            paint.setColor(color);
            canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(source, rect, rect, paint);
            source.recycle();
            return output;
        }

        @Override
        public String key() {
            return "bitmapAngle()";
        }
    }
}
