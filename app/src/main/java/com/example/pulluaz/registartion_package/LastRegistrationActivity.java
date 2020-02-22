/*
 * Created by Rufat Asadzade on 19.02.20 14:19
 * Copyright (c) 2020. Rufat Asadzade. All rights reserved.
 */

package com.example.pulluaz.registartion_package;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.pulluaz.R;

public class LastRegistrationActivity extends Activity {
    private static final String TAG = "LastRegistrationActivit";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_registration);
        Log.d(TAG, "onCreate: ");

        Intent intent = getIntent();

        String mail = intent.getStringExtra("email");
        String pass = intent.getStringExtra("pass");
        final String name = intent.getStringExtra("name");
        String lastname = intent.getStringExtra("lastname");
        String phone = intent.getStringExtra("phone");
        String country = intent.getStringExtra("country");
        String city = intent.getStringExtra("city");
        final String bDate = intent.getStringExtra("dp");
        String gender = intent.getStringExtra("gender");
        String sector = intent.getStringExtra("sector");

        NewUserStruct newUserStruct = new NewUserStruct(name,lastname,mail, pass, phone,bDate,gender,country,city,sector);

       init(newUserStruct);
    }

    private void init(final NewUserStruct newUserStruct) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pullu.az/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Log.d(TAG, "init: 1");

        SpinnerRetrofit api = retrofit.create(SpinnerRetrofit.class);

        Call<SignupResponse> call = api.signUp(newUserStruct.name,
                newUserStruct.name,
                newUserStruct.surname,
                newUserStruct.mail,
                newUserStruct.pass,
                newUserStruct.phone,
                newUserStruct.bDate,
                newUserStruct.gender,
                newUserStruct.country,
                newUserStruct.city,
                newUserStruct.sector);

       call.enqueue(new Callback<SignupResponse>() {
           @Override
           public void onResponse(Call<SignupResponse> call, Response<SignupResponse> response){
               Integer responseCode = response.body().response;
               Log.d(TAG, "onResponse: "+ call.request().url());
               Log.d(TAG, "onResponse: "+ call.request().toString());
               Log.d(TAG, "onResponse: " + responseCode);
               if (responseCode == 0) {
                   Toast.makeText(LastRegistrationActivity.this, "ok", Toast.LENGTH_SHORT).show();

               } else if (responseCode == 1) {
                   Toast.makeText(LastRegistrationActivity.this, "Server error", Toast.LENGTH_SHORT).show();

               } else if (responseCode == 2) {
                   Toast.makeText(LastRegistrationActivity.this, "İstifadəçi artiq vardır", Toast.LENGTH_SHORT).show();

               }
           }

           @Override
           public void onFailure(Call<SignupResponse> call, Throwable t) {

           }
       });




        Log.d(TAG, "init: 3");
        //  Log.d(TAG, "onFailure: " + t.getLocalizedMessage());
        //   Log.d(TAG, "onFailure: " + call.request().toString());

    }


}
