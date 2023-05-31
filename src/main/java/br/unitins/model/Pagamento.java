package br.unitins.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;

@Entity
public class Pagamento {

    private Long id;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Float valor;
    private LocalDateTime dataPagamento;

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public LocalDateTime getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDateTime dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

}
