package br.unitins.dto;

import java.time.LocalDateTime;

import br.unitins.model.PagamentoCartao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CartaoDTO(

    @NotBlank(message = "O nome do titular deve ser informado!")
    String nomeTitular,
    
    @NotBlank(message = "O codigo de seguranca deve ser informado!")
    @Size(max = 3, message = "Deve ter no maximo 3 numeros!")
    String codSeguranca, 
    
    @NotBlank(message = "A data de validade deve ser informada!")
    LocalDateTime dataValidade,
    
    @NotBlank(message = "O numero do cartao deve ser inserido!")
    @Size(max = 19, message = "Deve ter no maximo 19 numeros!")
    String numeroCartao,

    PagamentoCartao tipoPagamento
){
    
}
