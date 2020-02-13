/*
 * Created by Rufat Asadzade on 11.02.20 15:25
 * Copyright (c) 2020. Rufat Asadzade. All rights reserved.
 */


package com.example.pulluaz;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CountriesRegistrActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public static final String LOG_TAG = "onEmptyResponse";


    private Spinner spinnerCountry;
    private Spinner spinnerCity;
    private Spinner sectorSpinner;

    Button btnEndReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries_registr);


        spinnerCountry = findViewById(R.id.spinnerCountry);
        spinnerCity = findViewById(R.id.spinnerCity);
        sectorSpinner = findViewById(R.id.sector);
        init();
        Log.d(LOG_TAG, "onCreate: ");



        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.spinnerSector,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sectorSpinner.setAdapter(adapter);
        sectorSpinner.setOnItemSelectedListener(this);


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        if (parent.isSelected()) {
            Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    private void init() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://13.92.237.16/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SpinnerRetrofit api = retrofit.create(SpinnerRetrofit.class);

        Call<List<Countries>> call = api.getCountries();
        call.enqueue(new Callback<List<Countries>>() {
            @Override
            public void onResponse(Call<List<Countries>> call, Response<List<Countries>> response) {
                Log.d(LOG_TAG, "onResponse: " + response.code());
                Log.d(LOG_TAG, "onResponse: " + response.toString());

                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Log.d("onSuccess", response.body().toString());

                        bindCountries(response.body());

                    } else {
                        Log.d("onEmptyResponse", "Returned empty response");//Toast.makeText(getContext(),"Nothing returned",Toast.LENGTH_LONG).show();
                    }

                }
            }

            @Override
            public void onFailure(Call<List<Countries>> call, Throwable t) {

            }
        });

    }

    public void bindCountries(final List<Countries> countries) {
        final ArrayList<String> countriesNames = new ArrayList<>();
        for (int i = 0; i < countries.size(); i++) {

            countriesNames.add(countries.get(i).getName().toString());
        }

        Log.d(LOG_TAG, "bind: " + countriesNames);

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, countriesNames);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        spinnerCountry.setAdapter(spinnerArrayAdapter);
        spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Countries country = countries.get(i);
                onChooseCountry(country);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(CountriesRegistrActivity.this, "error", Toast.LENGTH_SHORT).show();

            }
        });


    }


    public void onChooseCountry(Countries country) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://13.92.237.16/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SpinnerRetrofit api = retrofit.create(SpinnerRetrofit.class);

        Call<List<City>> call = api.getCities(country.getId());
        call.enqueue(new Callback<List<City>>() {
            @Override
            public void onResponse(Call<List<City>> call, Response<List<City>> response) {
                Log.d(LOG_TAG, "onResponse: " + response.code());
                Log.d(LOG_TAG, "onResponse: " + response.toString());

                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Log.d("onSuccess", response.body().toString());

                        bindCities(response.body());

                    } else {
                        Log.d("onEmptyResponse", "Returned empty response");//Toast.makeText(getContext(),"Nothing returned",Toast.LENGTH_LONG).show();
                    }

                }
            }

            @Override
            public void onFailure(Call<List<City>> call, Throwable t) {

            }
        });
    }

    public void bindCities(List<City> cities) {
        final ArrayList<String> citiesNames = new ArrayList<>();
        for (int i = 0; i < cities.size(); i++) {

            citiesNames.add(cities.get(i).getName().toString());
        }

        Log.d(LOG_TAG, "bind: " + citiesNames);

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, citiesNames);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        spinnerCity.setAdapter(spinnerArrayAdapter);
        spinnerCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(CountriesRegistrActivity.this, "error", Toast.LENGTH_SHORT).show();
            }
        });

    }



    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (v instanceof EditText) {
                v.clearFocus();
                InputMethodManager imm = (InputMethodManager) getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

            }

        }
        return super.dispatchKeyEvent(event);
    }

    public void EndReg(View view) {

    }


}
