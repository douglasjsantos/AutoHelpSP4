package br.com.fiap.autohelp.service;

import br.com.fiap.autohelp.beans.Veiculo;
import br.com.fiap.autohelp.dao.VeiculoDAO;

import java.util.List;

public class VeiculoService {
    private VeiculoDAO veiculoDAO;

    public VeiculoService() {
        this.veiculoDAO = new VeiculoDAO();
    }

    public boolean criarNovoVeiculo(Veiculo veiculo) {
        return veiculoDAO.inserirVeiculo(veiculo);
    }

    public Veiculo buscarVeiculoPorId(int idVeiculo) {
        return veiculoDAO.buscarVeiculoPorId(idVeiculo);
    }

    public List<Veiculo> listarVeiculos() {
        return veiculoDAO.listarVeiculos();
    }
    
   
}
