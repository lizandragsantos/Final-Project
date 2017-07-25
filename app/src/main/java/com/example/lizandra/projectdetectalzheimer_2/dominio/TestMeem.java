package com.example.lizandra.projectdetectalzheimer_2.dominio;
import java.util.Date;

public class TestMeem {
    private Date data;
    private float ori_temporal;
    private float ori_espacial;
    private float mem_imediata;
    private float mem_recente;
    private float calculo;
    private float linguagem;
    private float acertos;
    private float erros;


    public TestMeem(Date data, float ori_temporal, float ori_espacial, float mem_imediata, float mem_recente, float calculo, float linguagem, float acertos, float erros) {
        this.data = data;
        this.ori_temporal = ori_temporal;
        this.ori_espacial = ori_espacial;
        this.mem_imediata = mem_imediata;
        this.mem_recente = mem_recente;
        this.calculo = calculo;
        this.linguagem = linguagem;
        this.acertos = acertos;
        this.erros = erros;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public float getOri_temporal() {
        return ori_temporal;
    }

    public void setOri_temporal(float ori_temporal) {
        this.ori_temporal = ori_temporal;
    }

    public float getOri_espacial() {
        return ori_espacial;
    }

    public void setOri_espacial(float ori_espacial) {
        this.ori_espacial = ori_espacial;
    }

    public float getMem_imediata() {
        return mem_imediata;
    }

    public void setMem_imediata(float mem_imediata) {
        this.mem_imediata = mem_imediata;
    }

    public float getMem_recente() {
        return mem_recente;
    }

    public void setMem_recente(float mem_recente) {
        this.mem_recente = mem_recente;
    }

    public float getCalculo() {
        return calculo;
    }

    public void setCalculo(float calculo) {
        this.calculo = calculo;
    }

    public float getLinguagem() {
        return linguagem;
    }

    public void setLinguagem(float linguagem) {
        this.linguagem = linguagem;
    }

    public float getAcertos() {
        return acertos;
    }

    public void setAcertos(int acertos) {
        this.acertos = acertos;
    }

    public float getErros() {
        return erros;
    }

    public void setErros(int erros) {
        this.erros = erros;
    }
}
