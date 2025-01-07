package com.user.model;

public class admin { // lowercase model class
    private int adminid;
    private String name;
    private String email;
    private String password;

    // Constructor
    public admin(int adminid, String name, String email, String password) {
        this.adminid = adminid;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // Getters and setters
    public int getAdminid() {
        return adminid;
    }

    public void setAdminid(int adminid) {
        this.adminid = adminid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
