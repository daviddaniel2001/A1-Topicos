package br.unitins.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintDeclarationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import jakarta.ws.rs.NotFoundException;

import br.unitins.dto.MunicipioDTO;
import br.unitins.dto.MunicipioResponseDTO;
import br.unitins.model.Estado;
import br.unitins.model.Municipio;
import br.unitins.repository.EstadoRepository;
import br.unitins.repository.MunicipioRepository;

@ApplicationScoped
public class MunicipioServiceImpl implements MunicipioService {

    @Inject 
    MunicipioRepository municipioRepository;
    
    @Inject
    EstadoRepository estadoRepository;

    @Inject
    Validator  validator;

    @Override
    public List<MunicipioResponseDTO> getAll() {
        List<Municipio> list = municipioRepository.listAll();
        return list.stream().map(MunicipioResponseDTO::new).collect(Collectors.toList());
        
    }

    @Override
    public MunicipioResponseDTO findBy(Long id) {
       Municipio municipio = municipioRepository.findById(id);
       if(municipio == null)
            throw new NotFoundException("Municipio não encontrado.");
        return new MunicipioResponseDTO(municipio);
    }

    @Override
    @Transactional
    public MunicipioResponseDTO create(MunicipioDTO municipioDTO) throws ConstraintViolationException {
        validar(municipioDTO);

        Municipio entity = new Municipio();
        entity.setNome(municipioDTO.nome());
        entity.setEstado(new Estado());
        entity.getEstado().setId(municipioDTO.idEstado());
        municipioRepository.persist(entity);

        return new MunicipioResponseDTO(entity);
    }

    @Override
    @Transactional
    public MunicipioResponseDTO update(Long id, MunicipioDTO municipioDTO) throws ConstraintViolationException{
       validar(municipioDTO);

       Municipio entity = new Municipio();

       entity.setNome(municipioDTO.nome());
       entity.setEstado(new Estado());
       entity.getEstado().setId(municipioDTO.idEstado());
        
       return new MunicipioResponseDTO(entity);
    }

    private void validar(MunicipioDTO municipioDTO) throws ConstraintDeclarationException{
        Set<ConstraintViolation<MunicipioDTO>> violations = validator.validate(municipioDTO);
        if(!violations.isEmpty())
            throw new ConstraintViolationException(violations);
    }

    @Override
    @Transactional
    public void delete(Long id) throws IllegalArgumentException, NotFoundException {
       municipioRepository.deleteById(id);
        
    }

    @Override
    public List<MunicipioResponseDTO> findByNome(String nome) throws NullPointerException {
       List<Municipio> list = municipioRepository.findByNome(nome);
       return list.stream().map(MunicipioResponseDTO::new).collect(Collectors.toList()); 
    }

    @Override
    public long count() {
       return municipioRepository.count();
    }
    
}
