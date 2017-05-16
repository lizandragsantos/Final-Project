package com.example.lizandra.projectdetectalzheimer_2.dominio;
import java.util.Date;

public class Testmeem {
    private Date data;
    private int resultado;
    private int acertos;
    private int erros;

    public Testmeem(Date data, int resultado, int acertos, int erros){
        this.data = data;
        this.resultado = resultado;
        this.acertos = acertos;
        this.erros = erros;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
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
}
