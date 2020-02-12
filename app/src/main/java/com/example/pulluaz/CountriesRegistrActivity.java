/*
 * Created by Rufat Asadzade on 11.02.20 15:25
 * Copyright (c) 2020. Rufat Asadzade. All rights reserved.
 */

package com.example.pulluaz;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;

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

                        countrieslArrayList = new ArrayList<>();

                                Countries spinnerModelCountry = new Countries();

                     //   spinnerModelCountry.setName(dataobj.getString("name"));

                        countrieslArrayList.add(spinnerModelCountry);

                    }

                    for (int i = 0; i < countrieslArrayList.size(); i++){
                        countriesNames.add(countrieslArrayList.get(i).getName().toString());
                    }

//                    ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, countriesNames);
//                    spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
//                    spinnerCountry.setAdapter(spinnerArrayAdapter);


                    for (int i = 0; i <countrieslArrayList.size() ; i++) {

                        }


                    } else {
                        Log.d("onEmptyResponse", "Returned empty response");//Toast.makeText(getContext(),"Nothing returned",Toast.LENGTH_LONG).show();
                    }
                }



            @Override
            public void onFailure(Call<Countries> call, Throwable t) {

            }
        });



    }

    public void EndReg(View view){

    }

  /*  private void spinJSON(String response){

        try {

                JSONObject obj = new JSONObject(response);
                countrieslArrayList = new ArrayList<>();
                JSONArray dataArray  = null;

                for (int i = 0; i < dataArray.length(); i++) {

                    Countries spinnerModelCountry = new Countries();
                    JSONObject dataobj = dataArray.getJSONObject(i);

                    spinnerModelCountry.setName(dataobj.getString("name"));

                    countrieslArrayList.add(spinnerModelCountry);

                }

                for (int i = 0; i < countrieslArrayList.size(); i++){
                    countriesNames.add(countrieslArrayList.get(i).getName().toString());
                }

                ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, countriesNames);
                spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                spinnerCountry.setAdapter(spinnerArrayAdapter);

            } catch (JSONException ex) {
            ex.printStackTrace();
        }

    }
*/

}
