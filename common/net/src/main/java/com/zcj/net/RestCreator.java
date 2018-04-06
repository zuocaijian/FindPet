package com.zcj.net;

import android.content.Context;

import com.zcj.net.Interceptors.BaseInterceptor;

import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by zcj on 2018/4/6 10:53
 */
public class RestCreator {

    // TODO: 2018/4/6 base url 应该由外部module传进来
    private static String sBaseUrl = "http://127.0.0.1/";
    // TODO: 2018/4/6 拦截器 应该由外部module传进来
    private static final ArrayList<Interceptor> INTERCEPTORS = new ArrayList<>();
    private static Context sApplicationContext;
    private static boolean isReady;

    public static void init(Context context, String baseUrl, List<BaseInterceptor> interceptors) {
        sApplicationContext = context;
        sBaseUrl = baseUrl;
        INTERCEPTORS.clear();
        INTERCEPTORS.addAll(interceptors);
        isReady = true;
    }

    public static RestService getRestService() {
        checkInit();
        return RestServiceHolder.REST_SERVICE;
    }

    public static WeakHashMap<String, Object> getParams() {
        checkInit();
        return ParamsHolder.PARAMS;
    }

    public static Context getApplicationContext() {
        return sApplicationContext;
    }

    private static void checkInit() {
        if (!isReady) {
            throw new RuntimeException("RestCreator must init before use!");
        }
    }

    private static final class ParamsHolder {
        private static final WeakHashMap<String, Object> PARAMS = new WeakHashMap<>();
    }

    private static final class RetrofitHolder {
        private static final Retrofit RETROFIT_CLIENT = new Retrofit.Builder()
                .baseUrl(sBaseUrl)
                .client(OKHttpHolder.OK_HTTP_CLIENT)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
    }

    private static final class OKHttpHolder {
        private static final int TIME_OUT = 60;
        private static final OkHttpClient.Builder BUILDER = new OkHttpClient.Builder();

        private static OkHttpClient.Builder addInterceptor() {
            if (INTERCEPTORS != null && !INTERCEPTORS.isEmpty()) {
                for (Interceptor interceptor : INTERCEPTORS) {
                    BUILDER.addInterceptor(interceptor);
                }
            }
            return BUILDER;
        }

        private static final OkHttpClient OK_HTTP_CLIENT = addInterceptor()
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .build();
    }

    private static final class RestServiceHolder {
        private static final RestService REST_SERVICE =
                RetrofitHolder.RETROFIT_CLIENT.create(RestService.class);
    }
}
