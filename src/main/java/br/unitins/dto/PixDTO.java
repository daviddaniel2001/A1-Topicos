package br.unitins.dto;

import br.unitins.model.TipoChavePix;
import jakarta.validation.constraints.NotBlank;

public record PixDTO(

    @NotBlank(message = "Informe o nome!")
    String nome, 

    TipoChavePix tipoChave 
){
    
}
