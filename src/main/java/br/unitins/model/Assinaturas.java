package br.unitins.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;

@Entity
public class Assinaturas extends Pagamento {

    private LocalDateTime dataInicio;
    private LocalDateTime dataFinal;
    private Boolean status;
    private Usuario nomeUuario;
    private CriadorDeConteudo nomeCriadorDeConteudo;

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public Usuario getNomeUuario() {
        return nomeUuario;
    }

    public void setNomeUuario(Usuario nomeUuario) {
        this.nomeUuario = nomeUuario;
    }

    public CriadorDeConteudo getNomeCriadorDeConteudo() {
        return nomeCriadorDeConteudo;
    }

    public void setNomeCriadorDeConteudo(CriadorDeConteudo nomeCriadorDeConteudo) {
        this.nomeCriadorDeConteudo = nomeCriadorDeConteudo;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDateTime getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDateTime dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

}
