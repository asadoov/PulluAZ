/*
 * Created by Rufat Asadzade on 11.02.20 15:57
 * Copyright (c) 2020. Rufat Asadzade. All rights reserved.
 */

package com.example.pulluaz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;


public class SecondRegistrationActivity  extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    DatePicker dp;
    EditText edNames,edLastName,edPhone;
    Spinner spinner;
    Button btnNextCountry;
    private static final String TAG="SecondRegistrationActiv";
    private  final Pattern PHONE_NUMBER =
            Pattern.compile("^" +
                     "(?=.*[0-9])" +         //at least 1 digit
                  //  "(?=.*[a-z])" +         //at least 1 lower case letter
                    //"(?=.*[A-Z])" +         //at least 1 upper case letter
                    // "(?=.*[a-zA-Z])" +      //any letter
                    // "(?=.*[@#$%^&+=])" +    //at least 1 special character
                     "(?=\\S+$)" +           //no white spaces
                    ".{9,}" +               //at least 4 characters
                    "$");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_registration);
        closeKeyboard();






        edNames = findViewById(R.id.edName);
        edPhone = findViewById(R.id.edPhone);
        edLastName = findViewById(R.id.edLastName);

        dp = (DatePicker)findViewById(R.id.datePicker);

            dp.isSaveEnabled();



        spinner = findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.spinner,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);




}

    private void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view !=null){
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(),0);
        }

    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        String text = adapterView.getItemAtPosition(i).toString();



        if (adapterView.isSelected()) {

            intent();
            Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

        Toast.makeText(this, "Choose...", Toast.LENGTH_SHORT).show();

    }

    public void btnNext(View view){
      final   String setBirthDayPicker = " "+ dp.getDayOfMonth() + " " + (dp.getMonth() +1)+ " " + dp.getYear();

      String name = edNames.getText().toString();
      String lastname = edLastName.getText().toString();
      String phone = edPhone.getText().toString();

      if (name.isEmpty()){
          edNames.setError("Daxil edin");
      }else if (lastname.isEmpty()){
          edLastName.setError("Soyadinizi qeyd edin");
      } else if (name.isEmpty() && lastname.isEmpty()){
          edNames.setError("daxil edin");
          edLastName.setError("daxil edin");

      }else if (phone.isEmpty()){
          edPhone.setError("Daxil edin");
      }else if (name.isEmpty() | lastname.isEmpty() | phone.isEmpty()){
          edNames.setError("daxil edin");
          edLastName.setError("daxil edin");
          edPhone.setError("daxil edin");
      }else if (phone.length() <9 && phone.length()>10){
          edPhone.setError("daxil edin");
      }else if (!PHONE_NUMBER.matcher(phone).matches()) {
          edPhone.setError("Password too weak");


      } else
          intent();






       // Toast.makeText(this, "" + setBirthDayPicker, Toast.LENGTH_SHORT).show();
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
            intent();
            Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show();
        }
        
    }

    private void intent() {

        Intent intent = getIntent();

        String mail = intent.getStringExtra("email");
        String pass = intent.getStringExtra("pass");

        String gender = spinner.getSelectedItem().toString();

        Log.d(TAG, "onCreate: "+ mail+pass);

        Intent intent2 = new Intent(getApplicationContext(), CountriesRegistrActivity.class);
        intent2.putExtra("name", edNames.getText().toString());
        intent2.putExtra("lastname", edLastName.getText().toString());
        intent2.putExtra("phone", "+994"+ edPhone.getText().toString());
        intent2.putExtra("email", mail);
        intent2.putExtra("pass", pass);
        intent2.putExtra("gender", gender);
        intent2.putExtra("dp", dp.getYear() + "-" + (dp.getMonth() +1)+ "-" + dp.getDayOfMonth());

        startActivity(intent2);

    }
    private void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() ==  MotionEvent.ACTION_DOWN) hideKeyboard();
        return super.dispatchTouchEvent(ev);
    }
}
