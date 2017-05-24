package com.example.lizandra.projectdetectalzheimer_2.dominio;
import java.util.Date;

public class TestMeem {
    private Date data;
    private float acertos;
    private float erros;

    public TestMeem(Date data, int resultado, int acertos, int erros){
        this.data = data;
        this.acertos = acertos;
        this.erros = erros;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
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
