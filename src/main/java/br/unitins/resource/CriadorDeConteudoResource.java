package br.unitins.resource;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import br.unitins.dto.CriadorDeConteudoDTO;
import br.unitins.dto.CriadorDeConteudoResponseDTO;
import br.unitins.service.CriadorDeConteudoService;

@Path("/CriadorDeConteudo")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CriadorDeConteudoResource {

  @Inject
  private CriadorDeConteudoService service;

  @GET
  public List<CriadorDeConteudoResponseDTO> getAll() {

    // seleciona todas as Estados do banco de dados
    return service.getAll();

  }

  @POST
  public CriadorDeConteudoResponseDTO insert(CriadorDeConteudoDTO criadorDeConteudoDTO) {

    return service.create(criadorDeConteudoDTO);

  }

  @PUT
  @Path("/{id}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Transactional
  public CriadorDeConteudoResponseDTO update(@PathParam("id") Long id, CriadorDeConteudoDTO criadorDeConteudoDTO) {
    return service.update(id, criadorDeConteudoDTO);
  }

  @GET
  @Path("/count")
  public long count() {
    return service.count();
  }

  @DELETE
  @Path("/{id}")
  @Transactional
  public void delete(@PathParam("id") Long id) {
    service.delete(id);
  }

  @GET
  @Path("/search/{id}")
  public CriadorDeConteudoResponseDTO searchId(@PathParam("id") Long id) {
    return service.findById(id);
  }

  @GET
  @Path("/search/{nome}")
  public List<CriadorDeConteudoResponseDTO> search(@PathParam("nome") String nome) {
    return service.findByNome(nome);
  }

}
