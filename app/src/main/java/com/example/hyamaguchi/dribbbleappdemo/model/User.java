package com.example.hyamaguchi.dribbbleappdemo.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by h.yamaguchi on 2018/02/28.
 */

public class User {

    public String name;
    public String userName;

    @SerializedName("avatar_url")
    public String avatarUrl;
}
