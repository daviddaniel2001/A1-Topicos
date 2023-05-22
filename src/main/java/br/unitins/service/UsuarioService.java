package br.unitins.service;

import java.util.List;

import br.unitins.dto.UsuarioResponseDTO;

public interface UsuarioService {

    List<UsuarioResponseDTO> getAll();

    UsuarioResponseDTO findById(Long id);

    //UsuarioResponseDTO create(UsuarioDTO usuarioDTO);

    //UsuarioResponseDTO update(Long id, UsuarioDTO usuarioDTO);

    void delete(Long id);

    List<UsuarioResponseDTO> findByNome(String nome);

    long count();
}
