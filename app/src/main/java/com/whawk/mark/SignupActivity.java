package com.whawk.mark;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {


    private FirebaseAuth mAuth;
    private Button sign_up_BT;
    private EditText nameET, emailET, mobileET, passwordET, pinET;
    private RadioGroup genderRG;
    private RadioButton maleRB, femaleRB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        init();
        onClickListeners();



    }

    private void onClickListeners() {


        sign_up_BT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(InternetConectivity.getInstance(SignupActivity.this).checkInternetConnection()) {


                    final String name, email, mobile, password, pin, gender;

                    name = nameET.getText().toString();
                    email = emailET.getText().toString();
                    password = passwordET.getText().toString();
                    mobile = mobileET.getText().toString();
                    pin = pinET.getText().toString();

                    if (maleRB.isChecked()) {
                        gender = "Male";
                    } else {
                        gender = "Female";
                    }

                    View data_entry_view = LayoutInflater.from(SignupActivity.this).inflate(R.layout.black_dialog_box, null, false);
                    AlertDialog.Builder builder = new AlertDialog.Builder(SignupActivity.this);
                    builder.setView(data_entry_view);
                    final TextView processing = data_entry_view.findViewById(R.id.processing);

                    final AlertDialog alertDialog = builder.create();
                    alertDialog.setCancelable(false);
                    alertDialog.show();
                    processing.setText("Registering User");

                    mAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information

                                        final String uid = mAuth.getCurrentUser().getUid();
                                        UserInfo user_info = new UserInfo(name, email, gender, mobile, pin);
                                        FirebaseDatabase.getInstance().getReference().child(uid)
                                                .setValue(user_info).addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {

                                                if (task.isSuccessful()) {
                                                    SharedPrefManager.getInstance(getApplicationContext()).saveUser(new User(uid, name, email, password, pin));
                                                    processing.setText("Successful");
                                                    new Handler().postDelayed(new Runnable() {
                                                        @Override
                                                        public void run() {
                                                            startActivity(new Intent(SignupActivity.this, MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY));
                                                        }
                                                    },200);
                                                } else {
                                                    alertDialog.dismiss();
                                                    Toast.makeText(SignupActivity.this, "Registration failed.", Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        });



                                    } else {
                                        // If sign in fails, display a message to the user.
                                        alertDialog.dismiss();
                                        Toast.makeText(SignupActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                                    }

                                    // ...
                                }
                            });
                }else{
                Toast.makeText(SignupActivity.this, "No Internet conection", Toast.LENGTH_SHORT).show();
            }
            }
        });
    }

    private void init() {
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        nameET = findViewById(R.id.nameET);
        emailET = findViewById(R.id.emailET);
        mobileET = findViewById(R.id.mobileET);
        passwordET = findViewById(R.id.passwordET);
        pinET = findViewById(R.id.pinET);
        genderRG = findViewById(R.id.genderRG);
        maleRB = findViewById(R.id.maleRB);
        femaleRB = findViewById(R.id.femaleRB);
        sign_up_BT = findViewById(R.id.sign_up_BT);
    }

}
