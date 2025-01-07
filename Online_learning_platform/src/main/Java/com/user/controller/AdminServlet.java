package com.user.controller;

import com.user.model.admin; // lowercase class name
import com.user.service.AdminService; // lowercase service class

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AdminServlet extends HttpServlet { // lowercase servlet class
    private AdminService adminservice; // lowercase service variable

    @Override
    public void init() throws ServletException {
        adminservice = new AdminService(); // Initialize service
    }

    // Handles GET requests (show admin details or form)
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            if ("edit".equals(action)) {
                // Edit an admin
                int adminid = Integer.parseInt(request.getParameter("id"));
                admin admin = adminservice.getAdminById(adminid);
                request.setAttribute("admin", admin);
                request.getRequestDispatcher("/admin_form.jsp").forward(request, response);
            } else if ("delete".equals(action)) {
                // Delete an admin
                int adminid = Integer.parseInt(request.getParameter("id"));
                adminservice.deleteAdmin(adminid);
                response.sendRedirect("admin_dashboard.jsp"); // Redirect to dashboard after delete
            } else {
                // Display all admins (for example purposes)
                List<admin> admins = adminservice.getAllAdmins();
                request.setAttribute("admins", admins);
                request.getRequestDispatcher("/admin_dashboard.jsp").forward(request, response);
            }
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace(); // Use a logger in production
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Unable to retrieve or process the admin data");
        }
    }

    // Handles POST requests (add or update an admin)
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm_password");

        // Check if passwords match
        if (!password.equals(confirmPassword)) {
            request.setAttribute("error", "Passwords do not match");
            request.getRequestDispatcher("/admin_add.h").forward(request, response);
            return;
        }

        // Check if an adminid is present (for editing an existing admin)
        String adminidstr = request.getParameter("adminid");
        admin admin;

        if (adminidstr != null && !adminidstr.isEmpty()) {
            // Edit existing admin
            int adminid = Integer.parseInt(adminidstr);
            admin = new admin(adminid, name, email, password);
            try {
                adminservice.updateAdmin(admin);
                response.sendRedirect("admin_dashboard.html"); // Redirect after update
            } catch (SQLException e) {
                e.printStackTrace();
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Unable to update admin");
            }
        } else {
            // Add new admin
            admin = new admin(0, name, email, password); // id = 0 for new admin
            try {
                adminservice.addAdmin(admin);
                response.sendRedirect("admin_dashboard.html"); // Redirect after adding
            } catch (SQLException e) {
                e.printStackTrace();
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Unable to add admin");
            }
        }
    }

    @Override
    public void destroy() {
        adminservice = null;
    }
}
