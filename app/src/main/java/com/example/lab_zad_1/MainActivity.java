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

    public void onPlus(View view){
        TextView firstInput = findViewById(R.id.firstInput);
        TextView secondInput = findViewById(R.id.secondInput);

        Integer firstValue = Integer.parseInt(firstInput.getText().toString());
        Integer secondValue = Integer.parseInt(secondInput.getText().toString());
        Integer answerValue = firstValue + secondValue;

        CharSequence answerValueString = answerValue.toString();
        TextView answerInput = findViewById(R.id.answerInput);
        TextView znak = findViewById(R.id.textView4);
        znak.setText("+");

        answerInput.setText(answerValueString);

    }

    public void onMinus(View view){
        TextView firstInput = findViewById(R.id.firstInput);
        TextView secondInput = findViewById(R.id.secondInput);

        Integer firstValue = Integer.parseInt(firstInput.getText().toString());
        Integer secondValue = Integer.parseInt(secondInput.getText().toString());
        Integer answerValue = firstValue - secondValue;

        CharSequence answerValueString = answerValue.toString();
        TextView answerInput = findViewById(R.id.answerInput);
        TextView znak = findViewById(R.id.textView4);
        znak.setText("-");

        answerInput.setText(answerValueString);
    }

    public void onDivide(View view){
        TextView firstInput = findViewById(R.id.firstInput);
        TextView secondInput = findViewById(R.id.secondInput);

        Integer firstValue = Integer.parseInt(firstInput.getText().toString());
        Integer secondValue = Integer.parseInt(secondInput.getText().toString());
        Integer answerValue = firstValue / secondValue;

        CharSequence answerValueString = answerValue.toString();
        TextView answerInput = findViewById(R.id.answerInput);
        TextView znak = findViewById(R.id.textView4);
        znak.setText("/");

        answerInput.setText(answerValueString);
    }

    public void onMultiply(View view){
        TextView firstInput = findViewById(R.id.firstInput);
        TextView secondInput = findViewById(R.id.secondInput);

        Integer firstValue = Integer.parseInt(firstInput.getText().toString());
        Integer secondValue = Integer.parseInt(secondInput.getText().toString());
        Integer answerValue = firstValue * secondValue;

        CharSequence answerValueString = answerValue.toString();
        TextView answerInput = findViewById(R.id.answerInput);
        TextView znak = findViewById(R.id.textView4);
        znak.setText("*");

        answerInput.setText(answerValueString);
    }

    public void onClear(View view){
        TextView firstInput = findViewById(R.id.firstInput);
        TextView secondInput = findViewById(R.id.secondInput);
        TextView answerInput = findViewById(R.id.answerInput);
        TextView znak = findViewById(R.id.textView4);
        firstInput.setText("0");
        secondInput.setText("0");
        answerInput.setText("0");
        znak.setText(" ");

    }



}