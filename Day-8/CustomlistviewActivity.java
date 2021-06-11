package com.example.mydemoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

public class CustomlistviewActivity extends AppCompatActivity {
    ListView lv1;
    int image[] = {R.drawable.android,R.drawable.aws,R.drawable.c,R.drawable.cplus,R.drawable.csharp,R.drawable.go,R.drawable.java,R.drawable.python,R.drawable.nodejs,R.drawable.php,R.drawable.js};
    String name[] = {"Android","AWS","C","C++","C#","GO","Java","Python","Node.js","PHP","JavaScript"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customlistview);

        lv1 = findViewById(R.id.lv1);
        Myadapter myadapter = new Myadapter(CustomlistviewActivity.this,image,name);
        lv1.setAdapter(myadapter);
    }
}