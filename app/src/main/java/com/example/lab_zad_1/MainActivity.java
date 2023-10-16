package com.example.lab_zad_1;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.ImageView;

import android.widget.Button;
import android.view.View;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onTextToast2sec(View view){
        Toast toast = Toast.makeText(getApplicationContext(), "My CUSTOM message", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM, 0,0);
        toast.show();
    }
    public void onTextToast3_5sec(View view){
        Toast toast = Toast.makeText(getApplicationContext(), "My CUSTOM LONG message", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP, 0, 0);
        toast.show();
    }
    public void onTextToastDialog(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

            builder.setTitle("Title").setIcon(R.drawable.test_icon)
            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialogInterface, int i) {
                  dialogInterface.cancel();

                  Button textToast2sec = findViewById(R.id.textToast2sec);
                  textToast2sec.setTextColor(Color.RED);

                  Button textToast3_5sec = findViewById(R.id.textToast3_5sec);
                  textToast3_5sec.setTextColor(Color.RED);

                  Button textToastDialog = findViewById(R.id.textToastDialog);
                  textToastDialog.setTextColor(Color.RED);

                  Button textToastChoose = findViewById(R.id.textToastChoose);
                  textToastChoose.setTextColor(Color.RED);
              }
            }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                    Toast toast= Toast.makeText(getApplicationContext(),"Dialog closed", Toast.LENGTH_SHORT);

                    toast.setGravity(Gravity.BOTTOM, 0,0);
                    toast.show();
                }
            });
        AlertDialog alert = builder.create();
        alert.show();
    }
    public void onTextToastChoose(View view){
        String[] chooseItems = {"Bread", "croissant", "bulochka"};
        boolean[] selectedItems = {false, false, false};  //Boolean !== boolean => cringe

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        builder.setTitle("Title").setIcon(R.drawable.test_icon).setCancelable(true)
                .setMultiChoiceItems(chooseItems, selectedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        selectedItems[i]=b;
                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();

                        Button textToast2sec = findViewById(R.id.textToast2sec);
                        textToast2sec.setTextColor(Color.RED);

                        Button textToast3_5sec = findViewById(R.id.textToast3_5sec);
                        textToast3_5sec.setTextColor(Color.RED);

                        Button textToastDialog = findViewById(R.id.textToastDialog);
                        textToastDialog.setTextColor(Color.RED);

                        Button textToastChoose = findViewById(R.id.textToastChoose);
                        textToastChoose.setTextColor(Color.RED);
                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String selected="";
                        for (int j=0;j<chooseItems.length;j++){
                            if(selectedItems[0]){
                                Toast toast = Toast.makeText(getApplicationContext(), "Title", Toast.LENGTH_SHORT);
                                toast.show();
                            }
                            else {
                                Button textToast2sec = findViewById(R.id.textToast2sec);
                                textToast2sec.setVisibility(View.INVISIBLE);

                                Button textToast3_5sec = findViewById(R.id.textToast3_5sec);
                                textToast3_5sec.setVisibility(View.INVISIBLE);

                                Button textToastDialog = findViewById(R.id.textToastDialog);
                                textToastDialog.setVisibility(View.INVISIBLE);

                                Button textToastChoose = findViewById(R.id.textToastChoose);
                                textToastChoose.setVisibility(View.INVISIBLE);
                            }
                        }
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
}


