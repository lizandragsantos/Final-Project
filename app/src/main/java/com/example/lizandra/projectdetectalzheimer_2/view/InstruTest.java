package com.example.lizandra.projectdetectalzheimer_2.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.view.MenuItem;
import android.widget.TextView;

import com.bluejamesbond.text.DocumentView;
import com.bluejamesbond.text.hyphen.DefaultHyphenator;
import com.example.lizandra.projectdetectalzheimer_2.R;

/**
 * Created by LIZANDRA on 26/06/2017.
 */

public class InstruTest extends AppCompatActivity {
    TextView txt_instrucao;
    String instrucao;
    Toolbar toolbar;
    Spannable span;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instrutest);
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        //toolbar.setNavigationIcon(R.drawable.ic_action_left);
        toolbar.setTitle("Instruções");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        instrucao = "   Mine Exame de Estado Mental, também conhecido pela sigla MEEM, este é o teste mais utilizado para avaliar a função cognitiva por ser rápido e de fácil aplicação. Deve ser utilizado como instrumento de rastreamento não substituindo uma avaliação mais detalhada, não serve como teste diagnóstico, mas sim pra indicar funções que precisam ser investigadas.\n" +
                "   A pessoa a ser avaliada deve ser deixada à vontade, não deve ajuda-lo e eventuais erros cometidos por ele durante a prova não devem ser corrigidos, pois esta correção pode inibi-lo.\n" +
                "   Não esqueça de pegar uma folha de papel e uma caneta/lápis, pois será útil durante o teste.\n" +
                "   Lembrando que o teste não deve ser realizado pela pessoa que irá ser avaliada.\n";

        span = new SpannableStringBuilder(instrucao);
        txt_instrucao = (TextView) findViewById(R.id.txt_instrucao);
        txt_instrucao.setText(span);
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
