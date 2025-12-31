package com.hcl_jdbc_and_servlet_crud_project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hcl_jdbc_and_servlet_crud_project.connection.JdbcConnection;
import com.hcl_jdbc_and_servlet_crud_project.dto.User;
import com.hcl_jdbc_and_servlet_crud_project.util.PasswordUtil;

public class UserDao {
	public User register(User user) {
		String insertUserQuery = "insert into users(id, name, email, password) values(?,?,?,?)";
		try ( Connection connection = JdbcConnection.getJdbcConnection();
			PreparedStatement ps = connection.prepareStatement(insertUserQuery);) {
			ps.setInt(1, user.getId());
			ps.setString(2, user.getName());
			ps.setString(3, user.getEmail());
			
			String hashedPassword = PasswordUtil.hashedPassword(user.getPassword());
			ps.setString(4, hashedPassword);
			
			int a = ps.executeUpdate();
			return a != 0 ? user : null;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public User getUserByEmail(String email) {
	    String query = "SELECT * FROM users WHERE email = ?";
	    try (Connection connection = JdbcConnection.getJdbcConnection();
	         PreparedStatement ps = connection.prepareStatement(query)) {

	        ps.setString(1, email);
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            return new User(
	                rs.getInt("id"),
	                rs.getString("name"),
	                rs.getString("email"),
	                rs.getString("password") // hashed password
	            );
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}

	public boolean isEmailExists(String email) {
	    String query = "SELECT 1 FROM users WHERE email = ?";

	    try (
	        Connection connection = JdbcConnection.getJdbcConnection();
	        PreparedStatement ps = connection.prepareStatement(query)
	    ) {
	        ps.setString(1, email);
	        ResultSet rs = ps.executeQuery();
	        return rs.next(); // true if email exists
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}
	
	public int getNextUserId() {
	    String query = "SELECT MAX(id) AS max_id FROM users";
	    try (Connection connection = JdbcConnection.getJdbcConnection();
	         PreparedStatement ps = connection.prepareStatement(query);
	         ResultSet rs = ps.executeQuery()) {

	        if (rs.next()) {
	            return rs.getInt("max_id") + 1;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return 101; // Start IDs from 1 if table is empty
	}
}
