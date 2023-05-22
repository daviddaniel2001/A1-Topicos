package br.unitins.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record EstadoDTO(

        @NotBlank(message = "O nome do Estado deve ser informado.")
        String nome, 

        @NotBlank(message = "A sigla deve ser informada")
        @Size(max = 3, message = "A sigla deve ter no maximo 3 caracteres")
        String sigla
    
){

}
