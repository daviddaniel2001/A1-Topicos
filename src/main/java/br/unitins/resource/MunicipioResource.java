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

import br.unitins.dto.MunicipioDTO;
import br.unitins.dto.MunicipioResponseDTO;
import br.unitins.service.MunicipioService;

@Path("/municipios")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MunicipioResource {

    @Inject
    private MunicipioService service;

    @GET
    public List<MunicipioResponseDTO> getAll() {

        // seleciona todas as Estados do banco de dados
        return service.getAll();

    }

    @POST
    @Transactional
    public MunicipioResponseDTO insert(MunicipioDTO municipioDTO) {

        return service.create(municipioDTO);

    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public MunicipioResponseDTO update(@PathParam("id") Long id, MunicipioDTO municipioDTO) {

        return service.update(id, municipioDTO);
    }

    @GET
    @Path("/count")
    public long count() {
        return service.count();
    }

    @GET
    @Path("/search/{nome}")
    public List<MunicipioResponseDTO> search(@PathParam("nome") String nome) {
        return service.findByNome(nome);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void delete(@PathParam("id") Long id) {
        service.delete(id);
    }
}