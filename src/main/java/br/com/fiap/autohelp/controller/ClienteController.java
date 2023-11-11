package br.com.fiap.autohelp.controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import br.com.fiap.autohelp.beans.Cliente;
import br.com.fiap.autohelp.service.ClienteService;

@Path("clientes")
public class ClienteController {
    private ClienteService clienteService;

    public ClienteController() {
        clienteService = new ClienteService();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response criarCliente(Cliente cliente) {
        Response.Status status;
        boolean sucesso = clienteService.criarNovoCliente(cliente);

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
    public Response getCliente(@PathParam("id") int id) {
        Response.Status status;
        Cliente cliente = clienteService.buscarClientePorId(id);

        if (cliente != null) {
            status = Response.Status.OK;
        } else {
            status = Response.Status.NOT_FOUND;
        }

        return Response.status(status).entity(cliente).build();
    }
}
