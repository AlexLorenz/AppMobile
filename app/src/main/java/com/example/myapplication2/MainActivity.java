package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Handler handler = new Handler();
//        handler.postDelayed(this,2000);
//        handler.postDelayed(this, 2000);
    }
    public void proximaTela(View view) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
//    @Override
//    public void run() {
//        startActivity(new Intent(this, Splashscreen.class));
//        finish();
//    }
}
