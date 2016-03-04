package com.robot0x.app.api;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

/**
 * Created by Jackie on 2016/3/4.
 */
public class Robot0xApi {

    /**
     * BUG上报
     * @param data
     * @param handler
     */
    public static void uploadLog(String data, AsyncHttpResponseHandler handler) {
        uploadLog(data, "1", handler);
    }

    private static void uploadLog(String data, String report, AsyncHttpResponseHandler handler) {
        RequestParams params = new RequestParams();
        params.put("app", 1);
        params.put("report", 1);
        params.put("msg", data);
        ApiHttpClient.post("action/api/user_report_to_admin", params, handler);
    }
}
