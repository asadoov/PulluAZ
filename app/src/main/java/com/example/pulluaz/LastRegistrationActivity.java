/*
 * Created by Rufat Asadzade on 13.02.20 16:25
 * Copyright (c) 2020. Rufat Asadzade. All rights reserved.
 */

package com.example.pulluaz;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

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
                .baseUrl("http://13.92.237.16/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Log.d(TAG, "init: 1");

        SpinnerRetrofit api = retrofit.create(SpinnerRetrofit.class);
        Call<UserModel> call = api.getUserList( /*newUserStruct.name,
                newUserStruct.surname,
                newUserStruct.mail,
                newUserStruct.pass,
                newUserStruct.phone,
                newUserStruct.bDate,
                newUserStruct.gender,
                newUserStruct.country,
                newUserStruct.city,
                newUserStruct.sector*/);

       call.enqueue(new Callback<UserModel>() {
           @Override
           public void onResponse(Call<UserModel> call, Response<UserModel> response) {
               if (response.isSuccessful()) {

                      // Log.d(TAG, "onResponse: " + response.body().newUserStructs.size());
                       Log.d(TAG, "onResponse: " + response.body().newUserStructs.get(1));


               } else {
                   response.message();
               }
           }

           @Override
           public void onFailure(Call<UserModel> call, Throwable t) {


               Log.d(TAG, "onFailure: " + t.getLocalizedMessage());
               Log.d(TAG, "onFailure: " + call.request().toString());
           }


       });



        Log.d(TAG, "init: 3");
        //  Log.d(TAG, "onFailure: " + t.getLocalizedMessage());
        //   Log.d(TAG, "onFailure: " + call.request().toString());

    }


}
