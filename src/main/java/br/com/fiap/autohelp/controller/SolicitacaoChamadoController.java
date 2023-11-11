package br.com.fiap.autohelp.controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import br.com.fiap.autohelp.beans.SolicitacaoChamado;
import br.com.fiap.autohelp.service.SolicitacaoChamadoService;

@Path("solicitacoes")
public class SolicitacaoChamadoController {
    private SolicitacaoChamadoService solicitacaoChamadoService;

    public SolicitacaoChamadoController() {
        solicitacaoChamadoService = new SolicitacaoChamadoService();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response criarSolicitacao(SolicitacaoChamado solicitacao) {
        Response.Status status;
        solicitacaoChamadoService.criarNovaSolicitacaoChamado(solicitacao);
        status = Response.Status.CREATED;

        return Response.status(status).build();
    }

    @GET
    @Path("/{numeroSolicitacao}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSolicitacao(@PathParam("numeroSolicitacao") int numeroSolicitacao) {
        Response.Status status;
        SolicitacaoChamado solicitacao = solicitacaoChamadoService.buscarSolicitacaoChamadoPorNumero(numeroSolicitacao);

        if (solicitacao != null) {
            status = Response.Status.OK;
        } else {
            status = Response.Status.NOT_FOUND;
        }

        return Response.status(status).entity(solicitacao).build();
    }
}
