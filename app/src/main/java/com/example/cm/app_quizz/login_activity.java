package com.example.cm.app_quizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login_activity extends AppCompatActivity {

    //Declaration

    EditText etLogin,etPassword;
    Button bLogin;
    TextView tvRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);

        //Recupération des ids

        etLogin=(EditText)findViewById(R.id.etLogin);
        etPassword=(EditText)findViewById(R.id.etPassword);
        bLogin=(Button)findViewById(R.id.bLogin);
        tvRegister=(TextView)findViewById(R.id.tvRegister);

        //Associations des listeners:
        bLogin.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
          //String email = eMail.getText().toString().trim();
                //                String password = etPassword.getText().toString().trim();
                //
                //                if(TextUtils.isEmpty(email)){
                //                    eMail.setError("Email is Required");
                //                    return;
                //                }
                //                if(TextUtils.isEmpty(password)){
                //                    etPassword.setError("Password is Required");
                //                    return;
                //                }
                //                if(password.length() < 6) {
                //                    etPassword.setError("Password must be >= 6 Characters");
                //                    return;
                //                }
                   // authenticate the use


                if (etLogin.getText().toString().equals("root") && etPassword.getText().toString().equals("root")) {
                    startActivity(new Intent(login_activity.this, activity_Quiz1.class));
                } else {
                    Toast.makeText(getApplicationContext(), "Login or password incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        }));
        tvRegister.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login_activity.this,Activity_register.class));
            }
        }));
    }
}
