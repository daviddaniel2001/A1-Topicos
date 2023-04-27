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

import br.unitins.dto.CriadorDeConteudoDTO;
import br.unitins.dto.CriadorDeConteudoResponseDTO;
import br.unitins.model.CriadorDeConteudo;
import br.unitins.model.Endereco;
import br.unitins.repository.CriadorDeConteudoRepository;


@ApplicationScoped
public class CriadorDeConteudoServiceImpl implements CriadorDeConteudoService{

    @Inject 
    EnderecoService enderecoService;
    
    @Inject 
    CriadorDeConteudoRepository criadorDeConteudoRepository;
    
    @Inject
    Validator  validator;
    
    @Override
    public List<CriadorDeConteudoResponseDTO> getAll() {
        List<CriadorDeConteudo> list = criadorDeConteudoRepository.listAll();
        return list.stream().map(CriadorDeConteudoResponseDTO::new).collect(Collectors.toList());
    }
    
    @Override
    public CriadorDeConteudoResponseDTO findById(Long id) {
        CriadorDeConteudo criadorDeConteudo = criadorDeConteudoRepository.findById(id);
        if(criadorDeConteudo == null)
             throw new NotFoundException("Criador não encontrado.");
         return new CriadorDeConteudoResponseDTO(criadorDeConteudo);
    }
 
    @Override
    @Transactional
    public CriadorDeConteudoResponseDTO create(CriadorDeConteudoDTO criadorDeConteudoDTO) throws ConstraintViolationException  {
        validar(criadorDeConteudoDTO);
 
        CriadorDeConteudo entity = new CriadorDeConteudo();
        var endereco = enderecoService.create(criadorDeConteudoDTO.enderecoDTO());
        entity.setNome(criadorDeConteudoDTO.nome());
        entity.setIdade(criadorDeConteudoDTO.idade());
        entity.setCpf(criadorDeConteudoDTO.cpf());
        entity.setEmail(criadorDeConteudoDTO.email());
        entity.setEndereco(new Endereco());

        entity.getEndereco().setId(endereco.id());

        criadorDeConteudoRepository.persist(entity);
 
        return new CriadorDeConteudoResponseDTO(entity);
    }
 
    @Override
    @Transactional
    public CriadorDeConteudoResponseDTO update(Long id, CriadorDeConteudoDTO criadorDeConteudoDTO) throws ConstraintViolationException{
        validar(criadorDeConteudoDTO);
 
        CriadorDeConteudo entity = new CriadorDeConteudo();
 
        entity.setNome(criadorDeConteudoDTO.nome());
        entity.setIdade(criadorDeConteudoDTO.idade());
        entity.setCpf(criadorDeConteudoDTO.cpf());
        entity.setEmail(criadorDeConteudoDTO.email());
        entity.setEndereco(new Endereco());

        entity.getEndereco().setBairro(criadorDeConteudoDTO.enderecoDTO().bairro());
        entity.getEndereco().setNumero(criadorDeConteudoDTO.enderecoDTO().numero());
        entity.getEndereco().setLagradouro(criadorDeConteudoDTO.enderecoDTO().lagradouro());
        entity.getEndereco().setCep(criadorDeConteudoDTO.enderecoDTO().cep());
        entity.getEndereco().setComplemento(criadorDeConteudoDTO.enderecoDTO().complemento());

        criadorDeConteudoRepository.persist(entity);
        
        return new CriadorDeConteudoResponseDTO(entity);
    }
    private void validar(CriadorDeConteudoDTO criadorDeConteudoDTO) throws ConstraintViolationException{
       Set<ConstraintViolation<CriadorDeConteudoDTO>> violations = validator.validate(criadorDeConteudoDTO);
       if(!violations.isEmpty())
           throw new ConstraintViolationException(violations);
   }
 
    @Override
    @Transactional
    public void delete(Long id) throws IllegalArgumentException, NotFoundException {
        criadorDeConteudoRepository.deleteById(id);
    }
 
    @Override
    public List<CriadorDeConteudoResponseDTO> findByNome(String nome) throws NullPointerException {
        List<CriadorDeConteudo> list = criadorDeConteudoRepository.findByNome(nome);
        return list.stream().map(CriadorDeConteudoResponseDTO::new).collect(Collectors.toList()); 
    }
 
    @Override
    public long count() {
        return criadorDeConteudoRepository.count();
    }

}
