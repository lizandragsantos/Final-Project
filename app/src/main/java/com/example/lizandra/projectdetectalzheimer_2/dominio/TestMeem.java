package com.example.lizandra.projectdetectalzheimer_2.dominio;

import java.io.Serializable;
import java.util.Date;

public class TestMeem extends TestMemoria implements Serializable {
    private String data;
    private int ori_temporal;
    private int ori_espacial;
    private int mem_imediata;
    private int mem_recente;
    private int calculo;
    private int linguagem;
    private int acertos;
    private int erros;


    public TestMeem(Individuo individuo){
        super(individuo);

    }
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getOri_temporal() {
        return ori_temporal;
    }

    public void setOri_temporal(int ori_temporal) {
        this.ori_temporal = ori_temporal;
    }

    public int getOri_espacial() {
        return ori_espacial;
    }

    public void setOri_espacial(int ori_espacial) {
        this.ori_espacial = ori_espacial;
    }

    public int getMem_imediata() {
        return mem_imediata;
    }

    public void setMem_imediata(int mem_imediata) {
        this.mem_imediata = mem_imediata;
    }

    public int getMem_recente() {
        return mem_recente;
    }

    public void setMem_recente(int mem_recente) {
        this.mem_recente = mem_recente;
    }

    public int getCalculo() {
        return calculo;
    }

    public void setCalculo(int calculo) {
        this.calculo = calculo;
    }

    public int getLinguagem() {
        return linguagem;
    }

    public void setLinguagem(int linguagem) {
        this.linguagem = linguagem;
    }

    public int getAcertos() {
        return acertos;
    }

    public void setAcertos(int acertos) {
        this.acertos = acertos;
    }

    public int getErros() {
        return erros;
    }

    public void setErros(int erros) {
        this.erros = erros;
    }

    @Override
    public void realizarTeste(int opt, int clicked, int fase, int n1, int n2, int n3, int n4, int n5) {
        if (opt == 1) {
            orientacaoTemporal(clicked);
        }
        if (opt == 2) {
            orientacaoEspacial(clicked);
        }
        if (opt == 3) {
            memoriaImediata(clicked);
        }
        if (opt == 4) {
            memoriaRecente(clicked);
        }
        if (opt == 5) {
            registrarCalculo(clicked, n1, n2, n3, n4, n5);
        }
        if (opt == 6) {
            registrarLinguagem(clicked, fase);
        }
    }

    public void opcaoSelecionada_1(int click){

        if  (click==1){
            acertos++;
        }
        else if (click==2){
            erros++;
        }
    }

    public void opcaoSelecionada_2(int click){

        if  (click==1){
            acertos++;
            erros = erros+2;
        }
        if (click==2){
            acertos = acertos +2;
            erros = erros+1;
        }
        if (click==3){
            acertos = acertos +3;
        }
        if (click==4){
            erros = erros+3;
        }
    }

    public void orientacaoTemporal(int clicked){

        opcaoSelecionada_1(clicked);
        if (clicked==1){
            ori_temporal++;
        }
    }

    public void orientacaoEspacial(int clicked){

        opcaoSelecionada_1(clicked);
        if (clicked==1){
            ori_espacial++;
        }
    }

    public void memoriaImediata(int clicked){

        opcaoSelecionada_2(clicked);
        if (clicked==1){
            mem_imediata = 1;
        }
        if (clicked==2){
            mem_imediata = 2;
        }
        if (clicked==3){
            mem_imediata = 3;
        }
    }

    public void memoriaRecente(int clicked){

        opcaoSelecionada_2(clicked);
        if (clicked==1){
            mem_recente++;
        }
        if (clicked==2){
            mem_recente = mem_recente + 2;
        }
        if (clicked==3){
            mem_recente = mem_recente + 3;
        }
    }

    public void registrarCalculo(int clicked, int n1, int n2, int n3, int n4, int n5){

        if (clicked==5)
        {
            if (n1==93){
                acertos++;
                calculo++;
            }
            else {
                erros++;
            }
            if (n2==86){
                acertos++;
                calculo++;
            }
            else {
                erros++;
            }
            if (n3==79){
                acertos++;
                calculo++;
            }
            else {
                erros++;
            }
            if (n4==72){
                acertos++;
                calculo++;
            }
            else {
                erros++;
            }
            if (n5==65){
                acertos++;
                calculo++;
            }
            else {
                erros++;
            }
        }
        else if (clicked==1){
            acertos = acertos +5;
            calculo = 5;
        }
        else if (clicked==2){
            erros = erros+5;
        }

    }

    public void registrarLinguagem(int clicked, int fase){

        if (fase == 1){
            opcaoSelecionada_1(clicked);
            if (clicked==1){
                linguagem++;
            }
        }
        if (fase == 2){
            opcaoSelecionada_2(clicked);
            if (clicked==1){
                linguagem++;
            }
            if (clicked==2){
                linguagem = linguagem + 2;
            }
            if (clicked==3){
                linguagem = linguagem + 3;
            }
        }
        if (fase == 3){
            if (clicked==1){
                acertos = acertos+1;
                erros = erros+1;
                linguagem++;
            }
            if (clicked==2){
                acertos = acertos+2;
                linguagem = linguagem+2;
            }
            if (clicked==3){
                erros = erros+2;
            }
        }
    }
}
