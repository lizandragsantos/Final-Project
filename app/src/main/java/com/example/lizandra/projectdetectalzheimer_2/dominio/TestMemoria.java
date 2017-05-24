package com.example.lizandra.projectdetectalzheimer_2.dominio;

import java.util.ArrayList;
import java.util.List;

public class TestMemoria extends AbsTestMemoria {

    List<TestMeem> meem;

    public TestMemoria(Individuo individuo){
        super(individuo);
    }


    public void setMeem(List<TestMeem> meem) {
        this.meem = meem;
    }

    public List<TestMeem> getMeem() {
        return meem;
    }

}
