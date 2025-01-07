package com.user.dao;

import com.user.model.lessons;
import java.sql.*;

public class lessonesdao {
    private String jdbcURL = "jdbc:mysql://localhost:3306/olp";
    private String jdbcUsername = "root";
    private String jdbcPassword = "root@123";
    private Connection connection;

    // SQL queries
    private static final String INSERT_LESSON_SQL = "INSERT INTO lessons (title, content, instructor_id) VALUES (?, ?, ?)";
    private static final String UPDATE_LESSON_SQL = "UPDATE lessons SET title = ?, content = ?, instructor_id = ? WHERE lesson_id = ?";
    private static final String DELETE_LESSON_SQL = "DELETE FROM lessons WHERE lesson_id = ?";
    private static final String SELECT_LESSON_BY_ID_SQL = "SELECT * FROM lessons WHERE lesson_id = ?";

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

    // Insert a new Lesson
    public void addLesson(lessons lesson) throws SQLException {
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(INSERT_LESSON_SQL)) {
            ps.setString(1, lesson.getTitle());
            ps.setString(2, lesson.getContent());
            ps.setInt(3, lesson.getInstructorId());
            ps.executeUpdate();
        }
    }

    // Update an existing Lesson
    public void updateLesson(lessons lesson) throws SQLException {
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(UPDATE_LESSON_SQL)) {
            ps.setString(1, lesson.getTitle());
            ps.setString(2, lesson.getContent());
            ps.setInt(3, lesson.getInstructorId());
            ps.setInt(4, lesson.getLessonId());
            ps.executeUpdate();
        }
    }

    // Delete a Lesson by ID
    public void deleteLesson(int lessonId) throws SQLException {
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(DELETE_LESSON_SQL)) {
            ps.setInt(1, lessonId);
            ps.executeUpdate();
        }
    }

    // Get a Lesson by ID
    public lessons getLessonById(int lessonId) throws SQLException {
        lessons lesson = null;
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_LESSON_BY_ID_SQL)) {
            ps.setInt(1, lessonId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                lesson = new lessons();
                lesson.setLessonId(rs.getInt("lesson_id"));
                lesson.setTitle(rs.getString("title"));
                lesson.setContent(rs.getString("content"));
                lesson.setInstructorId(rs.getInt("instructor_id"));
            }
        }
        return lesson;
    }
}
