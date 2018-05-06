package com.example.lizandra.projectdetectalzheimer_2.dominio;


import java.io.Serializable;

public abstract class Pessoa extends ObjetoDominio{
    private String nome;
    private String sexo;


    public Pessoa(String nome, String sexo){
        this.nome = nome;
        this.sexo = sexo;

    }
    public Pessoa(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

}
