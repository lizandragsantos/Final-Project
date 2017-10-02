package com.example.lizandra.projectdetectalzheimer_2.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import java.sql.Date;
import java.text.SimpleDateFormat;

import com.example.lizandra.projectdetectalzheimer_2.dominio.Individuo;
import com.example.lizandra.projectdetectalzheimer_2.dominio.TestMeem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LIZANDRA on 21/09/2017.
 */

public class TestMeemDAO {
    public static final String TAG = "TestMeemDAO";

    private Context context;

    // Database fields
    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;

    private String [] todasColunas = {dbHelper.COLUNA_COD_TESTE_MEEM,
            dbHelper.COLUNA_DATA,
            dbHelper.COLUNA_ORI_TEMPORAL,
            dbHelper.COLUNA_ORI_ESPACIAL,
            dbHelper.COLUNA_MEM_IMEDIATA,
            dbHelper.COLUNA_MEM_RECENTE,
            dbHelper.COLUNA_CALCULO,
            dbHelper.COLUNA_LINGUAGEM,
            dbHelper.COLUNA_ACERTOS,
            dbHelper.COLUNA_ERROS,
            dbHelper.COLUNA_COD_INDIVIUO_1};

    public TestMeemDAO(Context context) {
        this.context = context;
        dbHelper = new DatabaseHelper(this.context);
        try {
            open();
        }
        catch (SQLiteException e){
            Log.e(TAG, "SQLException ao abrir o banco de dados " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void open(){

        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public TestMeem inserirTestMeem( int ori_temporal, int ori_espacial, int mem_imediata, int mem_recente, int calculo, int linguagem, int acertos, int erros, Long cod_individuo){
        Long insertCod;
        Cursor cursor;
        TestMeem auxTestMeem;
        Date auxData = new Date(System.currentTimeMillis());
        SimpleDateFormat formatarDate = new SimpleDateFormat("dd-MM-yyyy");
        String data = formatarDate.format(auxData);
        ContentValues valores = new ContentValues();
        try {
            open();
            valores.put(dbHelper.COLUNA_DATA, data);
            valores.put(dbHelper.COLUNA_ORI_TEMPORAL, ori_temporal);
            valores.put(dbHelper.COLUNA_ORI_ESPACIAL, ori_espacial);
            valores.put(dbHelper.COLUNA_MEM_IMEDIATA, mem_imediata);
            valores.put(dbHelper.COLUNA_MEM_RECENTE, mem_recente);
            valores.put(dbHelper.COLUNA_CALCULO, calculo);
            valores.put(dbHelper.COLUNA_LINGUAGEM, linguagem);
            valores.put(dbHelper.COLUNA_ACERTOS, acertos);
            valores.put(dbHelper.COLUNA_ERROS, erros);
            valores.put(dbHelper.COLUNA_COD_INDIVIUO_1, cod_individuo);
            insertCod = database.insert(dbHelper.TABLE_TESTE_MEEM, null, valores);
            cursor = database.query(dbHelper.TABLE_TESTE_MEEM, todasColunas, dbHelper.COLUNA_COD_TESTE_MEEM+" = "+insertCod, null, null,null, null);
            cursor.moveToFirst();
            auxTestMeem = cursorToTestMemm(cursor);
        }
        finally {
            close();
        }

        return auxTestMeem;
    }
    public void deletarTesteMeem(TestMeem testMeem){
        Long codigo = testMeem.getId();
        try {
            open();
            database.delete(dbHelper.TABLE_TESTE_MEEM, dbHelper.COLUNA_COD_TESTE_MEEM+" = "+codigo, null);
        }
        finally {
            close();
        }
    }

    public List<TestMeem> ListTestes(){
        List<TestMeem> listTestes = new ArrayList<TestMeem>();
        Cursor cursor;
        TestMeem auxTestmeem;
        try {
            open();
            cursor = database.query(dbHelper.TABLE_TESTE_MEEM, todasColunas, dbHelper.COLUNA_COD_INDIVIUO_1+" = ?", null, null, null, null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                auxTestmeem = cursorToTestMemm(cursor);
                listTestes.add(auxTestmeem);
                cursor.moveToNext();
            }
        }
        finally {
            close();
        }
        return listTestes;
    }

    public List<TestMeem> getTestesofIndividuo(Long cod_individuo){
        List<TestMeem> listTestes = new ArrayList<TestMeem>();
        Cursor cursor;
        TestMeem auxTestmeem;
        try {
            open();
            cursor = database.query(dbHelper.TABLE_TESTE_MEEM, todasColunas, dbHelper.COLUNA_COD_INDIVIUO_1+" = ?", new String[]{String.valueOf(cod_individuo)}, null, null, null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                auxTestmeem = cursorToTestMemm(cursor);
                listTestes.add(auxTestmeem);
                cursor.moveToNext();
            }
        }
        finally {
            close();
        }
        return listTestes;
    }

    private TestMeem cursorToTestMemm(Cursor cursor){
        TestMeem testMeem;
        Long cod_individuo;
        IndividuoDAO individuoDAO = new IndividuoDAO(context);
        Individuo auxIndividuo;

        cod_individuo = cursor.getLong(10);
        auxIndividuo = individuoDAO.getIndividuoById(cod_individuo);
        testMeem = new TestMeem(auxIndividuo);
        testMeem.setId(cursor.getLong(0));
        testMeem.setData(cursor.getString(1));
        testMeem.setOri_temporal(cursor.getInt(2));
        testMeem.setOri_espacial(cursor.getInt(3));
        testMeem.setMem_imediata(cursor.getInt(4));
        testMeem.setMem_recente(cursor.getInt(5));
        testMeem.setCalculo(cursor.getInt(6));
        testMeem.setLinguagem(cursor.getInt(7));
        testMeem.setAcertos(cursor.getInt(8));
        testMeem.setErros(cursor.getInt(9));

        return testMeem;
    }
}
