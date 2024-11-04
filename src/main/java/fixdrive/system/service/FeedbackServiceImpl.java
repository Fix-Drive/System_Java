package fixdrive.system.service;

import fixdrive.system.dao.FeedbackDao;
import fixdrive.system.model.Feedback;

import java.sql.SQLException;
import java.util.List;

public class FeedbackServiceImpl implements FeedbackService {
    private final FeedbackDao feedbackDao;

    public FeedbackServiceImpl(FeedbackDao feedbackDao) {
        this.feedbackDao = feedbackDao;
    }

    @Override
    public Feedback getFeedbackById(Long id) throws SQLException {
        return feedbackDao.findById(id);
    }

    @Override
    public List<Feedback> getAllFeedbacks() throws SQLException {
        return feedbackDao.findAll();
    }

    @Override
    public Feedback createFeedback(Feedback feedback) throws SQLException {
        return feedbackDao.createFeedback(feedback);
    }

    @Override
    public void updateFeedback(Feedback feedback) throws SQLException {
        feedbackDao.update(feedback);
    }

    @Override
    public void deleteFeedback(Long id) throws SQLException {
        feedbackDao.deleteById(id);
    }
}
