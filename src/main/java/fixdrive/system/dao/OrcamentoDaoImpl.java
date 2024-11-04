package fixdrive.system.dao;

import fixdrive.system.model.Orcamento;
import fixdrive.system.connection.DataBaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrcamentoDaoImpl implements OrcamentoDao {

    @Override
    public Orcamento findById(Long id) throws SQLException {
        String sql = "SELECT * FROM T_VB_ORCAMENTO WHERE ID_ORCAMENTO = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return mapResultSetToOrcamento(rs);
            }
        }
        return null;
    }

    @Override
    public List<Orcamento> findAll() throws SQLException {
        List<Orcamento> orcamentos = new ArrayList<>();
        String sql = "SELECT * FROM T_VB_ORCAMENTO";
        try (Connection conn = DataBaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                orcamentos.add(mapResultSetToOrcamento(rs));
            }
        }
        return orcamentos;
    }

    @Override
    public Orcamento createOrcamento(Orcamento orcamento) throws SQLException {
        String sql = "INSERT INTO T_VB_ORCAMENTO (ID_ORCAMENTO, VL_PECA, VL_SERVICO, ID_MANUTENCAO) " +
                "VALUES (?, ?, ?, ?)";

        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, orcamento.getIdOrcamento()); // ID gerado manualmente
            stmt.setDouble(2, orcamento.getVlPeca());
            stmt.setDouble(3, orcamento.getVlServico());
            stmt.setLong(4, orcamento.getIdManutencao());

            stmt.executeUpdate();
        }
        return orcamento;
    }

    @Override
    public void update(Orcamento orcamento) throws SQLException {
        String sql = "UPDATE T_VB_ORCAMENTO SET VL_PECA = ?, VL_SERVICO = ?, ID_MANUTENCAO = ? " +
                "WHERE ID_ORCAMENTO = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, orcamento.getVlPeca());
            stmt.setDouble(2, orcamento.getVlServico());
            stmt.setLong(3, orcamento.getIdManutencao());
            stmt.setLong(4, orcamento.getIdOrcamento());

            stmt.executeUpdate();
        }
    }

    @Override
    public void deleteById(Long id) throws SQLException {
        String sql = "DELETE FROM T_VB_ORCAMENTO WHERE ID_ORCAMENTO = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }

    private Orcamento mapResultSetToOrcamento(ResultSet rs) throws SQLException {
        Orcamento orcamento = new Orcamento();
        orcamento.setIdOrcamento(rs.getLong("ID_ORCAMENTO"));
        orcamento.setVlPeca(rs.getDouble("VL_PECA"));
        orcamento.setVlServico(rs.getDouble("VL_SERVICO"));
        orcamento.setIdManutencao(rs.getLong("ID_MANUTENCAO"));
        return orcamento;
    }
}
