package com.robot0x.app.api;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.robot0x.app.AppConfig;
import com.robot0x.app.AppContext;

import java.util.Locale;

import cz.msebera.android.httpclient.client.params.ClientPNames;

/**
 * Created by Jackie on 2016/3/4.
 */
public class ApiHttpClient {
    private static final String API_URL = "http://www.robot0x.com/%s";
    private static final String HOST = "www.robot0x.com";
    public static AsyncHttpClient client;

    public static void post(String partUrl, RequestParams params, AsyncHttpResponseHandler handler) {
        client.post(getAbsoluteApiUrl(partUrl), params, handler);
    }

    public static String getAbsoluteApiUrl(String partUrl) {
        String url = partUrl;
        if (!partUrl.startsWith("http:") && !partUrl.startsWith("https:")) {
            url = String.format(API_URL, partUrl);
        }
        return url;
    }

    public static void setHttpClient(AsyncHttpClient c) {
        client = c;
        client.addHeader("Accept-Language", Locale.getDefault().toString());
        client.addHeader("Host", HOST);
        client.addHeader("Connection", "Keep-Alive");
        client.addHeader("Cookie", getCookie());
        client.getHttpClient().getParams()
                .setParameter(ClientPNames.ALLOW_CIRCULAR_REDIRECTS, true);

        client.setUserAgent(ApiClientHelper.getUserAgent(AppContext.getInstance()));

    }

    public static String getCookie() {
        return AppConfig.getAppConfig(AppContext.getInstance()).get(AppConfig.COOKIE);
    }
}
