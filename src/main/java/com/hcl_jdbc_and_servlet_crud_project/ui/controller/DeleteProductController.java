package com.hcl_jdbc_and_servlet_crud_project.ui.controller;

import java.io.IOException;
import com.hcl_jdbc_and_servlet_crud_project.dao.ProductDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/delete")
public class DeleteProductController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("DeleteProductController doGet() method called");

        try {
            int id = Integer.parseInt(req.getParameter("id"));
            System.out.println("Product ID to delete: " + id);

            ProductDao productDao = new ProductDao();
            boolean isDeleted = productDao.deleteProductByIdDao(id);

            // ✅ Set toast message in session
            if (isDeleted) {
                req.getSession().setAttribute("msg", "Product deleted successfully!");
                req.getSession().setAttribute("msgType", "success");
                System.out.println("Product with ID " + id + " deleted successfully.");
            } else {
                req.getSession().setAttribute("msg", "Failed to delete product!");
                req.getSession().setAttribute("msgType", "error");
                System.out.println("Failed to delete product with ID " + id + ".");
            }

            // Redirect to view-products.jsp to clear query string
            res.sendRedirect("view-products.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            // Optional: show error in toast
            req.getSession().setAttribute("msg", "Error: " + e.getMessage());
            req.getSession().setAttribute("msgType", "error");
            res.sendRedirect("view-products.jsp");
        }
    }
}
