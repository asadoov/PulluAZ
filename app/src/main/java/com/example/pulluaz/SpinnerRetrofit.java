/*
 * Created by Rufat Asadzade on 12.02.20 11:02
 * Copyright (c) 2020. Rufat Asadzade. All rights reserved.
 */

package com.example.pulluaz;


import retrofit2.Call;
import retrofit2.http.GET;

public interface SpinnerRetrofit {
    @GET("/getCountries")
    Call<Countries> getCountries();
}
