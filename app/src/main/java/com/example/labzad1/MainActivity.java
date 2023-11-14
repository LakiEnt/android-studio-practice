package com.example.labzad1;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.TextView;


import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.labzad1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private static final int NOTIFY_ID = 101;
    private static String CHANNEL_ID = "aaaaaa";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

    public void sendForm(View view) {
        TextView fio = findViewById(R.id.editTextText2);
        TextView email = findViewById(R.id.editTextText);

        email.setText(null);
        fio.setText(null);

        Toast myToast = Toast.makeText(getApplicationContext(), "Sucsess!!", Toast.LENGTH_SHORT);

        myToast.setGravity(Gravity.BOTTOM, 0, 100);
        myToast.show();
    }

    public void openDialog(View view) {
        String[] chooseItems = {"Da", "Net"};
        boolean[] selectedItems = {false, false};

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        builder.setTitle("Queres").setCancelable(true)
                .setMultiChoiceItems(chooseItems, selectedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        selectedItems[i] = b;
                    }
                })
                .setPositiveButton("podtverdit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                        Toast myToast = Toast.makeText(getApplicationContext(), "Вау молодец правильно j", Toast.LENGTH_SHORT);

                        myToast.setGravity(Gravity.TOP, 0, 100);
                        myToast.show();
                    }
                }).setNegativeButton("otmena", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
//                        String selected="";
//                        for (int j=0;j<chooseItems.length;j++){
//                            if(selectedItems[0]){
//                                Toast toast = Toast.makeText(getApplicationContext(), "Title", Toast.LENGTH_SHORT);
//                                toast.show();
//                            }
//                        }
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }


    public void sendPush(View view) {
        Toast myToast = Toast.makeText(getApplicationContext(), "aga", Toast.LENGTH_SHORT);
        myToast.setGravity(Gravity.BOTTOM, 0, 100);
        myToast.show();

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(MainActivity.this, CHANNEL_ID)
                        .setSmallIcon(R.drawable.ic_home_black_24dp)
                        .setContentTitle("123")
                        .setContentText("456")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManager =
                NotificationManagerCompat.from(MainActivity.this);

        notificationManager.notify(NOTIFY_ID, builder.build());
    }
}