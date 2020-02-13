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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CountriesRegistrActivity extends AppCompatActivity {

    public static final String LOG_TAG = "onEmptyResponse";


    private Spinner spinnerCountry;
    private Spinner spinnerCity;

    Button btnEndReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries_registr);

>>>>>>> 2691887c232373036b1db6ecd1b986025d4a8a8a


        spinnerCountry = findViewById(R.id.spinnerCountry);
        init();



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
                Log.d(LOG_TAG, "onResponse: "+ response.code());
                Log.d(LOG_TAG, "onResponse: "+ response.toString());

                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Log.d("onSuccess", response.body().toString());

                        String jsonresponse = response.body().toString();
                        spinJSON(jsonresponse);
                    }

                    for (int i = 0; i < countrieslArrayList.size(); i++) {
                    }

                } else {
                    Log.d("onEmptyResponse", "Returned empty response");
                     Toast.makeText(getApplicationContext(),"Nothing returned",Toast.LENGTH_LONG).show();
                }
            }
>>>>>>> 2691887c232373036b1db6ecd1b986025d4a8a8a
            @Override
            public void onResponse(Call<List<City>> call, Response<List<City>> response) {
                Log.d(LOG_TAG, "onResponse: "+ response.code());
                Log.d(LOG_TAG, "onResponse: "+ response.toString());

                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Log.d("onSuccess", response.body().toString());

<<<<<<< HEAD
                   
        }

    private void spinJSON(String response){

        try {
               JSONObject obj = new JSONObject(response);


                countrieslArrayList = new ArrayList<>();
                JSONArray dataArray  = obj.getJSONArray("");
>>>>>>> 2691887c232373036b1db6ecd1b986025d4a8a8a

        Log.d(LOG_TAG, "bind: " + citiesNames);

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, citiesNames);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        spinnerCity.setAdapter(spinnerArrayAdapter);
        spinnerCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


            }

                    Countries countries = new Countries();
                    JSONObject dataobj = dataArray.getJSONObject(i);

                    countries.setName(dataobj.getString("name"));


                    countrieslArrayList.add(countries);
>>>>>>> 2691887c232373036b1db6ecd1b986025d4a8a8a

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(CountriesRegistrActivity.this, "error", Toast.LENGTH_SHORT).show();
            }
            });

    }


                ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, R.layout.activity_countries_registr, countriesNames);
                spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                spinnerCountry.setAdapter(spinnerArrayAdapter);



        } catch (JSONException e) {
            e.printStackTrace();
        }
>>>>>>> 2691887c232373036b1db6ecd1b986025d4a8a8a

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

    public void EndReg(View view){

    }
}
