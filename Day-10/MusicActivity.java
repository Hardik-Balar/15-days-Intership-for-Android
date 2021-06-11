package com.example.mydemoapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MusicActivity extends AppCompatActivity implements View.OnClickListener {
    Button button6;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        button6 = (Button) findViewById(R.id.button6);


        mediaPlayer = MediaPlayer.create(MusicActivity.this,R.raw.chittiyaankalaiyaan);

        button6.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.button6:
                if(!mediaPlayer.isPlaying())
                {
                    mediaPlayer.start();
                }
                else if(mediaPlayer.isPlaying())
                {
                    mediaPlayer.pause();
                }
                break;
        }
    }
}