package com.user.dao;

import com.user.model.admin; // lowercase model
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class admindao { // lowercase DAO class
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/olp";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "mysqlsimmy1102$$";

    // Add an admin to the database
    public void addAdmin(admin admin) throws SQLException {
        String query = "INSERT INTO admins (name, email, password) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, admin.getName());
            ps.setString(2, admin.getEmail());
            ps.setString(3, admin.getPassword());
            ps.executeUpdate();
        }
    }

    // Update an existing admin
    public void updateAdmin(admin admin) throws SQLException {
        String query = "UPDATE admins SET name = ?, email = ?, password = ? WHERE adminid = ?";
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, admin.getName());
            ps.setString(2, admin.getEmail());
            ps.setString(3, admin.getPassword());
            ps.setInt(4, admin.getAdminid());
            ps.executeUpdate();
        }
    }

    // Delete an admin by ID
    public void deleteAdmin(int adminid) throws SQLException {
        String query = "DELETE FROM admins WHERE adminid = ?";
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, adminid);
            ps.executeUpdate();
        }
    }

    // Get an admin by ID
    public admin getAdminById(int adminid) throws SQLException {
        String query = "SELECT * FROM admins WHERE adminid = ?";
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, adminid);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new admin(rs.getInt("adminid"), rs.getString("name"), rs.getString("email"), rs.getString("password"));
            }
        }
        return null;
    }

    // Get all admins
    public List<admin> getAllAdmins() throws SQLException {
        List<admin> admins = new ArrayList<>();
        String query = "SELECT * FROM admins";
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                admins.add(new admin(rs.getInt("adminid"), rs.getString("name"), rs.getString("email"), rs.getString("password")));
            }
        }
        return admins;
    }

    // Get an admin by email
    public admin getAdminByEmail(String email) throws SQLException {
        String query = "SELECT * FROM admins WHERE email = ?";
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new admin(rs.getInt("adminid"), rs.getString("name"), rs.getString("email"), rs.getString("password"));
            }
        }
        return null;
    }
}