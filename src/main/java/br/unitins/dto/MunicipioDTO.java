package br.unitins.dto;

import javax.validation.constraints.NotBlank;

import br.unitins.model.Estado;

public record MunicipioDTO(
        Long id,

        @NotBlank(message = "O nome do municipio deve ser informado.") 
        String nome, 
        
        @NotBlank(message = "O nome do estado deve ser informado.")
        Estado estado
    
){

}
