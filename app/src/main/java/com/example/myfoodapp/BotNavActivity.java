package com.example.myfoodapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BotNavActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bot_nav);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomnav);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
    }

private BottomNavigationView.OnNavigationItemSelectedListener navListener =

        new  BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment = null;
                switch (item.getItemId()){
                    case R.id.nav_home:
                        fragment = new HomePageActivity();
                        break;

                }

                switch (item.getItemId()){
                    case R.id.favourites:
                        fragment = new FavouriteFragment();
                        break;

                }

                switch (item.getItemId()){
                    case R.id.nav_profile:
                        fragment = new UserProfileFragment();
                        break;

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.framecontainer1,
                        fragment).commit();

                return true;
            }
        };
    }
