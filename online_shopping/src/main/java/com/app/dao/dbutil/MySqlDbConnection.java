package com.app.dao.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlDbConnection {
	
	private static Connection connection = null;
		
		private MySqlDbConnection() {
			
		}
		
		public static Connection getConnection() throws ClassNotFoundException, SQLException {
	
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			String url = "jdbc:mysql://localhost:3306/revature_project_1";
			String username = "root";
			String password = "mysqlROOT@1";
			connection = DriverManager.getConnection(url, username, password);
			
			return connection;
			
		}
	

}
