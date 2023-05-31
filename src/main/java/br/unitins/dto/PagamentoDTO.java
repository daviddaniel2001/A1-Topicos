package br.unitins.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;

public record PagamentoDTO(

        Long id,

        @NotBlank(message = "O valor deve ser informado!")
        Float valor, 

        LocalDateTime dataPagamento
){

}
