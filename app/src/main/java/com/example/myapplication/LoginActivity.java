package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private Button buttonLogin;
    private TextView createAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.editEmail);
        password = findViewById(R.id.editPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        createAccount = findViewById(R.id.textSignUp);

        createAccount.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(LoginActivity.this,SignupActivity.class);
                //startActivity(intent);
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                startActivity(intent);
            }
        });


    }
}