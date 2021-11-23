package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.config.FirebaseConfig;
import com.example.myapplication.helper.Preferences;
import com.example.myapplication.models.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;

public class SignupActivity extends AppCompatActivity {

    private EditText name;
    private EditText email;
    private EditText password;
    private EditText repeatPassword;
    private Button button;
    private User user;
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
        button = findViewById(R.id.bt_login_create);

        if(resultCompare){
            button.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    user = new User();
                    user.setName(name.getText().toString());
                    user.setEmail(email.getText().toString());
                    user.setPassword(password.getText().toString());
                    firebase = FirebaseConfig.getFirebaseAuthInstance();
                    firebase.createUserWithEmailAndPassword(user.getEmail(),user.getPassword())
                            .addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    if(task.isSuccessful()){

                                        user.setId(user.getEmail());
                                        user.save();
                                        Toast.makeText(getApplicationContext(),
                                                "Conta criada com sucesso!",
                                                Toast.LENGTH_LONG).show();

                                        Preferences pref = new Preferences(SignupActivity.this);
                                        pref.saveData(user.getEmail(),user.getName());
                                        openScreenLogin();
                                    }else{

                                        Toast.makeText(getApplicationContext(),
                                                "Houve um erro ao cadastrar. Tente colocar numeros na senha! ",
                                                Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
                }

            });

        }else{
            Toast.makeText(getApplicationContext(),
                    "As senhas nao são iguais",
                    Toast.LENGTH_LONG).show();
        }

    }

    private void openScreenLogin(){
        Intent intent = new Intent(SignupActivity.this,LoginActivity.class);
        startActivity(intent);
        finish();
    }

    private Boolean comparePasswords(String passwordText, String passwordRepeat){

        if(passwordRepeat.equals(passwordRepeat)){
            return true;
        }else{
            return false;
        }

    }

}