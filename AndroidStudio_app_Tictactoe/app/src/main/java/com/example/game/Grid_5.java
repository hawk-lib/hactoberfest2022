package com.example.game;

import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Grid_5 extends AppCompatActivity {
    ImageView a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21, a22, a23, a24, a25, img ;
    TextView status, dial;
    Button retry;
    int ap = 0;
    boolean gameactive = true;
    int[] gamestate = {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] winps = {{0, 1, 2, 3, 4}, {5, 6, 7, 8, 9}, {10, 11, 12, 13, 14}, {15, 16, 17, 18, 19}, {20, 21, 22, 23, 24}, {0, 5, 10, 15, 20}, {1, 6, 11, 16, 21}, {2, 7, 12, 17, 22}, {3, 8, 13, 18, 22}, {4, 9, 14, 19, 24}, {0, 6, 12, 18, 24}, {4, 8, 12, 16, 20}};
    int bck = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid5);
        status = findViewById(R.id.textView2);
        a1 = findViewById(R.id.imageView2);
        a2 = findViewById(R.id.imageView3);
        a3 = findViewById(R.id.imageView4);
        a4 = findViewById(R.id.imageView5);
        a5 = findViewById(R.id.imageView6);
        a6 = findViewById(R.id.imageView7);
        a7 = findViewById(R.id.imageView8);
        a8 = findViewById(R.id.imageView9);
        a9 = findViewById(R.id.imageView10);
        a10 = findViewById(R.id.imageView11);
        a11 = findViewById(R.id.imageView12);
        a12 = findViewById(R.id.imageView13);
        a13 = findViewById(R.id.imageView14);
        a14 = findViewById(R.id.imageView15);
        a15 = findViewById(R.id.imageView16);
        a16 = findViewById(R.id.imageView17);
        a17 = findViewById(R.id.imageView18);
        a18 = findViewById(R.id.imageView19);
        a19 = findViewById(R.id.imageView20);
        a20 = findViewById(R.id.imageView21);
        a21 = findViewById(R.id.imageView22);
        a22 = findViewById(R.id.imageView23);
        a23 = findViewById(R.id.imageView24);
        a24 = findViewById(R.id.imageView25);
        a25 = findViewById(R.id.imageView26);
        retry=findViewById(R.id.button);
        retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameactive = true;
                ap = 0;
                Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                if (Build.VERSION.SDK_INT >= 26) {
                    vibrator.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE));
                } else {
                    vibrator.vibrate(200);
                }
                for (int i = 0; i < 25; i++) {
                    gamestate[i] = 2;
                }
                status.setText("Tap to play the game");
                a1.setImageResource(0);
                a2.setImageResource(0);
                a3.setImageResource(0);
                a4.setImageResource(0);
                a5.setImageResource(0);
                a6.setImageResource(0);
                a7.setImageResource(0);
                a8.setImageResource(0);
                a9.setImageResource(0);
                a10.setImageResource(0);
                a11.setImageResource(0);
                a12.setImageResource(0);
                a13.setImageResource(0);
                a14.setImageResource(0);
                a15.setImageResource(0);
                a16.setImageResource(0);
                a17.setImageResource(0);
                a18.setImageResource(0);
                a19.setImageResource(0);
                a20.setImageResource(0);
                a21.setImageResource(0);
                a22.setImageResource(0);
                a23.setImageResource(0);
                a24.setImageResource(0);
                a25.setImageResource(0);
            }
        });

     }

    public void click(View view) {
        ImageView img = (ImageView) view;
        int taping = Integer.parseInt(img.getTag().toString());
        bck = taping;
        if (gamestate[taping] == 2 && gameactive) {
            gamestate[taping] = ap;
            img.setTranslationY(-1000f);
            if (ap == 0) {
                img.setImageResource(R.drawable.ic_xbg);
                ap = 1;
                status.setText(" O-turn to play");
            } else {
                img.setImageResource(R.drawable.ic_obg);
                ap = 0;
                status.setText(" X-turn to play");
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }
        winner();
    }
    public void winner() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_box);
        dial = dialog.findViewById(R.id.textView3);
        for (int i = 0; i < 12; i++) {
            if (gamestate[winps[i][0]] == gamestate[winps[i][1]] && gamestate[winps[i][1]] == gamestate[winps[i][2]] && gamestate[winps[i][2]] == gamestate[winps[i][3]] && gamestate[winps[i][3]] == gamestate[winps[i][4]]) {
                if (gamestate[winps[i][0]] != 2) {
                    gameactive = false;
                    if (gamestate[winps[i][0]] == 0) {
                        status.setText("winner is X");
                        dial.setText("winner is X");
                    } else {
                        status.setText("winner is O");
                        dial.setText("winner is O");
                    }
                    dialog.show();
                } else {
                    return;
                }
            }
        }
    }
}
