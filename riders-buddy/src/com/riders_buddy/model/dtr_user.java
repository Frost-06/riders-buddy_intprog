package com.riders_buddy.model;

public class dtr_user {
	private static String employeeID;
	private String date, timein, timeout;
	
	public static String getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(String employeeID) {
		dtr_user.employeeID = employeeID;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTimein() {
		return timein;
	}
	public void setTimein(String timein) {
		this.timein = timein;
	}
	public String getTimeout() {
		return timeout;
	}
	public void setTimeout(String timeout) {
		this.timeout = timeout;
	}
}
