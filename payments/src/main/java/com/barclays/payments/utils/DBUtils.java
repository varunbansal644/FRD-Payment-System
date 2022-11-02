package com.barclays.payments.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	
	public DBUtils() {
		// TODO Auto-generated constructor stub
	}
	
	private static DBUtils dbUtils;
	
	public Connection getConnection() {
		try {
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/payments",
					"root","root@123");
			return connection;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void closeConnection(Connection connection) {
		
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
