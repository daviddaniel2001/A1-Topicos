package br.unitins.service;

import java.util.List;

import br.unitins.dto.MunicipioDTO;
import br.unitins.dto.MunicipioResponseDTO;

public interface MunicipioService {

    List<MunicipioResponseDTO> getAll();

    MunicipioResponseDTO findBy(Long id);

    MunicipioResponseDTO create(MunicipioDTO productDTO);

    MunicipioResponseDTO update(Long id, MunicipioDTO productDTO);

    void delete(Long id);

    List<MunicipioResponseDTO> findByNome(String nome);

    long count();
}
