/*
 * Created by Rufat Asadzade on 02.03.20 16:25
 * Copyright (c) 2020. Rufat Asadzade. All rights reserved.
 */

package com.example.pulluaz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pulluaz.Fragments.AddFragment;
import com.example.pulluaz.Fragments.Detail_Fragment_Ads;
import com.example.pulluaz.Fragments.HomeFragment;
import com.example.pulluaz.Fragments.NotificationFragment;
import com.example.pulluaz.Fragments.ProfilFragment;
import com.example.pulluaz.Fragments.SearchFrgment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static com.example.pulluaz.Fragments.HomeFragment.EXTRA_ADS_DESC;
import static com.example.pulluaz.Fragments.HomeFragment.EXTRA_ADS_IMG;
import static com.example.pulluaz.Fragments.HomeFragment.EXTRA_ADS_NAME;
import static com.example.pulluaz.Fragments.HomeFragment.EXTRA_ADS_SELLERNAME;


public class DetailAdsActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    private ArrayList<adView> data;
    private static final String TAG = "DetailAdsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_ads);

        NavigationView navView = findViewById(R.id.nav_view);


        Intent intent = getIntent();
        String name = intent.getStringExtra(EXTRA_ADS_NAME);
        String desc = intent.getStringExtra(EXTRA_ADS_DESC);
        String img = intent.getStringExtra(EXTRA_ADS_IMG);
        String sellerName = intent.getStringExtra(EXTRA_ADS_SELLERNAME);

        TextView nameText = (TextView) findViewById(R.id.name);
        nameText.setText(name);
        TextView descText = (TextView) findViewById(R.id.detail_desc);
        descText.setText(desc);
        TextView sellerFullName = (TextView) findViewById(R.id.sellerName);
        sellerFullName.setText(sellerName);

        ImageView imgView = (ImageView)findViewById(R.id.detail_img);

        Picasso.with(this).load(img)                                 //
                .fit().centerCrop()
                .into(imgView);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.exit:
                // do whatever
                Toast.makeText(this, "Cixiw", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void openSideBar(View view) {
        try {
            drawerLayout = findViewById(R.id.drawer_layout);
            drawerLayout.openDrawer(GravityCompat.START);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    }

