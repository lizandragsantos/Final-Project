package com.example.lizandra.projectdetectalzheimer_2.dominio;


import java.io.Serializable;

public abstract class TestMemoria extends ObjetoDominio implements Serializable {

    private Individuo individuo;

    public abstract void realizarTeste(int opt, int clicked, int fase, int n1, int n2, int n3, int n4, int n5);

    public TestMemoria(Individuo individuo) {
        this.individuo = individuo;
    }

    public void setIndividuo(Individuo individuo) {
        this.individuo = individuo;
    }

    public Pessoa getIndividuo() {
        return individuo;
    }

}
