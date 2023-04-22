package br.unitins.dto;

import br.unitins.model.CriadorDeConteudo;
import br.unitins.model.Endereco;

public record CriadorDeConteudoResponseDTO(

Long id, 
String nome, 
Integer idade, 
String cpf, 
String email, 
Endereco endereco

){
    public CriadorDeConteudoResponseDTO(CriadorDeConteudo cdc){
        this(cdc.getId(), cdc.getNome(), cdc.getIdade(), cdc.getCpf(), cdc.getEmail(), cdc.getEndereco());
    }
}
