package com.example.pulluaz;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;
import java.util.regex.Pattern;

public class RegActivity extends AppCompatActivity {

    private static final String JSON_URL = "http://13.92.237.16/api/androidmobileapp/user/about?mail=mirza@gmail.com&pass=mirza123&advertID=253";

    EditText edEmail, edPass, edPass2;
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
                    ".{4,}" +               //at least 4 characters
                    "$");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_layout);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        edEmail = findViewById(R.id.edEmail);
        edPass = findViewById(R.id.edPass);
        edPass2 = findViewById(R.id.edPass2);


        btnNext = (Button) findViewById(R.id.btnNext);


        final String email = edEmail.getText().toString();
        final String password = edPass.getText().toString();
        final String password2 = edPass2.getText().toString();


        mDisplayDate = (TextView) findViewById(R.id.date);


    }

    private void intent() {
        Intent intent = new Intent(getApplicationContext(), SecondRegistrationActivity.class);
        intent.putExtra("email", edEmail.getText().toString());
        intent.putExtra("pass", edPass.getText().toString());
        intent.putExtra("pass2", edPass2.getText().toString());
        startActivity(intent);
    }

    private boolean validateEmail() {
        String emailInput = edEmail.getText().toString().trim();
        if (emailInput.isEmpty()) {
            edEmail.setError("Field can't be empty");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            edEmail.setError("Please enter a valid email address");
            return false;
        } else {
            edEmail.setError(null);
            return true;
        }
    }

    private boolean validatePassword() {
        String passwordInput = edPass.getText().toString().trim().toLowerCase();

        if (passwordInput.isEmpty()) {
            edPass.setError("Field can't be empty");
            return false;
        } else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
            edPass.setError("Password too weak");
            return false;

        } else {
            edPass.setError(null);
            return true;
        }
    }

    private boolean validatePassword2() {
        String passwordInput = edPass2.getText().toString().trim().toLowerCase();

        if (passwordInput.isEmpty()) {
            edPass2.setError("Field can't be empty");
            return false;
        } else {
            edPass2.setError(null);
            return true;
        }
    }

    public void confirmInput(View v) {
        if (!validateEmail() | !validatePassword() | !validatePassword2()) {
            return;
        }
        if (!validatePassword() == validatePassword2()) {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();

        }else {
                Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show();

                intent();
            }



        /*String input = "Email: " + edEmail.getText().toString();
        input += "\n";
        input += "Username: " + edPass.getText().toString();
        input += "\n";
        input += "Password: " + edPass2.getText().toString();*/


        }
    }
