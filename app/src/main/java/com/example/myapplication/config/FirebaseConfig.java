package com.example.myapplication.config;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public final class FirebaseConfig {
    private static DatabaseReference reference;
    private static FirebaseAuth authentication;

    public static DatabaseReference getFirebaseInstance(){

        if(reference == null){
            reference = FirebaseDatabase.getInstance().getReference();
        }
        return reference;
    }

    public static FirebaseAuth getFirebaseAuthInstance(){

        if(authentication == null){
            authentication = FirebaseAuth.getInstance();
        }
        return authentication;
    }

}
