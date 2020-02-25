/*
 * Created by Rufat Asadzade on 24.02.20 13:22
 * Copyright (c) 2020. Rufat Asadzade. All rights reserved.
 */

package com.example.pulluaz.Fragments;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pulluaz.Ads;
import com.example.pulluaz.AdsActivity;
import com.example.pulluaz.R;
import com.google.android.material.navigation.NavigationView;

import java.text.ParseException;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment  implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        NavigationView navView = container.findViewById(R.id.nav_view);
        drawerLayout = container.findViewById(R.id.drawer_layout);

        View view = inflater.inflate(R.layout.home_fragment, null);

/*


        Intent intent = new Intent(HomeFragment.this.getActivity(), AdsActivity.class);
        startActivity(intent);*/

        return view;

    }


    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        return;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.exit:
                // do whatever
                //   Toast.makeText(this, "Cixiw", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_logout: {
                break;
            }
        }
        menuItem.setChecked(true);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;

    }


        public void openSideBar(View view) {
            try {
                drawerLayout.openDrawer(GravityCompat.START);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }




}
