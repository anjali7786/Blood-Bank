package com.example.locating_blood_centre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText User_Email;
    private EditText Pwd;
    private TextView Login;
    private Button rgt;
    private Button log;
    private Button forget_pwd;

    private void validate(String Email, String Password) {
        if (Email.equals("Admin") && Password.equals("0000")) {
            //correct email or password
//            Intent success=new Intent(Login.this,Choose);
//            startActivity(Intent success);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        User_Email = (EditText) findViewById(R.id.etEmailrec);
        Pwd = (EditText) findViewById(R.id.etPwd);
        Login = (TextView) findViewById(R.id.tvLogin);
        log = (Button) findViewById(R.id.bLogin);
        rgt = (Button) findViewById(R.id.bRegister);
        forget_pwd = (Button) findViewById(R.id.bForget_pwd);

        log.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                validate(User_Email.getText().toString(), Pwd.getText().toString());
            }
        });
        forget_pwd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent forget=new Intent(MainActivity.this, Recover_Account.class);
                startActivity(forget);
            }
        });
        rgt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent forget=new Intent(MainActivity.this, choose_account.class);
                startActivity(forget);
            }
        });
    }
}