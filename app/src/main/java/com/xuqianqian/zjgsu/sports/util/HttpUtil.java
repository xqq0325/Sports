package com.xuqianqian.zjgsu.sports.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by z on 2017/5/30.
 */

public class HttpUtil {
    public static void sendOkHttpRequest(String address, okhttp3.Callback callback) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);
    }

}


