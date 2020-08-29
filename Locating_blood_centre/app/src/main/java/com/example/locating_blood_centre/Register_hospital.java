package com.example.locating_blood_centre;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Register_hospital extends AppCompatActivity {

    private Button signin,signup;
    private EditText adress;
    private EditText pincode;
    private EditText phone;
    private EditText tele;
    private EditText hospname;
    private EditText proof;
    private EditText pwd;
    private EditText comPwd;
    private EditText email;
    private FirebaseAuth fAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_hospital);
        signin = (Button) findViewById(R.id.Btn);
        signup = (Button) findViewById(R.id.signup);
        adress = (EditText)findViewById(R.id.adr);
        pincode = (EditText)findViewById(R.id.pincode);
        phone = (EditText)findViewById(R.id.phone);
        tele = (EditText)findViewById(R.id.tele);
        hospname = (EditText)findViewById(R.id.hosname);
        proof = (EditText)findViewById(R.id.proof);
        pwd = (EditText)findViewById(R.id.Pwd);
        comPwd = (EditText)findViewById(R.id.ComPwd);
        email = (EditText)findViewById(R.id.email);
        fAuth = FirebaseAuth.getInstance();


        if(fAuth.getCurrentUser()!=null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }


        signin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent forget=new Intent(Register_hospital.this, MainActivity.class);
                startActivity(forget);
                finish();
            }
        });
        signup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String password= pwd.getText().toString().trim();
                String eml =email.getText().toString().trim();
                String comfirm= comPwd.getText().toString().trim();
                if(TextUtils.isEmpty(eml)){
                    email.setError("E-Mail is Required");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    pwd.setError("Password is Required");
                    return;
                }
                if(password.length()<6){
                    pwd.setError("Password Must be >= 6 Characters");
                    return;         }

                if(TextUtils.isEmpty(comfirm)){
                    comPwd.setError("Confirm Password is Required");
                    return;
                }
                if(comfirm.length()<6){
                    comPwd.setError("Confirm Password Must be >= 6 Characters");
                    return;
                }
                if(!pwd.getText().toString().equals((comPwd.getText().toString()))){
                    comPwd.setError("Password does not match");
                }
                fAuth.createUserWithEmailAndPassword(eml,password).addOnCompleteListener(new OnCompleteListener<AuthResult>(){
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task){
                        if(task.isSuccessful()){

                            //EMAIL VERIFICATION
                            FirebaseUser user = fAuth.getCurrentUser();
                            user.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(Register_hospital.this,"Verification mail has been sent!",Toast.LENGTH_SHORT).show();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d("registerh","onFailure: Email not sent "+e.getMessage());
                                }
                            });

                            Toast.makeText(Register_hospital.this, "User Created", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                      }
                        else {
                        Toast.makeText(Register_hospital.this,"Error"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
}});
};
});
};
}