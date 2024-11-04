package fixdrive.system.dao;

import fixdrive.system.model.Feedback;
import fixdrive.system.connection.DataBaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FeedbackDaoImpl implements FeedbackDao {

    @Override
    public Feedback findById(Long id) throws SQLException {
        String sql = "SELECT * FROM T_VB_FEEDBACK WHERE ID_FEEDBACK = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return mapResultSetToFeedback(rs);
            }
        }
        return null;
    }

    @Override
    public List<Feedback> findAll() throws SQLException {
        List<Feedback> feedbacks = new ArrayList<>();
        String sql = "SELECT * FROM T_VB_FEEDBACK";
        try (Connection conn = DataBaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                feedbacks.add(mapResultSetToFeedback(rs));
            }
        }
        return feedbacks;
    }

    @Override
    public Feedback createFeedback(Feedback feedback) throws SQLException {
        String sql = "INSERT INTO T_VB_FEEDBACK (ID_FEEDBACK, DS_COMENTARIO_AVALIATIVO, NR_PONTUACAO_AVALIATIVA, ID_DIAGNOSTICO) " +
                "VALUES (?, ?, ?, ?)";

        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, feedback.getIdFeedback()); // ID gerado manualmente
            stmt.setString(2, feedback.getDsComentarioAvaliativo());
            stmt.setInt(3, feedback.getNrPontuacaoAvaliativa());
            stmt.setLong(4, feedback.getIdDiagnostico());

            stmt.executeUpdate();
        }
        return feedback;
    }

    @Override
    public void update(Feedback feedback) throws SQLException {
        String sql = "UPDATE T_VB_FEEDBACK SET DS_COMENTARIO_AVALIATIVO = ?, NR_PONTUACAO_AVALIATIVA = ?, ID_DIAGNOSTICO = ? " +
                "WHERE ID_FEEDBACK = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, feedback.getDsComentarioAvaliativo());
            stmt.setInt(2, feedback.getNrPontuacaoAvaliativa());
            stmt.setLong(3, feedback.getIdDiagnostico());
            stmt.setLong(4, feedback.getIdFeedback());

            stmt.executeUpdate();
        }
    }

    @Override
    public void deleteById(Long id) throws SQLException {
        String sql = "DELETE FROM T_VB_FEEDBACK WHERE ID_FEEDBACK = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }

    private Feedback mapResultSetToFeedback(ResultSet rs) throws SQLException {
        Feedback feedback = new Feedback();
        feedback.setIdFeedback(rs.getLong("ID_FEEDBACK"));
        feedback.setDsComentarioAvaliativo(rs.getString("DS_COMENTARIO_AVALIATIVO"));
        feedback.setNrPontuacaoAvaliativa(rs.getInt("NR_PONTUACAO_AVALIATIVA"));
        feedback.setIdDiagnostico(rs.getLong("ID_DIAGNOSTICO"));
        return feedback;
    }
}
