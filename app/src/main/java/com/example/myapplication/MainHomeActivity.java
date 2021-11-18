package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.myapplication.adapter.TabAdapter;
import com.example.myapplication.helper.SlidingTabLayout;

public class MainHomeActivity extends AppCompatActivity {

    private SlidingTabLayout tabLayout;
    private ViewPager viewPager;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);

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



}