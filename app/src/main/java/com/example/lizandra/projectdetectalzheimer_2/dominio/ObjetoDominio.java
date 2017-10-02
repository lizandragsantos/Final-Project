package com.example.lizandra.projectdetectalzheimer_2.dominio;

/**
 * Created by LIZANDRA on 20/09/2017.
 */

public abstract class ObjetoDominio {
    private Long id;

   public ObjetoDominio() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
