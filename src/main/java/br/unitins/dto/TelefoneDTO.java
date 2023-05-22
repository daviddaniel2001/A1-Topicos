package br.unitins.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TelefoneDTO(

        Long id, 

        @NotBlank(message = "O codigo de area deve ser informado.")
        @Size(max = 2, message = "O codigo deve ter no maximo 2 caracteres.")
        String codArea,
        
        @NotBlank(message = "O nuemro deve ser informado.")
        @Size(max = 9, message = "O numero deve ter no maximo 9 caracteres.")
        String numero
        
) {

} 

