package br.unitins.dto;

import br.unitins.model.Pix;
import br.unitins.model.TipoChavePix;

public record PixResponseDTO(

    String nome, 
    TipoChavePix tipoChave
){
    public PixResponseDTO(Pix pix){
        this(pix.getNome(), pix.getTipoChave());
    }
}
