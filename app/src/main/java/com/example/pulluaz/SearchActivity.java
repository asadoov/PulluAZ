/*
 * Created by Rufat Asadzade on 24.02.20 11:30
 * Copyright (c) 2020. Rufat Asadzade. All rights reserved.
 */

package com.example.pulluaz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.pulluaz.Fragments.AddFragment;
import com.example.pulluaz.Fragments.NotificationFragment;
import com.example.pulluaz.Fragments.ProfilFragment;
import com.example.pulluaz.Fragments.SearchFrgment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SearchActivity extends AppCompatActivity{ //implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

    /*    loadFragment(new SearchFrgment());
        BottomNavigationView navigationView = findViewById(R.id.bottom_navigate);
        navigationView.setOnNavigationItemSelectedListener(this);

    }




                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment fragment = null;

                    switch (item.getItemId()) {
                        case R.id.search:

                            fragment = new SearchFrgment();
                            break;

                        case R.id.add:

                            fragment = new AddFragment();
                            break;
                        case R.id.notifications:
                            fragment = new NotificationFragment();

                            break;
                        case R.id.profile:
                            fragment = new ProfilFragment();
                            break;

                    }
                    return loadFragment(fragment);

                }

                private boolean loadFragment(Fragment fragment) {
                    if (fragment != null) {
                        getSupportFragmentManager().beginTransaction().replace(R.id.adsLayout, fragment);
                        return true;
                    }
                    return false;
                }*/
    }


}