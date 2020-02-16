/*
 * Created by Rufat Asadzade on 13.02.20 16:25
 * Copyright (c) 2020. Rufat Asadzade. All rights reserved.
 */

package com.example.pulluaz;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

public class LastRegistrationActivity extends Activity {
    private static final String TAG = "LastRegistrationActivit";


    SharedPreferences.Editor ed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_registration);

        Log.d(TAG, "onCreate: ");

      // init();

        TextView txtCountry=(TextView)findViewById(R.id.countryTxt);
      //  TextView mail=(TextView)findViewById(R.id.mail);
     //   TextView city=(TextView)findViewById(R.id.cityTxt);
        TextView profession=(TextView)findViewById(R.id.profession);
       // TextView gender=(TextView)findViewById(R.id.gender);
        TextView date=(TextView)findViewById(R.id.dateTxt);




        Intent intent = getIntent();

        String mail = intent.getStringExtra("email");
        String pass = intent.getStringExtra("pass");
        String name = intent.getStringExtra("name");
        String lastname = intent.getStringExtra("lastname");
        String phone = intent.getStringExtra("phone");
        String country = intent.getStringExtra("country");
        String city = intent.getStringExtra("city");
        String dp = intent.getStringExtra("dp");
        String gender = intent.getStringExtra("gender");
        String sector = intent.getStringExtra("sector");


        Log.d(TAG, "onCreate: "+ mail+" "+ pass+" "+name+" "+lastname+" "+phone+" "+country+" "+city+" "+dp+" "+gender+" "+sector);




/*

            String valueCountry = getIntent().getStringExtra("country");
            txtCountry.setText(valueCountry);
*/



         //   city.setText(valueCity);

       /* String valueProfession = getIntent().getStringExtra("profession");
        Log.d(TAG, "onClick: 1");
         profession.setText(valueProfession);
        Log.d(TAG, "onClick: 2");*/
        /*
       *//* String value = getIntent().getStringExtra("city");
        txtCountry.setText(value);
        String value = getIntent().getStringExtra("city");
        txtCountry.setText(value);*//*

*/





        }

    private void init(User user) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://13.92.237.16/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SpinnerRetrofit api = retrofit.create(SpinnerRetrofit.class);

      //  Call<List<City>> call = api.getCities(user);
    }


}
