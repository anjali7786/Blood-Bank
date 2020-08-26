package com.example.locating_blood_centre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class register extends AppCompatActivity {
    private Spinner spinnerbloodgroup;
    private Spinner sgender;
    private EditText fname;
    private EditText lname;
    private EditText uemail;
    private EditText uphone;
    private EditText pwd;
    private TextView createacc;
    private TextView bgroup;
    private TextView login;
    private Button signup;
    private Button signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        spinnerbloodgroup = findViewById(R.id.spinnerbloodgroup);
        sgender = findViewById(R.id.sgender);

        String[] bloodgroup = getResources().getStringArray(R.array.blood_group);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,bloodgroup);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerbloodgroup.setAdapter(adapter);

        String[] gender = getResources().getStringArray(R.array.gender);
        ArrayAdapter adapterg = new ArrayAdapter(this,android.R.layout.simple_spinner_item,gender);
        adapterg.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sgender.setAdapter(adapterg);

        fname = (EditText) findViewById(R.id.editTextTextPersonName);
        lname = (EditText) findViewById(R.id.editTextTextPersonName2);
        uemail = (EditText) findViewById(R.id.editTextTextEmailAddress);
        uphone = (EditText) findViewById(R.id.editTextPhone);
        pwd = (EditText) findViewById(R.id.editTextTextPassword);
        createacc = (TextView) findViewById(R.id.textView);
        bgroup = (TextView) findViewById(R.id.textView3);
        login = (TextView) findViewById(R.id.tvhintbb);
        signup = (Button) findViewById(R.id.bsignupbb);
        signin = (Button) findViewById(R.id.bloginbb);


       /* THIS IS NOT CORRECT NOW signup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent forget=new Intent(register.this, MainActivity.class);
                startActivity(forget);
            }
        }); */
        signin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent forget=new Intent(register.this, MainActivity.class);
                startActivity(forget);
            }
        });


    }
}