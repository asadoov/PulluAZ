
/*
 * Created by Rufat Asadzade on 23.12.19
 * Copyright (c) 2019. Rufat Asadzade. All rights reserved.
 */

package com.example.pulluaz;

import android.content.Context;
import android.os.AsyncTask;
import android.util.JsonReader;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class DbSelect {
    String DefaultURL = "http://13.92.237.16";

    public List<User> GetUserList(String username, String pass) throws IOException, JSONException {

        String data = "";
        URL url = new URL(DefaultURL + "/api/androidmobileapp/user/login?mail=" + username + "&pass=" + pass);


        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        InputStream inputStream = httpURLConnection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = "";
        while ((line = bufferedReader.readLine()) != null) {

            data += line;
        }
        List<User> usrList = new ArrayList();
        try {

                Gson gson = new GsonBuilder().setLenient().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();

                usrList = Arrays.asList(gson.fromJson(data, User[].class));

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return usrList;
    }

   /* public List<User> getUserRegister(String name,  String pass) throws IOException, JSONException {

        String data = "";
        URL url = new URL(DefaultURL + "/api/androidmobileapp/" + name + "&pass=" + pass);


        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        InputStream inputStream = httpURLConnection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = "";
        while ((line = bufferedReader.readLine()) != null) {

            data += line;
        }
        List<User> usrList = new ArrayList();
        try {

            Gson gson = new GsonBuilder().setLenient().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();

            usrList = Arrays.asList(gson.fromJson(data, User[].class));

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return usrList;
    }*/




    public List<Ads> GetAds(String username, String pass) throws IOException, JSONException {

        String data = "";
        URL url = new URL(DefaultURL + "/api/androidmobileapp/user/getAds?username=" + username + "&pass=" + pass);


        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        InputStream inputStream = httpURLConnection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = "";
        while ((line = bufferedReader.readLine()) != null) {

            data += line;
        }
        List<Ads> adsList = new ArrayList();
        try {

            Gson gson = new GsonBuilder().setLenient().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();

            adsList = Arrays.asList(gson.fromJson(data, Ads[].class));
        } catch (Exception ex) {
            ex.printStackTrace();
        }




/*
       JSONArray JA = new JSONArray(data);

        ArrayList<User> usrList = new ArrayList<User>();
        User usr = new User();
        for (int i = 0; i < JA.length(); i++) {

            JSONObject JO = (JSONObject) JA.get(i);
            usr.name = JO.get("id").toString();
          //  usr.surname = JO.get("surname").toString();

            usrList.add(usr);
        }
*/

        return adsList;
    }

}