package com.riders_buddy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.riders_buddy.model.edit_user;

public class edit_userDAO {
	private static final String url = "jdbc:mysql://127.0.0.1:3306/riders-buddy-db";
	private static final String user="root";
	private static final String password="";
	private static final String employeeid=edit_user.getEmployeeId();
	
	public static int userReg(edit_user editUserData) throws ClassNotFoundException {
		String updateUserSQL = "UPDATE `employee-table` set employeeid=?, firstname=?, "
				+ "lastname=?, mi=?, email=?, username=?, password=? WHERE employeeid="+employeeid;
		
		int result = 0;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		try (Connection connection = DriverManager
				.getConnection(url,user,password);
				
				//Create a statement using connection object
				PreparedStatement prepState = connection.prepareStatement(updateUserSQL)) {
				
				prepState.setString(1, edit_user.getEmployeeId());
				prepState.setString(2, editUserData.getFirstname());
				prepState.setString(3, editUserData.getLastname());
				prepState.setString(4, editUserData.getMname());
				prepState.setString(5, editUserData.getEmail());
				prepState.setString(6, editUserData.getUsername());
				prepState.setString(7, editUserData.getPassword());
				
				System.out.println(prepState);
				
				//Execute query or update query
				result = prepState.executeUpdate();
		} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		return result;
	}
}
