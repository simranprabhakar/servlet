package com.user.service;

import com.user.dao.userdao;
import com.user.model.user;
import java.sql.SQLException;

public class UserService {
    private userdao userDAO;

    public UserService() {
        userDAO = new userdao(); // Create an instance of UserDAO
    }

    public void addUser(user user) throws SQLException {
        userDAO.addUser(user); // Call DAO method to add a user
    }

    public void updateUser(user user) throws SQLException {
        userDAO.updateUser(user); // Call DAO method to update a user
    }

    public void deleteUser(int userId) throws SQLException {
        userDAO.deleteUser(userId); // Call DAO method to delete a user
    }

    public user getUserById(int userId) throws SQLException {
        return userDAO.getUserById(userId); // Call DAO method to fetch a user by ID
    }
}
