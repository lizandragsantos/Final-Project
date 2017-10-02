package com.example.lizandra.projectdetectalzheimer_2.dominio;


/**
 * Created by LIZANDRA on 18/03/2017.
 */

public class Individuo extends Pessoa{

    private String escolaridade;
    private String idade;


    public Individuo(String nome, String sexo, String escolaridade, String idade) {
        super(nome, sexo);
        this.escolaridade = escolaridade;
        this.idade = idade;
    }

    public Individuo(){}

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }


}
