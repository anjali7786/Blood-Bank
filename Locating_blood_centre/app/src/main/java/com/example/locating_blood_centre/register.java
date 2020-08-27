package com.example.locating_blood_centre;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class register extends AppCompatActivity {
    private Spinner spinnerbloodgroup;
    private Spinner sgender;
    private EditText fname;
    private EditText lname;
    private EditText uemail;
    private EditText uphone;
    private EditText upwd;
    private EditText conupwd;
    private TextView createacc;
    private TextView bgroup;
    private TextView login;
    private Button signup;
    private Button signin;
    private FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        spinnerbloodgroup = findViewById(R.id.spinnerbloodgroup);
        sgender = findViewById(R.id.sgender);
        fname = (EditText) findViewById(R.id.editTextTextPersonName);
        lname = (EditText) findViewById(R.id.editTextTextPersonName2);
        uemail = (EditText) findViewById(R.id.editTextTextEmailAddress);
        uphone = (EditText) findViewById(R.id.editTextPhone);
        upwd = (EditText) findViewById(R.id.editTextTextPassword);
        conupwd = (EditText) findViewById(R.id.econfirmpwd);
        createacc = (TextView) findViewById(R.id.textView);
        bgroup = (TextView) findViewById(R.id.textView3);
        login = (TextView) findViewById(R.id.tvhintbb);
        signup = (Button) findViewById(R.id.bsignupbb);
        signin = (Button) findViewById(R.id.bloginbb);

        fAuth = FirebaseAuth.getInstance();

        String[] bloodgroup = getResources().getStringArray(R.array.blood_group);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,bloodgroup);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerbloodgroup.setAdapter(adapter);

        String[] gender = getResources().getStringArray(R.array.gender);
        ArrayAdapter adapterg = new ArrayAdapter(this,android.R.layout.simple_spinner_item,gender);
        adapterg.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sgender.setAdapter(adapterg);

        // already logged in
        if(fAuth.getCurrentUser() != null)
        {
            Intent forget=new Intent(register.this, MainActivity.class);
            startActivity(forget);
            finish();
        }



       signin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent forget=new Intent(register.this, MainActivity.class);
                startActivity(forget);
                finish();
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                String email = uemail.getText().toString().trim();
                String pwd = upwd.getText().toString().trim();
                String cpwd = conupwd.getText().toString().trim();
                String name = fname.getText().toString().trim();
                String lastname = lname.getText().toString().trim();
                String phone = uphone.getText().toString().trim();
                String bgrp = spinnerbloodgroup.getSelectedItem().toString().trim();
                String sex = sgender.getSelectedItem().toString().trim();

                if(TextUtils.isEmpty(name))
                {
                    fname.setError("First Name is required");
                    return;
                }
                if(TextUtils.isEmpty(email))
                {
                    uemail.setError("Email is required");
                    return;
                }
                if(TextUtils.isEmpty(phone))
                {
                    uphone.setError("phone no. is required");
                    return;
                }
                if(TextUtils.isEmpty(pwd))
                {
                    upwd.setError("Password is required");
                    return;
                }
                if(pwd.length()<6)
                {
                    upwd.setError("Password must contain more than 5 characters");
                    return;
                }
                if(TextUtils.isEmpty(cpwd))
                {
                    conupwd.setError("Confirm Password is required");
                    return;
                }
                if(!cpwd.equals(pwd))
                {
                    conupwd.setError("Doesn't match with Password");
                    return;
                }

                // registration in firebase
                fAuth.createUserWithEmailAndPassword(email,pwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            
                            Toast.makeText(register.this,"Registration Successful",Toast.LENGTH_SHORT).show();
                            Intent forget=new Intent(register.this, mainpersonalacc.class);
                            startActivity(forget);
                            finish();
                        }
                        else
                        {
                            Toast.makeText(register.this,"Error! " + task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });


            }
        });




    }
}