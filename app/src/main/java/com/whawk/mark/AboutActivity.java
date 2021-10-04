package com.whawk.mark;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

    }


    @Override
    protected void onPause() {
        super.onPause();
        HomeActivity.isStillRunning = false;
        AboutActivity.this.finish();
    }

}
