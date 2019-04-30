package com.example.nudgerewriten;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.support.design.widget.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView botNav = findViewById(R.id.bottom_navigation);
        botNav.setOnNavigationItemSelectedListener(navlistener);

    }
    private BottomNavigationView.OnNavigationItemSelectedListener navlistener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                    Fragment selectedFragment= null;
                    switch (menuItem.getItemId())
                    {
                        case R.id.home:
                            selectedFragment = new Fragment_home();
                            break;
                        case R.id.c_m:
                            selectedFragment = new Fragment_c_m();
                            break;
                        case R.id.farmer:
                            selectedFragment = new Fragment_farmerlist();
                            break;
                        case R.id.profile:
                            selectedFragment = new Fragment_profile();
                            break;
                        case R.id.service:
                            selectedFragment = new Fragment_service();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
                    return true;
                }

            };
}
