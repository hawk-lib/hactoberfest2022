package com.whawk.mark;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class ManagePasswordActivity extends AppCompatActivity {

    private static TextView empty;
    private static RecyclerView passwords_view;
    private static List<DataEntry> dataEntries;
    private Toolbar toolbar;
    static PasswordDB db;
    static BroadcastReceiver broadcastReceiver;
    static IntentFilter intentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,WindowManager.LayoutParams.FLAG_SECURE);
        setContentView(R.layout.activity_manage_password);

        init();
        onClickListeners();
        toolbar.setTitle(SharedPrefManager.getInstance(ManagePasswordActivity.this).getName());
        setSupportActionBar(toolbar);

        fetch();
    }

    public void fetch() {
        db = new PasswordDB(ManagePasswordActivity.this);
        if (db.openDB(0)) {
            dataEntries = db.getData();
            db.closeDB();
            if (dataEntries.size() > 0) {
                empty.setVisibility(View.GONE);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ManagePasswordActivity.this, RecyclerView.VERTICAL, false);
                PasswordManageAdapter passwordManageAdapter = new PasswordManageAdapter(ManagePasswordActivity.this, dataEntries);
                passwords_view.setLayoutManager(layoutManager);
                passwords_view.setAdapter(passwordManageAdapter);
                passwords_view.setVisibility(View.VISIBLE);
            }else{
                passwords_view.setVisibility(View.GONE);
                empty.setVisibility(View.VISIBLE);
            }
        }
    }

    private void init() {
        empty = findViewById(R.id.empty);
        passwords_view = findViewById(R.id.passwords_view);
        toolbar = findViewById(R.id.toolbar);

        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                fetch();
            }
        };
        intentFilter = new IntentFilter();
        intentFilter.addAction("com.whawk.mark.DATABASE_CHANGED");
    }

    private void onClickListeners() {



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.manage_menu, menu);
        MenuItem item = menu.findItem(R.id.action_add);

        TextView mTextView = item.getActionView().findViewById(R.id.mTextView);
        mTextView.setText("Add");
        item.getActionView().findViewById(R.id.mTextView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View data_entry_view = LayoutInflater.from(ManagePasswordActivity.this).inflate(R.layout.activity_add, null, false);
                AlertDialog.Builder builder = new AlertDialog.Builder(ManagePasswordActivity.this);
                builder.setView(data_entry_view);
                builder.setCancelable(true);
                final Button saveBT = data_entry_view.findViewById(R.id.saveBT);
                final EditText titleET = data_entry_view.findViewById(R.id.titleET);
                final EditText usernameET = data_entry_view.findViewById(R.id.usernameET);
                final EditText password1ET = data_entry_view.findViewById(R.id.password1ET);
                final EditText password2ET = data_entry_view.findViewById(R.id.password2ET);
                final EditText pinET = data_entry_view.findViewById(R.id.pinET);

                final AlertDialog alertDialog = builder.create();

                saveBT.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!TextUtils.isEmpty(titleET.getText())) {
                            if (TextUtils.isEmpty(password1ET.getText())) {
                                password1ET.setError("Enter! your " + titleET.getText().toString() + " password.");
                            } else {

                                String title, username, password1, password2, pin;
                                title = titleET.getText().toString();
                                username = usernameET.getText().toString();
                                password1 = password1ET.getText().toString();
                                password2 = password2ET.getText().toString();
                                pin = pinET.getText().toString();
                                alertDialog.setCancelable(false);
                                titleET.setEnabled(false);
                                usernameET.setEnabled(false);
                                password1ET.setEnabled(false);
                                password2ET.setEnabled(false);
                                pinET.setEnabled(false);
                                saveBT.setText("Saving");
                                saveBT.setEnabled(false);

                                if (!ManageData.getInstance(ManagePasswordActivity.this).addData(new DataEntry(title, username, password1, password2, pin))) {
                                    alertDialog.setCancelable(true);
                                    titleET.setEnabled(true);
                                    usernameET.setEnabled(true);
                                    password1ET.setEnabled(true);
                                    password2ET.setEnabled(true);
                                    pinET.setEnabled(true);
                                    saveBT.setEnabled(true);
                                } else {
                                    alertDialog.dismiss();
                                }
                            }
                        } else {
                            titleET.setError("Enter! website name.");
                        }
                    }
                });

                alertDialog.show();
            }
        });


        return true;
    }


    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(broadcastReceiver,intentFilter);
    }



    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(broadcastReceiver);
        HomeActivity.isStillRunning = false;
        ManagePasswordActivity.this.finish();
    }
}
