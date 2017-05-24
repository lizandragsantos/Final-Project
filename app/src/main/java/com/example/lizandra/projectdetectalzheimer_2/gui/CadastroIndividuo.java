package com.example.lizandra.projectdetectalzheimer_2.gui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.lizandra.projectdetectalzheimer_2.R;

/**
 * Created by LIZANDRA on 18/03/2017.
 */

public class CadastroIndividuo extends AppCompatActivity {
    Button btn_cancelar, btn_concluir;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadindividuo);

        btn_cancelar = (Button) findViewById(R.id.btn_cancelar);
        cancelar();
        btn_concluir = (Button) findViewById(R.id.btn_concluir);
        concluir();
    }

    public void cancelar(){
        btn_cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void concluir(){
        btn_concluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CadastroIndividuo.this,TestMemoria.class));
            }
        });
    }

}
