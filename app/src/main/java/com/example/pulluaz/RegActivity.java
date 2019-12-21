package com.example.pulluaz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RegActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_layout);
    }
    public void goToSignIn(View view)
    {
finishAffinity();
Intent SignInPage=new Intent(this,MainActivity.class);
startActivity(SignInPage);

    }
}
