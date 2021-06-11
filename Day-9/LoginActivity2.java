package com.example.mydemoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity2 extends AppCompatActivity {
    EditText et1,et2;
    Button b1,b2;

    public static final String main_key = "myPref";
    public static final String email_key = "emailkey";
    public static final String password_key = "passwordkey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String useremail,userpassword;
                useremail = et1.getText().toString();
                userpassword = et2.getText().toString();

                SharedPreferences sharedPreferences = getSharedPreferences(main_key,MODE_PRIVATE);
                String email = sharedPreferences.getString(email_key,"");
                String password = sharedPreferences.getString(password_key,"");

                if (useremail.equals(email) && userpassword.equals(password))
                {
                    Intent intent = new Intent(LoginActivity2.this,HomeActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(LoginActivity2.this,"Invaild Email and Password",Toast.LENGTH_SHORT).show();
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity2.this,SignupActivity.class);
                startActivity(intent);
            }
        });
    }
}