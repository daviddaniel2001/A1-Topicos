package br.unitins.service;

import java.util.List;

import br.unitins.dto.UsuarioResponseDTO;
import br.unitins.model.Usuario;

public interface UsuarioService {

    List<UsuarioResponseDTO> getAll();

    Usuario findByLoginAndSenha(String login, String senha);

    UsuarioResponseDTO findById(Long id);

    UsuarioResponseDTO findByLogin(String login);

    //UsuarioResponseDTO create(UsuarioDTO usuarioDTO);

    //UsuarioResponseDTO update(Long id, UsuarioDTO usuarioDTO);

    UsuarioResponseDTO update(Long id, String nomeImagem);

    void delete(Long id);

    List<UsuarioResponseDTO> findByNome(String nome);

    long count();
}
