package com.example.pulluaz;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

public class RegActivity extends AppCompatActivity {

    private static final String JSON_URL = "http://13.92.237.16/api/androidmobileapp/user/about?mail=mirza@gmail.com&pass=mirza123&advertID=253";

  //  EditText edEmail, edPass, edPass2;
    TextInputLayout txtInput,txtInputPass2,txtInputPass;
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
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        txtInput = findViewById(R.id.txtInput);
        txtInputPass = findViewById(R.id.txtInputPass);
        txtInputPass2 = findViewById(R.id.txtInputPass2);

       /* edEmail.setOnFocusChangeListener(listener);
        edPass.setOnFocusChangeListener(listener);
        edPass2.setOnFocusChangeListener(listener);*/

        btnNext = findViewById(R.id.btnNext);
        txtInput = findViewById(R.id.txtInput);



        final String email = txtInput.getEditText().toString();
        final String password = txtInputPass.getEditText().toString();
        final String password2 = txtInputPass2.getEditText().toString();

        mDisplayDate = (TextView) findViewById(R.id.date);


    }

    private void intent() {
        Intent intent = new Intent(getApplicationContext(), SecondRegistrationActivity.class);

        intent.putExtra("email",txtInput.getEditText().toString());
        intent.putExtra("pass",txtInputPass.getEditText().toString());
        startActivity(intent);
    }

    private boolean validateEmail() {
        String emailInput = txtInput.getEditText().getText().toString().trim();
        if (emailInput.isEmpty()) {
            txtInput.setError("Field can't be empty");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            txtInput.setError("Please enter a valid email address");
            return false;
        } else {
            txtInput.setError(null);
            return true;
        }
    }

    private boolean validatePassword() {
        String passwordInput = txtInputPass.getEditText().getText().toString().trim().toLowerCase();

        if (passwordInput.isEmpty()) {
            txtInputPass.setError("Field can't be empty");
            return false;
        } else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
            txtInputPass.setError("Password too weak");
            return false;

        } else {
            txtInputPass.setError(null);
            return true;
        }
    }

    private boolean validatePassword2() {
        String passwordInput2 = txtInputPass2.getEditText().getText().toString().trim().toLowerCase();

        if (passwordInput2.isEmpty()) {
            txtInputPass2.setError("Field can't be empty");
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

        String strPassword1 = txtInputPass.getEditText().getText().toString();
        String strPassword2 = txtInputPass2.getEditText().getText().toString();

        if (strPassword1.equals(strPassword2)) {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
            intent();
        }

        else {
                Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show();


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

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() ==  MotionEvent.ACTION_DOWN) hideKeyboard();
        return super.dispatchTouchEvent(ev);
    }

}
