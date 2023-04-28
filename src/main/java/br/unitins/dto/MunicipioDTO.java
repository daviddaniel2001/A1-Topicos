package br.unitins.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record MunicipioDTO(

        @NotBlank(message = "O nome do municipio deve ser informado.") 
        String nome, 
        
        @NotNull(message = "O nome do estado deve ser informado.")
        Long idEstado
    
){

}
