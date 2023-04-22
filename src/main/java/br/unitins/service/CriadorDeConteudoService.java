package br.unitins.service;

import java.util.List;

import br.unitins.dto.CriadorDeConteudoDTO;
import br.unitins.dto.CriadorDeConteudoResponseDTO;

public interface CriadorDeConteudoService {
<<<<<<< HEAD
        
    List<CriadorDeConteudoResponseDTO> getAll();

    CriadorDeConteudoResponseDTO findById(Long id);

    CriadorDeConteudoResponseDTO create(CriadorDeConteudoDTO criadorDeConteudoDTO);

    CriadorDeConteudoResponseDTO update(Long id, CriadorDeConteudoDTO criadorDeConteudoDTO);

    void delete(Long id);

    List<CriadorDeConteudoResponseDTO> findByNome(String nome);

    long count();
=======
    
    List<CriadorDeConteudoResponseDTO> getAll();
        CriadorDeConteudoResponseDTO findById(Long id);
        CriadorDeConteudoResponseDTO create (CriadorDeConteudoDTO criadordto);
        CriadorDeConteudoResponseDTO update (Long id, CriadorDeConteudoDTO criadordto);
        void delete(Long id);

    List<CriadorDeConteudoResponseDTO> findByNome(String nome);
        long count();

>>>>>>> c997eaa80096eab5e3c4265a343ecf9ee1398862
}
