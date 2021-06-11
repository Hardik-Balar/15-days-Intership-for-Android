package com.example.mydemoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignupActivity extends AppCompatActivity {
    EditText e1,e2,e3,e4;
    Button b1;

public static final String main_key = "myPref";
    public static final String name_key = "namekey";
    public static final String email_key = "emailkey";
    public static final String password_key = "passwordkey";
    public static final String mobile_key = "mobilekey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        e1=findViewById(R.id.e1);
        e2=findViewById(R.id.e2);
        e3=findViewById(R.id.e3);
        e4=findViewById(R.id.e4);
        b1=findViewById(R.id.b1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPreferences = getSharedPreferences(main_key,MODE_PRIVATE);
                String name,email,password,mobile;
                name = e1.getText().toString();
                email = e2.getText().toString();
                password = e3.getText().toString();
                mobile = e4.getText().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString( name_key,name);
                editor.putString( email_key,email);
                editor.putString( password_key,password);
                editor.putString( mobile_key,mobile);

                editor.commit();

                Intent intent = new Intent(SignupActivity.this,LoginActivity2.class);
                startActivity(intent);
            }
        });
    }
}