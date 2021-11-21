package com.example.myapplication.helper;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferences {

    private Context context;
    private SharedPreferences preferences;
    private final String FILE_NAME = "example.preferences";
    private final int MODE = 0;
    private SharedPreferences.Editor editor;

    public Preferences(Context contextParam){

        context = contextParam;
        preferences = context.getSharedPreferences(FILE_NAME,MODE);
        editor = preferences.edit();

    }

    public void saveData(String identificador,String nome){

        editor.putString("ideUserLog0101",identificador);
        editor.putString("nomeUsuLog01010",nome);
        editor.commit();

    }

    public String getIdentificator(){
        return preferences.getString("ideUserLog0101",null);
    }

    public String getName(){
        return preferences.getString("nomeUsuLog01010",null);
    }
    
}
