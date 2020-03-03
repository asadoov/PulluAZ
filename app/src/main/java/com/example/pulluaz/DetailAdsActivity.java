/*
 * Created by Rufat Asadzade on 02.03.20 16:25
 * Copyright (c) 2020. Rufat Asadzade. All rights reserved.
 */

package com.example.pulluaz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.pulluaz.Fragments.AddFragment;
import com.example.pulluaz.Fragments.HomeFragment;
import com.example.pulluaz.Fragments.NotificationFragment;
import com.example.pulluaz.Fragments.ProfilFragment;
import com.example.pulluaz.Fragments.SearchFrgment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import static com.example.pulluaz.Fragments.HomeFragment.EXTRA_ADS_DESC;
import static com.example.pulluaz.Fragments.HomeFragment.EXTRA_ADS_NAME;


public class DetailAdsActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_ads);

        bottomNavigation = findViewById(R.id.bottom_nav_detail);
        NavigationView navView = findViewById(R.id.nav_view);

  //      getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container3,new HomeFragment()).commit();


/*

        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment selectedFragment = null;

                switch (item.getItemId()) {
                    case R.id.main:
                        selectedFragment = new HomeFragment();
                        break;
                    case R.id.search:
                        selectedFragment = new SearchFrgment();
                        break;
                    case R.id.add:
                        selectedFragment = new AddFragment();
                        break;
                    case R.id.profile:
                        selectedFragment = new ProfilFragment();
                        break;
                    case R.id.notifications:
                        selectedFragment = new NotificationFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container3,selectedFragment).commit();
                return true;
            }
        });
*/




        Intent intent = getIntent();
        String name = intent.getStringExtra(EXTRA_ADS_NAME);
        String desc = intent.getStringExtra(EXTRA_ADS_DESC);

        TextView nameText= (TextView)findViewById(R.id.name);
        nameText.setText(name);
        TextView descText= (TextView)findViewById(R.id.detail_desc);
        descText.setText(desc);

    }
}
