package br.unitins.service;

import java.util.List;

import br.unitins.dto.CriadorDeConteudoDTO;
import br.unitins.dto.CriadorDeConteudoResponseDTO;

public interface CriadorDeConteudoService {
        
    List<CriadorDeConteudoResponseDTO> getAll();

    CriadorDeConteudoResponseDTO findById(Long id);

    CriadorDeConteudoResponseDTO create(CriadorDeConteudoDTO criadorDeConteudoDTO);

    CriadorDeConteudoResponseDTO update(Long id, CriadorDeConteudoDTO criadorDeConteudoDTO);

    void delete(Long id);

    List<CriadorDeConteudoResponseDTO> findByNome(String nome);

    long count();

}
