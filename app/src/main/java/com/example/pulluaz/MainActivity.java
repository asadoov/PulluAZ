package com.example.pulluaz;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.json.JSONException;
import org.w3c.dom.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void RegMe(View view) {
        Intent intent = new Intent(this, RegActivity.class);

        startActivity(intent);

        //startActivity(new Intent(MainActivity.this, RegActivity.class));

        // Do something in response to button click
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void SignIn(View view) {
        LinearLayout lr = new LinearLayout(this);

        SharedPreferences sharedPreferences
                = getSharedPreferences("MySharedPref",
                MODE_PRIVATE);


        // Creating an Editor object
// to edit(write to the file)
        SharedPreferences.Editor myEdit
                = sharedPreferences.edit();

// Storing the key and its value
// as the data fetched from edittext

      /*  myEdit.putString(
                "name",
                "Rufat");*/


        final EditText usernameEdit = findViewById(R.id.username);

        final EditText passEdit = findViewById(R.id.pass);
        final String usernameTxt = usernameEdit.getText().toString();
        final String PassTxt = passEdit.getText().toString();
        DbSelect db = new DbSelect();
        String forToast;

        Thread aa = new Thread(new Runnable() {
            DbSelect db = new DbSelect();
            ArrayList<User> UserData = new ArrayList<User>();

            @Override
            public void run() {


                try {
                    UserData = db.GetUserList(usernameTxt, PassTxt);

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                //usernameEdit.setText( UserData.get(0).id.toString());

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        Toast.makeText(MainActivity.this, UserData.get(0).id.toString(), Toast.LENGTH_SHORT).show();

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


        //Toast.makeText(getApplicationContext(),"Hello Javatpoint",Toast.LENGTH_SHORT).show();
// Once the changes have been made,
// we need to commit to apply those changes made,
// otherwise, it will throw an error
        myEdit.commit();
        //Toast.makeText(this, sharedPreferences.getString("name",""), Toast.LENGTH_SHORT).show();
        //Toast.makeText(this, aa, Toast.LENGTH_SHORT).show();

        // Intent intent=new Intent(this,RegActivity.class);

        // startActivity(intent);

        //startActivity(new Intent(MainActivity.this, RegActivity.class));

        // Do something in response to button click
    }
}
