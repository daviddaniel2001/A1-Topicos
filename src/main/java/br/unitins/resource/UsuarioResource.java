package br.unitins.resource;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


import br.unitins.dto.UsuarioResponseDTO;

import br.unitins.service.UsuarioService;

@Path("/usuarios")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioResource {

    @Inject
    private UsuarioService service;

    @GET
    public List<UsuarioResponseDTO> getAll() {

        // seleciona todas as Estados do banco de dados
        return service.getAll();

    }

    //@POST
    //@Transactional
    //public UsuarioResponseDTO insert(UsuarioDTO usuarioDTO) {

    //    return service.create(usuarioDTO);

    //}

    //@PUT
    //@Path("/{id}")
    //@Consumes(MediaType.APPLICATION_JSON)
    //@Produces(MediaType.APPLICATION_JSON)
    //@Transactional
    //public UsuarioResponseDTO update(@PathParam("id") Long id, UsuarioDTO usuarioDTO) {

    //    return service.update(id, usuarioDTO);
    //}

    //@GET
    //@Path("/count")
    //public long count() {
    //    return service.count();
    //}

    @GET
    @Path("/search/{nome}")
    public List<UsuarioResponseDTO> search(@PathParam("nome") String nome) {
        return service.findByNome(nome);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void delete(@PathParam("id") Long id) {
        service.delete(id);
    }
}