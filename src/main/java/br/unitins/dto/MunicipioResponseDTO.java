package br.unitins.dto;

import br.unitins.model.Estado;
import br.unitins.model.Municipio;

public record MunicipioResponseDTO(

Long id, 
String nome, 
Estado estado 

){
    public MunicipioResponseDTO(Municipio mn){
        this(mn.getId(), mn.getNome(), mn.getEstado());
    }
}
