package com.user.controller;

import com.user.model.admin;
import com.user.service.AdminService;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

public class AddAdminServlet extends HttpServlet {
    private AdminService adminService;

    @Override
    public void init() throws ServletException {
        adminService = new AdminService();
    }

    // Handles POST requests to add a new admin
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        admin admin = new admin(0, name, email, password); // id = 0 since it's a new admin

        try {
            adminService.addAdmin(admin);
            response.sendRedirect("admin_dashboard.html"); // Redirect to the dashboard after adding
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Unable to add admin");
        }
    }

    @Override
    public void destroy() {
        adminService = null;
    }
}
