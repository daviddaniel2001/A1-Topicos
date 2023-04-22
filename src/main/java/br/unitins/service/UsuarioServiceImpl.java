package br.unitins.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import javax.ws.rs.NotFoundException;

import br.unitins.dto.UsuarioDTO;
import br.unitins.dto.UsuarioResponseDTO;
import br.unitins.model.Usuario;
import br.unitins.repository.UsuarioRepository;

@ApplicationScoped
public class UsuarioServiceImpl implements UsuarioService {

    @Inject 
    UsuarioRepository usuarioRepository;
    
    @Inject
    Validator  validator;
    
    @Override
    public List<UsuarioResponseDTO> getAll() {
        List<Usuario> list = usuarioRepository.listAll();
        return list.stream().map(UsuarioResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public UsuarioResponseDTO findById(Long id) {
        Usuario usuario = usuarioRepository.findById(id);
        if(usuario == null)
             throw new NotFoundException("Municipio não encontrado.");
         return new UsuarioResponseDTO(usuario);
    }

    @Override
    @Transactional
    public UsuarioResponseDTO create(UsuarioDTO usuarioDTO) {
        validar(usuarioDTO);

        Usuario entity = new Usuario();
        entity.setNome(usuarioDTO.nome());
        entity.setIdade(usuarioDTO.idade());
        entity.setEmail(usuarioDTO.email());
        entity.setTelefone(usuarioDTO.telefone());

        usuarioRepository.persist(entity);

        return new UsuarioResponseDTO(entity);
    }

    @Override
    @Transactional
    public UsuarioResponseDTO update(Long id, UsuarioDTO usuarioDTO) {
        validar(usuarioDTO);

        Usuario entity = new Usuario();
 
        entity.setNome(usuarioDTO.nome());
        entity.setIdade(usuarioDTO.idade());
        entity.setEmail(usuarioDTO.email());
        entity.setTelefone(usuarioDTO.telefone());

        return new UsuarioResponseDTO(entity);
    }
    private void validar(UsuarioDTO usuarioDTO) throws ConstraintViolationException{
        Set<ConstraintViolation<UsuarioDTO>> violations = validator.validate(usuarioDTO);
        if(!violations.isEmpty())
            throw new ConstraintViolationException(violations);
    }

    @Override
    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public List<UsuarioResponseDTO> findByNome(String nome) {
        List<Usuario> list = usuarioRepository.findByUsuario(nome);
        return list.stream().map(UsuarioResponseDTO::new).collect(Collectors.toList()); 
    }

    @Override
    public long count() {
        return usuarioRepository.count();
    }
    
}
