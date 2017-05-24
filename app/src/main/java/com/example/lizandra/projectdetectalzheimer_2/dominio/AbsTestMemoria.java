package com.example.lizandra.projectdetectalzheimer_2.dominio;


public abstract class AbsTestMemoria {
    private Pessoa individuo;

    public AbsTestMemoria(Individuo individuo){
        this.individuo = individuo;
    }

    public void setIndividuo(Pessoa individuo) {
        this.individuo = individuo;
    }

    public Pessoa getIndividuo() {
        return individuo;
    }
}
