package br.unitins.service;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Validator;
import jakarta.ws.rs.NotFoundException;
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
        return list.stream().map(u -> UsuarioResponseDTO.valueOf(u)).collect(Collectors.toList());
    }

    @Override
    public UsuarioResponseDTO findById(Long id) {
        Usuario pessoaFisica = usuarioRepository.findById(id);
        if(pessoaFisica == null)
            throw new NotFoundException("Usuario não encontrado.");
        return UsuarioResponseDTO.valueOf(pessoaFisica);
    }

    //@Override
    //@Transactional
    //public UsuarioResponseDTO create(UsuarioDTO usuarioDTO) throws ConstraintViolationException {
    //    validar(usuarioDTO);

    //    Usuario entity = new Usuario();
    //    entity.setNome(usuarioDTO.nome());
    //    entity.setIdade(usuarioDTO.idade());
    //    entity.setEmail(usuarioDTO.email());
    //    entity.setTelefone(usuarioDTO.telefone());

    //    usuarioRepository.persist(entity);

    //    return new UsuarioResponseDTO(entity);
    //}

    //@Override
    //@Transactional
    //public UsuarioResponseDTO update(Long id, UsuarioDTO usuarioDTO) throws ConstraintViolationException {
    //    validar(usuarioDTO);

    //    Usuario entity = new Usuario();
 
    //    entity.setNome(usuarioDTO.nome());
    //    entity.setIdade(usuarioDTO.idade());
    //    entity.setEmail(usuarioDTO.email());
    //    entity.setTelefone(usuarioDTO.telefone());

    //    return new UsuarioResponseDTO(entity);
    //}
    //private void validar(UsuarioDTO usuarioDTO) throws ConstraintViolationException{
    //    Set<ConstraintViolation<UsuarioDTO>> violations = validator.validate(usuarioDTO);
    //    if(!violations.isEmpty())
    //        throw new ConstraintViolationException(violations);
    //}

    @Override
    public void delete(Long id){
        usuarioRepository.deleteById(id);
    }

    @Override
    public List<UsuarioResponseDTO> findByNome(String nome) {
        List<Usuario> list = usuarioRepository.findByNome(nome);
        return list.stream().map(u -> UsuarioResponseDTO.valueOf(u)).collect(Collectors.toList());
    }

    @Override
    public long count() {
        return usuarioRepository.count();
    }

    @Override
    public Usuario findByLoginAndSenha(String login, String senha) {
        return usuarioRepository.findByLoginAndSenha(login, senha);
    }

    @Override
    public UsuarioResponseDTO findByLogin(String login) {
        Usuario usuario = usuarioRepository.findByLogin(login);
        if(usuario == null)
            throw new NotFoundException("Usuario não encotrado.");
        return UsuarioResponseDTO.valueOf(usuario);
    }

    @Override
    @Transactional
    public UsuarioResponseDTO update(Long id, String nomeImagem) {
   
        Usuario entity = usuarioRepository.findById(id);
        entity.setNomeImagem(nomeImagem);

        return UsuarioResponseDTO.valueOf(entity);
    }

    
}
