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
        newUserStruct.name = name;
        newUserStruct.surname = lastname;
        newUserStruct.mail = mail;
        newUserStruct.pass = pass;
        newUserStruct.phone = phone;
        newUserStruct.bDate = bDate;
        newUserStruct.gender = gender;
        newUserStruct.country = country;
        newUserStruct.city = city;
        newUserStruct.sector = sector;

       init(new NewUserStruct(name,lastname,mail, pass, phone,bDate,gender,country,city,sector));
    }

    private void init(final NewUserStruct newUserStruct) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://13.92.237.16/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Log.d(TAG, "init: 1");

        SpinnerRetrofit api = retrofit.create(SpinnerRetrofit.class);
        Intent intent = getIntent();

        final String mail = intent.getStringExtra("email");
        final String pass = intent.getStringExtra("pass");
        final String nameItem = intent.getStringExtra("name");
        final String lastname = intent.getStringExtra("lastname");
        final String phone = intent.getStringExtra("phone");
        final String country = intent.getStringExtra("country");
        final String city = intent.getStringExtra("city");
        final String bDate = intent.getStringExtra("dp");
        final String gender = intent.getStringExtra("gender");
        final String sector = intent.getStringExtra("sector");

        ArrayList<String> arrayList = new ArrayList<>();
       // arrayList.get()

        Log.d(TAG, "init: 2");

       Call<List<NewUserStruct>> call = api.getUserList(newUserStruct.name,lastname, mail, pass, phone,bDate,gender,country,city,sector);

        Log.d(TAG, "init: 3");
;
       // call.enqueue();

    }


}
