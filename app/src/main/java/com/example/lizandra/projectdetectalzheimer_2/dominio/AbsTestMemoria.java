package com.example.lizandra.projectdetectalzheimer_2.dominio;


public abstract class AbsTestMemoria {
    private Individuo individuo;
    private Testmeem meem;

    public AbsTestMemoria(Individuo individuo, Testmeem meem){
        this.individuo = individuo;
        this.meem = meem;
    }


}
