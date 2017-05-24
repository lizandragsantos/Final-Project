package com.example.lizandra.projectdetectalzheimer_2.gui;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import com.bluejamesbond.text.DocumentView;
import com.bluejamesbond.text.style.JustifiedSpan;
import com.bluejamesbond.text.style.TextAlignment;
import com.bluejamesbond.text.hyphen.DefaultHyphenator;
import com.bluejamesbond.text.hyphen.DefaultHyphenator.HyphenPattern;

import com.example.lizandra.projectdetectalzheimer_2.R;

/**
 * Created by LIZANDRA on 17/05/2017.
 */

public class InstruTest extends AppCompatActivity {
    Button btn_proximo;
    DocumentView dvText;
    WebView mWebView;
    TextView txt_instrucao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instrucao);

        btn_proximo = (Button) findViewById(R.id.btn_proximo);
        activityCadastro();

       /* txt_instrucao = (TextView) findViewById(R.id.txt_instrucao);

        Spannable span = new SpannableStringBuilder("   A pessoa a ser avaliada deve ser deixada à vontade, não deve ajuda-lo e eventuais erros cometidos por ele durante a prova não devem ser corrigidos, pois esta correção pode inibi-lo.\n" +
                "   Não esqueça de pegar uma folha de papel e uma caneta/lápis, pois será útil durante o teste.\n" +
                "   Lembrando que o teste não deve ser realizado pela pessoa que irá ser avaliada.\n");
        txt_instrucao.setText(span);


        Spannable span = new SpannableStringBuilder("   A pessoa a ser avaliada deve ser deixada à vontade, não deve ajuda-lo e eventuais erros cometidos por ele durante a prova não devem ser corrigidos, pois esta correção pode inibi-lo.\n" +
                 "   Não esqueça de pegar uma folha de papel e uma caneta/lápis, pois será útil durante o teste.\n" +
                 "   Lembrando que o teste não deve ser realizado pela pessoa que irá ser avaliada.\n\n" +
                 "  Será necessário informar os dados da pessoa a ser avaliada");
        dvText = (DocumentView) findViewById(R.id.dvText);
        dvText.setText(span);
        dvText.getDocumentLayoutParams().setHyphenator(DefaultHyphenator.getInstance(HyphenPattern.PT));
        dvText.getDocumentLayoutParams().setHyphenated(true);*/

       /* mWebView = (WebView) findViewById(R.id.txt_webview);

        String text = "<html><body>"
                + "<p align=\"justify\">    A pessoa a ser avaliada deve ser deixada à vontade, não deve ajuda-lo e eventuais erros cometidos por ele durante a prova não devem ser corrigidos, pois esta correção pode inibi-lo.</p> "
                + "<p align=\"justify\">    Não esqueça de pegar uma folha de papel e uma caneta/lápis, pois será útil durante o teste.</p>"
                + "<p align=\"justify\">    Lembrando que o teste não deve ser realizado pela pessoa que irá ser avaliada.</p>"
                + "</body></html>";

        mWebView.loadData(text, "text/html", "utf-8");*/

    }

    public void voltar(View view){
        finish();
    }

    public void activityCadastro(){
        btn_proximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InstruTest.this,CadastroIndividuo.class));
            }
        });
    }
}