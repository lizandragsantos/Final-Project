package com.example.lizandra.projectdetectalzheimer_2.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lizandra.projectdetectalzheimer_2.R;

/**
 * Created by LIZANDRA on 26/06/2017.
 */

public class InstrucaoActivity extends AppCompatActivity {
    TextView txt_instrucao;
    Toolbar toolbar;
    Button btn_proximo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instrutest);
        initViews();
        proximo();
    }

    public void initViews(){
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        txt_instrucao = (TextView) findViewById(R.id.txt_instrucao);
        txt_instrucao.setText(R.string.instrucao);
        btn_proximo = (Button) findViewById(R.id.btn_finalizar);
        btn_proximo.setText(R.string.proximo);
        toolbar.setTitle("Instruções");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_left);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void proximo(){
        btn_proximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent auxIntent = getIntent();
                Intent intent = new Intent(InstrucaoActivity.this, AddMeemActivity.class);
                if (auxIntent != null) {
                    Bundle params = auxIntent.getExtras();
                    intent.putExtras(params);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(v.getContext(), "Dados não foram repassados", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
