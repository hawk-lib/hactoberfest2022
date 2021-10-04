package com.whawk.mark;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt, b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;
    private TextView textview, pin1, pin2, pin3, pin4;
    public static boolean splash = false, flag = false;
    private static String name, pin;
    private static int count;
    private BroadcastReceiver broadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!splash) {
            splash = true;
            setContentView(R.layout.activity_splash);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    MainActivity.this.finish();
                    startActivity(new Intent(MainActivity.this, MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY));
                }
            }, 2000);
        } else {

            name = SharedPrefManager.getInstance(getApplicationContext()).getName();

            if (!name.equals("")) {
                broadcastReceiver = new BroadcastReceiver() {
                    @Override
                    public void onReceive(Context context, Intent intent) {

                        if (!flag){
                            flag = true;
                            //startService(new Intent(MainActivity.this, TimerService.class));
                        }
                        startActivity(new Intent(MainActivity.this, HomeActivity.class));
                        stopBroadcast();
                    }
                };

                registerReceiver(broadcastReceiver, new IntentFilter("com.whawk.mark.UNLOCK"));

                if (!flag) {
                    setContentView(R.layout.activity_main);
                    init();
                    onClickListeners();


                } else {
                    sendBroadcast(new Intent("com.whawk.mark.UNLOCK"));
                }
            } else {
                startActivity(new Intent(MainActivity.this, LoginActivity.class).setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY));
            }
        }

    }

    private void stopBroadcast() {
        unregisterReceiver(broadcastReceiver);
    }


    private void onClickListeners() {

    }

    private void init() {
        bt = findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (count > 1) {
                    pin = pin.substring(0, count - 1);

                    if (count == 4) {
                        pin4.setText("");
                    } else if (count == 3) {
                        pin3.setText("");
                    } else {
                        pin2.setText("");
                    }
                    count--;
                } else {
                    count = 0;
                    pin = "";
                    pin1.setText("");
                }

            }
        });

        textview = findViewById(R.id.textView);
        textview.setText("Hello, " + name);

        pin1 = findViewById(R.id.pin1);
        pin2 = findViewById(R.id.pin2);
        pin3 = findViewById(R.id.pin3);
        pin4 = findViewById(R.id.pin4);

        b0 = findViewById(R.id.b0);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);

        b0.setOnClickListener(this);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (count == 0) {

            count++;
            if (id == R.id.b0) {
                pin = "0";
            } else if (id == R.id.b1) {
                pin = "1";
            } else if (id == R.id.b2) {
                pin = "2";
            } else if (id == R.id.b3) {
                pin = "3";
            } else if (id == R.id.b4) {
                pin = "4";
            } else if (id == R.id.b5) {
                pin = "5";
            } else if (id == R.id.b6) {
                pin = "6";
            } else if (id == R.id.b7) {
                pin = "7";
            } else if (id == R.id.b8) {
                pin = "8";
            } else if (id == R.id.b9) {
                pin = "9";
            }



            pin1.setText("*");

        } else {
            count++;
            if (id == R.id.b0) {
                pin += "0";
            } else if (id == R.id.b1) {
                pin += "1";
            } else if (id == R.id.b2) {
                pin += "2";
            } else if (id == R.id.b3) {
                pin += "3";
            } else if (id == R.id.b4) {
                pin += "4";
            } else if (id == R.id.b5) {
                pin += "5";
            } else if (id == R.id.b6) {
                pin += "6";
            } else if (id == R.id.b7) {
                pin += "7";
            } else if (id == R.id.b8) {
                pin += "8";
            } else if (id == R.id.b9) {
                pin += "9";
            }


            if (count == 2) {
                pin2.setText("*");
            } else if (count == 3) {
                pin3.setText("*");
            } else {
                pin4.setText("*");

                if (SharedPrefManager.getInstance(getApplicationContext()).verifyPin(pin)) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            pin = "";
                            count = 0;
                            pin1.setText("");
                            pin2.setText("");
                            pin3.setText("");
                            pin4.setText("");
                            sendBroadcast(new Intent("com.whawk.mark.UNLOCK"));
                        }
                    }, 200);
                }else{
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            pin = "";
                            count = 0;
                            pin1.setText("");
                            pin2.setText("");
                            pin3.setText("");
                            pin4.setText("");
                        }
                    }, 200);

                }


            }

        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();

        MainActivity.this.finishAndRemoveTask();

    }
}
