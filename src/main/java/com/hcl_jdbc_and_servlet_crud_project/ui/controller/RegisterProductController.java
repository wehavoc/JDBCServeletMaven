package com.hcl_jdbc_and_servlet_crud_project.ui.controller;

import java.io.IOException;
import java.time.LocalDate;

import com.hcl_jdbc_and_servlet_crud_project.dao.ProductDao;
import com.hcl_jdbc_and_servlet_crud_project.dto.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
//@WebServlet("/product-register")
public class RegisterProductController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			Product product = new Product(Integer.parseInt(req.getParameter("id")), req.getParameter("name"),
					req.getParameter("color"), Double.parseDouble(req.getParameter("price")),
					LocalDate.parse(req.getParameter("mfd")), LocalDate.parse(req.getParameter("expd")));

			Product savedProduct = new ProductDao().saveProductDao(product);

			if (savedProduct != null) {
				req.getSession().setAttribute("msg", "Product registered successfully!");
				req.getSession().setAttribute("msgType", "success");
			} else {
				req.getSession().setAttribute("msg", "Failed to register product.");
				req.getSession().setAttribute("msgType", "error");
			}

			// Redirect to view-products.jsp to clear query string
			resp.sendRedirect("view-products.jsp");

		} catch (Exception e) {
			e.printStackTrace();
			req.getSession().setAttribute("msg", "Error: " + e.getMessage());
			req.getSession().setAttribute("msgType", "error");
			resp.sendRedirect("view-products.jsp");
		}
	}
}
