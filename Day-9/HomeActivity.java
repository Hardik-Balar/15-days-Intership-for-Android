package com.example.mydemoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    TextView textView1,textView2,textView3,textView4;
    Button b1;
    public static final String main_key = "myPref";
    public static final String name_key = "namekey";
    public static final String email_key = "emailkey";
    public static final String password_key = "passwordkey";
    public static final String mobile_key = "mobilekey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        b1 = findViewById(R.id.b1);

        SharedPreferences sharedPreferences = getSharedPreferences(main_key,MODE_PRIVATE);
        String name = sharedPreferences.getString(name_key,"");
        String email = sharedPreferences.getString(email_key,"");
        String password = sharedPreferences.getString(password_key,"");
        String mobile = sharedPreferences.getString(mobile_key,"");
        textView1.setText(":- "+name);
        textView2.setText(":- "+email);
        textView3.setText(":- "+password);
        textView4.setText(":- "+mobile);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPreferences = getSharedPreferences(main_key,MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
                finish();
            }
        });
    }
}