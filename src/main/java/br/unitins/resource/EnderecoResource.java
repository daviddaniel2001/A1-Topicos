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

import br.unitins.dto.EnderecoDTO;
import br.unitins.dto.EnderecoResponseDTO;
import br.unitins.service.EnderecoService;

@Path("/enderecos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EnderecoResource {

    @Inject
    private EnderecoService service;

    @GET
    public List<EnderecoResponseDTO> getAll() {

        // seleciona todas as Estados do banco de dados
        return service.getAll();

    }

    @POST
    @Transactional
    public EnderecoResponseDTO insert(EnderecoDTO enderecoDTO) {

        return service.create(enderecoDTO);

        
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public EnderecoResponseDTO update(@PathParam("id") Long id, EnderecoDTO enderecoDTO) {

        return service.update(id, enderecoDTO);
    }

    @GET
    @Path("/count")
    public long count() {
        return service.count();
    }

    @GET
    @Path("/search/{nome}")
    public List<EnderecoResponseDTO> search(@PathParam("nome") String nome) {
        return service.findByNome(nome);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void delete(@PathParam("id") Long id){
        service.delete(id);
    }

}
