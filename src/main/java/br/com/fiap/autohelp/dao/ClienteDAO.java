package br.com.fiap.autohelp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.autohelp.beans.Cliente;


public class ClienteDAO {
	Connection conexao = new ConnectionFactory().criaConexao();
	
	public boolean inserirCliente(Cliente cliente) {
        String sql = "INSERT INTO CLIENTE (ID_CLIENTE, NOME_CLIENTE, CPF) VALUES (?, ?, ?)";

        try (Connection conexao = new ConnectionFactory().criaConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, cliente.getIdCliente());
            stmt.setString(2, cliente.getNomeCliente());
            stmt.setString(3, cliente.getCpf());

            int linhasAfetadas = stmt.executeUpdate();

            return linhasAfetadas > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir cliente no banco de dados: " + e.getMessage(), e);
        }
    }
	
    public Cliente buscarClientePorId(int idCliente) {
        String sql = "SELECT * FROM CLIENTE WHERE ID_CLIENTE = ?";

        try (Connection conexao = new ConnectionFactory().criaConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, idCliente);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setIdCliente(rs.getInt("ID_CLIENTE"));
                    cliente.setNomeCliente(rs.getString("NOME_CLIENTE"));
                    cliente.setCpf(rs.getString("CPF"));
                    return cliente;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar cliente no banco de dados: " + e.getMessage(), e);
        }

        return null;
    }
}
