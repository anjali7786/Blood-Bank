package com.example.locating_blood_centre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class choose_account extends AppCompatActivity {

    RadioGroup chaccount;
    RadioButton rbutton;
    TextView createacc;
    TextView tchoose;
    Button bac;
    Button apply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_account);

        chaccount = findViewById(R.id.radiogrp);
        createacc = (TextView) findViewById(R.id.textView4);
        tchoose = (TextView) findViewById(R.id.textView5);
        apply = findViewById(R.id.button2);
        bac = findViewById(R.id.bback);

        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioId= chaccount.getCheckedRadioButtonId();
                rbutton = findViewById(radioId);

                if(rbutton.getText().equals("Personal Account"))
                {

                            Intent forget=new Intent(choose_account.this, register.class);
                            startActivity(forget);
                            finish();
                }
                else if(rbutton.getText().equals("Hospital"))
                {


                            Intent forget=new Intent(choose_account.this, Register_hospital.class);
                            startActivity(forget);
                            finish();

                }
                else if(rbutton.getText().equals("Blood bank")) {


                            Intent forget=new Intent(choose_account.this, Register_bloodbank.class);
                            startActivity(forget);
                            finish();

                }



            }
        });
        bac.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent forget=new Intent(choose_account.this, MainActivity.class);
                startActivity(forget);
                finish();
            }
        });


    }
    public void checkButton(View v)
    {
         int radioId= chaccount.getCheckedRadioButtonId();
         rbutton = findViewById(radioId);

        Toast.makeText(this, "Selected Radio Button: "+ rbutton.getText(),Toast.LENGTH_SHORT).show();
    }
}