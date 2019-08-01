package com.example.level0;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
ImageView ironman,cap,thor;
TextView i_sc,c_sc,t_sc,scText;
MediaPlayer mPlayer = new MediaPlayer();
ImageButton pause,next,prev;
boolean isPlaying = false;
View line;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ironman = findViewById(R.id.ironman);
        cap = findViewById(R.id.captain);
        thor = findViewById(R.id.thor);
        pause = findViewById(R.id.pause);
        scText = findViewById(R.id.sc_text);
        scText.setSelected(true);
        line = findViewById(R.id.line);
        next = findViewById(R.id.next);
        prev = findViewById(R.id.prev);
        ironman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPlayer.stop();
                mPlayer = MediaPlayer.create(MainActivity.this, R.raw.ironmantheme);
                mPlayer.start();
                isPlaying = true;
                scText.setText("Iron Man Theme Song");
                scText.setSelected(true);
                playing();
            }
        });
        cap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPlayer.stop();
                mPlayer = MediaPlayer.create(MainActivity.this, R.raw.captainamericatheme);
                mPlayer.start();
                isPlaying = true;
                scText.setText("Captain America Theme Song");
                scText.setSelected(true);
                playing();
            }
        });
        thor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPlayer.stop();
                mPlayer = MediaPlayer.create(MainActivity.this, R.raw.thorragnarok);
                mPlayer.start();
                isPlaying = true;
                scText.setText("Thor Theme Song");
                playing();
            }
        });
    }
public void playing(){
        pause.setVisibility(View.VISIBLE);
        scText.setVisibility(View.VISIBLE);
        next.setVisibility(View.VISIBLE);
        prev.setVisibility(View.VISIBLE);
        pause.setImageResource(R.drawable.pause);
        line.setVisibility(View.VISIBLE);
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPlaying){
                    mPlayer.pause();
                    pause.setImageResource(R.drawable.play);
                    isPlaying = false;
                    scText.setSelected(false);
                }else if(!isPlaying){
                    mPlayer.start();
                    pause.setImageResource(R.drawable.pause);
                    isPlaying = true;
                    scText.setSelected(false);
                }

            }
        });
}
}
