package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Handler;

import android.os.Bundle;

public class Splashscreen extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
        private void mostrarMainActivity() {
            Intent intent = new Intent(Splashscreen.this, MainActivity.class);
            startActivity(intent);
            finish();
        }

    @Override
    public void run() {
            mostrarMainActivity();
        }
        },2000);
    }
}
