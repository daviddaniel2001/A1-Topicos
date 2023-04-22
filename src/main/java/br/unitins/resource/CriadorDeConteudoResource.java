package br.unitins.resource;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.unitins.dto.CriadorDeConteudoDTO;
import br.unitins.dto.CriadorDeConteudoResponseDTO;
import br.unitins.service.CriadorDeConteudoService;

<<<<<<< HEAD
@Path("/CriadorDeConteudo")
=======
@Path("/criadordeconteudo")
>>>>>>> c997eaa80096eab5e3c4265a343ecf9ee1398862
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CriadorDeConteudoResource {

<<<<<<< HEAD
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
=======
  @Inject
  private CriadorDeConteudoService criadorservice;

  @GET
  public List<CriadorDeConteudoResponseDTO> getAll() {
    return criadorservice.getAll();
>>>>>>> c997eaa80096eab5e3c4265a343ecf9ee1398862

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public CriadorDeConteudoResponseDTO update(@PathParam("id") Long id, CriadorDeConteudoDTO criadorDeConteudoDTO) {

<<<<<<< HEAD
        return service.update(id, criadorDeConteudoDTO);
    }

    @GET
    @Path("/count")
    public long count() {
        return service.count();
    }
=======
  @POST
  public Response insert(@Valid CriadorDeConteudoDTO criadordto) {

    CriadorDeConteudoResponseDTO criador = criadorservice.create(criadordto);
    return Response
        .status(Status.CREATED)
        .entity(criador)
        .build();
  }

  @PUT
  @Path("/{id}")
  public Response update(@Valid @PathParam("id") Long id, CriadorDeConteudoDTO criadordto) {

<<<<<<< HEAD
    CriadorDeConteudoResponseDTO criador = criadorservice.update(id, criadordto);
    return Response
        .status(Status.NO_CONTENT)
        .entity(criador)
        .build();
=======
    CriadorDeConteudo criadorid = repository.findById(id);
>>>>>>> c997eaa80096eab5e3c4265a343ecf9ee1398862

    @GET
    @Path("/search/{nome}")
    public List<CriadorDeConteudoResponseDTO> search(@PathParam("nome") String nome) {
        return service.findByNome(nome);
    }

<<<<<<< HEAD
    @DELETE
    @Path("/{id}")
    @Transactional
    public void delete(@PathParam("id") Long id) {
        service.delete(id);
    }
}
=======
    
    return criadorid;
>>>>>>> b1e0cd6f002f29293f016afa5dfbc838083c907a

  }

  @DELETE
  @Path("/{id}")
  public Response delete(@Valid @PathParam("id") Long id) {
    criadorservice.delete(id);
    return Response
        .status(Status.NO_CONTENT)
        .build();
  }

  @GET
  @Path("/search/{id}")
  public CriadorDeConteudoResponseDTO searchId(@PathParam("id") Long id) {
    return criadorservice.findById(id);
  }

  @GET
  @Path("/search/{nome}")
  public List<CriadorDeConteudoResponseDTO> search(@PathParam("nome") String nome) {
    return criadorservice.findByNome(nome);
  }

  @GET
  @Path("/count")
  public long count() {
    return criadorservice.count();
  }

}
>>>>>>> c997eaa80096eab5e3c4265a343ecf9ee1398862
