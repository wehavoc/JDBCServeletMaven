package com.hcl_jdbc_and_servlet_crud_project.controller;

import java.util.List;

import com.hcl_jdbc_and_servlet_crud_project.dao.ProductDao;
import com.hcl_jdbc_and_servlet_crud_project.dto.Product;

public class DisplayAllProductController {

	public static void main(String[] args) {
		List<Product> products = new ProductDao().getAllProductDetailsDao();
		if (!products.isEmpty() && products != null) {
			System.out.println(products.size() + " Products found:");
			for(Product product : products) {
				System.out.println(product);
			}
		}


	}

}
