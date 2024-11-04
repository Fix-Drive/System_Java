package fixdrive.system.dao;

import fixdrive.system.model.Feedback;

import java.sql.SQLException;
import java.util.List;

public interface FeedbackDao {
    Feedback findById(Long id) throws SQLException;
    List<Feedback> findAll() throws SQLException;
    Feedback createFeedback(Feedback feedback) throws SQLException;
    void update(Feedback feedback) throws SQLException;
    void deleteById(Long id) throws SQLException;
}
