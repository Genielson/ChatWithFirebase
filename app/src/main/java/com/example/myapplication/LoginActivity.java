package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.config.FirebaseConfig;
import com.example.myapplication.helper.Preferences;
import com.example.myapplication.models.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private Button buttonLogin;
    private TextView createAccount;
    private FirebaseAuth firebase;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.edit_login_email);
        password = findViewById(R.id.edit_login_password);
        buttonLogin = findViewById(R.id.bt_login);
        createAccount = findViewById(R.id.txtSignup);

        createAccount.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,SignupActivity.class);
                startActivity(intent);
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                firebase = FirebaseConfig.getFirebaseAuthInstance();
                user = new User();
                user.setEmail(email.getText().toString());
                user.setPassword(password.getText().toString());
                firebase.signInWithEmailAndPassword(user.getEmail(),user.getPassword()).
                        addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){

                            Preferences pref = new Preferences(LoginActivity.this);
                            pref.saveData(user.getEmail(),user.getName());
                            openMainScreen();
                            finish();
                            
                        }else{
                            Toast.makeText(getApplicationContext(),
                                    "Erro ao realizar login!",
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                });

                //openMainScreen();
                //finish();
            }
        });

    }

    private void openMainScreen(){
        Intent intent = new Intent(LoginActivity.this,MainHomeActivity.class);
        startActivity(intent);
    }

}