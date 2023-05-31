package br.unitins.dto;

import java.time.LocalDateTime;

import br.unitins.model.Cartao;
import br.unitins.model.PagamentoCartao;

public record CartaoResponseDTO(

    String nomeTitular, 
    String codSeguranca, 
    LocalDateTime dataValidade,
    String numeroCartao, 
    PagamentoCartao tipoPagamento 
){
    public CartaoResponseDTO(Cartao cart){
        this(cart.getNomeTitular(), cart.getCodSeguranca(), cart.getDataValidade(), cart.getNumeroCartao(), cart.getTipoPagamento());
    }
}
