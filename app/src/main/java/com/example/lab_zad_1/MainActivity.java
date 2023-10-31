package com.example.lab_zad_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.view.View;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void morningButtonOnClick(View view) {
        Intent intent = new Intent(MainActivity.this, MorningActivity.class);
        startActivity(intent);
    }

    public void dayButtonOnClick(View view) {
        Intent intent = new Intent(MainActivity.this, DayActivity.class );
        startActivity(intent);
    }

    public void eveningButtonOnClick(View view) {
        Intent intent2 = new Intent(MainActivity.this, EveningActivity.class );
        startActivity(intent2);
    }

    public void nightButtonOnClick(View view) {
        Intent intent3 = new Intent(MainActivity.this,  NightActivity.class);
        startActivity(intent3);
    }
}