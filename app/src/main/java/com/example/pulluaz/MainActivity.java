/*
 * Created by Rufat Asadzade on 23.12.19
 * Copyright (c) 2019. Rufat Asadzade. All rights reserved.
 */

package com.example.pulluaz;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.pulluaz.registartion_package.RegActivity;
import com.google.gson.Gson;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {


            SharedPreferences sharedPreferences
                    = getSharedPreferences("MySharedPref",
                    MODE_PRIVATE);
            if ((isNetworkAvailable() == true) && (sharedPreferences.getString("userData", null) != null)
                    && (sharedPreferences.getString("pass", null) != null)) {

                String aa = sharedPreferences.getString("userData", null);
                Intent AdsPage = new Intent(MainActivity.this, AdsActivity.class);
                startActivity(AdsPage);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if (!isNetworkAvailable()){
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

    }

    public void RegMe(View view) {
        Intent intent = new Intent(this, RegActivity.class);

        startActivity(intent);

        //startActivity(new Intent(MainActivity.this, RegActivity.class));

        // Do something in response to button click
    }

    @RequiresApi(api = Build.VERSION_CODES.N)

     //13.92.237.16/api/androidmobileapp/user/getAds?username=mirza@gmail.com&pass=mirza123
    public void SignIn(View view) {
        findViewById(R.id.progressBarHolder).setVisibility(View.VISIBLE);

        LinearLayout lr = new LinearLayout(this);

        SharedPreferences sharedPreferences
                = getSharedPreferences("MySharedPref",
                MODE_PRIVATE);
        final SharedPreferences.Editor myEdit
                = sharedPreferences.edit();
        final EditText usernameEdit = findViewById(R.id.username);

        final EditText passEdit = findViewById(R.id.pass);
        final String usernameTxt = usernameEdit.getText().toString();
        final String passTxt = passEdit.getText().toString();

        Intent AdsPage = new Intent(MainActivity.this, AdsActivity.class);
        AdsPage.putExtra("username",usernameTxt);
        AdsPage.putExtra("pass",passTxt);

        startActivity(AdsPage);

        if (!TextUtils.isEmpty(usernameTxt) && !TextUtils.isEmpty(passTxt)) {

            DbSelect db = new DbSelect();
            String forToast;
            if (isNetworkAvailable()) {
                Thread aa = new Thread(new Runnable() {
                    DbSelect db = new DbSelect();
                    List<User> UserData;

                    @Override
                    public void run() {


                        try {
                            UserData = db.GetUserList(usernameTxt, passTxt);

                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        //usernameEdit.setText( UserData.get(0).id.toString());

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (UserData.size() > 0) {
                                    try {
                                        Gson gson = new Gson();
                                        String jsonUserData = gson.toJson(UserData);
                                        finish();
                                        myEdit.putString(
                                                "userData",
                                                jsonUserData);
                                        myEdit.putString(
                                                "pass",
                                                passTxt);
                                        myEdit.commit();
                                        Intent AdsPage = new Intent(MainActivity.this, AdsActivity.class);
                                        AdsPage.putExtra("username",usernameTxt);
                                        AdsPage.putExtra("pass",passTxt);

                                        startActivity(AdsPage);


                                    } catch (Exception ex) {
                                        ex.printStackTrace();

                                    }

                                } else {
                                    Toast.makeText(MainActivity.this, "Username Pass yalnish yazilib!", Toast.LENGTH_SHORT).show();
                                }
                                findViewById(R.id.progressBarHolder).setVisibility(View.GONE);
                            }
                        });


                    }

                });
                aa.start();

                try {
                    aa.join();
                } catch (
                        InterruptedException e) {
                    e.printStackTrace();
                }

            } else {

                findViewById(R.id.progressBarHolder).setVisibility(View.GONE);
                Toast.makeText(this, "Net Interneta!", Toast.LENGTH_SHORT).show();


                findViewById(R.id.progressBarHolder).setVisibility(View.GONE);
            }

        } else {
            findViewById(R.id.progressBarHolder).setVisibility(View.GONE);
            Toast.makeText(this, "Boshluqlari doldurun!", Toast.LENGTH_SHORT).show();
        }
    }

        private boolean isNetworkAvailable () {
            ConnectivityManager connectivityManager
                    = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();

    }
}