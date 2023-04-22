package br.unitins.dto;


import com.fasterxml.jackson.annotation.JsonInclude;

import br.unitins.model.Endereco;
import br.unitins.model.Sexo;
import br.unitins.model.Telefone;
import br.unitins.model.Usuario;

public record UsuarioResponseDTO (
    String nome,
    Long id, 
    Integer idade,
    String email,
    Endereco endereco, 
    Telefone telefone,
     
    @JsonInclude(JsonInclude.Include.NON_NULL)
    Sexo sexo 
){ 
    public UsuarioResponseDTO(Usuario us) {
        this(us.getNome(), us.getId(), us.getIdade(), us.getEmail(), us.getEndereco(), us.getTelefone(), us.getSexo());
    }
}
