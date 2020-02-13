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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CountriesRegistrActivity extends AppCompatActivity {

    public static final String LOG_TAG = "onEmptyResponse";

    private ArrayList<Countries> countrieslArrayList;
    private ArrayList<String> countriesNames = new ArrayList<String>();
    private Spinner spinnerCountry;

    Button btnEndReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries_registr);






        spinnerCountry = findViewById(R.id.spinnerCountry);
        init();



    }
    
    private void init() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://13.92.237.16/api/androidmobileapp/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SpinnerRetrofit api = retrofit.create(SpinnerRetrofit.class);

        Call<Countries> call = api.getCountries();
        call.enqueue(new Callback<Countries>() {
            @Override
            public void onResponse(Call<Countries> call, Response<Countries> response) {
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
            @Override
            public void onFailure(Call<Countries> call, Throwable t) {

            }
        });

        }

    private void spinJSON(String response){

        try {
               JSONObject obj = new JSONObject(response);


                countrieslArrayList = new ArrayList<>();
                JSONArray dataArray  = obj.getJSONArray("");

                for (int i = 0; i < dataArray.length(); i++) {

                    Countries countries = new Countries();
                    JSONObject dataobj = dataArray.getJSONObject(i);

                    countries.setName(dataobj.getString("name"));


                    countrieslArrayList.add(countries);

                }

                for (int i = 0; i < countrieslArrayList.size(); i++){
                    countriesNames.add(countrieslArrayList.get(i).getName().toString());
                }


                ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, R.layout.activity_countries_registr, countriesNames);
                spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                spinnerCountry.setAdapter(spinnerArrayAdapter);



        } catch (JSONException e) {
            e.printStackTrace();
        }

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
