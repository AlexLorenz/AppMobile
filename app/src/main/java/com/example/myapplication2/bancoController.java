package com.example.myapplication2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import static com.example.myapplication2.bancoDeDados.EMAIL;
import static com.example.myapplication2.bancoDeDados.SENHA;
import static com.example.myapplication2.bancoDeDados.TABELA;

public class bancoController {
    private SQLiteDatabase db;
    private bancoDeDados banco;

    public bancoController(Context context) {
        banco = new bancoDeDados(context);
    }

    public String insereDado(String nome, String email, String senha) {
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(bancoDeDados.NOME, nome);
        valores.put(EMAIL, email);
        valores.put(SENHA, senha);

        resultado = db.insert(TABELA, null, valores);
        db.close();

        if (resultado == -1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";
    }
    public Cursor fazerLogin(String email, String senha) {
        db = banco.getWritableDatabase();
        String sql = "SELECT * FROM " + TABELA + " WHERE "+ EMAIL +" = ? AND " + SENHA +" = ?";
        String[] selectionArgs = new String[]{ email, senha};
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        if(cursor != null) {
            cursor.moveToFirst();
            return cursor;
        } else {
            return null;
        }
    }
}
