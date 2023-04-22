package br.unitins.service;

import java.util.List;

import br.unitins.dto.EnderecoDTO;
import br.unitins.dto.EnderecoResponseDTO;

public interface EnderecoService {
    
    List<EnderecoResponseDTO> getAll();

    EnderecoResponseDTO findById(Long id);

    EnderecoResponseDTO create(EnderecoDTO enderecoDTO);

    EnderecoResponseDTO update(Long id, EnderecoDTO enderecoDTO);

    void delete(Long id);

    List<EnderecoResponseDTO> findByNome(String nome);

    long count();
}
