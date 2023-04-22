package br.unitins.service;

import java.util.List;

import br.unitins.dto.EstadoDTO;
import br.unitins.dto.EstadoResponseDTO;

public interface EstadoService {
    
    List<EstadoResponseDTO> getAll();

    EstadoResponseDTO findById(Long id);

    EstadoResponseDTO create(EstadoDTO productDTO);

    EstadoResponseDTO update(Long id, EstadoDTO productDTO);

    void delete(Long id);

    List<EstadoResponseDTO> findByNome(String nome);

    long count();
}
