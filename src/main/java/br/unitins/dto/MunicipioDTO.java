package br.unitins.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MunicipioDTO(

        @NotBlank(message = "O nome do municipio deve ser informado.") 
        String nome, 
        
        @NotNull(message = "O nome do estado deve ser informado.")
        Long idEstado
    
){

}
