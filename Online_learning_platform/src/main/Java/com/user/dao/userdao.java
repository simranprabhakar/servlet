package com.user.dao;

import com.user.model.user;
import java.sql.*;

public class userdao {
    private String jdbcURL = "jdbc:mysql://localhost:3306/olp";
    private String jdbcUsername = "root";
    private String jdbcPassword = "root@123";
    private Connection connection;

    // SQL queries
    private static final String INSERT_USER_SQL = "INSERT INTO users (name, email, password, role) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_USER_SQL = "UPDATE users SET name = ?, email = ?, password = ?, role = ? WHERE user_id = ?";
    private static final String DELETE_USER_SQL = "DELETE FROM users WHERE user_id = ?";
    private static final String SELECT_USER_BY_ID_SQL = "SELECT * FROM users WHERE user_id = ?";

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

    // Insert a new User
    public void addUser(user user) throws SQLException {
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(INSERT_USER_SQL)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getRole());
            ps.executeUpdate();
        }
    }

    // Update an existing User
    public void updateUser(user user) throws SQLException {
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(UPDATE_USER_SQL)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getRole());
            ps.setInt(5, user.getUserId());
            ps.executeUpdate();
        }
    }

    // Delete a User by ID
    public void deleteUser(int userId) throws SQLException {
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(DELETE_USER_SQL)) {
            ps.setInt(1, userId);
            ps.executeUpdate();
        }
    }

    // Get a User by ID
    public user getUserById(int userId) throws SQLException {
    	user user = null;
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_USER_BY_ID_SQL)) {
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new user();
                user.setUserId(rs.getInt("user_id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
            }
        }
        return user;
    }
}
