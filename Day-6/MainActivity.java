package com.example.mydemoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    MediaPlayer sound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sound = MediaPlayer.create(MainActivity.this,R.raw.splashsound);
        sound.start();

        Thread thread = new Thread(){
        public void run(){
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
            }
        }
        };
        thread.start();
    }
    @Override
    protected void onPause(){
        super.onPause();
        sound.release();
        finish();
    }
}