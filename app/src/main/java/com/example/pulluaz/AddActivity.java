/*
 * Created by Rufat Asadzade on 25.02.20 16:15
 * Copyright (c) 2020. Rufat Asadzade. All rights reserved.
 */

package com.example.pulluaz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AddActivity extends AppCompatActivity {


    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
    }


    /*    bottomNavigation = findViewById(R.id.bottom_nav);
        Menu menu = bottomNavigation.getMenu();
        MenuItem menuItem = menu.getItem(2);
        menuItem.setChecked(true);

        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.main:

                       *//* Intent intentAds = new Intent(AddActivity.this, AdsActivity.class);
                        startActivity(intentAds);
                        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);*//*
                        break;


                    case R.id.search:

                       *//* Intent intentAdd = new Intent(AddActivity.this, SearchActivity.class);
                        startActivity(intentAdd);
                        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);*//*
                        break;


                    case R.id.add:

                        break;
                    case R.id.profile:
                        *//*Intent intentProfile = new Intent(AddActivity.this, ProfileActivity.class);
                        startActivity(intentProfile);
                        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);*//*
                        break;
                    case R.id.notifications:
                        Intent intentNotification = new Intent(AddActivity.this, NotificationActivity.class);
                        startActivity(intentNotification);
                        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                        break;


                }
                return false;
            }
        });

    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
    }*/
}
