package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class splash_screen extends AppCompatActivity {
    ImageView imgb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        imgb=findViewById(R.id.imageView11);
        Intent intent = new Intent(this,Mainmain.class);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                imgb.animate().alpha(0).setDuration(2000);
                startActivity(intent);
                finish();
            }
        },3000);
    }
}