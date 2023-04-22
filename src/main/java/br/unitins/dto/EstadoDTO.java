package br.unitins.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public record EstadoDTO(
        Long id,

        @NotBlank(message = "O nome do Estado deve ser informado.")
        String nome, 

        @NotBlank(message = "A sigla deve ser informada")
        @Size(max = 3, message = "A sigla deve ter no maximo 3 caracteres")
        String sigla
    
){

}
