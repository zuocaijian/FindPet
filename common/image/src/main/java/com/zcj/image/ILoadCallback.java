package com.zcj.image;

import android.graphics.Bitmap;

/**
 * Datetime: 2018/4/10 15:15
 * Author: zcj
 */
public interface ILoadCallback {
    void onBitmapLoaded(Bitmap bitmap);

    void onBitmapFailed(Exception e);

    class EmptyCallback implements ILoadCallback {

        @Override
        public void onBitmapLoaded(Bitmap bitmap) {

        }

        @Override
        public void onBitmapFailed(Exception e) {

        }
    }
}
