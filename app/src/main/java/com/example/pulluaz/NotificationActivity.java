/*
 * Created by Rufat Asadzade on 17.02.20 12:00
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

public class NotificationActivity extends AppCompatActivity  {

    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification_layout);
        bottomNavigation = findViewById(R.id.bottom_nav);

      /*  Menu menu = bottomNavigation.getMenu();
        MenuItem menuItem = menu.getItem(3);
        menuItem.setChecked(true);

        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.main:

                        Intent intentAds = new Intent(NotificationActivity.this, AdsActivity.class);
                        startActivity(intentAds);
                        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
                        break;


                    case R.id.search:

                        Intent intentSearch = new Intent(NotificationActivity.this, SearchActivity.class);
                        startActivity(intentSearch);
                        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
                        break;


                    case R.id.add:
                        Intent intentAdd = new Intent(NotificationActivity.this, AddActivity.class);
                        startActivity(intentAdd);
                        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
                        break;
                    case R.id.profile:
                        Intent intentProfil= new Intent(NotificationActivity.this, ProfileActivity.class);
                        startActivity(intentProfil);
                        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                        break;
                    case R.id.notifications:

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
