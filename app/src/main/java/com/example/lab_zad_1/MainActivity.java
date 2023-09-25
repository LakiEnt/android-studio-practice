package com.example.lab_zad_1;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.ImageView;

import android.widget.Button;
import android.view.View;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void hideTextViews(View view){
        TextView textName = findViewById(R.id.textView);
        TextView textGroup = findViewById(R.id.textView2);

        if(textName.getVisibility() == View.VISIBLE && textGroup.getVisibility() == View.VISIBLE){
            textName.setVisibility(View.INVISIBLE);
            textGroup.setVisibility(View.INVISIBLE);
        }
        else{
            textName.setVisibility(View.VISIBLE);
            textGroup.setVisibility(View.VISIBLE);
        }
    }

    public void hideImg(View view){
        ImageView img = findViewById(R.id.imageView);

        if(img.getVisibility() == View.VISIBLE && img.getVisibility() == View.VISIBLE){
            img.setVisibility(View.INVISIBLE);
        }
        else{
            img.setVisibility(View.VISIBLE);
        }
    }
}