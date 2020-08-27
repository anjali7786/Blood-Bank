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

public class MainActivity extends AppCompatActivity {

    private EditText User_Email;
    private EditText Pwd;
    private TextView Login;
    private Button rgt;
    private Button log;
    private Button forget_pwd;
    private FirebaseAuth fAuth;


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
        fAuth = FirebaseAuth.getInstance();

        log.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                String email = User_Email.getText().toString().trim();
                String pwd = Pwd.getText().toString().trim();
                if(TextUtils.isEmpty(email))
                {
                    User_Email.setError("Email is required");
                    return;
                }
                if(TextUtils.isEmpty(pwd))
                {
                    Pwd.setError("Password is required");
                    return;
                }

                //Authentication
                fAuth.signInWithEmailAndPassword(email,pwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(MainActivity.this,"Log-In Successful",Toast.LENGTH_SHORT).show();
                            Intent forget=new Intent(MainActivity.this, mainpersonalacc.class);
                            startActivity(forget);
                            finish();
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this,"Error! " + task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        forget_pwd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent forget=new Intent(MainActivity.this, Recover_Account.class);
                startActivity(forget);
                finish();
            }
        });
        rgt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent forget=new Intent(MainActivity.this, choose_account.class);
                startActivity(forget);
                finish();
            }
        });
    }
}