package com.user.controller;

import com.user.service.AdminService;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

public class DeleteAdminServlet extends HttpServlet {
    private AdminService adminService;

    @Override
    public void init() throws ServletException {
        adminService = new AdminService();
    }

    // Handles GET requests to delete an admin
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int adminId = Integer.parseInt(request.getParameter("id"));

        try {
            adminService.deleteAdmin(adminId);
            response.sendRedirect("admin_dashboard.jsp"); // Redirect to the dashboard after deleting
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Unable to delete admin");
        }
    }

    @Override
    public void destroy() {
        adminService = null;
    }
}
