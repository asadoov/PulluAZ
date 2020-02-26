/*
 * Created by Rufat Asadzade on 26.02.20 12:01
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

public class ProfileActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

       /* bottomNavigation = findViewById(R.id.bottom_nav);
        Menu menu = bottomNavigation.getMenu();
        MenuItem menuItem = menu.getItem(4);
        menuItem.setChecked(true);

        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.main:

                        Intent intentAds = new Intent(ProfileActivity.this, AdsActivity.class);
                        startActivity(intentAds);
                        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
                        break;


                    case R.id.search:

                        Intent intentSearch = new Intent(ProfileActivity.this, SearchActivity.class);
                        startActivity(intentSearch);
                        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
                        break;


                    case R.id.add:
                        Intent intentAdd = new Intent(ProfileActivity.this, AddActivity.class);
                        startActivity(intentAdd);
                        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
                        break;
                    case R.id.profile:

                        break;
                    case R.id.notifications:
                        Intent intentNotification = new Intent(ProfileActivity.this, NotificationActivity.class);
                        startActivity(intentNotification);
                        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
                        break;


                }
                return false;
            }
        });

    }

    @Override
    public void finish() {
        super.finish();
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);*/
    }
}
