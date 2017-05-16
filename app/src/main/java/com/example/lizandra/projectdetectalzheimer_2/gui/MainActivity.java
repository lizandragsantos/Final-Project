package com.example.lizandra.projectdetectalzheimer_2.gui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;

import com.example.lizandra.projectdetectalzheimer_2.R;

public class MainActivity extends AppCompatActivity {
    Button btn_tmemoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        btn_tmemoria = (Button) findViewById(R.id.btn_tmemoria);
        cadIndividuo();


    }

    public void cadIndividuo() {
        btn_tmemoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //showMessage("teste", "É necessário informar os dados da pessoa a ser avaliada");
                Toast.makeText(getApplicationContext(), "É necessário informar os dados da pessoa a ser avaliada", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this, CadastroIndividuo.class);
                startActivity(i);
                //startActivity(new Intent(MainActivity.this,CadastroIndividuo.class));
            }
        });
    }

    public void showMessage(String title,String Message){
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}