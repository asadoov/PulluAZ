/*
 * Created by Rufat Asadzade on 17.02.20 12:00
 * Copyright (c) 2020. Rufat Asadzade. All rights reserved.
 */

package com.example.pulluaz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.pulluaz.Fragments.AddFragment;
import com.example.pulluaz.Fragments.HomeFragment;
import com.example.pulluaz.Fragments.NotificationFragment;
import com.example.pulluaz.Fragments.ProfilFragment;
import com.example.pulluaz.Fragments.SearchFrgment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FinishActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bot_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

       /* Intent intent = new Intent(this, AdsActivity.class);
        startActivity(intent);*/
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container1, new HomeFragment()).commit();
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()){
                        case  R.id.main:
                            selectedFragment = new HomeFragment();
                            break;

                        case  R.id.notifications:
                            selectedFragment = new NotificationFragment();
                            break;
                        case  R.id.add:
                            selectedFragment = new AddFragment();
                            break;
                        case  R.id.search:
                            selectedFragment = new SearchFrgment();
                            break;
                        case  R.id.profile:
                            selectedFragment = new ProfilFragment();
                            break;

                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container1,selectedFragment).commit();
                    return true;

                }
            };
}
