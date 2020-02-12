/*
 * Created by Rufat Asadzade on 11.02.20 15:57
 * Copyright (c) 2020. Rufat Asadzade. All rights reserved.
 */

package com.example.pulluaz;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.regex.Pattern;

import androidx.appcompat.app.AppCompatActivity;


public class SecondRegistrationActivity  extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    DatePicker dp;
    EditText edNames,edLastName,edPhone;
    Button btnNext;
    private static final String TAG="SecondRegistrationActiv";
    private  final Pattern PHONE_NUMBER =
            Pattern.compile("^" +
                     "(?=.*[0-9])" +         //at least 1 digit
                  //  "(?=.*[a-z])" +         //at least 1 lower case letter
                    //"(?=.*[A-Z])" +         //at least 1 upper case letter
                    // "(?=.*[a-zA-Z])" +      //any letter
                    // "(?=.*[@#$%^&+=])" +    //at least 1 special character
                     "(?=\\S+$)" +           //no white spaces
                    ".{12,}" +               //at least 4 characters
                    "$");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_registration);

        edNames = findViewById(R.id.edName);
        edPhone = findViewById(R.id.edPhone);
        edLastName = findViewById(R.id.edLastName);

        Intent intent = getIntent();

        String email = intent.getStringExtra("email");
        String pass = intent.getStringExtra("pass");
        String pass2 = intent.getStringExtra("pass2");

        Log.d(TAG, "onCreate: " + email + pass + pass2);



        dp = (DatePicker)findViewById(R.id.datePicker);

            dp.isSaveEnabled();


        Spinner spinner = findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.spinner,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


}



    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        String text = adapterView.getItemAtPosition(i).toString();
        if (adapterView.isSelected()) {
            Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

        Toast.makeText(this, "Choose...", Toast.LENGTH_SHORT).show();

    }
    
    public void btnNext(View view){
        String setBirthDayPicker = " "+ dp.getDayOfMonth() + " " + (dp.getMonth() +1)+ " " + dp.getYear();

        Toast.makeText(this, "" + setBirthDayPicker, Toast.LENGTH_SHORT).show();
        return;


    }


    private boolean validatePhone() {
        String phoneInput = edPhone.getText().toString().trim();
        if (phoneInput.isEmpty()) {
            edPhone.setError("Field can't be empty");
            return false;
        } else if (phoneInput.length() < 9 || phoneInput.length() > 13) {
            edPhone.setError("Please enter a valid phone number");
            return false;
        } else {
            edPhone.setError(null);
            return true;
        }
    }

    private boolean validateName() {
        String nameInput = edNames.getText().toString().trim();

        if (nameInput.isEmpty()) {
            edNames.setError("Field can't be empty");
            return false;
        } else {
            edNames.setError(null);
            return true;
        }
    }

    private boolean validateLastName() {
        String passwordInput = edLastName.getText().toString().trim();

        if (passwordInput.isEmpty()) {
            edLastName.setError("Field can't be empty");
            return false;
        } else {
            edLastName.setError(null);
            return true;
        }
    }
    public void confirmInputSecondRegistration(View v) {
        if (!validateName() | !validateLastName() | !validatePhone()) {
            return;
        }else {
            Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show();

            intent();
        }
        
    }

    private void intent() {
        Intent intent = new Intent(getApplicationContext(), CountriesRegistrActivity.class);
        startActivity(intent);

    }
}
