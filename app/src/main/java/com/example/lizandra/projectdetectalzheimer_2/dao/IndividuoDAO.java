package com.example.lizandra.projectdetectalzheimer_2.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import android.widget.Toast;

import com.example.lizandra.projectdetectalzheimer_2.dominio.Individuo;
import com.example.lizandra.projectdetectalzheimer_2.dominio.TestMeem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LIZANDRA on 21/09/2017.
 */

public class IndividuoDAO {

    public static final String TAG = "IndividuoDAO";

    private Context context;

    // Database fields
    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;

    private String [] todasColunas = {dbHelper.COLUNA_COD_INDIVIDUO,
            dbHelper.COLUNA_NOME,
            dbHelper.COLUNA_SEXO,
            dbHelper.COLUNA_IDADE,
            dbHelper.COLUNA_ESCOLARIDADE};

    public IndividuoDAO(Context context) {
        this.context = context;
        dbHelper = new DatabaseHelper(this.context);

    }

    public void open() throws SQLiteException {

            database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public Individuo inserirIndividuo(String nome, String sexo, String escola, String idade){

        Long insertCod;
        Cursor cursor;
        ContentValues valores = new ContentValues();
        Individuo auxIndividuo;
        try {
            open();
            valores.put(dbHelper.COLUNA_NOME, nome);
            valores.put(dbHelper.COLUNA_SEXO, sexo);
            valores.put(dbHelper.COLUNA_ESCOLARIDADE, escola);
            valores.put(dbHelper.COLUNA_IDADE, idade);
            insertCod = database.insert(dbHelper.TABLE_INDIVIDUO, null, valores);
            cursor = database.query(dbHelper.TABLE_INDIVIDUO, todasColunas, dbHelper.COLUNA_COD_INDIVIDUO+" = "+insertCod, null, null,null, null);
            if (cursor != null){
                Toast.makeText(context.getApplicationContext(), "Dados do individuo salvo", Toast.LENGTH_SHORT).show();
            }
            cursor.moveToFirst();
            auxIndividuo = cursorToIndividuo(cursor);
        }
        finally {
            close();
        }
        return auxIndividuo;
    }

    public void atualizarIndividuo(Individuo individuo){
        Long codigo = individuo.getId();
        ContentValues valores = new ContentValues();

        try {
            open();
            valores.put(dbHelper.COLUNA_NOME, individuo.getNome());
            valores.put(dbHelper.COLUNA_SEXO, individuo.getSexo());
            valores.put(dbHelper.COLUNA_ESCOLARIDADE, individuo.getEscolaridade());
            valores.put(dbHelper.COLUNA_IDADE, individuo.getIdade());

            database.update(dbHelper.TABLE_INDIVIDUO, valores, dbHelper.COLUNA_COD_INDIVIDUO+" = "+codigo, null);
        }
        finally {
           close();
        }
    }

    public void deletarIndividuo(Individuo individuo){
        Long codigo = individuo.getId();
        List<TestMeem> listTestMeem;

        try {
            open();
            TestMeemDAO testMeemDAO = new TestMeemDAO(context);
            listTestMeem = testMeemDAO.getTestesofIndividuo(codigo);
            if ((listTestMeem != null)&&(!listTestMeem.isEmpty())){
                for (TestMeem e: listTestMeem) {
                    testMeemDAO.deletarTesteMeem(e);
                }
            }
            database.delete(dbHelper.TABLE_INDIVIDUO, dbHelper.COLUNA_COD_INDIVIDUO+" = "+codigo, null);
        }
        finally {
            close();
        }
    }

    public List<Individuo> listarIndividuos(){
        List<Individuo> listIndividuos = new ArrayList<Individuo>();
        Cursor cursor;

        try {
            open();
            cursor = database.query(dbHelper.TABLE_INDIVIDUO, todasColunas, null, null, null, null, null);
            if (cursor !=null){
                cursor.moveToFirst();
                while (!cursor.isAfterLast()){
                    Individuo auxIndividuo = cursorToIndividuo(cursor);
                    listIndividuos.add(auxIndividuo);
                    cursor.moveToNext();
                }
            }
        }
        finally {
            close();
        }

        return listIndividuos;
    }

    public Individuo getIndividuoById(Long id){
        Cursor cursor;
        Individuo auxIndividuo;

        try {
            open();
            cursor = database.query(dbHelper.TABLE_INDIVIDUO, todasColunas, dbHelper.COLUNA_COD_INDIVIDUO + " = ?", new String[] {String.valueOf(id)}, null, null, null);
            if (cursor != null) {
                cursor.moveToFirst();
            }
            else {
                Toast.makeText(context.getApplicationContext(), "ID não encontrado", Toast.LENGTH_SHORT).show();
            }
            auxIndividuo = cursorToIndividuo(cursor);
        }
        finally {
            close();
        }
        return auxIndividuo;
    }

    private Individuo cursorToIndividuo(Cursor cursor){
            Individuo individuo = new Individuo();
            individuo.setId(cursor.getLong(0));
            individuo.setNome(cursor.getString(1));
            individuo.setSexo(cursor.getString(2));
            individuo.setEscolaridade(cursor.getString(4));
            individuo.setIdade(cursor.getString(3));
        return individuo;
    }
}
