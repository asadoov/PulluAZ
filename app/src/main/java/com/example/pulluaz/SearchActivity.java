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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        final BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_nav);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);



        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {


                if (menuItem.getItemId() == R.id.main) {
                    Intent intent = new Intent(SearchActivity.this, MainActivity.class);
                    startActivity(intent);


                } else if (menuItem.getItemId() == R.id.profile) {

                    Intent intentProfil = new Intent(SearchActivity.this, StatisticActivity.class);
                    startActivity(intentProfil);
                }else if (menuItem.getItemId() == R.id.add){
                    Intent intentProfil = new Intent(SearchActivity.this, AddActivity.class);
                    startActivity(intentProfil);
                }
                return true;
            }
            Menu menu = bottomNavigationView.getMenu();
            MenuItem menuItem = menu.getItem(1);


            public void setMenuItem(MenuItem menuItem) {
                this.menuItem = menuItem;
                menuItem.setChecked(true);
            }
        });

    }


}