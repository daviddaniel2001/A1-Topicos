package br.unitins.dto;
import br.unitins.model.Endereco;
import br.unitins.model.Telefone;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UsuarioDTO(
        @NotBlank(message = "O nome deve ser informado.") 
        @Size(max = 100, message = "O nome deve possuir no maximo 100 caracteres.") 
        String nome,

        @NotNull(message = "O campo deve ser informado.")
        @Size(max = 3, message = "A idade dever ter no maximo 3 caracteres.")
        Long id,

        Integer idade,

        @NotBlank(message = "O campo deve ser informado.")
        String email, 

        @NotBlank(message = "O nome deve ser informado.") 
        Endereco endereco,
        
        @NotBlank(message = "O nome deve ser informado.") 
        Telefone telefone,

        @NotNull(message = "O nome deve ser informado.") 
        Integer sexo

) { 

}
