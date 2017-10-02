package com.example.lizandra.projectdetectalzheimer_2.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lizandra.projectdetectalzheimer_2.R;
import com.example.lizandra.projectdetectalzheimer_2.dao.IndividuoDAO;
import com.example.lizandra.projectdetectalzheimer_2.dao.TestMeemDAO;
import com.example.lizandra.projectdetectalzheimer_2.dominio.Individuo;
import com.example.lizandra.projectdetectalzheimer_2.dominio.TestMeem;

/**
 * Created by LIZANDRA on 18/05/2017.
 */

public class AddMeemActivity extends AppCompatActivity {

    private TextView texto;
    private Button btn_1, btn_2, btn_3, btn_4, btn_finalizar, btn_proximo;
    private LinearLayout lcalculo;
    private ImageView imageView;
    private int i, clicked=0;
    private TestMeem meem;
    private TestMeemDAO testMeemDAO;
    private IndividuoDAO individuoDAO;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtestmeem);
        this.testMeemDAO = new TestMeemDAO(this);
        this.individuoDAO = new IndividuoDAO(this);
        initView();
        receberDadosIndividuo();
        habilitarViews(i);
        verificarBotaoClickado();
        proximo();
        finalizar();

    }

    public void initView(){
        texto = (TextView) findViewById(R.id.texto);
        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_2 = (Button) findViewById(R.id.btn_2);
        btn_3 = (Button) findViewById(R.id.btn_3);
        btn_4 = (Button) findViewById(R.id.btn_4);
        btn_finalizar = (Button) findViewById(R.id.btn_finalizar);
        btn_finalizar.setText(R.string.finalizar);
        btn_proximo = (Button) findViewById(R.id.btn_proximo);
        btn_proximo.setText(R.string.proximo);
        lcalculo = (LinearLayout) findViewById(R.id.lcalculo);
        imageView = (ImageView) findViewById(R.id.imageView);
    }
    public void habilitarViews(int passo){

        setInvisible();
        int n1 =0, n2 = 0, n3 = 0, n4 = 0, n5 = 0;

        switch (passo)
        {
            case 0:
            {
                //orientação temporal
                texto.setText(getString(R.string.passo1));
                btn_1.setText(getString(R.string.acertou));
                btn_2.setText(getString(R.string.errou));
                setVisible(2);
                break;
            }
            case 1:
            {   meem.realizarTeste(1,clicked,0,0,0,0,0,0);
                texto.setText(getString(R.string.passo2));
                btn_1.setText(getString(R.string.acertou));
                btn_2.setText(getString(R.string.errou));
                setVisible(2);
                break;
            }
            case 2:
            {
                meem.realizarTeste(1,clicked,0,0,0,0,0,0);
                texto.setText(getString(R.string.passo3));
                btn_1.setText(getString(R.string.acertou));
                btn_2.setText(getString(R.string.errou));
                setVisible(2);
                break;
            }
            case 3:
            {
                meem.realizarTeste(1,clicked,0,0,0,0,0,0);
                texto.setText(getString(R.string.passo4));
                btn_1.setText(getString(R.string.acertou));
                btn_2.setText(getString(R.string.errou));
                setVisible(2);
                break;
            }
            case 4:
            {
                meem.realizarTeste(1,clicked,0,0,0,0,0,0);
                texto.setText(getString(R.string.passo5));
                btn_1.setText(getString(R.string.acertou));
                btn_2.setText(getString(R.string.errou));
                setVisible(2);
                break;
            }
            case 5:
            {
                //orientação espacial
                meem.realizarTeste(1,clicked,0,0,0,0,0,0);
                texto.setText(getString(R.string.passo6));
                btn_1.setText(getString(R.string.acertou));
                btn_2.setText(getString(R.string.errou));
                setVisible(2);
                break;
            }
            case 6:
            {
                meem.realizarTeste(2,clicked,0,0,0,0,0,0);
                texto.setText(getString(R.string.passo7));
                btn_1.setText(getString(R.string.acertou));
                btn_2.setText(getString(R.string.errou));
                setVisible(2);
                break;
            }
            case 7:
            {
                meem.realizarTeste(2,clicked,0,0,0,0,0,0);
                texto.setText(getString(R.string.passo8));
                btn_1.setText(getString(R.string.acertou));
                btn_2.setText(getString(R.string.errou));
                setVisible(2);
                break;
            }
            case 8:
            {
                meem.realizarTeste(2,clicked,0,0,0,0,0,0);
                texto.setText(getString(R.string.passo9));
                btn_2.setText(getString(R.string.errou));
                setVisible(2);
                break;
            }
            case 9:
            {
                meem.realizarTeste(2,clicked,0,0,0,0,0,0);
                texto.setText(getString(R.string.passo10));
                btn_1.setText(getString(R.string.acertou));
                btn_2.setText(getString(R.string.errou));
                setVisible(2);
                break;
            }
            case 10:
            {
                //memoria imediata
                meem.realizarTeste(2,clicked,0,0,0,0,0,0);
                texto.setText(getString(R.string.passo11));
                btn_1.setText(getString(R.string.objeto1));
                btn_2.setText(getString(R.string.objetos2));
                btn_3.setText(getString(R.string.objetos3));
                btn_4.setText(getString(R.string.nenhum));
                setVisible(4);
                break;
            }
            case 11:
            {   //calculo
                meem.realizarTeste(3,clicked,0,0,0,0,0,0);
                texto.setText(getString(R.string.passo12));
                btn_1.setText(getString(R.string.sim));
                btn_2.setText(getString(R.string.nao));
                setVisible(2);
                break;
            }
            case 12:{
                escolherPasso12();
                break;
            }
            case 13:
            {
                setValorCalculo(n1, n2, n3, n4, n5);
                meem.realizarTeste(5,clicked,0,n1,n2,n3,n4,n5);
                texto.setText(getString(R.string.passo13));
                btn_1.setText(getString(R.string.objeto1));
                btn_2.setText(getString(R.string.objetos2));
                btn_3.setText(getString(R.string.objetos3));
                btn_4.setText(getString(R.string.nenhum));
                setVisible(4);
                break;
            }
            case 14:
            {
                //memoria recente
                meem.realizarTeste(4,clicked,0,0,0,0,0,0);
                texto.setText(getString(R.string.passo14));
                btn_1.setText(getString(R.string.objeto1));
                btn_2.setText(getString(R.string.objetos2));
                btn_3.setText(getString(R.string.nenhum));
                setVisible(3);
                break;
            }
            case 15:
            {
                //linguagem
                meem.realizarTeste(6,clicked,3,0,0,0,0,0);
                texto.setText(getString(R.string.passo17));
                btn_1.setText(getString(R.string.acao1));
                btn_2.setText(getString(R.string.acoes2));
                btn_3.setText(getString(R.string.acoes3));
                btn_4.setText(getString(R.string.nenhum));
                setVisible(4);
                break;
            }
            case 16:
            {
                meem.realizarTeste(6,clicked,2,0,0,0,0,0);
                texto.setText(getString(R.string.passo15));
                btn_1.setText(getString(R.string.acertou));
                btn_2.setText(getString(R.string.errou));
                setVisible(2);
                break;
            }
            case 17:
            {
                meem.realizarTeste(6,clicked,1,0,0,0,0,0);
                texto.setText(getString(R.string.passo16));
                btn_1.setText(getString(R.string.acertou));
                btn_2.setText(getString(R.string.errou));
                setVisible(2);
                break;
            }
            case 18:
            {
                meem.realizarTeste(6,clicked,1,0,0,0,0,0);
                texto.setText(getString(R.string.passo18));
                btn_1.setText(getString(R.string.acertou));
                btn_2.setText(getString(R.string.errou));
                setVisible(2);
                break;
            }
            case 19:
            {
                meem.realizarTeste(6,clicked,1,0,0,0,0,0);
                texto.setText(getString(R.string.passo19));
                imageView.setVisibility(View.VISIBLE);
                btn_1.setText(getString(R.string.acertou));
                btn_2.setText(getString(R.string.errou));
                setVisible(2);
                break;
            }
            default:
            {
                meem.realizarTeste(6,clicked,1,0,0,0,0,0);
                btn_finalizar.setVisibility(View.VISIBLE);
                texto.setText(getString(R.string.diagnostico)+"\n\nResultdo da avaliação cognitiva\n\nOrientação Temporal: "+meem.getOri_temporal()+"\nOrientação Espacial: "+meem.getOri_espacial()+"\nMemória Imediata: "+meem.getMem_imediata()+"\nCalculo: "+meem.getCalculo()+"\nMemória Recente: "+meem.getMem_recente()+"\nLinguagem: "+meem.getLinguagem()+"\nAcertos: "+meem.getAcertos()+"\nErros: "+meem.getErros());
            }

        }
    }
    public void finalizar(){
        btn_finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                meem = testMeemDAO.inserirTestMeem( meem.getOri_temporal(), meem.getOri_espacial(), meem.getMem_imediata(), meem.getMem_recente(), meem.getCalculo(), meem.getLinguagem(), meem.getAcertos(), meem.getErros(),meem.getIndividuo().getId());
                setResult(RESULT_OK);
                finish();
            }
        });
    }
    public void proximo(){
        btn_proximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked = 5;
                habilitarViews(++i);
            }
        });
    }

    public void setInvisible(){
        btn_1.setVisibility(View.INVISIBLE);
        btn_2.setVisibility(View.INVISIBLE);
        btn_3.setVisibility(View.INVISIBLE);
        btn_4.setVisibility(View.INVISIBLE);
        imageView.setVisibility(View.INVISIBLE);
        lcalculo.setVisibility(View.INVISIBLE);
        btn_proximo.setVisibility(View.INVISIBLE);
        btn_finalizar.setVisibility(View.INVISIBLE);

    }
    public void setVisible(int botoes){
        if (botoes==2){
            btn_1.setVisibility(View.VISIBLE);
            btn_2.setVisibility(View.VISIBLE);
        }
        if (botoes==3){
            btn_1.setVisibility(View.VISIBLE);
            btn_2.setVisibility(View.VISIBLE);
            btn_3.setVisibility(View.VISIBLE);
        }
        if (botoes==4){
            btn_1.setVisibility(View.VISIBLE);
            btn_2.setVisibility(View.VISIBLE);
            btn_3.setVisibility(View.VISIBLE);
            btn_4.setVisibility(View.VISIBLE);
        }
    }

    public int verificarBotaoClickado(){

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked = 1;
                habilitarViews(++i);

            }
        });
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked = 2;
                habilitarViews(++i);
            }
        });
        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked = 3;
                habilitarViews(++i);
            }
        });
        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked = 4;
                habilitarViews(++i);
            }
        });

        return clicked;
    }
    public void escolherPasso12(){
        if (clicked==1){
            texto.setText(getString(R.string.passo12a));
            lcalculo.setVisibility(View.VISIBLE);
            btn_proximo.setVisibility(View.VISIBLE);
        }
        else if (clicked==2){
            texto.setText(getString(R.string.passo12b));
            btn_1.setText(getString(R.string.acertou));
            btn_2.setText(getString(R.string.errou));
            setVisible(2);
        }
    }

   public void setValorCalculo(int n1, int n2, int n3, int n4, int n5){
       EditText calctxt_1, calctxt_2, calctxt_3, calctxt_4, calctxt_5;

       calctxt_1 = (EditText) findViewById(R.id.calctxt_1);
       calctxt_2 = (EditText) findViewById(R.id.calctxt_2);
       calctxt_3 = (EditText) findViewById(R.id.calctxt_3);
       calctxt_4 = (EditText) findViewById(R.id.calctxt_4);
       calctxt_5 = (EditText) findViewById(R.id.calctxt_5);

       if (calctxt_1.getText().toString().isEmpty())
           n1=0;
       else
           n1 = Integer.parseInt(calctxt_1.getText().toString());
       if (calctxt_2.getText().toString().isEmpty())
           n2=0;
       else
           n2 = Integer.parseInt(calctxt_2.getText().toString());
       if (calctxt_3.getText().toString().isEmpty())
           n3=0;
       else
           n3 = Integer.parseInt(calctxt_3.getText().toString());
       if (calctxt_4.getText().toString().isEmpty())
           n4=0;
       else
           n4 = Integer.parseInt(calctxt_4.getText().toString());
       if (calctxt_5.getText().toString().isEmpty())
           n5=0;
       else
           n5 = Integer.parseInt(calctxt_5.getText().toString());

   }

    public void receberDadosIndividuo(){

       Intent intent = getIntent();
        Individuo auxIndividuo;
       if (intent != null){
           Bundle params = intent.getExtras();
           Long id = params.getLong("id");
           auxIndividuo = individuoDAO.getIndividuoById(id);
           if (auxIndividuo == null){
               Toast.makeText(getApplicationContext(),"individuo nulo", Toast.LENGTH_SHORT).show();
           }else {
               meem = new TestMeem(auxIndividuo);
           }


       }
   }

}
