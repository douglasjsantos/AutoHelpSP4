package br.com.fiap.autohelp.controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import br.com.fiap.autohelp.beans.Guincho;
import br.com.fiap.autohelp.service.GuinchoService;

@Path("guinchos")
public class GuinchoController {
    private GuinchoService guinchoService;

    public GuinchoController() {
        guinchoService = new GuinchoService();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response criarGuincho(Guincho guincho) {
        Response.Status status;
        boolean sucesso = guinchoService.criarNovoGuincho(guincho);

        if (sucesso) {
            status = Response.Status.CREATED;
        } else {
            status = Response.Status.INTERNAL_SERVER_ERROR;
        }

        return Response.status(status).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGuincho(@PathParam("id") int id) {
        Response.Status status;
        Guincho guincho = guinchoService.buscarGuinchoPorId(id);

        if (guincho != null) {
            status = Response.Status.OK;
        } else {
            status = Response.Status.NOT_FOUND;
        }

        return Response.status(status).entity(guincho).build();
    }
}
