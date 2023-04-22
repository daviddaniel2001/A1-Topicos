package br.unitins.dto;

import br.unitins.model.Estado;

public record EstadoResponseDTO(
    Long id, 
    String nome, 
    String sigla
){
    public EstadoResponseDTO(Estado est){
        this(est.getId(), est.getNome(), est.getSigla());
    }
}
