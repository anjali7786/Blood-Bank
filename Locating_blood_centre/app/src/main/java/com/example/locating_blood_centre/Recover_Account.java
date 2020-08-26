package com.example.locating_blood_centre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Recover_Account extends AppCompatActivity {

    private EditText Email;
    private EditText New_Password;
    private EditText Confirm_Password;
    private Button Submit;
    private Button Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recover__account);

        Email = (EditText) findViewById(R.id.etEmailrec);
        New_Password = (EditText) findViewById(R.id.etNewPwd);
        Confirm_Password = (EditText) findViewById(R.id.etConfirmPwd);
        Submit = (Button) findViewById(R.id.bReset);
        Back = (Button) findViewById(R.id.bback);
        Submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (New_Password.getText().toString().equals(Confirm_Password.getText().toString())) {
                    Intent suc = new Intent(Recover_Account.this, MainActivity.class);
                    startActivity(suc);
                }
//                else {
//                    System.out.println("Password not matched");
//                }
            }
        });

        Back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent forget=new Intent(Recover_Account.this, MainActivity.class);
                startActivity(forget);
            }
        });

    }
}
