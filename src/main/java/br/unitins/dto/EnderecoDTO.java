package br.unitins.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record EnderecoDTO(
        long id, 

        @NotBlank(message = "O lagradouro deve ser informado.")
        String lagradouro, 

        @NotBlank(message = "O bairro deve ser informado.")
        String bairro, 

        @NotBlank(message = "O numero da residencia deve ser informado")
        String numero,

        String complemento,  

        @NotBlank(message = "O cep deve ser informado.")
        @Size(max = 8, message = "A quantidade maxima de caracteres é 8.")
        String cep, 

        
        Long idmunicipio
){
  
}

