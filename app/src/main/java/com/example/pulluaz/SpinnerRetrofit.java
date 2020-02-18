/*
 * Created by Rufat Asadzade on 12.02.20 11:02
 * Copyright (c) 2020. Rufat Asadzade. All rights reserved.
 */

package com.example.pulluaz;


import android.content.Intent;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Query;
import retrofit2.http.GET;

public interface SpinnerRetrofit {
    @GET("api/androidmobileapp/getCountries")
    Call<List<Countries>> getCountries();

    @GET("api/androidmobileapp/getCities")
    Call<List<City>> getCities(@Query("countryId") Integer countryId);

    //@GET("api/androidmobileapp/user/signUp?")
    //Call<SignupResponse> getUserList();


    @GET("api/androidmobileapp/user/signUp?")
    Call<SignupResponse> signUp(@Query("username") String username,@Query("name") String name,@Query("surname")String surname, @Query("mail")String mail, @Query("pass")
            String pass, @Query("phone") String phone,  @Query("bDate")String bDate, @Query("gender")String gender,
                                @Query("country")String country,  @Query("city")String city, @Query("profession")String sector);

}
