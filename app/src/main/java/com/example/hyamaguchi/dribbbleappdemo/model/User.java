package com.example.hyamaguchi.dribbbleappdemo.model;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by h.yamaguchi on 2018/02/28.
 */

public class User implements Serializable {

    public int id;
    public String name;
    public String userName;

    @SerializedName("avatar_url")
    public String avatarUrl;
}
