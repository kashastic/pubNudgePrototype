package com.example.button_navigation;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

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
                                selectedFragment = new Fragment_Home();
                                break;
                            case R.id.fav:
                                selectedFragment = new Fragment_fav();
                                break;
                            case R.id.srch:
                                selectedFragment = new Fragment_search();
                                break;
                            case R.id.prsn:
                                selectedFragment = new Fragment_profile();
                                break;
                        }
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
                        return true;
                    }

                };

}
