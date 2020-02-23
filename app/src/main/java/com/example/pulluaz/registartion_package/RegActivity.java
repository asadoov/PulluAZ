/*
 * Created by Rufat Asadzade on 19.02.20 13:57
 * Copyright (c) 2020. Rufat Asadzade. All rights reserved.
 */

package com.example.pulluaz.registartion_package;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pulluaz.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

public class RegActivity extends AppCompatActivity {


    TextInputLayout txtInput,txtInputPass2,txtInputPass;
    TextInputEditText edEmail, edPass,edConfimPass;
    Button btnNext;

    TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    private static final String TAG = "RegActivity";
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                   // "(?=.*[0-9])" +         //at least 1 digit
                    "(?=.*[a-z])" +         //at least 1 lower case letter
                    //"(?=.*[A-Z])" +         //at least 1 upper case letter
                    // "(?=.*[a-zA-Z])" +      //any letter
                   // "(?=.*[@#$%^&+=])" +    //at least 1 special character
                   // "(?=\\S+$)" +           //no white spaces
                    ".{3,}" +               //at least 4 characters
                    "$");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_layout);
       getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        /*if (!isNetworkAvailable()){
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("İnternet yoxdur")
                    .setMessage("Internet bağlanmasını yoxlayın")
                    .setPositiveButton("Çixiş", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    })
                    .show();

        }else {
            return;
        }
*/



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        txtInput = findViewById(R.id.txtInput);
        txtInputPass = findViewById(R.id.txtInputPass);
        txtInputPass2 = findViewById(R.id.txtInputPass2);

        edEmail = (TextInputEditText)findViewById(R.id.edEmail);
        edPass = (TextInputEditText)findViewById(R.id.edPass);
        edConfimPass = (TextInputEditText)findViewById(R.id.confimPass);

       /* edEmail.setOnFocusChangeListener(listener);
        edPass.setOnFocusChangeListener(listener);
        edPass2.setOnFocusChangeListener(listener);*/

        btnNext = findViewById(R.id.btnNext);



/*
        final String email = edEmail.getText().toString();
        final String password = edPass.getText().toString();
        final String password2 = edConfimPass.getText().toString();

        mDisplayDate = (TextView) findViewById(R.id.date);

        if (email.isEmpty()) {
            txtInput.setError("Field can't be empty");
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            txtInput.setError("Please enter a valid email address");

        } else {
            txtInput.setError(null);

        }*/

    }

   /* private void onClick(View view) {
        Intent intent = new Intent(getApplicationContext(), SecondRegistrationActivity.class);

        intent.putExtra("email",txtInput.getEditText().getText().toString());
        intent.putExtra("pass",txtInputPass.getEditText().getText().toString());
        startActivity(intent);
    }*/

    private boolean validateEmail() {
        String emailInput = edEmail.getText().toString().trim();
        if (emailInput.isEmpty()) {
            txtInput.setError("Field can't be empty");
       //     requestFocus(edEmail);
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            txtInput.setError("Please enter a valid email address");
           // requestFocus(edEmail);
            return false;
        } else {
            txtInput.setError(null);
            return true;
        }
    }

    private boolean validatePassword() {
        String passwordInput = edPass.getText().toString().trim().toLowerCase();

        if (passwordInput.isEmpty()) {
            txtInputPass.setError("Field can't be empty");
         //   requestFocus(edPass);
            return false;
        } else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
            txtInputPass.setError("Password too weak");
            requestFocus(edPass);
            return false;

        } else {
            txtInputPass.setError(null);
            return true;
        }
    }

    private boolean validatePassword2() {
        String passwordInput2 = edConfimPass.getText().toString().trim().toLowerCase();

        if (passwordInput2.isEmpty()) {
            txtInputPass2.setError("Field can't be empty");
         ///   requestFocus(edConfimPass);
            return false;
        } else {
            txtInputPass2.setError(null);
            return true;
        }
    }

    public void confirmInput(View v) {
           if (!validateEmail() | !validatePassword() | !validatePassword2()) {
               return;
           }

         String strPassword1 = edPass.getText().toString();
         String strPassword2 = edConfimPass.getText().toString();

         Log.d(TAG, "confirmInput: "  + strPassword2);

        if (strPassword1.equals(strPassword2)) {
            Intent intent = new Intent(getApplicationContext(), SecondRegistrationActivity.class);

            intent.putExtra("email",edEmail.getText().toString());
            intent.putExtra("pass",edPass.getText().toString());
            startActivity(intent);
        }
        else {
                Toast.makeText(this, "Duzgun doldurun", Toast.LENGTH_SHORT).show();
            }
        }

    final View.OnFocusChangeListener listener = new View.OnFocusChangeListener() {
        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            if (!hasFocus) hideKeyboard();
        }
    };

    private void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
    }

    public void requestFocus(View view){
        if (view.requestFocus()) {

            getWindow().setSoftInputMode(
                    WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    private boolean isNetworkAvailable () {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() ==  MotionEvent.ACTION_DOWN) hideKeyboard();
        return super.dispatchTouchEvent(ev);
    }

}
