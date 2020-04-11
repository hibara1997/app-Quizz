package com.example.cm.app_quizz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Activity_register extends AppCompatActivity {
    EditText eName,eMail,etLogin,etPassword;
    Button bRegister;
    FirebaseAuth fAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        eName = findViewById(R.id.eName);
        eMail = findViewById(R.id.eMail);
        etLogin= findViewById(R.id.etLogin);
        etPassword=findViewById(R.id.etPassword);
        bRegister = findViewById(R.id.bRegister);

        fAuth = FirebaseAuth.getInstance();

        if(fAuth.getCurrentUser() !=null){
            startActivity(new Intent(getApplicationContext(),login_activity.class));
            finish();
        }

        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = eMail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    eMail.setError("Email is Required");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    etPassword.setError("Password is Required");
                    return;
                }
                if(password.length() < 6) {
                    etPassword.setError("Password must be >= 6 Characters");
                    return;
                }

                //register the user in firebase
                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Activity_register.this,"user created",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),login_activity.class));
                        }
                        else {
                            Toast.makeText(Activity_register.this, "Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });
            }
        });




    }
}
