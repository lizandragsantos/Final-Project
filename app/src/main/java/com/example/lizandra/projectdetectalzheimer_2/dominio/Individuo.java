package com.example.lizandra.projectdetectalzheimer_2.dominio;

/**
 * Created by LIZANDRA on 18/03/2017.
 */

public class Individuo extends Pessoa {
    private String escolaridade;
    private int idade;

    public Individuo(String nome, String sexo, String escolaridade, int idade) {
        super(nome, sexo);
        this.escolaridade = escolaridade;
        this.idade = idade;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
