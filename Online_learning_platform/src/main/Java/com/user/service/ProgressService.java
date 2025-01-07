package com.user.service;

import com.user.dao.progressdao;
import com.user.model.progress;
import java.sql.SQLException;

public class ProgressService {
    private progressdao progressDAO;

    public ProgressService() {
        progressDAO = new progressdao(); // Create an instance of ProgressDAO
    }

    public void addProgressp(progress progress) throws SQLException {
        progressDAO.addProgress(progress); // Call DAO method to add progress
    }

    public void updateProgress(progress progress) throws SQLException {
        progressDAO.updateProgress(progress); // Call DAO method to update progress
    }

    public void deleteProgress(int progressId) throws SQLException {
        progressDAO.deleteProgress(progressId); // Call DAO method to delete progress
    }

    public progress getProgressById(int progressId) throws SQLException {
        return progressDAO.getProgressById(progressId); // Call DAO method to fetch progress by ID
    }
}
