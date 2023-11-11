package br.com.fiap.autohelp.dao;

import br.com.fiap.autohelp.beans.Guincho;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GuinchoDAO {
    private Connection conexao;

    public GuinchoDAO() {
        this.conexao = new ConnectionFactory().criaConexao();
    }

    public Guincho buscarGuinchoPorId(int id) {
        Guincho guincho = null;
        String sql = "SELECT * FROM Guincho WHERE idGuincho = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    guincho = criarGuinchoDoResultSet(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Trate a exceção apropriadamente
        }

        return guincho;
    }

    public boolean criarNovoGuincho(Guincho guincho) {
        String sql = "INSERT INTO Guincho (idGuincho, capacidadeCarga) VALUES (?, ?)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, guincho.getIdGuincho());
            stmt.setDouble(2, guincho.getCapacidadeCarga());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();  // Trate a exceção apropriadamente
            return false;
        }
    }

    // Adicione outros métodos conforme necessário

    private Guincho criarGuinchoDoResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt("idGuincho");
        double capacidadeCarga = rs.getDouble("capacidadeCarga");

        return new Guincho(id, capacidadeCarga);
    }

    // Lembre-se de fechar a conexão quando não for mais necessária
    public void fecharConexao() {
        try {
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Trate a exceção apropriadamente
        }
    }
}
