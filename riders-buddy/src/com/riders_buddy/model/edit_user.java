package com.riders_buddy.model;


public class edit_user {
	private static String employeeid;
	private String firstname;
	private String lastname;
	private String mi;
	private String email;
	private String username;
	private String password;
	
	public static String getEmployeeId() {
		return employeeid;
	}
	public void setEmployeeId(String userID) {
		edit_user.employeeid = userID;
	}
	public String getFirstname() {
		return firstname.toUpperCase();
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname.toUpperCase();
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getMname() {
		return mi.toUpperCase();
	}
	public void setMname(String mi) {
		this.mi = mi;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
