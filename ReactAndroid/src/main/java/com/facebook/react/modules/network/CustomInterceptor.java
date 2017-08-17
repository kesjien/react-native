package com.facebook.react.modules.network;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import java.io.*;

public class CustomInterceptor implements Interceptor {
    private static final String CUSTOM_USER_AGENT = "com.ciklum.EPension";
    @Override public Response intercept(Interceptor.Chain chain) throws IOException {
        Request originalRequest = chain.request();
        Request requestWithUserAgent = originalRequest.newBuilder()
                .removeHeader("User-Agent")
                .header("User-Agent",CUSTOM_USER_AGENT + '/' + System.getProperty("http.agent"))
                .build();
        return chain.proceed(requestWithUserAgent);
    }
}
