package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.myapplication.adapter.TabAdapter;
import com.example.myapplication.config.FirebaseConfig;
import com.example.myapplication.helper.SlidingTabLayout;
import com.google.firebase.auth.FirebaseAuth;

public class MainHomeActivity extends AppCompatActivity {

    private SlidingTabLayout tabLayout;
    private ViewPager viewPager;
    private Toolbar toolbar;
    private FirebaseAuth firebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);

        firebase = FirebaseConfig.getFirebaseAuthInstance();

        toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        toolbar.setTitle("WhatsApp");
        setSupportActionBar(toolbar);

        tabLayout = findViewById(R.id.sld_tab);
        viewPager = findViewById(R.id.vp_home);

        // distribui os tamanhos iguais para cada aba
        tabLayout.setDistributeEvenly(true);
        // cor da linha em baixo
        tabLayout.setSelectedIndicatorColors(ContextCompat.getColor(this,R.color.colorAccent));

        TabAdapter adapter = new TabAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setViewPager(viewPager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.item_sair :
                logoutUser();
                return true;
            case R.id.item_adicionar :
                openSignupContact();
                return true;

        }

        return super.onOptionsItemSelected(item);
    }

    private void openSignupContact(){

    }

    private void logoutUser(){
        firebase.signOut();
        Intent intent = new Intent(MainHomeActivity.this,LoginActivity.class);
        startActivity(intent);
        finish();
    }
}