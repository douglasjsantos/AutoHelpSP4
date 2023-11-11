package br.com.fiap.autohelp.dao;

import br.com.fiap.autohelp.beans.Veiculo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VeiculoDAO {
    private Connection conexao;

    public VeiculoDAO() {
        this.conexao = new ConnectionFactory().criaConexao();
    }

    public boolean inserirVeiculo(Veiculo veiculo) {
        String sql = "INSERT INTO veiculo (id_veiculo, placa, marca, modelo, tipo, carga, ano) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, veiculo.getIdVeiculo());
            stmt.setString(2, veiculo.getPlaca());
            stmt.setString(3, veiculo.getMarca());
            stmt.setString(4, veiculo.getModelo());
            stmt.setString(5, veiculo.getTipo());
            stmt.setString(6, veiculo.getCarga());
            stmt.setString(7, veiculo.getAno());

            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir veículo no banco de dados: " + e.getMessage(), e);
        }
    }

    public Veiculo buscarVeiculoPorId(int idVeiculo) {
        String sql = "SELECT * FROM veiculo WHERE id_veiculo = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idVeiculo);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return criarVeiculo(rs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar veículo no banco de dados: " + e.getMessage(), e);
        }

        return null;
    }

    public List<Veiculo> listarVeiculos() {
        List<Veiculo> veiculos = new ArrayList<>();
        String sql = "SELECT * FROM veiculo";
        try (Statement stmt = conexao.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Veiculo veiculo = criarVeiculo(rs);
                veiculos.add(veiculo);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar veículos no banco de dados: " + e.getMessage(), e);
        }

        return veiculos;
    }

    private Veiculo criarVeiculo(ResultSet rs) throws SQLException {
        Veiculo veiculo = new Veiculo();
        veiculo.setIdVeiculo(rs.getInt("id_veiculo"));
        veiculo.setPlaca(rs.getString("placa"));
        veiculo.setMarca(rs.getString("marca"));
        veiculo.setModelo(rs.getString("modelo"));
        veiculo.setTipo(rs.getString("tipo"));
        veiculo.setCarga(rs.getString("carga"));
        veiculo.setAno(rs.getString("ano"));
        return veiculo;
    }
    
    
}
