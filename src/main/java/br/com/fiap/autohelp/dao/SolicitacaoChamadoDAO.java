package br.com.fiap.autohelp.dao;

import br.com.fiap.autohelp.beans.SolicitacaoChamado;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SolicitacaoChamadoDAO {
    private Connection conexao;

    public SolicitacaoChamadoDAO() {
        this.conexao = new ConnectionFactory().criaConexao();
    }

    public void inserirSolicitacaoChamado(SolicitacaoChamado solicitacaoChamado) {
        String sql = "INSERT INTO solicitacao_chamado (numero_solicitacao, descricao, responsavel, data_abertura, id_veiculo, id_guincho, id_contrato) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, solicitacaoChamado.getNumeroSolicitacao());
            stmt.setString(2, solicitacaoChamado.getDescricao());
            stmt.setString(3, solicitacaoChamado.getResponsavel());
            stmt.setDate(4, solicitacaoChamado.getDataAbertura());
            stmt.setInt(5, solicitacaoChamado.getIdVeiculo());
            stmt.setInt(6, solicitacaoChamado.getIdGuincho());
            stmt.setInt(7, solicitacaoChamado.getIdContrato());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public SolicitacaoChamado buscarSolicitacaoChamadoPorNumero(int numeroSolicitacao) {
        String sql = "SELECT * FROM solicitacao_chamado WHERE numero_solicitacao = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, numeroSolicitacao);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return criarSolicitacaoChamado(rs);
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<SolicitacaoChamado> listarSolicitacoesChamado() {
        List<SolicitacaoChamado> solicitacoes = new ArrayList<>();
        String sql = "SELECT * FROM solicitacao_chamado";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                solicitacoes.add(criarSolicitacaoChamado(rs));
            }

            return solicitacoes;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private SolicitacaoChamado criarSolicitacaoChamado(ResultSet rs) throws SQLException {
        SolicitacaoChamado solicitacaoChamado = new SolicitacaoChamado();
        solicitacaoChamado.setNumeroSolicitacao(rs.getInt("numero_solicitacao"));
        solicitacaoChamado.setDescricao(rs.getString("descricao"));
        solicitacaoChamado.setResponsavel(rs.getString("responsavel"));
        solicitacaoChamado.setDataAbertura(rs.getDate("data_abertura"));
        solicitacaoChamado.setIdVeiculo(rs.getInt("id_veiculo"));
        solicitacaoChamado.setIdGuincho(rs.getInt("id_guincho"));
        solicitacaoChamado.setIdContrato(rs.getInt("id_contrato"));

        return solicitacaoChamado;
    }
}
