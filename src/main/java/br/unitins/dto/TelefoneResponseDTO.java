package br.unitins.dto;
import br.unitins.model.Telefone;


public record TelefoneResponseDTO(

    Long id, 
    String codArea, 
    String numero
    
){
    public TelefoneResponseDTO(Telefone tl){
        this(tl.getId(), tl.getCodArea(), tl.getNumero());
    }
}   