package br.unitins.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.ConstraintDeclarationException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import javax.ws.rs.NotFoundException;

import br.unitins.dto.EstadoDTO;
import br.unitins.dto.EstadoResponseDTO;
import br.unitins.model.Estado;
import br.unitins.repository.EstadoRepository;
import br.unitins.repository.MunicipioRepository;

@ApplicationScoped
public class EstadoServiceImpl implements EstadoService {

    @Inject
    EstadoRepository estadoRepository;

    @Inject
    MunicipioRepository municipioRepository;

    @Inject
    Validator validator;

    @Override
    public List<EstadoResponseDTO> getAll() {
        List<Estado> list = estadoRepository.listAll();
        return list.stream().map(EstadoResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public EstadoResponseDTO findById(Long id) {
        Estado estado = estadoRepository.findById(id);
        if (estado == null)
            throw new NotFoundException("Municipio não encontrado.");
        return new EstadoResponseDTO(estado);
    }

    @Override
    public EstadoResponseDTO create(EstadoDTO estadoDTO) throws ConstraintViolationException  {
        validar(estadoDTO);

        Estado entity = new Estado();
        entity.setNome(estadoDTO.nome());
        entity.setSigla(estadoDTO.sigla());
        estadoRepository.persist(entity);

        return new EstadoResponseDTO(entity);
    }

    @Override
    public EstadoResponseDTO update(Long id, EstadoDTO estadoDTO) throws ConstraintViolationException  {
        validar(estadoDTO);

        Estado entity = new Estado();

        entity.setNome(estadoDTO.nome());
        entity.setSigla(estadoDTO.sigla());

        return new EstadoResponseDTO(entity);
    }

    private void validar(EstadoDTO estadoDTO) throws ConstraintDeclarationException {
        Set<ConstraintViolation<EstadoDTO>> violations = validator.validate(estadoDTO);
        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);
    }

    @Override
    public void delete(Long id) throws IllegalArgumentException, NotFoundException {
        estadoRepository.deleteById(id);
    }

    @Override
    public List<EstadoResponseDTO> findByNome(String nome) throws NullPointerException {
        List<Estado> list = estadoRepository.findByNome(nome);
        return list.stream().map(EstadoResponseDTO::new).collect(Collectors.toList()); 
    }

    @Override
    public long count() {
        return estadoRepository.count();
    }

}
