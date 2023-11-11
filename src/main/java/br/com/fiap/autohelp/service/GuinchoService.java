package br.com.fiap.autohelp.service;

import br.com.fiap.autohelp.beans.Guincho;
import br.com.fiap.autohelp.dao.GuinchoDAO;

public class GuinchoService {
    private GuinchoDAO guinchoDAO;

    public GuinchoService() {
        this.guinchoDAO = new GuinchoDAO();
    }

    public Guincho buscarGuinchoPorId(int id) {
        return guinchoDAO.buscarGuinchoPorId(id);
    }

    public boolean criarNovoGuincho(Guincho guincho) {
        return guinchoDAO.criarNovoGuincho(guincho);
    }


    public void fecharConexao() {
        guinchoDAO.fecharConexao();
    }
}
