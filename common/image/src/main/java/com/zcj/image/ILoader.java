package com.zcj.image;

/**
 * Datetime: 2018/4/10 14:36
 * Author: zcj
 */
public interface ILoader {
    void loadImage(LoaderRequest request);

    void clearMemoryCache();

    void clearDiskCache();
}
