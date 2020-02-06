/*
 * Created by Rufat Asadzade on 2/4/20 12:27 PM
 * Copyright (c) 2020. Rufat Asadzade. All rights reserved.
 */

package com.example.pulluaz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class AdViewTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_view_test);
        Intent intent = getIntent();

        String VIEWADID = intent.getStringExtra(adLoadInBack.VIEWADID);
        String VIEWADHEADERTEXT = intent.getStringExtra(adLoadInBack.VIEWADHEADERTEXT);
        String VIEWADCONTENTTEXT = intent.getStringExtra(adLoadInBack.VIEWADCONTENTTEXT);
        String VIEWADOWNERNAME = intent.getStringExtra(adLoadInBack.VIEWADOWNERNAME);
        String VIEWADOWNERMOB = intent.getStringExtra(adLoadInBack.VIEWADOWNERMOB);
        String VIEWADTYPE = intent.getStringExtra(adLoadInBack.VIEWADTYPE);
        String VIEWADPROFIT = intent.getStringExtra(adLoadInBack.VIEWADPROFIT);
        String VIEWADBALANS = intent.getStringExtra(adLoadInBack.VIEWADBALANS);
        String VIEWADHEADERIMAGE = intent.getStringExtra(adLoadInBack.VIEWADHEADERIMAGE);


        TextView AdViewHeader = findViewById(R.id.AdViewHeader);
        AdViewHeader.setText(VIEWADHEADERTEXT);

        TextView AdType = findViewById(R.id.AdType);
        AdType.setText("Reklam tipi: "+VIEWADTYPE);

        TextView AdProfit = findViewById(R.id.AdProfit);
        AdProfit.setText("Qazanc: "+VIEWADPROFIT);

        TextView AdBaas = findViewById(R.id.AdBalans);
        AdBaas.setText("Balans: "+VIEWADBALANS);

        TextView adViewText = findViewById(R.id.adViewText);
        adViewText.setText(VIEWADCONTENTTEXT);

        TextView ownerMob = findViewById(R.id.ownerMob);
        ownerMob.setText(VIEWADOWNERMOB);

        TextView ownerName = findViewById(R.id.ownerName);
        ownerName.setText(VIEWADOWNERNAME);

        new DownloadImageTask((ImageView) findViewById(R.id.headerImage)).execute(VIEWADHEADERIMAGE);
    }

    public void OnBackPressed(View view)
    {
        super.onBackPressed();
        startActivity(new Intent(this, AdsActivity.class));
        finish();
    }
}

class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
    ImageView bmImage;

    public DownloadImageTask(ImageView bmImage) {
        this.bmImage = bmImage;
    }

    protected Bitmap doInBackground(String... urls) {
        String urldisplay = urls[0];
        Bitmap mIcon11 = null;
        try {
            InputStream in = new java.net.URL(urldisplay).openStream();
            mIcon11 = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mIcon11;
    }

    protected void onPostExecute(Bitmap result) {
        bmImage.setImageBitmap(result);
    }

}
