package br.unitins.dto;

import java.time.LocalDateTime;

import br.unitins.model.Pagamento;

public record PagamentoResponseDTO(
    Long id,
    Float valor,
    LocalDateTime dataPagamento
){
   public PagamentoResponseDTO(Pagamento pag){
       this(pag.getId(), pag.getValor(), pag.getDataPagamento());
   } 
}
