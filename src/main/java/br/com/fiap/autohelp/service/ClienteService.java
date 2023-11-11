package br.com.fiap.autohelp.service;

import br.com.fiap.autohelp.beans.Cliente;
import br.com.fiap.autohelp.dao.ClienteDAO;


public class ClienteService {
    private ClienteDAO clienteDAO;

    public ClienteService() {
        this.clienteDAO = new ClienteDAO();
    }

    public Cliente buscarClientePorId(int id) {
        return clienteDAO.buscarClientePorId(id);
    }

    public boolean criarNovoCliente(Cliente cliente) {
        return clienteDAO.inserirCliente(cliente);
    }
}
