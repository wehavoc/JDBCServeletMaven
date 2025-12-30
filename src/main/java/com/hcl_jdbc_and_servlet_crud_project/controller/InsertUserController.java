package com.hcl_jdbc_and_servlet_crud_project.controller;

import com.hcl_jdbc_and_servlet_crud_project.dao.UserDao;
import com.hcl_jdbc_and_servlet_crud_project.dto.User;

public class InsertUserController {

	public static void main(String[] args) {
		User user = new User(101, "Solu", "solu@gmailcom", "Solu@123");
		User savedUser = new UserDao().register(user);
		
		if(savedUser != null) {
			System.out.println("Uesr registered successfully");
			System.out.println(user);
		}else {
			System.out.println("Faild to register user ");
		}
	}
}
