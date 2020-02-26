/*
 * Created by Rufat Asadzade on 24.02.20 11:30
 * Copyright (c) 2020. Rufat Asadzade. All rights reserved.
 */

package com.example.pulluaz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.pulluaz.Fragments.AddFragment;
import com.example.pulluaz.Fragments.NotificationFragment;
import com.example.pulluaz.Fragments.ProfilFragment;
import com.example.pulluaz.Fragments.SearchFrgment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SearchActivity extends AppCompatActivity{ //implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

       /* bottomNavigation = findViewById(R.id.bottom_nav);
        Menu menu = bottomNavigation.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.main:

                        Intent intentAds = new Intent(SearchActivity.this, AdsActivity.class);
                        startActivity(intentAds);
                        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
                        break;


                    case R.id.search:


                        break;

                    case R.id.add:
                        Intent intentAdd = new Intent(SearchActivity.this, AddActivity.class);
                        startActivity(intentAdd);
                        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                        break;
                    case R.id.profile:
                        Intent intentProfile = new Intent(SearchActivity.this, ProfileActivity.class);
                        startActivity(intentProfile);
                        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                        break;
                    case R.id.notifications:
                        Intent intentNotification = new Intent(SearchActivity.this, NotificationActivity.class);
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
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);*/
    }
}