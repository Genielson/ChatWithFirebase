package com.example.myapplication.models;

import com.example.myapplication.config.FirebaseConfig;
import com.google.firebase.database.DatabaseReference;

public class User {
    private String id;
    private String name;
    private String password;
    private String email;

    public User(){

    }
    public User(String id, String name, String password, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void save(){
        DatabaseReference reference = FirebaseConfig.getFirebaseInstance();
        reference.child("usuarios").child(this.getId()).setValue(this);
    }
}
