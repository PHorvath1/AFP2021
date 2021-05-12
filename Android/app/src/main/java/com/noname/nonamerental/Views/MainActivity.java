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
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import com.google.android.material.navigation.NavigationView;
import com.noname.nonamerental.R;
import com.noname.nonamerental.Views.Fragments.CarListFragment;
import com.noname.nonamerental.Views.Fragments.HomeFragment;
import com.noname.nonamerental.Views.Fragments.MyProfileFragment;
import com.noname.nonamerental.Views.Fragments.MyRentalsFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;
    private DrawerLayout drawer;
    public HomeFragment myHomeFragment;
    private MyProfileFragment myProfileFragment;
    private CarListFragment carListFragment;
    private MyRentalsFragment rentalsFragment;

    private int userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //USER ID
        userId = getIntent().getIntExtra("UserId",-1);


        //Pre building fragments with data
        Bundle bundle = new Bundle();
        bundle.putInt("UserId",userId);
        Bundle bundle2 = new Bundle();
        bundle2.putInt("UserId",userId);
        myHomeFragment = new HomeFragment();
        myHomeFragment.setArguments(bundle);
        myProfileFragment = new MyProfileFragment();
        myProfileFragment.setArguments(bundle);
        carListFragment = new CarListFragment();
        carListFragment.setArguments(bundle);
        rentalsFragment = new MyRentalsFragment();
        rentalsFragment.setArguments(bundle);

        //Toolbar declaration
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
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, myHomeFragment).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }
    }


    //Navbar Functions
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_home:

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,myHomeFragment).commit();
                break;
            case R.id.nav_my_profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, myProfileFragment).commit();
                break;
            case R.id.nav_my_rentals:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, rentalsFragment).commit();
                break;
            case R.id.nav_car_list:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, carListFragment).commit();
                break;
            case R.id.nav_logout:
                Intent intent = new Intent(MainActivity.this,Rate.class);
                intent.putExtra("uid", userId);
                startActivity(intent);
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