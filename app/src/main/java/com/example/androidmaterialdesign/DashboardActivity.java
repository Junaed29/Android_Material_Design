package com.example.androidmaterialdesign;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class DashboardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        /*********************  Finding View  **********************/
        toolbar = findViewById(R.id.toolbarId);
        drawerLayout = findViewById(R.id.drawerLayoutId);
        navigationView = findViewById(R.id.nav_view);

        /*********************   ActionBar and Toolbar  **********************/
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.men);

        /**********************   ActionBarDrawerToggle For combining all  **********************/
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_navigation_drawer, R.string.close_navigation_drawer);
        drawerLayout.addDrawerListener(toggle);
        //toggle.syncState(); //Better bit its change the default icon

        /*********************  NavigationView Listener  **********************/
        navigationView.setNavigationItemSelectedListener(this);


        /*********************  NavigationView Default Checked Item**********************/
        navigationView.setCheckedItem(R.id.nev_home);


        /**********************    Menu Item Hide and Showing     **********************/
        Menu menu = navigationView.getMenu();
        menu.findItem(R.id.nev_logout).setVisible(false);
        menu.findItem(R.id.nev_profile).setVisible(false);
    }

    public void byBoat_1(View view) {
        toast("byBoat_1");
    }

    public void byBoat_2(View view) {
        toast("byBoat_2");
    }

    public void byBoat_3(View view) {
        toast("byBoat_3");
    }

    public void byPlane_1(View view) {
        toast("byPlane_1");
    }

    public void byPlane_2(View view) {
        toast("byPlane_2");
    }

    public void byPlane_3(View view) {
        toast("byPlane_3");
    }

    public void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(Gravity.LEFT)) {
            drawerLayout.closeDrawer(Gravity.LEFT);
        } else {
            super.onBackPressed();
        }
    }


    /*********************  NavigationView Item Selection**********************/
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Menu menu = navigationView.getMenu();
        switch (item.getItemId()){
            case R.id.nev_home :
                break;
            case R.id.nev_boat:
                startActivity(new Intent(DashboardActivity.this,BoatActivity.class));
                break;
            case R.id.nav_share:
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nev_rate:
                Toast.makeText(this, "Rate", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nev_login:
                Toast.makeText(this, "Log In", Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawer(Gravity.LEFT);
                menu.findItem(R.id.nev_logout).setVisible(true);
                menu.findItem(R.id.nev_profile).setVisible(true);
                break;
        }
        drawerLayout.closeDrawer(Gravity.LEFT);
        return true;
    }
}
