package br.com.fiap.autohelp.controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import br.com.fiap.autohelp.beans.Veiculo;
import br.com.fiap.autohelp.service.VeiculoService;

@Path("veiculos")
public class VeiculoController {
    private VeiculoService veiculoService;

    public VeiculoController() {
        veiculoService = new VeiculoService();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response criarVeiculo(Veiculo veiculo) {
        Response.Status status;
        boolean sucesso = veiculoService.criarNovoVeiculo(veiculo);

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
    public Response getVeiculo(@PathParam("id") int id) {
        Response.Status status;
        Veiculo veiculo = veiculoService.buscarVeiculoPorId(id);

        if (veiculo != null) {
            status = Response.Status.OK;
        } else {
            status = Response.Status.NOT_FOUND;
        }

        return Response.status(status).entity(veiculo).build();
    }
}
