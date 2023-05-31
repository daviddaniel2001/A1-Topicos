package br.unitins.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;

@Entity
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum PagamentoCartao {

    CREDITO(1, "Credito"),
    DEBITO(2, "Debito");

    private int id;
    private String label;

    PagamentoCartao(int id, String label) {
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

    public static PagamentoCartao valueOf(Integer id) throws IllegalArgumentException {
        if (id == null)
            return null;
        for (PagamentoCartao pagamentoCartao : PagamentoCartao.values()) {
            if (id.equals(pagamentoCartao.getId()))
                return pagamentoCartao;
        }
        throw new IllegalArgumentException("Id inválido:" + id);
    }
}
