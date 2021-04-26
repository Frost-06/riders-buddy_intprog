package com.riders_buddy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.riders_buddy.model.dtr_user;

public class dtr_userDAO {
	private static final String url = "jdbc:mysql://127.0.0.1:3306/riders-buddy-db";
	private static final String user="root";
	private static final String password="";
	
	public static int userDTR(dtr_user dtr) throws ClassNotFoundException {
		String insertUserSQL = "INSERT INTO `dtr-table`" +
								"(employeeid, date, timein, timeout) VALUES" +
								"(?, ?, ?, ?)";
		
		int result = 0;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		try (Connection connection = DriverManager
				.getConnection(url,user,password);
				
				//Create a statement using connection object
				PreparedStatement prepState = connection.prepareStatement(insertUserSQL)) {
			
				prepState.setString(1, dtr_user.getEmployeeID());
				prepState.setString(2, dtr.getDate());
				prepState.setString(3, dtr.getTimein());
				prepState.setString(4, dtr.getTimeout());
				
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
