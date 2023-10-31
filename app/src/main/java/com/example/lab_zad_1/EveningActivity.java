package com.example.lab_zad_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


public class EveningActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evening);
    }
    public void goToNight(View view) {
        Intent intent = new Intent(this, NightActivity.class);
        startActivity(intent);
    }
}