package com.example.pulluaz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void RegMe(View view)
    {
Intent intent=new Intent(this,RegActivity.class);

startActivity(intent);

       //startActivity(new Intent(MainActivity.this, RegActivity.class));

        // Do something in response to button click
    }
    public void SignIn(View view)
    {
        LinearLayout lr=new LinearLayout(this);
        EditText tx=new EditText{
        Text="ffafdsa"
        };
        SharedPreferences sharedPreferences
                = getSharedPreferences("MySharedPref",
                MODE_PRIVATE);
        // Creating an Editor object
// to edit(write to the file)
        SharedPreferences.Editor myEdit
                = sharedPreferences.edit();

// Storing the key and its value
// as the data fetched from edittext

        myEdit.putString(
                "name",
                "Rufat");


// Once the changes have been made,
// we need to commit to apply those changes made,
// otherwise, it will throw an error
        myEdit.commit();
        Toast.makeText(this, sharedPreferences.getString("name",""), Toast.LENGTH_SHORT).show();

       // Intent intent=new Intent(this,RegActivity.class);

       // startActivity(intent);

        //startActivity(new Intent(MainActivity.this, RegActivity.class));

        // Do something in response to button click
    }
}
