package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;

public class tela2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);
    }
    public void proximaTela(View view) {
        Intent intent = new Intent(this, drawer.class);
        startActivity(intent);
    }
}
