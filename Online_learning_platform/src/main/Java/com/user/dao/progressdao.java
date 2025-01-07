package com.user.dao;

import com.user.model.progress;
import java.sql.*;

public class progressdao {
    private String jdbcURL = "jdbc:mysql://localhost:3306/olp";
    private String jdbcUsername = "root";
    private String jdbcPassword = "root@123";
    private Connection connection;

    // SQL queries
    private static final String INSERT_PROGRESS_SQL = "INSERT INTO progress (learner_id, lesson_id, progress_percentage, completed) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_PROGRESS_SQL = "UPDATE progress SET progress_percentage = ?, completed = ? WHERE progress_id = ?";
    private static final String DELETE_PROGRESS_SQL = "DELETE FROM progress WHERE progress_id = ?";
    private static final String SELECT_PROGRESS_BY_ID_SQL = "SELECT * FROM progress WHERE progress_id = ?";

    // Method to establish a connection to the database
    private Connection getConnection() throws SQLException {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            } catch (SQLException e) {
                throw new SQLException("Connection to database failed.", e);
            }
        }
        return connection;
    }

    // Insert a new Progress record
    public void addProgress(progress progress) throws SQLException {
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(INSERT_PROGRESS_SQL)) {
            ps.setInt(1, progress.getLearnerId());
            ps.setInt(2, progress.getLessonId());
            ps.setBigDecimal(3, progress.getProgressPercentage());
            ps.setBoolean(4, progress.isCompleted());
            ps.executeUpdate();
        }
    }

    // Update an existing Progress record
    public void updateProgress(progress progress) throws SQLException {
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(UPDATE_PROGRESS_SQL)) {
            ps.setBigDecimal(1, progress.getProgressPercentage());
            ps.setBoolean(2, progress.isCompleted());
            ps.setInt(3, progress.getProgressId());
            ps.executeUpdate();
        }
    }

    // Delete a Progress record by ID
    public void deleteProgress(int progressId) throws SQLException {
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(DELETE_PROGRESS_SQL)) {
            ps.setInt(1, progressId);
            ps.executeUpdate();
        }
    }

    // Get a Progress record by ID
    public progress getProgressById(int progressId) throws SQLException {
        progress progress = null;
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_PROGRESS_BY_ID_SQL)) {
            ps.setInt(1, progressId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                progress = new progress();
                progress.setProgressId(rs.getInt("progress_id"));
                progress.setLearnerId(rs.getInt("learner_id"));
                progress.setLessonId(rs.getInt("lesson_id"));
                progress.setProgressPercentage(rs.getBigDecimal("progress_percentage"));
                progress.setCompleted(rs.getBoolean("completed"));
            }
        }
        return progress;
    }
}
