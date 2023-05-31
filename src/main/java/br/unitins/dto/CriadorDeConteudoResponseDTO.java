package br.unitins.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import br.unitins.model.CriadorDeConteudo;
import br.unitins.model.Endereco;
import br.unitins.model.Sexo;

public record CriadorDeConteudoResponseDTO(

    Long id,
    String cpf,
    String nome,
    String email,
    String login,
    String nomeImagem,

    @JsonInclude(JsonInclude.Include.NON_NULL)
    Sexo sexo 

){
    public static CriadorDeConteudoResponseDTO valueOf(CriadorDeConteudo cdc) {
        if (cdc.getPessoaFisica() == null)
            return new CriadorDeConteudoResponseDTO(getId(), null, null, null, cdc.getLogin(), null);
            
        return new CriadorDeConteudoResponseDTO(cdc.getId(),
            cdc.getPessoaFisica().getCpf(),
            cdc.getPessoaFisica().getNome(),
            cdc.getPessoaFisica().getEmail(),
            cdc.getLogin(),
            cdc.getNomeImagem(),
            cdc.getPessoaFisica().getSexo());
    }


}
