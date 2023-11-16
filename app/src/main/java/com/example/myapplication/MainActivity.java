package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private DBHelper helper;
    private SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper=new DBHelper(getApplicationContext());
        try {
            database=helper.getWritableDatabase();
        } catch (Exception e){
            e.printStackTrace();

        }

        Button button = findViewById(R.id.button);
        listView = findViewById(R.id.listview);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<HashMap<String,String>> list=new ArrayList<>();
                HashMap <String, String> list_item;

                Cursor cursor = database.rawQuery("SELECT id,name,quantity FROM clothes",null);
                cursor.moveToFirst();

                while (!cursor.isAfterLast()){
                    list_item=new HashMap<>();
                    list_item.put("name", cursor.getString(1));
                    list_item.put("quantity", cursor.getString(2));

                    list.add(list_item);
                    cursor.moveToNext();
                }
                cursor.close();

                SimpleAdapter adapter = new SimpleAdapter(
                        getApplicationContext(),
                        list, android.R.layout.simple_list_item_2,
                        new String[]{"name", "time"},
                        new int[] {android.R.id.text1, android.R.id.text2}
                );
                listView.setAdapter(adapter);
            }
        });
    }
}