package br.unitins.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import br.unitins.model.PessoaFisica;
import br.unitins.model.Sexo;

public record PessoaFisicaResponseDTO(
    Long id,
    String cpf,
    String nome,
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    Sexo sexo
){
    public PessoaFisicaResponseDTO(PessoaFisica pf) {
        this(pf.getId(), pf.getCpf(), pf.getNome(), pf.getSexo()); 
    }
}
