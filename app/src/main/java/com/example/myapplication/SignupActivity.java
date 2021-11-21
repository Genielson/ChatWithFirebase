package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity {

    private EditText name;
    private EditText email;
    private EditText password;
    private EditText repeatPassword;
    private Button button;
    private FirebaseAuth firebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        name = findViewById(R.id.edit_login_name_create);
        email = findViewById(R.id.edit_login_email_create);
        password = findViewById(R.id.edit_login_password_create);
        repeatPassword = findViewById(R.id.edit_login_password_repeat_create);
        Boolean resultCompare = comparePasswords(password.getText().toString(),
                repeatPassword.getText().toString());

        if(resultCompare){

        }else{
            Toast.makeText(getApplicationContext(),
                    "As senhas nao são iguais",
                    Toast.LENGTH_LONG).show();
        }

    }

    private Boolean comparePasswords(String passwordText, String passwordRepeat){

        if(passwordRepeat.equals(passwordRepeat)){
            return true;
        }else{
            return false;
        }

    }


}