package com.example.myapplication2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class cadastro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        Button botao = (Button) findViewById(R.id.cadastrar);

    botao.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
//            banco de Controller crud = new BancoController(gerBaseContext());
            EditText nome      = (EditText)findViewById(R.id.nome);
            EditText email     = (EditText)findViewById(R.id.email);
            EditText senha     = (EditText)findViewById(R.id.senha);
            EditText senhaConf = (EditText)findViewById(R.id.senhaConf);

            String nomeString  = nome.getText().toString();
            String emailString = email.getText().toString();
            String senhaString = senha.getText().toString();
            String senhaConfString = senhaConf.getText().toString();

            if (nomeString.isEmpty() || emailString.isEmpty() || senhaString.isEmpty() || senhaConfString.isEmpty()) {
                String resultado = "Preencha todos os campos";
                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
            }else{
                if (senhaString.equals(senhaConfString)) {
                    String resultado = "Cadastrou";
//                    String resultado = crud.insereDado(nomeString, emailString, senhaString);
                    Toast toast = Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0,0);
                    toast.show();
                } else {
                    String resultado = "Senhas não conferem";
                    Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
                }
            }
        }
    });
    }
//    public void retornaTela(View view) {
//        Intent intent = new Intent(this, login.class);
//        startActivity(intent);
//    }
}
