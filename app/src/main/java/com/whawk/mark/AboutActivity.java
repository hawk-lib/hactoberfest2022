package com.whawk.mark;


import android.os.Bundle;

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
