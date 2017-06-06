package com.xuqianqian.zjgsu.sports.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by z on 2017/5/30.
 */

public class Basic {

    @SerializedName("city")
    public String cityName;

    @SerializedName("id")
    public String weatherId;

    public Update update;

    public class Update {

        @SerializedName("loc")
        public String updateTime;

    }

}

