package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.textclassifier.TextLinks;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OkHttpHandler handler = new OkHttpHandler();
                handler.execute();

            }
        });
    }
    public class OkHttpHandler extends AsyncTask<Void, Void, String>{

        @Override
        protected String doInBackground(Void ... voids) {
            Request.Builder builder = new Request.Builder();

            Request request = builder.url("https://fakestoreapi.com/products/1").get().build();

            OkHttpClient client = new OkHttpClient().newBuilder().build();

            try {
                Response response = client.newCall(request).execute();
                JSONObject object = new JSONObject(response.body().string());

                String fullstring = "Название товара:" + "\n" + object.getString("title") + "\n" + "Цена товара:" + "\n" + object.getString("price");
                return fullstring;

            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
        @Override
        protected void onPostExecute(String o){
            super.onPostExecute(o);
            textView.setText(o);
        }
    }
}