package com.example.locating_blood_centre;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class Register_bloodbank extends AppCompatActivity {

    private EditText bbname;
    private EditText bbaddress;
    private EditText bbemail;
    private EditText bbphone;
    private EditText bbtelephone;
    private EditText bbpin;
    private EditText bbconpwd;
    private EditText bbpwd;
    private EditText bbproof;
    private TextView bblogin;
    private Button bbsignup;
    private Button bbsignin;


    private FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_bloodbank);
        bbname = (EditText) findViewById(R.id.etNameBB);
        bbaddress = (EditText) findViewById(R.id.etAddressBB);
        bbpin = (EditText) findViewById(R.id.etPinBB);
        bbemail = (EditText) findViewById(R.id.etEmailbb);
        bblogin = (TextView) findViewById(R.id.tvhintbb);
        bbphone = (EditText) findViewById(R.id.etPhoneBB);
        bbtelephone = (EditText) findViewById(R.id.etTelephoneBB);
        bbproof = (EditText) findViewById(R.id.etProofBB);
        bbpwd = (EditText) findViewById(R.id.etpwdbb);
        bbconpwd = (EditText) findViewById(R.id.etcon_pwdbb);
        bbsignin = (Button) findViewById(R.id.bloginbb);
        bbsignup = (Button) findViewById(R.id.bsignupbb);

        fAuth = FirebaseAuth.getInstance();

        /* For user already logged in */
        if (fAuth.getCurrentUser() != null) {
            Intent forget = new Intent(Register_bloodbank.this, MainActivity.class);
            startActivity(forget);
            finish();
        }

        bbsignup.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            String name = bbname.getText().toString().trim();
                                            String email = bbemail.getText().toString().trim();
                                            String pwd = bbpwd.getText().toString().trim();
                                            String cpwd = bbconpwd.getText().toString().trim();
                                            String address = bbaddress.getText().toString().trim();
                                            String pin = bbpin.getText().toString().trim();
                                            String phone = bbphone.getText().toString().trim();
                                            String proof = bbproof.getText().toString().trim();

                                            /* Setting Error messages */
                                            if (TextUtils.isEmpty(name)) {
                                                bbname.setError("Blood Bank Name is required");
                                                return;
                                            }
                                            if (TextUtils.isEmpty(email)) {
                                                bbemail.setError("Email is required");
                                                return;
                                            }
                                            if (TextUtils.isEmpty(phone)) {
                                                bbphone.setError("phone no. is required");
                                                return;
                                            }
                                            if (TextUtils.isEmpty(pwd)) {
                                                bbpwd.setError("Password is required");
                                                return;
                                            }
                                            if (pwd.length() < 6) {
                                                bbpwd.setError("Password must contain at least 6 characters");
                                                return;
                                            }
                                            if (TextUtils.isEmpty(cpwd)) {
                                                bbconpwd.setError("Confirm Password is required");
                                                return;
                                            }
                                            if (!(pwd).equals(cpwd)) {
                                                bbconpwd.setError("Password doesn't match");
                                                return;
                                            }
                                            if (TextUtils.isEmpty(proof)) {
                                                bbproof.setError("Proof is required");
                                                return;
                                            }
                                            if (TextUtils.isEmpty(address)) {
                                                bbaddress.setError("Address is required");
                                                return;
                                            }
                                            if (TextUtils.isEmpty(pin)) {
                                                bbpin.setError("Pincode is required");
                                                return;
                                            }

                                            /* Authentication of user */
                                            fAuth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                                @Override
                                                public void onComplete(@NonNull Task<AuthResult> task) {
                                                    if (task.isSuccessful()) {
                                                        Toast.makeText(Register_bloodbank.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                                                        Intent forget = new Intent(Register_bloodbank.this, mainpersonalacc.class);
                                                        startActivity(forget);
                                                        /* Welcome Screen will be shown */
                                                        finish();
                                                    } else {
                                                        Toast.makeText(Register_bloodbank.this, "Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                                    }
                                                }
                                            });

                                            bbsignin.setOnClickListener(new View.OnClickListener() {
                                                public void onClick(View view) {
                                                    Intent forget = new Intent(Register_bloodbank.this, MainActivity.class);
                                                    startActivity(forget);
                                                    finish();
                                                }
                                            });
                                        }
                                    }
        );
    }
}