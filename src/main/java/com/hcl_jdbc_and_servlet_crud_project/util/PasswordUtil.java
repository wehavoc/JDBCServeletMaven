package com.hcl_jdbc_and_servlet_crud_project.util;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtil {
	public static String hashedPassword(String plainPassword) {
		return BCrypt.hashpw(plainPassword, BCrypt.gensalt());
	}
	public static boolean checkPassword(String plainPassword, String hashedPassword) {
		return BCrypt.checkpw(plainPassword, hashedPassword);
	}
	public static void main(String[] args) {
		String password = "Solu@123";
		String hashed = hashedPassword(password);
		System.out.println("Hashed Password: " + hashed);
	}
}
