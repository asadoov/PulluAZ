/*
 * Created by Rufat Asadzade on 25.12.19
 * Copyright (c) 2019. Rufat Asadzade. All rights reserved.
 */

package com.example.pulluaz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;

import java.io.IOException;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;


public class AdsActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    List<User> usrList;
    List<Ads> AdsList;
    List<adView> Ad;
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

                        /*for (Ads adv: AdsList)
                        {
                            try {
                            Ad.add(db.AdView(String.valueOf(adv.id)));
                            }
                            catch (IOException e)
                            {
                                e.printStackTrace();
                            }
                            catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }*/
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

    Thread t=new Thread() {

        public void run(int adID, View view)
        {
        findViewById(R.id.progressBarHolder).setVisibility(View.VISIBLE);
        /*DbSelect db = new DbSelect();

        try {
            Ad.add(db.AdView(String.valueOf(adID)));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
            Intent intent = new Intent(view.getContext(), AdViewTest.class);
            intent.putExtra(VIEWADID, adID);
            startActivity(intent);*/
        }
    };



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
                advOpen.setOnClickListener(new View.OnClickListener(){
//DbSelect db = new DbSelect();
                    @Override
                    public void onClick(View v) {
                        findViewById(R.id.progressBarHolder).setVisibility(View.VISIBLE);
                        adLoadInBack adload = new adLoadInBack(v.getContext());
                        adload.execute(adv.id);
                    }
                });
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




class adLoadInBack extends AsyncTask<Integer, Void, adView> {
    private Context context;
    public static final String VIEWADID = "com.example.pullua.VIEWADID";
    public static final String VIEWADHEADERTEXT = "com.example.pullua.VIEWADHEADERTEXT";
    public static final String VIEWADCONTENTTEXT = "com.example.pullua.VIEWADCONTENTTEXT";
    public static final String VIEWADOWNERNAME = "com.example.pullua.VIEWADOWNERNAME";
    public static final String VIEWADOWNERMOB = "com.example.pullua.VIEWADOWNERMOB";
    public static final String VIEWADTYPE = "com.example.pullua.VIEWADTYPE";
    public static final String VIEWADPROFIT = "com.example.pullua.VIEWADPROFIT";
    public static final String VIEWADBALANS = "com.example.pullua.VIEWADBALANS";
    public static final String VIEWADHEADERIMAGE = "com.example.pullua.VIEWADHEADERIMAGE";
    public adLoadInBack(Context context)
    {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected adView doInBackground(Integer... params) {
    List<adView> Data;
    adView rtInfo = new adView();
    DbSelect db = new DbSelect();
        try {
            try {

                Data = db.AdView(String.valueOf(params[0]));
                for (adView adv : Data) {

                    if (adv.id > 0) {
                        rtInfo = adv;
                    }
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            catch (JSONException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rtInfo;

    }


    protected void onPostExecute(adView page) {
        super.onPreExecute();

        if (page.id > 0)
        {
            String[] urls;
            urls = page.photoUrl;
            Intent intent = new Intent(context, AdViewTest.class);
            intent.putExtra(VIEWADID, String.valueOf(page.id));
            intent.putExtra(VIEWADHEADERTEXT, page.name);
            intent.putExtra(VIEWADCONTENTTEXT, page.description);
            intent.putExtra(VIEWADOWNERNAME, page.sellerFullName);
            intent.putExtra(VIEWADOWNERMOB, page.sellerPhone);
            intent.putExtra(VIEWADTYPE, page.catName);
            intent.putExtra(VIEWADPROFIT, "NAN");
            intent.putExtra(VIEWADBALANS, "NAN");
            intent.putExtra(VIEWADHEADERIMAGE, urls[0]);
            context.startActivity(intent);
            ((Activity)context).finish();
        }
        else
        {
            Toast.makeText(context, "Məlumatları yükləmək mümkün olmadı", Toast.LENGTH_SHORT).show();
        }

    }
}


