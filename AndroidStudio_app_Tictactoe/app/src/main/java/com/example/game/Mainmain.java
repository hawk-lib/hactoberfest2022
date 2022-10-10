package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Mainmain extends AppCompatActivity {
   TextView three,four,five;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmain);
        three=findViewById(R.id.textView1);
        four=findViewById(R.id.textView2);
        five=findViewById(R.id.textView3);
    }
    public void three(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }
    public void four(View view){
        Intent intent = new Intent(this,grid4.class);
        startActivity(intent);

    }
    public void five(View view){
        Intent intent = new Intent(this,Grid_5.class);
        startActivity(intent);

    }
}