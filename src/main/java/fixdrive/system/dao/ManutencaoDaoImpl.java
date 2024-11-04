package fixdrive.system.dao;

import fixdrive.system.model.Manutencao;
import fixdrive.system.connection.DataBaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ManutencaoDaoImpl implements ManutencaoDao {

    @Override
    public Manutencao findById(Long id) throws SQLException {
        String sql = "SELECT * FROM T_VB_MANUTENCAO WHERE ID_MANUTENCAO = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return mapResultSetToManutencao(rs);
            }
        }
        return null;
    }

    @Override
    public List<Manutencao> findAll() throws SQLException {
        List<Manutencao> manutencoes = new ArrayList<>();
        String sql = "SELECT * FROM T_VB_MANUTENCAO";
        try (Connection conn = DataBaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                manutencoes.add(mapResultSetToManutencao(rs));
            }
        }
        return manutencoes;
    }

    @Override
    public Manutencao createManutencao(Manutencao manutencao) throws SQLException {
        String sql = "INSERT INTO T_VB_MANUTENCAO (ID_MANUTENCAO, DS_TIPO_MANUTENCAO, DS_DESCRICAO, DS_PECA_MANUTENCAO, " +
                "DS_RECOMENDACAO_OFICINA, ID_DIAGNOSTICO, ID_PROBLEMA, ID_AUTOMOVEL) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, manutencao.getIdManutencao()); // ID gerado manualmente
            stmt.setString(2, manutencao.getTipoManutencao());
            stmt.setString(3, manutencao.getDescricao());
            stmt.setString(4, manutencao.getPecaManutencao());
            stmt.setString(5, manutencao.getRecomendacaoOficina());
            stmt.setLong(6, manutencao.getIdDiagnostico());
            stmt.setLong(7, manutencao.getIdProblema());
            stmt.setLong(8, manutencao.getIdAutomovel());

            stmt.executeUpdate();
        }
        return manutencao;
    }

    @Override
    public void update(Manutencao manutencao) throws SQLException {
        String sql = "UPDATE T_VB_MANUTENCAO SET DS_TIPO_MANUTENCAO = ?, DS_DESCRICAO = ?, DS_PECA_MANUTENCAO = ?, " +
                "DS_RECOMENDACAO_OFICINA = ?, ID_DIAGNOSTICO = ?, ID_PROBLEMA = ?, ID_AUTOMOVEL = ? " +
                "WHERE ID_MANUTENCAO = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, manutencao.getTipoManutencao());
            stmt.setString(2, manutencao.getDescricao());
            stmt.setString(3, manutencao.getPecaManutencao());
            stmt.setString(4, manutencao.getRecomendacaoOficina());
            stmt.setLong(5, manutencao.getIdDiagnostico());
            stmt.setLong(6, manutencao.getIdProblema());
            stmt.setLong(7, manutencao.getIdAutomovel());
            stmt.setLong(8, manutencao.getIdManutencao());

            stmt.executeUpdate();
        }
    }

    @Override
    public void deleteById(Long id) throws SQLException {
        String sql = "DELETE FROM T_VB_MANUTENCAO WHERE ID_MANUTENCAO = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }

    private Manutencao mapResultSetToManutencao(ResultSet rs) throws SQLException {
        Manutencao manutencao = new Manutencao();
        manutencao.setIdManutencao(rs.getLong("ID_MANUTENCAO"));
        manutencao.setTipoManutencao(rs.getString("DS_TIPO_MANUTENCAO"));
        manutencao.setDescricao(rs.getString("DS_DESCRICAO"));
        manutencao.setPecaManutencao(rs.getString("DS_PECA_MANUTENCAO"));
        manutencao.setRecomendacaoOficina(rs.getString("DS_RECOMENDACAO_OFICINA"));
        manutencao.setIdDiagnostico(rs.getLong("ID_DIAGNOSTICO"));
        manutencao.setIdProblema(rs.getLong("ID_PROBLEMA"));
        manutencao.setIdAutomovel(rs.getLong("ID_AUTOMOVEL"));
        return manutencao;
    }
}
