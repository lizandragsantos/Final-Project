package com.example.lizandra.projectdetectalzheimer_2.gui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.TextView;

import com.example.lizandra.projectdetectalzheimer_2.R;

/**
 * Created by LIZANDRA on 18/05/2017.
 */

public class TestMemoria extends AppCompatActivity {

    TextView texto;
    Button btn_1, btn_2, btn_3, btn_4, btn_voltar, btn_proximo;
    LinearLayout lcalculo;
    ImageView imageView;
    int i=0, clicked=0;
    float acerto=0, erro=0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testmemoria);
        texto = (TextView) findViewById(R.id.texto);
        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_2 = (Button) findViewById(R.id.btn_2);
        btn_3 = (Button) findViewById(R.id.btn_3);
        btn_4 = (Button) findViewById(R.id.btn_4);
        btn_voltar = (Button) findViewById(R.id.btn_cancelar);
        btn_proximo = (Button) findViewById(R.id.btn_proximo);
        lcalculo = (LinearLayout) findViewById(R.id.lcalculo);
        imageView = (ImageView) findViewById(R.id.imageView);

        habilitarViews(i);
        verificarBotaoClickado();
        proximo();

    }
    public void habilitarViews(int passo){
        setInvisible();

        switch (passo)
        {
            case 0:
            {
                texto.setText(getString(R.string.passo1));
                btn_1.setText(getString(R.string.acertou));
                btn_2.setText(getString(R.string.errou));
                setVisible(2);
                break;
            }
            case 1:
            {   calcPontuacao1();
                texto.setText(getString(R.string.passo2));
                btn_1.setText(getString(R.string.acertou));
                btn_2.setText(getString(R.string.errou));
                setVisible(2);
                break;
            }
            case 2:
            {
                calcPontuacao1();
                texto.setText(getString(R.string.passo3));
                btn_1.setText(getString(R.string.acertou));
                btn_2.setText(getString(R.string.errou));
                setVisible(2);
                break;
            }
            case 3:
            {
                calcPontuacao1();
                texto.setText(getString(R.string.passo4));
                btn_1.setText(getString(R.string.acertou));
                btn_2.setText(getString(R.string.errou));
                setVisible(2);
                break;
            }
            case 4:
            {
                calcPontuacao1();
                texto.setText(getString(R.string.passo5));
                btn_1.setText(getString(R.string.acertou));
                btn_2.setText(getString(R.string.errou));
                setVisible(2);
                break;
            }
            case 5:
            {
                calcPontuacao1();
                texto.setText(getString(R.string.passo6));
                btn_1.setText(getString(R.string.acertou));
                btn_2.setText(getString(R.string.errou));
                setVisible(2);
                break;
            }
            case 6:
            {
                calcPontuacao1();
                texto.setText(getString(R.string.passo7));
                btn_1.setText(getString(R.string.acertou));
                btn_2.setText(getString(R.string.errou));
                setVisible(2);
                break;
            }
            case 7:
            {
                calcPontuacao1();
                texto.setText(getString(R.string.passo8));
                btn_1.setText(getString(R.string.acertou));
                btn_2.setText(getString(R.string.errou));
                setVisible(2);
                break;
            }
            case 8:
            {
                calcPontuacao1();
                texto.setText(getString(R.string.passo9));
                btn_2.setText(getString(R.string.errou));
                setVisible(2);
                break;
            }
            case 9:
            {
                calcPontuacao1();
                texto.setText(getString(R.string.passo10));
                btn_1.setText(getString(R.string.acertou));
                btn_2.setText(getString(R.string.errou));
                setVisible(2);
                break;
            }
            case 10:
            {
                calcPontuacao1();
                texto.setText(getString(R.string.passo11));
                btn_1.setText(getString(R.string.objeto1));
                btn_2.setText(getString(R.string.objetos2));
                btn_3.setText(getString(R.string.objetos3));
                btn_4.setText(getString(R.string.nenhum));
                setVisible(4);
                break;
            }
            case 11:
            {
                calcPontuacao2();
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
                calcPontuacao4();
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
                calcPontuacao2();
                texto.setText(getString(R.string.passo14));
                btn_1.setText(getString(R.string.objeto1));
                btn_2.setText(getString(R.string.objetos2));
                btn_3.setText(getString(R.string.nenhum));
                setVisible(3);
                break;
            }
            case 15:
            {
                calcPontuacao3();
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
                calcPontuacao2();
                texto.setText(getString(R.string.passo15));
                btn_1.setText(getString(R.string.acertou));
                btn_2.setText(getString(R.string.errou));
                setVisible(2);
                break;
            }
            case 17:
            {
                calcPontuacao1();
                texto.setText(getString(R.string.passo16));
                btn_1.setText(getString(R.string.acertou));
                btn_2.setText(getString(R.string.errou));
                setVisible(2);
                break;
            }
            case 18:
            {
                calcPontuacao1();
                texto.setText(getString(R.string.passo18));
                btn_1.setText(getString(R.string.acertou));
                btn_2.setText(getString(R.string.errou));
                setVisible(2);
                break;
            }
            case 19:
            {
                calcPontuacao1();
                texto.setText(getString(R.string.passo19));
                imageView.setVisibility(View.VISIBLE);
                btn_1.setText(getString(R.string.acertou));
                btn_2.setText(getString(R.string.errou));
                setVisible(2);
                break;
            }
            default:
            {
                texto.setText("");
                calcPontuacao1();
                btn_proximo.setVisibility(View.VISIBLE);
            }

        }
    }
    public boolean voltar(){
        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i!=0){
                    habilitarViews(--i);
                }
                else {
                   finish();
                }
            }
        });
        return true;
    }
    public void proximo(){
        btn_proximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i<18){
                    clicked = 5;
                    habilitarViews(++i);
                    voltar();
                }
                else {
                    finish();
                }
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
        btn_voltar.setVisibility(View.INVISIBLE);

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
    public void calcPontuacao1(){
        if  (clicked==1){
            acerto++;
        }
        else {
            erro++;
        }
        Toast.makeText(TestMemoria.this,"Acertos: "+ acerto +"\nErros: "+erro, Toast.LENGTH_SHORT).show();
    }

    public void calcPontuacao2(){
        if  (clicked==1){
            acerto = acerto +1;
            erro = erro+2;
        }
        if (clicked==2){
            acerto = acerto +2;
            erro = erro+1;
        }
        if (clicked==3){
            acerto = acerto +3;
        }
        if (clicked==4){
            erro = erro+3;
        }
        Toast.makeText(TestMemoria.this,"Acertos: "+ acerto +"\nErros: "+erro, Toast.LENGTH_SHORT).show();
    }
    public void calcPontuacao3(){
        if (clicked==1){
            acerto = acerto +1;
            erro = erro+1;
        }
        if (clicked==2){
            acerto = acerto +2;
        }
        if (clicked==3){
            erro = erro+2;
        }
        Toast.makeText(TestMemoria.this,"Acertos: "+ acerto +"\nErros: "+erro, Toast.LENGTH_SHORT).show();
    }
    public void calcPontuacao4(){
        EditText calctxt_1, calctxt_2, calctxt_3, calctxt_4, calctxt_5;
        int n1,n2,n3,n4,n5;

        if (clicked==5)
        {
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

            if (n1==93){
                acerto++;
            }
            else {
                erro++;
            }
            if (n2==86){
                acerto++;
            }
            else {
                erro++;
            }
            if (n3==79){
                acerto++;
            }
            else {
                erro++;
            }
            if (n4==72){
                acerto++;
            }
            else {
                erro++;
            }
            if (n5==65){
                acerto++;
            }
            else {
                erro++;
            }
        }
        else if (clicked==1){
            acerto = acerto +5;
        }
        else if (clicked==2){
            erro = erro+5;
        }
        Toast.makeText(TestMemoria.this,"Acertos: "+ acerto +"\nErros: "+erro, Toast.LENGTH_SHORT).show();
    }
}
