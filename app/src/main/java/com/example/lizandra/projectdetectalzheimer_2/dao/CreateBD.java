package com.example.lizandra.projectdetectalzheimer_2.dao;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CreateBD extends SQLiteOpenHelper{
    private static final String NOME_BD = "ProjetcBD";
    private static final int VERSAO_BD = 1;

    private static String TABLE_PESSOA = "CREATE TABLE IF NOT EXIST pessoa(" +
            "id_pessoa INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            "nome TEXT NOT NULL," +
            "sexo TEXT NOT NULL);";

    private static String TABLE_INDIVIDUO = "CREATE TABLE IF NOT EXIST individuo(" +
            "id_individuo INTEGER NOT NULL PRIMARU KEY AUTOINCREMENT," +
            "escolaridade TEXT NOT NULL," +
            "idade INTEGER NOT NULL," +
            "id_pessoa INTEGER NOT NULL," +
            "FOREING KEY(id_pessoa) REFERENCES pessoa(id_pessoa));";

    private static String TABLE_TESTEMEEM = "CREATE TABLE IF NOT EXIST testemeem(" +
            "id_tsmeem INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            "data DATE NOT NULL," +
            "resultado INTEGER NOT NULL," +
            "acertos INTEGER NOT NULL," +
            "erros INTEGER NOT NULL;";

    private static String TABLE_TESTEMEMORIA = "CREATE TABLE testememoria(" +
            "id_tsmemoria INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            "id_individuo INTEGER NOT NULL," +
            "id_tsmeem INTEGER NOT NULL," +
            "FOREING KEY(id_individuo) REFERENCES individuo(id_individuo)," +
            "FOREING KEY(id_tsmeem) REFERENCES testemeem(id_tsmeem))";

    public CreateBD(Context context){
        super(context, NOME_BD, null, VERSAO_BD);
    }
    @Override
    public void onCreate(SQLiteDatabase bd) {
        bd.execSQL(TABLE_PESSOA);
        bd.execSQL(TABLE_INDIVIDUO);
        bd.execSQL(TABLE_TESTEMEEM);
        bd.execSQL(TABLE_TESTEMEMORIA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
