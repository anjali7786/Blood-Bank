package com.example.locating_blood_centre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


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
        bbsignin= (Button) findViewById(R.id.bloginbb);
        bbsignup= (Button) findViewById(R.id.bsignupbb);

        bbsignin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent forget=new Intent(Register_bloodbank.this, MainActivity.class);
                startActivity(forget);
                finish();
            }
        });

        /* For use...after data storing and authentication part
        bbsignup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (bbpwd.getText().toString().equals(bbconpwd.getText().toString()) && bbpwd.getText().toString().length()>0 && bbconpwd.getText().toString().length()>0) {
                    // Both password and confirm password same
                }
                else {
                    // Different password and confirm password
                }
            }
        }); */

    }
}