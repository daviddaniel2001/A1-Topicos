package br.unitins.dto;

import java.util.HashMap;

import br.unitins.model.Plataforma;

public class PlataformaResponseDTO {

    private Long id;
    private String telefone;
    private String endereco;
    private String cnpj;

    private HashMap<String, Object> plataforma;

    public PlataformaResponseDTO(Plataforma plataforma) {
        this.id = plataforma.getId();
        this.telefone = plataforma.getTelefone();
        this.plataforma = new HashMap<String, Object>();
        this.plataforma.put(telefone, plataforma.getTelefone());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

}
