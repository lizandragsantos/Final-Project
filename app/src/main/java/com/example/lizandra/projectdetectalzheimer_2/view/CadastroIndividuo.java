package com.example.lizandra.projectdetectalzheimer_2.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.lizandra.projectdetectalzheimer_2.R;

/**
 * Created by LIZANDRA on 18/03/2017.
 */

public class CadastroIndividuo extends AppCompatActivity {
    //Button btn_cancelar;
    Button btn_proximo;
    Toolbar toolbar;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadindividuo);

        toolbar = (Toolbar) findViewById(R.id.app_bar2);
        //toolbar.setNavigationIcon(R.drawable.ic_action_left);
        toolbar.setTitle("Cadastro");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        //btn_cancelar = (Button) findViewById(R.id.btn_cancelar);
        //cancelar();
        btn_proximo = (Button) findViewById(R.id.btn_proximo);
        proximo();
    }

    /*public void cancelar(){
        btn_cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }*/

    public void proximo(){
        btn_proximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CadastroIndividuo.this,Meem.class));
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:  //ID do seu botão (gerado automaticamente pelo android, usando como está, deve funcionar
                //startActivity(new Intent(this, InstruTest.class));  //O efeito ao ser pressionado do botão (no caso abre a activity)
                finish(); //Método para matar a activity e não deixa-lá indexada na pilhagem
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
