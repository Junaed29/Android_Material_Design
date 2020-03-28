package com.example.androidmaterialdesign;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class DashboardActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        toolbar = findViewById(R.id.toolbarId);
        setSupportActionBar(toolbar);
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
}
