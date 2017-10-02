package com.example.lizandra.projectdetectalzheimer_2.dao;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class DatabaseHelper extends SQLiteOpenHelper{

    private static DatabaseHelper instancia = null;
    public static final String TAG = "DBHelper";
    private static final String NOME_BD = "ProjetcBD.db";
    private static final int VERSAO_BD = 3;



    public static final String TABLE_INDIVIDUO = "individuo";
    public static final String COLUNA_COD_INDIVIDUO = "codigo";
    public static final String COLUNA_NOME = "nome";
    public static final String COLUNA_SEXO = "sexo";
    public static final String COLUNA_ESCOLARIDADE = "escolaridade";
    public static final String COLUNA_IDADE = "idade";

    public static final String TABLE_TESTE_MEEM = "teste_meem";
    public static final String COLUNA_COD_TESTE_MEEM = COLUNA_COD_INDIVIDUO;
    public static final String COLUNA_DATA = "data";
    public static final String COLUNA_ORI_TEMPORAL = "ori_temporal";
    public static final String COLUNA_ORI_ESPACIAL = "ori_espacial";
    public static final String COLUNA_MEM_IMEDIATA = "mem_imediata";
    public static final String COLUNA_MEM_RECENTE = "mem_recente";
    public static final String COLUNA_CALCULO = "calculo";
    public static final String COLUNA_LINGUAGEM = "linguagem";
    public static final String COLUNA_ACERTOS = "acertos";
    public static final String COLUNA_ERROS = "erros";
    public static final String COLUNA_COD_INDIVIUO_1 = "cod_individuo";

    private static final String SQL_TABLE_INDIVIDUO = "CREATE TABLE "+TABLE_INDIVIDUO+"(" +
            COLUNA_COD_INDIVIDUO +" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            COLUNA_NOME+" TEXT NOT NULL," +
            COLUNA_SEXO+" TEXT NOT NULL," +
            COLUNA_ESCOLARIDADE+" TEXT NOT NULL," +
            COLUNA_IDADE+" TEXT NOT NULL);";

    private static final String SQL_TABLE_TESTE_MEEM = "CREATE TABLE "+TABLE_TESTE_MEEM+"(" +
            COLUNA_COD_TESTE_MEEM +" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            COLUNA_COD_INDIVIUO_1 +" INTEGER NOT NULL," +
            COLUNA_DATA+" DATE NOT NULL," +
            COLUNA_ORI_TEMPORAL+" INTEGER NOT NULL," +
            COLUNA_ORI_ESPACIAL+" INTEGER NOT NULL," +
            COLUNA_MEM_IMEDIATA+" INTEGER NOT NULL," +
            COLUNA_MEM_RECENTE+" INTEGER NOT NULL," +
            COLUNA_CALCULO+" INTEGER NOT NULL," +
            COLUNA_LINGUAGEM+" INTEGER NOT NULL," +
            COLUNA_ACERTOS+" INTEGER NOT NULL," +
            COLUNA_ERROS+" INTEGER NOT NULL," +
            "FOREIGN KEY("+ COLUNA_COD_INDIVIUO_1 +") REFERENCES "+TABLE_INDIVIDUO+"("+ COLUNA_COD_INDIVIDUO +"));";


    public DatabaseHelper(Context context){
        super(context, NOME_BD, null, VERSAO_BD);
    }

   /* public static DatabaseHelper getInstancia(Context context){
        if (DatabaseHelper.instancia == null){
            DatabaseHelper.instancia = new DatabaseHelper(context.getApplicationContext());
            Toast.makeText(context.getApplicationContext(), "Banco de dados do criado", Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(context.getApplicationContext(), "Banco de dados do instanciado", Toast.LENGTH_SHORT).show();
        return instancia;
    }*/
    @Override
    public void onCreate(SQLiteDatabase bd) {
        bd.execSQL(SQL_TABLE_INDIVIDUO);
        bd.execSQL(SQL_TABLE_TESTE_MEEM);
    }

    @Override
    public void onUpgrade(SQLiteDatabase bd, int i, int i1) {
        bd.execSQL("drop table if exists " + TABLE_INDIVIDUO);
        bd.execSQL("drop table if exists " + TABLE_TESTE_MEEM);
        onCreate(bd);
    }

}
