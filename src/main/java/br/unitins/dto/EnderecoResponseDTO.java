package br.unitins.dto;

import br.unitins.model.Endereco;
import br.unitins.model.Municipio;

public record EnderecoResponseDTO(

    Long id, 
    String lagradouro, 
    String numero, 
    String complemento, 
    String cep, 
    Municipio municipio
){
    public EnderecoResponseDTO(Endereco end){
        this(end.getId(), end.getLagradouro(), end.getNumero(), end.getComplemento(), end.getCep(), end.getMunicipio());
    }
}
