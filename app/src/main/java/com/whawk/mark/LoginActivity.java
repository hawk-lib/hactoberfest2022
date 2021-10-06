package com.whawk.mark;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {

    private EditText emailET, passwordET;
    private TextView forget_password;
    private Button login_BT, create_acct_BT;
    private String email, password, name, pin;
    private FirebaseAuth auth;
    private DatabaseReference databaseReference;
    private BroadcastReceiver broadcastReceiver;
    private IntentFilter intentFilter;
    private ValueEventListener valueEventListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();
        onClickListeners();

    }

    private void onClickListeners() {

        forget_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().sendPasswordResetEmail(emailET.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(LoginActivity.this, "A email is sent to you.", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(LoginActivity.this, "An error occured.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        create_acct_BT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, SignupActivity.class).setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY));
            }
        });

        login_BT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (InternetConectivity.getInstance(LoginActivity.this).checkInternetConnection()) {

                    email = emailET.getText().toString();
                    password = passwordET.getText().toString();


                    View data_entry_view = LayoutInflater.from(LoginActivity.this).inflate(R.layout.black_dialog_box, null, false);
                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                    builder.setView(data_entry_view);
                    final TextView processing = data_entry_view.findViewById(R.id.processing);

                    final AlertDialog alertDialog = builder.create();
                    alertDialog.setCancelable(false);

                    alertDialog.show();
                    processing.setText("Authenticating User");


                    auth.signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        final String uid = auth.getCurrentUser().getUid();
                                        startBroadcast();
                                        processing.setText("Gathering Information");


                                        databaseReference = FirebaseDatabase.getInstance().getReference().child(uid);
                                        valueEventListener = databaseReference.addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                                name = dataSnapshot.child("name").getValue().toString();
                                                pin = dataSnapshot.child("pin").getValue().toString();
                                                SharedPrefManager.getInstance(getApplicationContext()).saveUser(new User(uid, name, email, password, pin));
                                                sendBroadcast(new Intent("com.whawk.mark.UID_RECEIVED"));
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        databaseReference.addValueEventListener(valueEventListener);

                                    } else {
                                        alertDialog.dismiss();
                                        Toast.makeText(LoginActivity.this, "Username/password invalid.", Toast.LENGTH_SHORT).show();

                                    }
                                }

                                private void startBroadcast() {
                                    broadcastReceiver = new BroadcastReceiver() {
                                        @Override
                                        public void onReceive(Context context, Intent intent) {

                                            if (intent.getAction().equals("com.whawk.mark.UID_RECEIVED")) {
                                                databaseReference.removeEventListener(valueEventListener);
                                                processing.setText("Recieving User Data");
                                                ManageData.getInstance(LoginActivity.this).loadData();
                                            }


                                            if (intent.getAction().equals("com.whawk.mark.FINISHED_LOADING")) {
                                                processing.setText("Successful");
                                                stopBroadcast();
                                                new Handler().postDelayed(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        startActivity(new Intent(LoginActivity.this, MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY));
                                                    }
                                                }, 200);
                                            }
                                        }
                                    };

                                    intentFilter = new IntentFilter();
                                    intentFilter.addAction("com.whawk.mark.UID_RECEIVED");
                                    intentFilter.addAction("com.whawk.mark.FINISHED_LOADING");


                                    registerReceiver(broadcastReceiver,intentFilter);
                                }


                                private void stopBroadcast() {
                                    unregisterReceiver(broadcastReceiver);
                                }


                            });
                }else{
                    Toast.makeText(LoginActivity.this, "No Internet conection", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void init() {
        auth = FirebaseAuth.getInstance();
        emailET = findViewById(R.id.emailET);
        passwordET = findViewById(R.id.passwordET);
        forget_password = findViewById(R.id.forget_password);
        login_BT = findViewById(R.id.login_BT);
        create_acct_BT = findViewById(R.id.create_acct_BT);
    }
}
