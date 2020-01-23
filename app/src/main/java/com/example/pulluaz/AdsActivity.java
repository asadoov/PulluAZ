/*
 * Created by Rufat Asadzade on 25.12.19
 * Copyright (c) 2019. Rufat Asadzade. All rights reserved.
 */

package com.example.pulluaz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.w3c.dom.Text;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class AdsActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    List<User> usrList;
    List<Ads> AdsList;
    public int advCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences sharedPreferences
                = getSharedPreferences("MySharedPref",
                MODE_PRIVATE);
        super.onCreate(savedInstanceState);


        try {
            //findViewById(R.id.progressBarHolder).setVisibility(View.VISIBLE);
            setContentView(R.layout.ads_layout);
            NavigationView navView = findViewById(R.id.nav_view);
           /* toolbar = (Toolbar) findViewById(R.id.toolbar);
            drawerLayout = findViewById(R.id.drawer_layout);
            setSupportActionBar(toolbar);


                ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
                mDrawerToggle.syncState();



           CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.collapsing_toolbar);
            collapsingToolbar.setActivated(true);
            collapsingToolbar.setExpandedTitleColor(Color.parseColor("#00FFFFFF"));
            collapsingToolbar.setTitle("PULLU");


           */

            Intent iin = getIntent();
            Bundle uData = iin.getExtras();
            //String jsonUserData = sharedPreferences.getString("userData", "");
            if ((sharedPreferences.getString("userData", null) != null) && (sharedPreferences.getString("pass", null) != null)) {
                //= String jsonUserData = (String) uData.get("UserData");
                String jsonUserData = sharedPreferences.getString("userData", "");
                Gson gson = new GsonBuilder().setLenient().create();

                usrList = Arrays.asList(gson.fromJson(jsonUserData, User[].class));

                final String userMail = usrList.get(0).mail;
                View headerView = navView.getHeaderView(0);
                TextView nameSurname = headerView.findViewById(R.id.nameSurname);
                TextView mail = headerView.findViewById(R.id.mail);
                nameSurname.setText(usrList.get(0).name + " " + usrList.get(0).surname);
                mail.setText(userMail);


                Thread aa = new Thread(new Runnable() {
                    DbSelect db = new DbSelect();


                    @Override
                    public void run() {
                        SharedPreferences sharedPreferences
                                = getSharedPreferences("MySharedPref",
                                MODE_PRIVATE);

                        try {
                            AdsList = db.GetAds(userMail, sharedPreferences.getString("pass", ""));

                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        //usernameEdit.setText( UserData.get(0).id.toString());

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {


                                try {
                                    advCounter = 0;
                                    LinearLayout adsScroll = findViewById(R.id.adsScroll);
                                    adsScroll.removeAllViews();
                                    for (Ads adv : AdsList) {

                                        if (adv.isPaid == 1) {
                                            advCounter++;
                                            AdvCreator(adv);
                                        }
                                    }
                                    TextView advCounterView = findViewById(R.id.advCounter);
                                    advCounterView.setText(advCounter + " yeni reklam");
                                    findViewById(R.id.progressBarHolder).setVisibility(View.GONE);
                                } catch (Exception ex) {
                                    ex.printStackTrace();

                                }


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


            }


        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 0:
                // do whatever
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);


        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_logout: {
                break;
            }
        }
        menuItem.setChecked(true);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;

    }

    public void openSideBar(View view) {
        try {
            drawerLayout = findViewById(R.id.drawer_layout);
            drawerLayout.openDrawer(GravityCompat.START);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void notPaidClick(final View view) {


        try {
            findViewById(R.id.progressBarHolder).setVisibility(View.VISIBLE);
            findViewById(R.id.adsLayout).setVisibility(View.GONE);


            Button paidBtn = findViewById(R.id.paidBtn);
            paidBtn.setBackgroundResource(R.drawable.round_button_not_clicked);
            paidBtn.setTextColor(Color.parseColor("#454555"));


            Button btn = (Button) view;
            btn.setBackgroundResource(R.drawable.round_button);
            btn.setTextColor(Color.WHITE);

            TextView advCounterView = findViewById(R.id.advCounter);
            advCounterView.setText(advCounter + " yeni reklam");
            LinearLayout adsScroll = findViewById(R.id.adsScroll);
            adsScroll.removeAllViews();

            Thread secondThread = new Thread(new Runnable() {


                @Override
                public void run() {
                    try {


                        advCounter = 0;


                        for (Ads adv : AdsList) {

                            if (adv.isPaid == 0) {
                                advCounter++;
                                try {
                                    AdvCreator(adv);
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            secondThread.start();


        } catch (Exception ex) {
            ex.printStackTrace();
        }
        findViewById(R.id.adsLayout).setVisibility(View.VISIBLE);
        findViewById(R.id.progressBarHolder).setVisibility(View.GONE);
    }

    public void PaidClick(final View view) {
        findViewById(R.id.adsLayout).setVisibility(View.VISIBLE);


        try {


            Button notPaidBtn = findViewById(R.id.notPaidBtn);
            notPaidBtn.setBackgroundResource(R.drawable.round_button_not_clicked);
            notPaidBtn.setTextColor(Color.parseColor("#454555"));


            Button btn = (Button) view;
            btn.setBackgroundResource(R.drawable.round_button);
            btn.setTextColor(Color.WHITE);

            TextView advCounterView = findViewById(R.id.advCounter);
            advCounterView.setText(advCounter + " yeni reklam");
            LinearLayout adsScroll = findViewById(R.id.adsScroll);
            adsScroll.removeAllViews();

            advCounter = 0;


            for (Ads adv : AdsList) {

                if (adv.isPaid == 1) {
                    advCounter++;
                    try {
                        AdvCreator(adv);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }


        } catch (Exception ex) {
            ex.printStackTrace();
        }
        findViewById(R.id.adsLayout).setVisibility(View.VISIBLE);
        findViewById(R.id.progressBarHolder).setVisibility(View.GONE);
    }

    public void AdvCreator(final Ads adv) throws ParseException {
        runOnUiThread(new Runnable() {

            @Override
            public void run() {
                LinearLayout adsScroll = findViewById(R.id.adsScroll);
                CardView adCard = new CardView(AdsActivity.this);
                CardView.LayoutParams params = new CardView.LayoutParams(
                        CardView.LayoutParams.MATCH_PARENT,
                        CardView.LayoutParams.WRAP_CONTENT
                );
                params.setMargins(10, 10, 10, 10);
                adCard.setLayoutParams(params);

                adCard.setBackgroundResource(R.drawable.round_ads);
                adCard.setRadius(20);

                LinearLayout lr = new LinearLayout(AdsActivity.this);
                LinearLayout.LayoutParams lrParams = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT
                );
                lr.setLayoutParams(lrParams);
                lr.setOrientation(LinearLayout.VERTICAL);

                ImageView advImage = new ImageView(AdsActivity.this);


                advImage.setImageDrawable(getResources().getDrawable(R.drawable.ic_background));
                advImage.setScaleType(ImageView.ScaleType.FIT_XY);
                                       /* Bitmap bImage = BitmapFactory.decodeResource(getResources(), R.drawable.ic_background);
                                        advImage.setImageBitmap(bImage);

                                        */
                lr.addView(advImage);

                TextView advHead = new TextView(AdsActivity.this);
                LinearLayout.LayoutParams advTxtParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
                advTxtParams.setMargins(20, 20, 20, 20);
                advHead.setLayoutParams(advTxtParams);

                advHead.setText(adv.name);
                advHead.setTextSize(20);
                advHead.setTypeface(Typeface.DEFAULT_BOLD);
                lr.addView(advHead);

                TextView advDescription = new TextView(AdsActivity.this);
                advDescription.setLayoutParams(advTxtParams);

                advDescription.setText(adv.description);


                lr.addView(advDescription);
                //
                LinearLayout bottomLr = new LinearLayout(AdsActivity.this);
                bottomLr.setLayoutParams(advTxtParams);
                bottomLr.setOrientation(LinearLayout.HORIZONTAL);
                bottomLr.setWeightSum(5);

                TextView advDate = new TextView(AdsActivity.this);

                LinearLayout.LayoutParams advBottomParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

                advBottomParams.weight = 1;
                advDate.setLayoutParams(advBottomParams);

                Locale aLocale = Locale.forLanguageTag("en-US");

                SimpleDateFormat dt1 = new SimpleDateFormat("dd MMMM", new Locale("AZ"));
                advDate.setText(dt1.format(adv.cDate));


                bottomLr.addView(advDate);

                TextView separator = new TextView(AdsActivity.this);
                separator.setLayoutParams(advBottomParams);
                separator.setText("|");

                bottomLr.addView(separator);

                TextView advType = new TextView(AdsActivity.this);

                advType.setLayoutParams(advBottomParams);
                advType.setText(adv.aTypeName);

                bottomLr.addView(advType);


                TextView separator2 = new TextView(AdsActivity.this);
                separator2.setLayoutParams(advBottomParams);
                separator2.setText("|");

                bottomLr.addView(separator2);


                TextView advOpen = new TextView(AdsActivity.this);
                advOpen.setLayoutParams(advBottomParams);
                advOpen.setText("İzlə");

                bottomLr.addView(advOpen);


                lr.addView(bottomLr);
                adCard.addView(lr);
                TextView advCatName = new TextView(AdsActivity.this);
                LinearLayout.LayoutParams advCatNameParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                advCatNameParams.setMargins(20, 20, 20, 20);
                advCatName.setPadding(15, 15, 15, 15);
                advCatName.setTextColor(Color.WHITE);
                advCatName.setBackgroundResource(R.drawable.round_button);
                advCatName.setLayoutParams(advCatNameParams);
                advCatName.setText(adv.catName);
                advCatName.setTypeface(Typeface.DEFAULT_BOLD);

                adCard.addView(advCatName);
                adsScroll.addView(adCard);
            }
        });

    }

}

