package com.hcl_jdbc_and_servlet_crud_project.controller;

import com.hcl_jdbc_and_servlet_crud_project.dao.ProductDao;

public class DeleteProductByIdController {
	public static void main(String[] args) {
		ProductDao dao = new ProductDao();
		boolean b = dao.deleteProductByIdDao(101);
		String msg = b ? "Deleted" : "given id not found or something went wrong";
		System.out.println(msg);
		
	}
}
