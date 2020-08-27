package com.example.locating_blood_centre;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;

public class Recover_Account extends AppCompatActivity {

    private EditText Email;
    private Button Submit;
    private Button Back;
    private FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recover__account);

        Email = (EditText) findViewById(R.id.etEmailrec);
        Submit = (Button) findViewById(R.id.bReset);
        Back = (Button) findViewById(R.id.bback);
        fAuth = FirebaseAuth.getInstance();

        Submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                    String email = Email.getText().toString().trim();
                    fAuth.sendPasswordResetEmail(email).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(Recover_Account.this,"Reset Link Sent to Email",Toast.LENGTH_SHORT).show();
                            Intent suc = new Intent(Recover_Account.this, MainActivity.class);
                            startActivity(suc);
                            finish();
                        }

                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(Recover_Account.this,"Error! "+ e.getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    });

            }
        });

        Back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent forget=new Intent(Recover_Account.this, MainActivity.class);
                startActivity(forget);
                finish();
            }
        });

    }
}
