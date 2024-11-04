package fixdrive.system.dao;

import fixdrive.system.model.Diagnostico;
import fixdrive.system.connection.DataBaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DiagnosticoDaoImpl implements DiagnosticoDao {

    @Override
    public Diagnostico findById(Long id) throws SQLException {
        String sql = "SELECT * FROM T_VB_DIAGNOSTICO WHERE ID_DIAGNOSTICO = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return mapResultSetToDiagnostico(rs);
            }
        }
        return null;
    }

    @Override
    public List<Diagnostico> findAll() throws SQLException {
        List<Diagnostico> diagnosticos = new ArrayList<>();
        String sql = "SELECT * FROM T_VB_DIAGNOSTICO";
        try (Connection conn = DataBaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                diagnosticos.add(mapResultSetToDiagnostico(rs));
            }
        }
        return diagnosticos;
    }

    @Override
    public Diagnostico createDiagnostico(Diagnostico diagnostico) throws SQLException {
        String sql = "INSERT INTO T_VB_DIAGNOSTICO (ID_DIAGNOSTICO, DS_RESULTADO_DIAGNOSTICO, ID_PROBLEMA, ID_AUTOMOVEL) " +
                "VALUES (?, ?, ?, ?)";

        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, diagnostico.getIdDiagnostico()); // ID gerado manualmente
            stmt.setString(2, diagnostico.getResultadoDiagnostico());
            stmt.setLong(3, diagnostico.getIdProblema());
            stmt.setLong(4, diagnostico.getIdAutomovel());

            stmt.executeUpdate();
        }
        return diagnostico;
    }

    @Override
    public void update(Diagnostico diagnostico) throws SQLException {
        String sql = "UPDATE T_VB_DIAGNOSTICO SET DS_RESULTADO_DIAGNOSTICO = ?, ID_PROBLEMA = ?, ID_AUTOMOVEL = ? " +
                "WHERE ID_DIAGNOSTICO = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, diagnostico.getResultadoDiagnostico());
            stmt.setLong(2, diagnostico.getIdProblema());
            stmt.setLong(3, diagnostico.getIdAutomovel());
            stmt.setLong(4, diagnostico.getIdDiagnostico());

            stmt.executeUpdate();
        }
    }

    @Override
    public void deleteById(Long id) throws SQLException {
        String sql = "DELETE FROM T_VB_DIAGNOSTICO WHERE ID_DIAGNOSTICO = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }

    private Diagnostico mapResultSetToDiagnostico(ResultSet rs) throws SQLException {
        Diagnostico diagnostico = new Diagnostico();
        diagnostico.setIdDiagnostico(rs.getLong("ID_DIAGNOSTICO"));
        diagnostico.setResultadoDiagnostico(rs.getString("DS_RESULTADO_DIAGNOSTICO"));
        diagnostico.setIdProblema(rs.getLong("ID_PROBLEMA"));
        diagnostico.setIdAutomovel(rs.getLong("ID_AUTOMOVEL"));
        return diagnostico;
    }
}
