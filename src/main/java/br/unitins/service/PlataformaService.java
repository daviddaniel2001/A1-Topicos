package br.unitins.service;

import java.util.List;

import br.unitins.dto.PlataformaDTO;
import br.unitins.dto.PlataformaResponseDTO;

public interface PlataformaService {
    
        List<PlataformaResponseDTO> getAll();
            PlataformaResponseDTO findById(Long id);
            PlataformaResponseDTO create (PlataformaDTO plataformadto);
            PlataformaResponseDTO update (Long id, PlataformaDTO plataformadto);
            void delete(Long id);
    
        List<PlataformaResponseDTO> findByNome(String nome);
            long count();
}   
