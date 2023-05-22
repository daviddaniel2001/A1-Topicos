package br.unitins.dto;
import jakarta.validation.constraints.NotBlank;

public record CriadorDeConteudoDTO(
        Long id, 

        @NotBlank(message = "O nome deve ser informado.")
        String nome, 

        Integer idade, 

        @NotBlank(message = "O cpf deve ser informado.")
        String cpf, 

        @NotBlank(message = "O email deve ser informado.")
        String email,
        
        EnderecoDTO enderecoDTO
){

}
