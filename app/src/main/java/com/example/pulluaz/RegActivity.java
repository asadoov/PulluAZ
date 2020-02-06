package com.example.pulluaz;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class RegActivity extends AppCompatActivity {

    private static final String JSON_URL = "http://13.92.237.16/api/androidmobileapp/user/about?mail=mirza@gmail.com&pass=mirza123&advertID=253";

    EditText edEmail,edPass,edPass2;
    Button btnNext;
    TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    private static final String TAG = "RegActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_layout);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        edEmail = findViewById(R.id.edEmail);
        edPass = findViewById(R.id.edPass);
        edPass2 = findViewById(R.id.edPass2);


        btnNext=(Button)findViewById(R.id.btnNext);


        final String email = edEmail.getText().toString();
        final String password = edPass.getText().toString();
        final String password2 = edPass2.getText().toString();


        mDisplayDate = (TextView) findViewById(R.id.date);

        /*DatePicker dp = findViewById(R.id.datePicker);
        dp.setOnDateChangedListener(dateChangedListener);

    private DatePicker.OnDateChangedListener dateChangedListener =
            new DatePicker.OnDateChangedListener(){
                @Override
                public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                    Toast.makeText(DatePickerWidgetActivity.this, "picked date is " + datePicker.getDayOfMonth() +
                            " / " + (datePicker.getMonth()+1) +
                            " / " + datePicker.getYear(), Toast.LENGTH_SHORT).show();
    private DatePicker.OnDateChangedListener dateChangedListener =
            new DatePicker.OnDateChangedListener(){
                @Override
                public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                    Toast.makeText(getApplicationContext(), "picked date is " + datePicker.getDayOfMonth() +
                            " / " + (datePicker.getMonth()+1) +
                            " / " + datePicker.getYear(), Toast.LENGTH_SHORT).show();*/

        /*mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        getApplicationContext(),
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

                String date = month + "/" + day + "/" + year;
                mDisplayDate.setText(date);
            }
        };*/

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if (email.isEmpty()) {
                    edEmail.setError("Mailinizi daxil edin");
                    edEmail.requestFocus();
                } else if (password.isEmpty()) {
                    edPass.setError("Shifrenizi daxil edin");
                } else if (password2.isEmpty()) {
                    edPass2.setError(" Tekrar shifrenizi daxil edin");
                } else if (email.isEmpty() && password.isEmpty() && password2.isEmpty()) {
                    Toast.makeText(RegActivity.this, "Melumatlari daxil edin", Toast.LENGTH_SHORT).show();
                }

                intent();

            }


        });



}


    private void intent() {
        Intent intent = new Intent(getApplicationContext(), SecondRegistrationActivity.class);
        intent.putExtra("email", edEmail.getText().toString());
        intent.putExtra("pass", edPass.getText().toString());
        intent.putExtra("pass2", edPass2.getText().toString());
        startActivity(intent);
    }
}
