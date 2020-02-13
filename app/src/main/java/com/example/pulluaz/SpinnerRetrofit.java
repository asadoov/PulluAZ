/*
 * Created by Rufat Asadzade on 12.02.20 11:02
 * Copyright (c) 2020. Rufat Asadzade. All rights reserved.
 */

package com.example.pulluaz;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.Query;
import retrofit2.http.GET;

public interface SpinnerRetrofit {
    @GET("api/androidmobileapp/getCountries")
    Call<List<Countries>> getCountries();

    @GET("api/androidmobileapp/getCities")
    Call<List<City>> getCities(@Query("countryId") Integer countryId);
}
