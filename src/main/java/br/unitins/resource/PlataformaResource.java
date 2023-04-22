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

import br.unitins.dto.PlataformaDTO;
import br.unitins.dto.PlataformaResponseDTO;
import br.unitins.service.PlataformaService;

@Path("/plataforma")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PlataformaResource {

    @Inject
    private PlataformaService plataformaservice;

    @GET
    public List<PlataformaResponseDTO> getAll() {
        return plataformaservice.getAll();

    }

    @POST
    public Response insert(@Valid PlataformaDTO plataformadto) {

        PlataformaResponseDTO plataforma = plataformaservice.create(plataformadto);
        return Response
                .status(Status.CREATED)
                .entity(plataforma)
                .build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@Valid @PathParam("id") Long id, PlataformaDTO plataformadto) {

        PlataformaResponseDTO plataforma = plataformaservice.update(id, plataformadto);
        return Response
                .status(Status.NO_CONTENT)
                .entity(plataforma)
                .build();

    }

    @DELETE
    @Path("/{id}")
    public Response delete(@Valid @PathParam("id") Long id) {
        plataformaservice.delete(id);
        return Response
                .status(Status.NO_CONTENT)
                .build();
    }

    @GET
    @Path("/search/{id}")
    public PlataformaResponseDTO searchId(@PathParam("id") Long id) {
        return plataformaservice.findById(id);
    }

    @GET
    @Path("/search/{nome}")
    public List<PlataformaResponseDTO> search(@PathParam("nome") String nome) {
        return plataformaservice.findByNome(nome);
    }

    @GET
    @Path("/count")
    public long count() {
        return plataformaservice.count();
    }

}
