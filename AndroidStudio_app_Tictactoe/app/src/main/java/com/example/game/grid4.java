package com.example.game;

import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class grid4 extends AppCompatActivity {
    ImageView a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16;
    TextView status,dial;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid4);
        status =findViewById(R.id.textView2);
    }
    int ap = 0;
    boolean gameactive=true;
    int[] gamestate = {2, 2, 2, 2, 2, 2, 2, 2, 2, 2 ,2, 2, 2, 2, 2, 2, 2};
    int[][] winps={{0,1,2,3},{4,5,6,7},{8,9,10,11},{12,13,14,15},{0,4,8,12},{1,5,9,13},{2,6,10,14},{3,7,11,15},{0,5,10,15},{3,6,9,12}};

    public void click(View view) {
        ImageView img = (ImageView) view;
        int taping = Integer.parseInt(img.getTag().toString());


        if(gamestate[taping]==2 && gameactive){
            gamestate[taping]=ap;
            img.setTranslationY(-1000f);
            if(ap==0){
                img.setImageResource(R.drawable.ic_xbg);
                ap=1;
                status.setText(" O-turn to play");
            }
            else{
                img.setImageResource(R.drawable.ic_obg);
                ap=0;
                status.setText(" X-turn to play");
            }
            img.animate().translationYBy(1000f).setDuration(300);

        }
        winner();

    }
    public void retry(View view){

        gameactive=true;
        ap=0;
        Vibrator vibrator = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        if(Build.VERSION.SDK_INT >=26){
            vibrator.vibrate(VibrationEffect.createOneShot(200,VibrationEffect.DEFAULT_AMPLITUDE));
        }
        else{
            vibrator.vibrate(200);
        }

        for(int i=0;i<16;i++){
            gamestate[i]=2;
        }
        status.setText("Tap to play the game");
        a1 = findViewById(R.id.imageView2);a1.setImageResource(0);
        a2 = findViewById(R.id.imageView3);a2.setImageResource(0);
        a3 = findViewById(R.id.imageView4);a3.setImageResource(0);
        a4 = findViewById(R.id.imageView5);a4.setImageResource(0);
        a5 = findViewById(R.id.imageView6);a5.setImageResource(0);
        a6 = findViewById(R.id.imageView7);a6.setImageResource(0);
        a7 = findViewById(R.id.imageView8);a7.setImageResource(0);
        a8 = findViewById(R.id.imageView9);a8.setImageResource(0);
        a9 = findViewById(R.id.imageView10);a9.setImageResource(0);
        a10 = findViewById(R.id.imageView11);a10.setImageResource(0);
        a11 = findViewById(R.id.imageView12);a11.setImageResource(0);
        a12 = findViewById(R.id.imageView13);a12.setImageResource(0);
        a13 = findViewById(R.id.imageView14);a13.setImageResource(0);
        a14 = findViewById(R.id.imageView15);a14.setImageResource(0);
        a15 = findViewById(R.id.imageView16);a15.setImageResource(0);
        a16 = findViewById(R.id.imageView17);a16.setImageResource(0);
    }
    public void winner(){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_box);
        dial=dialog.findViewById(R.id.textView3);



        for(int i=0;i<10;i++){
            if(gamestate[winps[i][0]]==gamestate[winps[i][1]] && gamestate[winps[i][1]]==gamestate[winps[i][2]] && gamestate[winps[i][2]]==gamestate[winps[i][3]]){
                if(gamestate[winps[i][0]] != 2){
                    gameactive=false;
                    if (gamestate[winps[i][0]]==0){
                        status.setText("winner is X");
                        dial.setText("winner is X");


                    }
                    else{
                        status.setText("winner is O");
                        dial.setText("winner is O");
                    }
                    dialog.show();
                }
                else{
                    return;
                }
            }

        }

    }
}