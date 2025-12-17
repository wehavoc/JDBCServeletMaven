package com.hcl_jdbc_and_servlet_crud_project.controller;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.hcl_jdbc_and_servlet_crud_project.dao.ProductDao;
import com.hcl_jdbc_and_servlet_crud_project.dto.Product;

public class GetAllProductAscByPrice {

	public static void main(String[] args) {
		List<Product> products =  new ProductDao().getAllProductDetailsDao();
		
		System.out.println("===============Before Sorted==============");
		for (Product product : products) {
			System.out.println(product);
		}
		System.out.println("===============After Sorted==============");
		
		List<Product> products2 = products.stream().sorted(Comparator.comparing(Product::getPrice)).collect(Collectors.toList());
		for (Product product : products2) {
			System.out.println(product);
		}
		
		

	}

}
