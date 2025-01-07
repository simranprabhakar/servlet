package com.user.model;

public class user {
	private int userId;
    private String name;
    private String email;
    private String password;
    private String role; // "Instructor" or "Learner"
	public user() {
		super();
		// TODO Auto-generated constructor stub
	}
	public user(int userId, String name, String email, String password, String role) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "user [userId=" + userId + ", name=" + name + ", email=" + email + ", password=" + password + ", role="
				+ role + "]";
	}
    

}
