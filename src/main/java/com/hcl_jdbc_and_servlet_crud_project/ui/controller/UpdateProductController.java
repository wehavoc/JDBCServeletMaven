package com.hcl_jdbc_and_servlet_crud_project.ui.controller;

import java.io.IOException;
import java.time.LocalDate;

import com.hcl_jdbc_and_servlet_crud_project.dao.ProductDao;
import com.hcl_jdbc_and_servlet_crud_project.dto.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/update-product")
public class UpdateProductController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			Product product = new Product(Integer.parseInt(req.getParameter("id")), req.getParameter("name"),
					req.getParameter("color"), Double.parseDouble(req.getParameter("price")),
					LocalDate.parse(req.getParameter("mfd")), LocalDate.parse(req.getParameter("expd")));

			Product updatedProduct = new ProductDao().updateProductDao(product);

			if (updatedProduct != null) {
				req.getSession().setAttribute("msg", "Product updated successfully!");
				req.getSession().setAttribute("msgType", "success");
			} else {
				req.getSession().setAttribute("msg", "Failed to update product.");
				req.getSession().setAttribute("msgType", "error");
			}

			// Redirect to clear query string
			res.sendRedirect("view-products.jsp");

		} catch (Exception e) {
			e.printStackTrace();
			req.getSession().setAttribute("msg", "Error: " + e.getMessage());
			req.getSession().setAttribute("msgType", "error");
			res.sendRedirect("view-products.jsp");
		}
	}
}
