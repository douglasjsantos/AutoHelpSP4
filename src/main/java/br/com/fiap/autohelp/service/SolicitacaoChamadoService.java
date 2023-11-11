package br.com.fiap.autohelp.service;

import br.com.fiap.autohelp.beans.SolicitacaoChamado;
import br.com.fiap.autohelp.dao.SolicitacaoChamadoDAO;

import java.util.List;

public class SolicitacaoChamadoService {
    private SolicitacaoChamadoDAO solicitacaoChamadoDAO;

    public SolicitacaoChamadoService() {
        this.solicitacaoChamadoDAO = new SolicitacaoChamadoDAO();
    }

    public void criarNovaSolicitacaoChamado(SolicitacaoChamado solicitacaoChamado) {
        solicitacaoChamadoDAO.inserirSolicitacaoChamado(solicitacaoChamado);
    }

    public SolicitacaoChamado buscarSolicitacaoChamadoPorNumero(int numeroSolicitacao) {
        return solicitacaoChamadoDAO.buscarSolicitacaoChamadoPorNumero(numeroSolicitacao);
    }

    public List<SolicitacaoChamado> listarSolicitacoesChamado() {
        return solicitacaoChamadoDAO.listarSolicitacoesChamado();
    }
}
