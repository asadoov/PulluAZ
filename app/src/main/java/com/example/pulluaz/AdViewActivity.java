/*
 * Created by Rufat Asadzade on 2/4/20 11:10 AM
 * Copyright (c) 2020. Rufat Asadzade. All rights reserved.
 */

package com.example.pulluaz;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class AdViewActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            try {
                setContentView(R.layout.ad_view);
                Intent intent = getIntent();
                TextView AdHeader = findViewById(R.id.adViewText);
                AdHeader.setText("Test");
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
}
