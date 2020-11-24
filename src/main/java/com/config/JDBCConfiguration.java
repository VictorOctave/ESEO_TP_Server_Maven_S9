package com.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class JDBCConfiguration {
	
	public static final ResourceBundle CONFIGURATION = ResourceBundle.getBundle("application");
	
	private JDBCConfiguration() {
		
	}
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/twic?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
		String user = CONFIGURATION.getString("user");
		String pass = CONFIGURATION.getString("password");
	    return DriverManager.getConnection(url, user, pass);
	}

}
