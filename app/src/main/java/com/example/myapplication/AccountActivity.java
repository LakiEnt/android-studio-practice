package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class AccountActivity extends AppCompatActivity{

    private Button exit_btn;
    private TextView account_name;
    private TextView account_email;

    GoogleSignInOptions gso;
    GoogleSignInClient gsc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        exit_btn = findViewById(R.id.exitFromAccount);
        account_email = findViewById(R.id.account_email);
        account_name = findViewById(R.id.account_name);

        Bundle argument = getIntent().getExtras();
        account_name.setText(argument.get("name").toString());

        account_email.setText(argument.get("email").toString());


    }
    private void SignOut() {
        gsc.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                finish();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));

                Toast toast = Toast.makeText(getApplicationContext(), "Выход успешен", Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }
}
