/*
 * Created by Rufat Asadzade on 21.02.20 15:08
 * Copyright (c) 2020. Rufat Asadzade. All rights reserved.
 */

package com.example.pulluaz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class StatisticActivity extends AppCompatActivity {
    private static final String TAG = "StatisticActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistic);

      /*  bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
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
*/





}
}
