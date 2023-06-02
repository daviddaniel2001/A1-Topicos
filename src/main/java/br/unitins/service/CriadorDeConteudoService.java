package br.unitins.service;

import java.util.List;

import br.unitins.dto.CriadorDeConteudoResponseDTO;

public interface CriadorDeConteudoService {
        
    List<CriadorDeConteudoResponseDTO> getAll();

    CriadorDeConteudoResponseDTO findByLoginAndSenha(String login, String senha);

    CriadorDeConteudoResponseDTO findById(Long id);

    CriadorDeConteudoResponseDTO findByLogin(String login);

    //CriadorDeConteudoResponseDTO create(CriadorDeConteudoDTO criadorDeConteudoDTO);

    //CriadorDeConteudoResponseDTO update(Long id, CriadorDeConteudoDTO criadorDeConteudoDTO);

    CriadorDeConteudoResponseDTO update(Long id, String nomeImagem);

    void delete(Long id);

    List<CriadorDeConteudoResponseDTO> findByNome(String nome);

    long count();

}
