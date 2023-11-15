package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.Manifest;

import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;


public class MainActivity extends AppCompatActivity {
    private ImageView image;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = findViewById(R.id.imageView);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{
                            Manifest.permission.CAMERA
                    },100);
                }
                else {
                    ScanOptions options = new ScanOptions();
                    options.setPrompt("Скан кода");
                    options.setBeepEnabled(true);
                    options.setOrientationLocked(true);
                    options.setCaptureActivity(CaptureAct.class);

                    barLauncher.launch(options);

                }
//                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                startActivityForResult(intent, 100);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 100) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            image.setImageBitmap(bitmap);
        }
    }
    ActivityResultLauncher<ScanOptions> barLauncher = registerForActivityResult(new ScanContract(),result ->{
        if (result.getContents()!=null){
              String qrText = result.getContents().toString();
//              String qrText = "123";


            if(qrText == "улица") {
                Intent intent = new Intent(MainActivity.this, StreetActivity.class);
                startActivity(intent);
            } else if (qrText == "аптека" ) {
                Intent intent = new Intent(MainActivity.this, HealActivity.class);
                startActivity(intent);
            } else if (qrText == "фонарь") {
                Intent intent = new Intent(MainActivity.this, LightActivity.class);
                startActivity(intent);
            }
            else {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Нет такой страницы");
                builder.setMessage(qrText);
                builder.show();
            }
        }
    });
}