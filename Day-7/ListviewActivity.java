package com.example.mydemoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.Transliterator;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

public class ListviewActivity extends AppCompatActivity {
    GridView lv1;
    String name[] = {"PHP","AWS","JNODE","HTML","JAVASCRIPT","C#","PYTHON","C++","C","GO","JAVA","ANDOID","PHP","AWS","JNODE","HTML","JAVASCRIPT","C#","PYTHON","C++","C","GO","JAVA","ANDOID"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        lv1 = findViewById(R.id.lv1);
        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(ListviewActivity.this, android.R.layout.simple_list_item_1,name);
        lv1.setAdapter(arrayAdapter);

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListviewActivity.this,"You select "+name[position],Toast.LENGTH_SHORT).show();
            }
        });
    }
}