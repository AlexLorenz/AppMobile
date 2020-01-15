package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class tela3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela3);
//        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
//        setSupportActionBar(myToolbar);
//        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }
    public void proximaTela(View view) {
        Intent intent = new Intent(this, tela4.class);
        startActivity(intent);
    }
}
