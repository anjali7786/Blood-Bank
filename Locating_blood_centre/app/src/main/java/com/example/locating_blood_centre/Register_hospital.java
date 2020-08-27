package com.example.locating_blood_centre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Register_hospital extends AppCompatActivity {

    private Button signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_hospital);
        signin = (Button) findViewById(R.id.Btn);

        signin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent forget=new Intent(Register_hospital.this, MainActivity.class);
                startActivity(forget);
                finish();
            }
        });

    }
}