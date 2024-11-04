package fixdrive.system.dao;

import fixdrive.system.model.Problema;
import fixdrive.system.connection.DataBaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProblemaDaoImpl implements ProblemaDao {

    @Override
    public Problema findById(Long id) throws SQLException {
        String sql = "SELECT * FROM T_VB_PROBLEMA WHERE ID_PROBLEMA = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return mapResultSetToProblema(rs);
            }
        }
        return null;
    }

    @Override
    public List<Problema> findAll() throws SQLException {
        List<Problema> problemas = new ArrayList<>();
        String sql = "SELECT * FROM T_VB_PROBLEMA";
        try (Connection conn = DataBaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                problemas.add(mapResultSetToProblema(rs));
            }
        }
        return problemas;
    }

    @Override
    public Problema createProblema(Problema problema) throws SQLException {
        String sql = "INSERT INTO T_VB_PROBLEMA (ID_PROBLEMA, DS_TIPO_PROBLEMA, DS_DESCRICAO, NR_PONTUACAO_GRAVIDADE, ID_AUTOMOVEL) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, problema.getIdProblema()); // ID gerado manualmente
            stmt.setString(2, problema.getTipoProblema());
            stmt.setString(3, problema.getDescricao());
            stmt.setInt(4, problema.getPontuacaoGravidade());
            stmt.setLong(5, problema.getIdAutomovel());

            stmt.executeUpdate();
        }
        return problema;
    }

    @Override
    public void update(Problema problema) throws SQLException {
        String sql = "UPDATE T_VB_PROBLEMA SET DS_TIPO_PROBLEMA = ?, DS_DESCRICAO = ?, NR_PONTUACAO_GRAVIDADE = ?, ID_AUTOMOVEL = ? " +
                "WHERE ID_PROBLEMA = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, problema.getTipoProblema());
            stmt.setString(2, problema.getDescricao());
            stmt.setInt(3, problema.getPontuacaoGravidade());
            stmt.setLong(4, problema.getIdAutomovel());
            stmt.setLong(5, problema.getIdProblema());

            stmt.executeUpdate();
        }
    }

    @Override
    public void deleteById(Long id) throws SQLException {
        String sql = "DELETE FROM T_VB_PROBLEMA WHERE ID_PROBLEMA = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }

    private Problema mapResultSetToProblema(ResultSet rs) throws SQLException {
        Problema problema = new Problema();
        problema.setIdProblema(rs.getLong("ID_PROBLEMA"));
        problema.setTipoProblema(rs.getString("DS_TIPO_PROBLEMA"));
        problema.setDescricao(rs.getString("DS_DESCRICAO"));
        problema.setPontuacaoGravidade(rs.getInt("NR_PONTUACAO_GRAVIDADE"));
        problema.setIdAutomovel(rs.getLong("ID_AUTOMOVEL"));
        return problema;
    }
}
