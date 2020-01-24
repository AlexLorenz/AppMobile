package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void login(View view) {
        EditText email = findViewById(R.id.emailLogin);
        EditText senha = findViewById(R.id.senhaLogin);
        String strEmail = email.getText().toString();
        String strSenha = senha.getText().toString();
        boolean erro = false;

        if(strEmail.length() > 0 && strSenha.length() > 0) {
            bancoController crud = new bancoController(getBaseContext());
            Cursor cursor = crud.fazerLogin(strEmail, strSenha);
            if(cursor == null || cursor.getCount() == 0) {
                erro = true;
            } else {
                String resEmail = cursor.getString(cursor.getColumnIndex("email"));
                String resSenha = cursor.getString(cursor.getColumnIndex("senha"));

                if(strEmail.equals(resEmail) && strSenha.equals(resSenha)) {
                    Toast.makeText(this, "Seja bem vindo.", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(this, Drawer.class);
                    startActivity(intent);
                } else {
                    erro = true;
                }
            }
        } else {
            erro = true;
        }
        if (erro) {
            Toast.makeText(getApplicationContext(), "Credenciais incorretas.", Toast.LENGTH_LONG).show();
        }
    }

//    public void proximaTela(View view) {
//        Intent intent = new Intent(this, Drawer.class);
//        startActivity(intent);
//    }
    public void telaCadastro(View view) {
        Intent intent = new Intent(this, cadastro.class);
        startActivity(intent);
    }
}
