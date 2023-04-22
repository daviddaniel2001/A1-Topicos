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

import br.unitins.dto.EstadoDTO;
import br.unitins.dto.EstadoResponseDTO;
import br.unitins.service.EstadoServiceImpl;

@Path("/estados")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EstadoResource {

    @Inject
    private EstadoServiceImpl service;

    @GET
    public List<EstadoResponseDTO> getAll() {

        // seleciona todas as Estados do banco de dados
        return service.getAll();

    }

    @POST
    @Transactional
    public EstadoResponseDTO insert(EstadoDTO estadoDTO) {

        return service.create(estadoDTO);

        
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public EstadoResponseDTO update(@PathParam("id") Long id, EstadoDTO estadoDTO) {

        return service.update(id, estadoDTO);
    }

    @GET
    @Path("/count")
    public long count() {
        return service.count();
    }

    @GET
    @Path("/search/{nome}")
    public List<EstadoResponseDTO> search(@PathParam("nome") String nome) {
        return service.findByNome(nome);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void delete(@PathParam("id") Long id){
        service.delete(id);
    }

}