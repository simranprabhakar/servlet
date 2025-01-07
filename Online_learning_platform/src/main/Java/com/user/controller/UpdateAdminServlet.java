package com.user.controller;

import com.user.model.admin;
import com.user.service.AdminService;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

public class UpdateAdminServlet extends HttpServlet {
    private AdminService adminService;

    @Override
    public void init() throws ServletException {
        adminService = new AdminService();
    }

    // Handles POST requests to update an existing admin
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String adminIdStr = request.getParameter("adminId");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        int adminId = Integer.parseInt(adminIdStr);
        admin admin = new admin(adminId, name, email, password);

        try {
            adminService.updateAdmin(admin);
            response.sendRedirect("admin_dashboard.jsp"); // Redirect to the dashboard after updating
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Unable to update admin");
        }
    }

    @Override
    public void destroy() {
        adminService = null;
    }
}
