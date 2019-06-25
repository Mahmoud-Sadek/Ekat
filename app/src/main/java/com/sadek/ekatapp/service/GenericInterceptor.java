package com.sadek.ekatapp.service;

import android.content.Context;
import android.os.SystemClock;

import com.sadek.ekatapp.BuildConfig;

import java.io.IOException;

import io.paperdb.Paper;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;


public class GenericInterceptor implements Interceptor {
    private Context context;
    public static final String ANDROID = "0";

    public GenericInterceptor(Context context) {
        this.context = context;
        Paper.init(context);
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        // Delay Requests with development
//        SystemClock.sleep(BuildConfig.DELAY);

        return addRequestHeaders(chain, context);
    }

    private static Response addRequestHeaders(Chain chain, Context context) throws IOException {
        Request request;
//        String lang = Paper.book().read(Common.language);
//        String registration_token = Paper.book().read(Common.Registration_Device);

//        if (lang == null)
//            lang = "en";
//        if (registration_token == null)
//            registration_token = "0";

        request = chain.request().newBuilder()
//                .addHeader("consumer_key", "ck_9d1296652958a3209e71c50839b27300a38cb174")
//                .addHeader("consumer_secret", "cs_88afda5fc025c1afd449cdc5ab84055da4d8f3e9")
                .addHeader("Content-Type", "application/json")
                .build();
        return chain.proceed(request);
    }
}
