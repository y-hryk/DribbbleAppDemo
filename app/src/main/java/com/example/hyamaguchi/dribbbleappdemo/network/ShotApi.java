package com.example.hyamaguchi.dribbbleappdemo.network;
import com.example.hyamaguchi.dribbbleappdemo.model.Shot;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by h.yamaguchi on 2017/12/11.
 */

public interface ShotApi {

    String END_POINT = "https://api.dribbble.com";

    @GET("/v1/shots?access_token=b1621158ad9eefeaaf2a1047b0345d4662993a045398ad3c90c2a6e55462f084")
    Call<List<Shot>> fetchShots();
}