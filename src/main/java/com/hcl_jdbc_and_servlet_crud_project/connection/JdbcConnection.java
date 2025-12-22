package com.hcl_jdbc_and_servlet_crud_project.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class JdbcConnection {
	public static Connection getJdbcConnection() {
		try {
			Driver driver = new Driver();
			
			DriverManager.registerDriver(driver);
			
			String url = "jdbc:mysql://localhost:3306/jdbc-m16";
			String username = "root";
			String password = "Mmnir@911mysql";

			Connection connection = DriverManager.getConnection(url, username, password);

			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
