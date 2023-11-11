package br.com.fiap.autohelp.service;

import br.com.fiap.autohelp.beans.Contrato;
import br.com.fiap.autohelp.dao.ContratoDAO;


public class ContratoService {
    private ContratoDAO contratoDAO;

    public ContratoService() {
        this.contratoDAO = new ContratoDAO();
    }

    public Contrato buscarContratoPorId(int id) {
        return contratoDAO.buscarContratoPorId(id);
    }

    public boolean criarNovoContrato(Contrato contrato) {
        return contratoDAO.criarNovoContrato(contrato);
    }

}
