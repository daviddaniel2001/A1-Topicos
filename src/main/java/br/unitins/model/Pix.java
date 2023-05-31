package br.unitins.model;

import jakarta.persistence.Entity;

@Entity
public class Pix {

    private String nome;
    private TipoChavePix tipoChave;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoChavePix getTipoChave() {
        return tipoChave;
    }

    public void setTipoChave(TipoChavePix tipoChave) {
        this.tipoChave = tipoChave;
    }

}
