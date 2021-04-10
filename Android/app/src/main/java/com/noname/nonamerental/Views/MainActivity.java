package com.noname.nonamerental.Views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;


import com.google.android.material.navigation.NavigationView;
import com.noname.nonamerental.R;
import com.noname.nonamerental.Views.Fragments.CarListFragment;
import com.noname.nonamerental.Views.Fragments.HomeFragment;
import com.noname.nonamerental.Views.Fragments.MyProfileFragment;
import com.noname.nonamerental.Views.Fragments.MyRentalsFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        drawer = findViewById(R.id.drawer_layout);

        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                drawer,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        );

        drawer.addDrawerListener(toggle);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        toggle.syncState();

        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }
    }


    //Navbar Functions
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
                break;
            case R.id.nav_my_profile:
                System.out.println("You Opened My rentals");
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MyProfileFragment()).commit();
                break;
            case R.id.nav_my_rentals:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MyRentalsFragment()).commit();
                break;
            case R.id.nav_car_list:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CarListFragment()).commit();
                break;
            case R.id.nav_logout:
                startActivity(new Intent(MainActivity.this,Login.class));
                break;
        }
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }
        else super.onBackPressed();
    }
}