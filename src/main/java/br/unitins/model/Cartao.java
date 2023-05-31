package br.unitins.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;

@Entity
public class Cartao extends Pagamento {

    private String nomeTitular;
    private String codSeguranca;
    private LocalDateTime dataValidade;
    private String numeroCartao;
    private PagamentoCartao tipoPagamento;

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public String getCodSeguranca() {
        return codSeguranca;
    }

    public void setCodSeguranca(String codSeguranca) {
        this.codSeguranca = codSeguranca;
    }

    public LocalDateTime getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDateTime dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public PagamentoCartao getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(PagamentoCartao tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

}
