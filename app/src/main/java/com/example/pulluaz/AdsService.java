/*
 * Created by Rufat Asadzade on 19.02.20 17:26
 * Copyright (c) 2020. Rufat Asadzade. All rights reserved.
 */

package com.example.pulluaz;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AdsService  {

    @GET("api/androidmobileapp/user/getAds?")
    Call<List<adView>> getAds(@Query("username") String username, @Query("pass")String pass);

    @GET("api/androidmobileapp/user/getStatistics?")
    Call<Statics> getStatistics(@Query("username") String username, @Query("pass")String pass);

    //13.92.237.16/api/androidmobileapp/acategory

    @GET("api/androidmobileapp/acategory")
    Call<List<CategoryArray>> getCategory();


}
