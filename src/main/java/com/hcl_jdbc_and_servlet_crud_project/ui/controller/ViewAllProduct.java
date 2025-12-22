package com.hcl_jdbc_and_servlet_crud_project.ui.controller;

import java.util.List;
import java.io.IOException;

import com.hcl_jdbc_and_servlet_crud_project.dao.ProductDao;
import com.hcl_jdbc_and_servlet_crud_project.dto.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ViewAllProduct extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        ProductDao dao = new ProductDao();
        List<Product> products = dao.getAllProductDetailsDao();

        req.setAttribute("products", products);
        req.getRequestDispatcher("view-products.jsp").forward(req, resp);
    }
}

