package com.zcj.net.Interceptors;

import android.support.annotation.RawRes;

import com.zcj.net.RestCreator;
import com.zcj.util.file.FileUtils;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by zcj on 2018/4/6 17:29
 */
public class DebugInterceptor extends BaseInterceptor {

    private final String DEBUG_URL;
    private final int DEBUG_RAW_ID;

    public DebugInterceptor(String debugUrl, int debugRawId) {
        DEBUG_URL = debugUrl;
        DEBUG_RAW_ID = debugRawId;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        final String url = chain.request().url().toString();
        if (url.contains(DEBUG_URL)){
            return debugResponse(chain, DEBUG_RAW_ID);
        }
        return super.intercept(chain);
    }

    private Response getResponse(Chain chain, String json) {
        return new Response.Builder()
                .code(200)
                .message("OK")
                .request(chain.request())
                .protocol(Protocol.HTTP_1_1)
                .addHeader("Content-Type", "application/json")
                .body(ResponseBody.create(MediaType.parse("application/json"), json))
                .build();
    }

    private Response debugResponse(Chain chain, @RawRes int rawId) {
        final String json = FileUtils.getRawFile(RestCreator.getApplicationContext(), rawId);
        return getResponse(chain, json);
    }
}
