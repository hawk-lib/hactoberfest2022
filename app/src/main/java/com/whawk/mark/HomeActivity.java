package com.whawk.mark;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static com.whawk.mark.MainActivity.flag;


import java.util.List;

public class HomeActivity extends AppCompatActivity {
    Toolbar toolbar;
    static View online;
    FloatingActionButton action_float_exit;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawer;
    NavigationView navigationView;
    TextView name, email, empty, total_passwords;
    View navHeader;
    private RecyclerView passwords_view;
    private List<DataEntry> entries;
    static MenuItem item1, item2;
    static Menu main_menu;
    static ComponentName receiver;
    static PackageManager pm;
    static BroadcastReceiver onPauseReceiver, onResumeReceiver;
    static IntentFilter intentFilter;
    public static boolean isStillRunning = false;


    static boolean database_changed = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,WindowManager.LayoutParams.FLAG_SECURE);
        setContentView(R.layout.activity_home);

        init();
        onClickListeners();

        toolbar.setTitle(SharedPrefManager.getInstance(HomeActivity.this).getName());
        setSupportActionBar(toolbar);

        toggle = new ActionBarDrawerToggle(HomeActivity.this,drawer,toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        name.setText(SharedPrefManager.getInstance(HomeActivity.this).getName());
        email.setText(FirebaseAuth.getInstance().getCurrentUser().getEmail());
        fetch();
        registerInternetBroadcastReciever();
        registerReceiver(onPauseReceiver, new IntentFilter("com.whawk.mark.LOCK"));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu,menu);
        item1 = menu.findItem(R.id.action_manage);
        item1.getActionView().findViewById(R.id.mTextView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //HomeActivity.this.finish();
                isStillRunning = true;
                startActivity(new Intent(getApplicationContext(),ManagePasswordActivity.class).setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY));
            }
        });
        item2 = menu.findItem(R.id.action_restore);
        onlineStatus(InternetConectivity.getInstance(HomeActivity.this).checkInternetConnection());



        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.action_clear){
            ManageData.getInstance(getApplicationContext()).deleteOnDevice();

        }else if (item.getItemId() == R.id.action_restore){

            View view = LayoutInflater.from(HomeActivity.this).inflate(R.layout.edittext_enter_password, null);
            final EditText password_ET = view.findViewById(R.id.enter_password);
            final AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this);
            final AlertDialog dialog = builder.create();
            dialog.setTitle("Restore Passwords");
            dialog.setView(view);
            dialog.setMessage("Enter your password");
            dialog.setCancelable(true);
            dialog.setButton(Dialog.BUTTON_POSITIVE, "Submit", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    if(SharedPrefManager.getInstance(HomeActivity.this).verifyPassword(password_ET.getText().toString())){
                        if(ManageData.getInstance(HomeActivity.this).loadData()) {

                            dialog.dismiss();
                        }
                    }else {
                        Toast.makeText(HomeActivity.this, "Incorrect Password", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            dialog.setButton(Dialog.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialog.cancel();
                }
            });
            dialog.show();
        }



        return super.onOptionsItemSelected(item);
    }



    private void init() {
        toolbar = findViewById(R.id.toolbar);
        action_float_exit = findViewById(R.id.action_float_exit);
        online = findViewById(R.id.online);

        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navHeader = navigationView.getHeaderView(0);
        name = navHeader.findViewById(R.id.name);
        email = navHeader.findViewById(R.id.email);
        passwords_view = findViewById(R.id.passwords_view);
        empty = findViewById(R.id.empty);
        total_passwords = findViewById(R.id.total_passwords);

        receiver = new ComponentName(this, InternetConnectivityReceiver.class);
        pm = this.getPackageManager();



        onPauseReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {


                ActivityManager.RunningAppProcessInfo processInfo = new ActivityManager.RunningAppProcessInfo();
                ActivityManager.getMyMemoryState(processInfo);
                if (processInfo.importance != ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                    flag = false;
                    HomeActivity.this.finishAffinity();
                } else {
                    flag = false;
                    HomeActivity.this.finishAffinity();
                    startActivity(new Intent(HomeActivity.this, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY));
                    stopBroadcast();
                }
            }
        };

        onResumeReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                fetch();
            }
        };



        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

    }

    private void stopBroadcast() {
        unregisterReceiver(onPauseReceiver);
    }

    private void onClickListeners() {

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int id = menuItem.getItemId();

                if (id == R.id.nav_settings){
                    drawer.closeDrawer(GravityCompat.START,true);
                    isStillRunning = true;
                    startActivity(new Intent(HomeActivity.this, SettingsActivity.class));
                    overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
                }else if (id == R.id.nav_about){
                    drawer.closeDrawer(GravityCompat.START,true);
                    isStillRunning = true;
                    startActivity(new Intent(HomeActivity.this, AboutActivity.class));
                    overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
                }else if (id == R.id.nav_logout){

                    final AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this);
                    final AlertDialog dialog = builder.create();
                    dialog.setTitle("Logout?");
                    dialog.setMessage("Are you sure?");
                    dialog.setCancelable(true);
                    dialog.setButton(Dialog.BUTTON_POSITIVE, "YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            FirebaseAuth mAuth = FirebaseAuth.getInstance();
                            mAuth.signOut();
                            SharedPrefManager.getInstance(getApplicationContext()).deleteUser();
                            ManageData.getInstance(HomeActivity.this).deleteOnDevice();
                            HomeActivity.this.finish();
                            startActivity(new Intent(HomeActivity.this, MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY));
                            overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
                            drawer.closeDrawer(GravityCompat.START,true);
                        }
                    });
                    dialog.setButton(Dialog.BUTTON_NEGATIVE, "NO", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialog.cancel();
                        }
                    });
                    dialog.show();


                }
                return false;
            }
        });



        action_float_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HomeActivity.this.finishAndRemoveTask();
                System.exit(0);
            }
        });




    }


    private void fetch() {
        PasswordDB db = new PasswordDB(HomeActivity.this);
        if (db.openDB(0)){
            entries = db.getData();
            db.closeDB();
            if (entries.size() > 0){
                passwords_view.setLayoutManager(new LinearLayoutManager(HomeActivity.this,RecyclerView.VERTICAL,false));
                PasswordViewAdapter viewAdapter = new PasswordViewAdapter(getApplicationContext(), entries);
                passwords_view.setAdapter(viewAdapter);
                empty.setVisibility(View.GONE);
                passwords_view.setVisibility(View.VISIBLE);
                total_passwords.setVisibility(View.VISIBLE);

            }else{
                passwords_view.setVisibility(View.GONE);
                total_passwords.setVisibility(View.GONE);
                empty.setVisibility(View.VISIBLE);
            }
        }
        else {
            Toast.makeText(getApplicationContext(), "Failed to load data!", Toast.LENGTH_SHORT).show();
        }
        total_passwords.setText("All Total (" + entries.size() + ")");
    }

    public static void onlineStatus(boolean flag){
        if(flag){
            item1.setVisible(true);
            item2.setEnabled(true);
            TextView mTextView = item1.getActionView().findViewById(R.id.mTextView);
            mTextView.setText("Manage");
            online.setSelected(true);

        }else{
            item1.setVisible(false);
            item2.setEnabled(false);
            online.setSelected(false);
        }
    }
    private void registerInternetBroadcastReciever() {
        pm.setComponentEnabledSetting(receiver,
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP);
    }

    private void unRegisterInternetBroadcastReciever() {
        pm.setComponentEnabledSetting(receiver,
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP);
    }





    @Override
    protected void onResume() {
        super.onResume();
        isStillRunning = false;
        if (database_changed == true){
            database_changed = false;
            fetch();
        }
        registerReceiver(onResumeReceiver, new IntentFilter("com.whawk.mark.DATA_CHANGED"));
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(onResumeReceiver);
    }

}
