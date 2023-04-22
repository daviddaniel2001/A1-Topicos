package br.unitins.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import javax.ws.rs.NotFoundException;

import com.oracle.svm.core.annotate.Inject;

import br.unitins.dto.PlataformaDTO;
import br.unitins.dto.PlataformaResponseDTO;
import br.unitins.model.Plataforma;
import br.unitins.repository.CriadorDeConteudoRepository;
import br.unitins.repository.PlataformaRepository;

public class PlataformaServiceImpl implements PlataformaService{
    
    @Inject
    CriadorDeConteudoRepository criadordeconteudorepository;

    @Inject
    PlataformaRepository plataformarepository;

    @Inject
    Validator validator;

    @Override
    public List<PlataformaResponseDTO> getAll() {
        List<Plataforma> list = plataformarepository.listAll();
        return list
                .stream()
                .map(PlataformaResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public PlataformaResponseDTO findById(Long id) {
        Plataforma plataforma = plataformarepository.findById(id);
        if (plataforma == null)
            throw new NotFoundException("Criador de conteudo não encontrado!");
        return new PlataformaResponseDTO(plataforma);
    }

    @Override
    @Transactional
    public PlataformaResponseDTO create (PlataformaDTO plataformadto) {
        Set<ConstraintViolation<PlataformaRepository>> violations = validator
                .validate(plataformarepository);
        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);

        Plataforma entity = new Plataforma();
        entity.setCnpj(plataformadto.getCnpj());
        entity.setEndereco(plataformadto.getEndereco());
        entity.setId(plataformadto.getId());
        entity.setTelefone(plataformadto.getTelefone());
        plataformarepository.persist(entity);

        return new PlataformaResponseDTO(entity);

    }

    @Override
    @Transactional
    public void delete(Long id) {
        criadordeconteudorepository.deleteById(id);
    }

    @Override
    public List<PlataformaResponseDTO> findByNome(String nome) {
        List<Plataforma> list = plataformarepository.findByNome(nome);
        return list
                   .stream()
                   .map(PlataformaResponseDTO::new)
                   .collect(Collectors.toList());
    }

    @Override
    public long count() {
        return criadordeconteudorepository.count();
    }

    @Override
    @Transactional
    public PlataformaResponseDTO update(Long id, PlataformaDTO plataformadto) {
        Plataforma entity = plataformarepository.findById(id);
        
        entity.setId(plataformadto.getId());
        entity.setTelefone(plataformadto.getTelefone());
        entity.setEndereco(plataformadto.getEndereco());
        entity.setCnpj(plataformadto.getCnpj());

        return new PlataformaResponseDTO(entity);

    }
}
