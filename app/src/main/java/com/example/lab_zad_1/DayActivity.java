package com.example.lab_zad_1;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class DayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void goToMoring(View view) {
        Intent intent = new Intent(this, MorningActivity.class);
        startActivity(intent);
    }

    public void goToEvening(View view) {
        Intent intent = new Intent(this, EveningActivity.class);
        startActivity(intent);
        Toast toast = Toast.makeText(getApplicationContext(),
                "Иди-ка ты спать!", Toast.LENGTH_SHORT);
        toast.show();
    }

}