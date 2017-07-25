package com.example.lizandra.projectdetectalzheimer_2.crud;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CreateBD extends SQLiteOpenHelper{
    private static final String NOME_BD = "ProjetcBD.db";
    private static final int VERSAO_BD = 1;

    public static final String TABLE_PESSOA = "paciente";
    public static final String COLUNA_ID_PESSOA = "id_pessoa";
    public static final String COLUNA_NOME = "nome";
    public static final String COLUNA_SEXO = "sexo";

    public static final String TABLE_INDIVIDUO = "individuo";
    public static final String COLUNA_ID_INDIVIDUO = "id_individuo";
    public static final String COLUNA_ID_PESSOA_1 = "id_pessoa";
    public static final String COLUNA_ESCOLARIDADE = "escolaridade";
    public static final String COLUNA_IDADE = "idade";

    public static final String TABLE_TESTE_MEEM = "teste_meem";
    public static final String COLUNA_ID_TESTE_MEEM = "id_teste_meem";
    public static final String COLUNA_DATA = "data";
    public static final String COLUNA_ORI_TEMPORAL = "ori_temporal";
    public static final String COLUNA_ORI_ESPACIAL = "ori_espacial";
    public static final String COLUNA_MEM_IMEDIATA = "mem_imediata";
    public static final String COLUNA_MEM_RECENTE = "mem_recente";
    public static final String COLUNA_CALCULO = "calculo";
    public static final String COLUNA_LINGUAGEM = "linguagem";
    public static final String COLUNA_ACERTOS = "acertos";
    public static final String COLUNA_ERROS = "erros";

    public static final String TABLE_TESTE_MEMORIA = "teste_memoria";
    public static final String COLUNA_ID_TESTE_MEMORIA = "id_teste_memoria";
    public static final String COLUNA_ID_TESTE_MEEM_1 = "id_teste_meem";
    public static final String COLUNA_ID_INDIVIDUO_1 = "id_individuo";

    private static String SQL_TABLE_PESSOA = "CREATE TABLE IF NOT EXIST "+TABLE_PESSOA+"(" +
            COLUNA_ID_PESSOA+" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            COLUNA_NOME+" TEXT NOT NULL," +
            COLUNA_SEXO+"sexo TEXT NOT NULL);";

    private static String SQL_TABLE_INDIVIDUO = "CREATE TABLE IF NOT EXIST "+TABLE_INDIVIDUO+"(" +
            COLUNA_ID_INDIVIDUO+" INTEGER NOT NULL PRIMARU KEY AUTOINCREMENT," +
            COLUNA_ID_PESSOA_1+" INTEGER NOT NULL," +
            COLUNA_ESCOLARIDADE+" TEXT NOT NULL," +
            COLUNA_IDADE+" INTEGER NOT NULL," +
            "FOREING KEY("+COLUNA_ID_PESSOA_1+") REFERENCES "+TABLE_PESSOA+"("+COLUNA_ID_PESSOA+"));";

    private static String SQL_TABLE_TESTE_MEEM = "CREATE TABLE IF NOT EXIST "+TABLE_TESTE_MEEM+"(" +
            COLUNA_ID_TESTE_MEEM+" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            COLUNA_DATA+" data DATE NOT NULL," +
            COLUNA_ORI_TEMPORAL+" DOUBLE NOT NULL," +
            COLUNA_ORI_ESPACIAL+" DOUBLE NOT NULL," +
            COLUNA_MEM_IMEDIATA+" DOUBLE NOT NULL," +
            COLUNA_MEM_RECENTE+" DOUBLE NOT NULL," +
            COLUNA_CALCULO+" DOUBLE NOT NULL," +
            COLUNA_LINGUAGEM+" DOUBLE NOT NULL," +
            COLUNA_ACERTOS+" DOUBLE NOT NULL," +
            COLUNA_ERROS+" DOUBLE NOT NULL;";

    private static String SQL_TABLE_TESTE_MEMORIA = "CREATE TABLE "+TABLE_TESTE_MEMORIA+"(" +
            COLUNA_ID_TESTE_MEMORIA+" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            COLUNA_ID_INDIVIDUO_1+" INTEGER NOT NULL," +
            COLUNA_ID_TESTE_MEEM_1+" INTEGER NOT NULL," +
            "FOREING KEY("+COLUNA_ID_INDIVIDUO_1+") REFERENCES "+TABLE_INDIVIDUO+"("+COLUNA_ID_INDIVIDUO+")," +
            "FOREING KEY("+COLUNA_ID_TESTE_MEEM_1+") REFERENCES "+TABLE_TESTE_MEEM+"("+COLUNA_ID_TESTE_MEEM+"))";

    public CreateBD(Context context){
        super(context, NOME_BD, null, VERSAO_BD);
    }
    @Override
    public void onCreate(SQLiteDatabase bd) {
        bd.execSQL(SQL_TABLE_PESSOA);
        bd.execSQL(SQL_TABLE_INDIVIDUO);
        bd.execSQL(SQL_TABLE_TESTE_MEEM);
        bd.execSQL(SQL_TABLE_TESTE_MEMORIA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase bd, int i, int i1) {
        bd.execSQL("drop table if exists " + TABLE_PESSOA);
        bd.execSQL("drop table if exists " + TABLE_INDIVIDUO);
        bd.execSQL("drop table if exists " + TABLE_TESTE_MEEM);
        bd.execSQL("drop table if exists " + TABLE_TESTE_MEMORIA);
        onCreate(bd);
    }

}
