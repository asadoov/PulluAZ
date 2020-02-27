/*
 * Created by Rufat Asadzade on 24.02.20 13:22
 * Copyright (c) 2020. Rufat Asadzade. All rights reserved.
 */

package com.example.pulluaz.Fragments;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pulluaz.Adapters.CategoryAdapter;
import com.example.pulluaz.Ads;
import com.example.pulluaz.AdsActivity;
import com.example.pulluaz.AdsService;
import com.example.pulluaz.CategoryArray;
import com.example.pulluaz.R;
import com.google.android.material.navigation.NavigationView;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeFragment extends Fragment  implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    DrawerLayout drawerLayout;
    ImageButton btnTog;
    private static final String TAG = "HomeFragment";
    List<CategoryArray> data;
    CategoryAdapter categoryAdapter;
    RecyclerView recyclerView;

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
        ImageButton btnTog = (ImageButton)view.findViewById(R.id.btnToggle);


         recyclerView = (RecyclerView)view.findViewById(R.id.rec_cat);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);

        loadRetrofit();
        return view;

    }

    private void loadRetrofit() {
        //https://pullu.az/api/androidmobileapp/acategory
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http:/pullu.az/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Log.d(TAG, "init: 1");



        AdsService api = retrofit.create(AdsService.class);

        Call<List<CategoryArray>> call = api.getCategory();
        Log.d(TAG, "callInterface");
        call.enqueue(new Callback<List<CategoryArray>>() {
            @Override
            public void onResponse(Call<List<CategoryArray>> call, Response<List<CategoryArray>> response) {
                if (response.isSuccessful()){
                    data = response.body();
                    for (int i = 0; i < data.size(); i++) {
                        categoryAdapter = new CategoryAdapter(getActivity(), (ArrayList<CategoryArray>) data);
                        recyclerView.setAdapter(categoryAdapter);


                        Log.d(TAG, "onResponse: " + response.body());
                    }
                }else Log.d(TAG, "onResponse: "+response.code());
            }

            @Override
            public void onFailure(Call<List<CategoryArray>> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t.getLocalizedMessage());
                Log.d(TAG, "onFailure: "+t.getMessage());
            }
        });

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
                Log.d(TAG, "EXIIIIIT");
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

    @Override
    public void onClick(View view) {
        switch (view.getId()){
          case R.id.btnToggle:
                try {
                    DrawerLayout drawer = (DrawerLayout)getActivity().findViewById(R.id.drawer_layout);
                    drawer.openDrawer(Gravity.LEFT,true);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                Log.d(TAG, "onClick:  OOOOOOOOOOOOKKKKKKKKKKKKKKK");
        }

    }
}
