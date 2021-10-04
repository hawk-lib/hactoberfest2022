package com.whawk.mark;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class SettingsActivity extends AppCompatActivity {

    LinearLayout password_change_view, pin_change_view, email_change_view;
    Button change_password, cancel_password, save_password;
    Button change_pin, cancel_pin, save_pin;
    Button change_email, cancel_email, save_email;
    TextInputEditText old_password, new_password, confirm_password, pin_password, new_pin, confirm_pin, email_password, new_email;
    TextView password_result, pin_result, email_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        init();
        onClickListeners();
    }

    private void init() {
        password_change_view = findViewById(R.id.password_change_view);
        pin_change_view = findViewById(R.id.pin_change_view);
        email_change_view = findViewById(R.id.email_change_view);

        password_result = findViewById(R.id.password_result);
        pin_result = findViewById(R.id.pin_result);
        email_result = findViewById(R.id.email_result);

        change_password = findViewById(R.id.change_password);
        cancel_password = findViewById(R.id.cancel_password);
        save_password = findViewById(R.id.save_password);
        change_pin = findViewById(R.id.change_pin);
        cancel_pin = findViewById(R.id.cancel_pin);
        save_pin = findViewById(R.id.save_pin);
        change_email = findViewById(R.id.change_email);
        cancel_email = findViewById(R.id.cancel_email);
        save_email = findViewById(R.id.save_email);

        old_password = findViewById(R.id.old_password);
        new_password = findViewById(R.id.new_password);
        confirm_password = findViewById(R.id.confirm_password);

        pin_password = findViewById(R.id.pin_password);
        cancel_pin = findViewById(R.id.cancel_pin);
        new_pin = findViewById(R.id.new_pin);
        confirm_pin = findViewById(R.id.confirm_pin);

        email_password = findViewById(R.id.email_password);
        new_email = findViewById(R.id.new_email);

    }

    private void onClickListeners() {

        change_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                change_password.setVisibility(View.GONE);

                password_change_view.setVisibility(View.VISIBLE);
                pin_change_view.setVisibility(View.GONE);
                email_change_view.setVisibility(View.GONE);

                change_pin.setVisibility(View.VISIBLE);
                change_email.setVisibility(View.VISIBLE);

                password_result.setText("");
            }
        });
        cancel_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                password_change_view.setVisibility(View.GONE);
                change_password.setVisibility(View.VISIBLE);

                old_password.getText().clear();
                new_password.getText().clear();
                confirm_password.getText().clear();

                password_result.setVisibility(View.INVISIBLE);
            }
        });
        save_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                password_result.setVisibility(View.VISIBLE);

                password_result.setText("Wait, process running.");

                final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                AuthCredential credential = EmailAuthProvider.getCredential(SharedPrefManager.getInstance(SettingsActivity.this).getEmail(), old_password.getText().toString());
                user.reauthenticate(credential).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            user.updatePassword(new_password.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        SharedPrefManager.getInstance(SettingsActivity.this).updatePassword(new_password.getText().toString());
                                        old_password.getText().clear();
                                        new_password.getText().clear();
                                        confirm_password.getText().clear();
                                        password_result.setText("Successful.");
                                    } else {
                                        password_result.setText("Unsuccessful.");
                                    }
                                }
                            });
                        } else {
                            password_result.setText("Password didn't match");
                        }
                    }
                });
            }
        });


        change_pin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                change_pin.setVisibility(View.GONE);

                pin_change_view.setVisibility(View.VISIBLE);
                password_change_view.setVisibility(View.GONE);
                email_change_view.setVisibility(View.GONE);

                change_password.setVisibility(View.VISIBLE);
                change_email.setVisibility(View.VISIBLE);
                pin_result.setText("");
            }
        });
        cancel_pin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pin_change_view.setVisibility(View.GONE);
                change_pin.setVisibility(View.VISIBLE);

                pin_password.getText().clear();
                new_pin.getText().clear();
                confirm_pin.getText().clear();

                pin_result.setVisibility(View.INVISIBLE);
            }
        });
        save_pin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pin_result.setVisibility(View.VISIBLE);

                if (SharedPrefManager.getInstance(SettingsActivity.this).verifyPassword(pin_password.getText().toString())) {
                    pin_result.setText("Wait, process running.");
                    FirebaseDatabase.getInstance().getReference().child(SharedPrefManager.getInstance(SettingsActivity.this).getUid())
                            .child("pin").setValue(new_pin.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                SharedPrefManager.getInstance(SettingsActivity.this).updatePin(new_pin.getText().toString());
                                pin_result.setText("Successful.");
                                pin_password.getText().clear();
                                new_pin.getText().clear();
                                confirm_pin.getText().clear();
                            } else {
                                pin_result.setText("Unsuccessful.");
                            }
                        }
                    });

                } else {
                    pin_result.setText("Incorrect Password.");
                }

            }
        });


        change_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                change_email.setVisibility(View.GONE);

                email_change_view.setVisibility(View.VISIBLE);
                password_change_view.setVisibility(View.GONE);
                pin_change_view.setVisibility(View.GONE);

                change_password.setVisibility(View.VISIBLE);
                change_pin.setVisibility(View.VISIBLE);

                email_result.setText("");
            }
        });
        cancel_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email_change_view.setVisibility(View.GONE);
                change_email.setVisibility(View.VISIBLE);

                email_password.getText().clear();
                new_email.getText().clear();

                email_result.setVisibility(View.INVISIBLE);
            }
        });
        save_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email_result.setVisibility(View.VISIBLE);

                email_result.setText("Wait, process running.");
                final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                AuthCredential credential = EmailAuthProvider.getCredential(SharedPrefManager.getInstance(SettingsActivity.this).getEmail(), email_password.getText().toString());
                user.reauthenticate(credential).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            user.updateEmail(new_email.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        SharedPrefManager.getInstance(SettingsActivity.this).updateEmail(new_email.getText().toString());
                                        FirebaseDatabase.getInstance().getReference().child(SharedPrefManager.getInstance(SettingsActivity.this).getUid())
                                                .child("email").setValue(new_email.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if (task.isSuccessful()) {
                                                    email_result.setText("Successful.");
                                                    email_password.getText().clear();
                                                    new_email.getText().clear();
                                                } else {
                                                    email_result.setText("Unsuccessful.");
                                                }
                                            }
                                        });
                                    } else {
                                        email_result.setText("Unsuccessful.");
                                    }
                                }
                            });
                        } else {
                            email_result.setText("Password didn't match");
                        }
                    }
                });
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
    }

    @Override
    protected void onPause() {
        super.onPause();
        HomeActivity.isStillRunning = false;
        SettingsActivity.this.finish();
    }
}
