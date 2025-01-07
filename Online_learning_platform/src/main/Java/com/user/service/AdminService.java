package com.user.service;

import java.sql.SQLException;
import java.util.List;
import com.user.dao.admindao; // lowercase DAO class
import com.user.model.admin; // lowercase model class

public class AdminService { // lowercase service class
    private admindao admindao; // lowercase DAO variable

    public AdminService() {
        admindao = new admindao(); // Create an instance of admindao
    }

    public void addAdmin(admin admin) throws SQLException {
        admindao.addAdmin(admin); // Call DAO method to add an admin
    }

    public void updateAdmin(admin admin) throws SQLException {
        admindao.updateAdmin(admin); // Call DAO method to update an admin
    }

    public void deleteAdmin(int adminid) throws SQLException {
        admindao.deleteAdmin(adminid); // Call DAO method to delete an admin
    }

    public admin getAdminById(int adminid) throws SQLException {
        return admindao.getAdminById(adminid); // Call DAO method to fetch an admin by ID
    }

    // Get Admin by Email
    public admin getAdminByEmail(String email) throws SQLException {
        return admindao.getAdminByEmail(email); // Call DAO method to fetch an admin by email
    }

    // Get all admins (for listing purposes)
    public List<admin> getAllAdmins() throws SQLException {
        return admindao.getAllAdmins(); // Call DAO method to fetch all admins
    }
}
