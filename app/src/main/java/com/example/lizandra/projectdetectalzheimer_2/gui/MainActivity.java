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

import java.util.*;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btn_tmemoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        //btn_tmemoria = (Button) findViewById(R.id.btn_tmemoria);
        // cadIndividuo();
        ListView lista = (ListView) findViewById(R.id.listView);
        ArrayList<String> opt = preencherDados();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, opt);
        lista.setAdapter(arrayAdapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0: {
                        testMemoria();
                        break;
                    }
                    default:
                        finish();
                }
            }
        });

    }

    private ArrayList<String> preencherDados() {
        ArrayList<String> dados = new ArrayList<String>();
        dados.add("Teste de Memória");
        dados.add("Sair");
        return dados;
    }

    public void testMemoria(){
        Intent i = new Intent(MainActivity.this, InstruTest.class);
        startActivity(i);
    }

    /*public void cadIndividuo() {
        btn_tmemoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //showMessage("teste", "É necessário informar os dados da pessoa a ser avaliada");
                //Toast.makeText(getApplicationContext(), "É necessário informar os dados da pessoa a ser avaliada", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this, InstruTest.class);
                startActivity(i);
                //startActivity(new Intent(MainActivity.this,CadastroIndividuo.class));
            }
        });
    }*/
}