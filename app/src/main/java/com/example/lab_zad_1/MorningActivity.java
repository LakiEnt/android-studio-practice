package com.example.lab_zad_1;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MorningActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_morning);
    }

    public void goToDay(View view) {
        Intent intent = new Intent(this, DayActivity.class);
        startActivity(intent);
        Toast toast = Toast.makeText(getApplicationContext(),
                "Скоро конец рабочего дня!", Toast.LENGTH_SHORT);
        toast.show();
    }
}