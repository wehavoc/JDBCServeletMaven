package com.hcl_jdbc_and_servlet_crud_project.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.hcl_jdbc_and_servlet_crud_project.dao.ProductDao;
import com.hcl_jdbc_and_servlet_crud_project.dto.Product;

public class InsertMultipleProductsController {

	public static void main(String[] args) {
		ProductDao dao = new ProductDao();

		// Product 1
		Product p1 = new Product();
		p1.setId(113);
		p1.setName("RC car");
		p1.setColor("black");
		p1.setPrice(1200);
		p1.setMfd(LocalDate.parse("2025-02-03"));
		p1.setExpd(LocalDate.parse("2027-02-03"));

		Product p2 = new Product();
		p2.setId(114);
		p2.setName("Drone");
		p2.setColor("white");
		p2.setPrice(3500);
		p2.setMfd(LocalDate.parse("2025-01-15"));
		p2.setExpd(LocalDate.parse("2027-01-15"));

		Product p3 = new Product();
		p3.setId(115);
		p3.setName("Smart Watch");
		p3.setColor("silver");
		p3.setPrice(2200);
		p3.setMfd(LocalDate.parse("2025-03-10"));
		p3.setExpd(LocalDate.parse("2028-03-10"));

		Product p4 = new Product();
		p4.setId(116);
		p4.setName("Bluetooth Speaker");
		p4.setColor("blue");
		p4.setPrice(800);
		p4.setMfd(LocalDate.parse("2024-12-20"));
		p4.setExpd(LocalDate.parse("2027-12-20"));

		Product p5 = new Product();
		p5.setId(117);
		p5.setName("Gaming Mouse");
		p5.setColor("black");
		p5.setPrice(1500);
		p5.setMfd(LocalDate.parse("2025-04-01"));
		p5.setExpd(LocalDate.parse("2028-04-01"));

		Product p6 = new Product();
		p6.setId(118);
		p6.setName("VR Headset");
		p6.setColor("gray");
		p6.setPrice(5000);
		p6.setMfd(LocalDate.parse("2025-05-12"));
		p6.setExpd(LocalDate.parse("2029-05-12"));

		List<Product> products = new ArrayList<Product>(Arrays.asList(p1, p2, p3, p4, p5, p6));
		dao.saveMultipleProductDao(products);
		

	}

}
