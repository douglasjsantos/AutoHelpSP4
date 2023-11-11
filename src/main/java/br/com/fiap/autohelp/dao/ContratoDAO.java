package br.com.fiap.autohelp.dao;

import br.com.fiap.autohelp.beans.Contrato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ContratoDAO {

    public Contrato buscarContratoPorId(int id) {
        String sql = "SELECT * FROM contrato WHERE id_contrato = ?";
        try (Connection connection = new ConnectionFactory().criaConexao();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return criarContrato(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
        return null;
    }

    public boolean criarNovoContrato(Contrato contrato) {
    	String sql = "INSERT INTO contrato (tipo_contrato, codigo_contrato, cobertura_contrato, data_inicio, data_termino, valor_contrato, ativo) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = new ConnectionFactory().criaConexao();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

        	preparedStatement.setString(1, contrato.getTipoContrato());
        	preparedStatement.setString(2, contrato.getCodigoContrato());
        	preparedStatement.setString(3, contrato.getCoberturaContrato());
        	preparedStatement.setDate(4, contrato.getDataInicio());
        	preparedStatement.setDate(5, contrato.getDataTermino());
        	preparedStatement.setDouble(6, contrato.getValorContrato());
        	preparedStatement.setBoolean(7, contrato.isAtivo());

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
        return false;
    }

    private Contrato criarContrato(ResultSet resultSet) throws SQLException {
        Contrato contrato = new Contrato();
        contrato.setIdContrato(resultSet.getInt("id_contrato"));
        contrato.setTipoContrato(resultSet.getString("tipo_contrato"));
        contrato.setCodigoContrato(resultSet.getString("codigo_contrato"));
        contrato.setCoberturaContrato(resultSet.getString("cobertura_contrato"));
        contrato.setDataInicio(resultSet.getDate("data_inicio"));
        contrato.setDataTermino(resultSet.getDate("data_termino"));
        contrato.setValorContrato(resultSet.getDouble("valor_contrato"));
        contrato.setAtivo(resultSet.getBoolean("ativo"));
        return contrato;
    }
    
    
}
