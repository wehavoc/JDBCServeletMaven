package com.hcl_jdbc_and_servlet_crud_project.ui.controller;

import java.io.IOException;
import java.time.LocalDate;

import com.hcl_jdbc_and_servlet_crud_project.dao.ProductDao;
import com.hcl_jdbc_and_servlet_crud_project.dto.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings({"serial"})
public class RegisterProductController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException {

	    try {
	        Product product = new Product(
	                Integer.parseInt(req.getParameter("id")),
	                req.getParameter("name"),
	                req.getParameter("color"),
	                Double.parseDouble(req.getParameter("price")),
	                LocalDate.parse(req.getParameter("mfd")),
	                LocalDate.parse(req.getParameter("expd"))
	        );

	        Product savedProduct = new ProductDao().saveProductDao(product);

	        if (savedProduct != null) {
	            req.setAttribute("product", savedProduct);
	            req.getRequestDispatcher("success.jsp").forward(req, resp);
	        } else {
	            req.setAttribute("error", "Database error while saving product");
	            req.getRequestDispatcher("error.jsp").forward(req, resp);
	        }

	    } catch (Exception e) {
	        // Handles NumberFormatException, DateTimeParseException, etc.
	        e.printStackTrace();
	        resp.sendRedirect("error.jsp");
	    }
	}

}
