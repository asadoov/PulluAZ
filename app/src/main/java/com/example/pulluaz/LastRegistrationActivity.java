/*
 * Created by Rufat Asadzade on 13.02.20 16:25
 * Copyright (c) 2020. Rufat Asadzade. All rights reserved.
 */

package com.example.pulluaz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class LastRegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_registration);

        TextView txtCountry=(TextView)findViewById(R.id.countryTxt);


        String value = getIntent().getStringExtra("");
        txtCountry.setText(value);

    }
}
