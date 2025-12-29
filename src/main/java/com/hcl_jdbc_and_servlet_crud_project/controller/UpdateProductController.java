package com.hcl_jdbc_and_servlet_crud_project.controller;

import java.time.LocalDate;

import com.hcl_jdbc_and_servlet_crud_project.dao.ProductDao;
import com.hcl_jdbc_and_servlet_crud_project.dto.Product;

public class UpdateProductController {
	public static void main(String[] args) {

		// Create Product object
		Product product = new Product();
		product.setId(102);
		product.setName("Mobile");
		product.setColor("Silver");
		product.setPrice(18000.0);
		product.setMfd(LocalDate.of(2025, 1, 5));
		product.setExpd(LocalDate.of(2027, 1, 5));

		// Call DAO
		ProductDao dao = new ProductDao();
		Product savedProduct = dao.saveProductDao(product);

		// Check result
		if (savedProduct != null) {
			System.out.println("Product inserted successfully:");
			System.out.println(savedProduct);
		} else {
			System.out.println("Failed to insert product.");
		}
	}
}
