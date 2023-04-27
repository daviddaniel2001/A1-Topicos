package br.unitins.resource;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
