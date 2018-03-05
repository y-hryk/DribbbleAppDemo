package com.example.hyamaguchi.dribbbleappdemo.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by h.yamaguchi on 2017/12/11.
 */

public class Shot {

    public int id;
    public String title;
    public String description;

    @SerializedName("views_count")
    public int viewsCount;

    @SerializedName("likes_count")
    public int likesCount;

//    @SerializedName("user")
    public User user;
    public Image images;
}
