package com.hcl_jdbc_and_servlet_crud_project.controller;

import com.hcl_jdbc_and_servlet_crud_project.dao.ProductDao;
import com.hcl_jdbc_and_servlet_crud_project.dto.Product;

public class DisplayProductByIdController {

	public static void main(String[] args) {
		ProductDao dao = new ProductDao();
		Product product = dao.DisplayProductByIdDao(112);
		System.out.println(product);

	}

}
