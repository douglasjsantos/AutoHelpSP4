package br.com.fiap.autohelp.controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import br.com.fiap.autohelp.beans.Contrato;
import br.com.fiap.autohelp.service.ContratoService;

@Path("contratos")
public class ContratoController {
    private ContratoService contratoService;

    public ContratoController() {
        contratoService = new ContratoService();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response criarContrato(Contrato contrato) {
        Response.Status status;
        boolean sucesso = contratoService.criarNovoContrato(contrato);

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
    public Response getContrato(@PathParam("id") int id) {
        Response.Status status;
        Contrato contrato = contratoService.buscarContratoPorId(id);

        if (contrato != null) {
            status = Response.Status.OK;
        } else {
            status = Response.Status.NOT_FOUND;
        }

        return Response.status(status).entity(contrato).build();
    }
}
