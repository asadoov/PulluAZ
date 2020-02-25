/*
 * Created by Rufat Asadzade on 21.02.20 15:08
 * Copyright (c) 2020. Rufat Asadzade. All rights reserved.
 */

package com.example.pulluaz;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class StatisticActivity extends AppCompatActivity {
    private static final String TAG = "StatisticActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistic);




    }
}
