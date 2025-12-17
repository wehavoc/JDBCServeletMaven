package com.hcl_jdbc_and_servlet_crud_project.controller;



import java.util.List;

import com.hcl_jdbc_and_servlet_crud_project.dao.ProductDao;
import com.hcl_jdbc_and_servlet_crud_project.dto.Product;

public class getProductsByPriceUsingStoreProcedureController {

	public static void main(String[] args) {
		List<Product> products = new ProductDao().getMultipleProductByPriceDao(5000);
		if(!products.isEmpty()) {
			products.forEach(System.out::println);
		}

	}

}
