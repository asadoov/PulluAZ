/*
 * Created by Rufat Asadzade on 06.02.20 10:43
 * Copyright (c) 2020. Rufat Asadzade. All rights reserved.
 */

package com.example.pulluaz;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;


public class SecondRegistrationActivity  extends AppCompatActivity {

    private static final String TAG="SecondRegistrationActiv";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_registration);

        Intent intent = getIntent();

        String email = intent.getStringExtra("email");
        String pass = intent.getStringExtra("pass");
        String pass2 = intent.getStringExtra("pass2");

        Log.d(TAG, "onCreate: " + email + pass + pass2);
}
}
