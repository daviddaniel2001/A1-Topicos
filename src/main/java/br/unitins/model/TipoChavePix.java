package br.unitins.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;

@Entity
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TipoChavePix {
    CPF(1, "Cpf"),
    CNPJ(2, "Cnpj"),
    EMAIL(3, "Email"),
    CHAVEALEATORIA(4, "Chave Aleatoria");

    private int id;
    private String label;

    TipoChavePix(int id, String label) {
        this.id = id;
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public static TipoChavePix valueOf(Integer id) throws IllegalArgumentException {
        if (id == null)
            return null;
        for (TipoChavePix tipoChavePix : TipoChavePix.values()) {
            if (id.equals(tipoChavePix.getId()))
                return tipoChavePix;
        }
        throw new IllegalArgumentException("Id inválido:" + id);
    }

}
