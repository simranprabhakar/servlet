package com.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/olp"; // Update with your DB URL
    private static final String USER = "root"; // Update with your DB username
    private static final String PASSWORD = "root"; // Update with your DB password

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}