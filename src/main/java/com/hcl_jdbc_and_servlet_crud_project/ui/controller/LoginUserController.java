package com.hcl_jdbc_and_servlet_crud_project.ui.controller;

import java.io.IOException;

import com.hcl_jdbc_and_servlet_crud_project.dao.UserDao;
import com.hcl_jdbc_and_servlet_crud_project.dto.User;
import com.hcl_jdbc_and_servlet_crud_project.util.PasswordUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/login")
public class LoginUserController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        try {
            String email = req.getParameter("email");
            String password = req.getParameter("password");

            UserDao userDao = new UserDao();
            User user = userDao.getUserByEmail(email);

            if (user != null) {
                // check password
                if (PasswordUtil.checkPassword(password, user.getPassword())) {
                		HttpSession session = req.getSession();
                		session.setAttribute("loggedInUser", user.getEmail());
                		
                    // ✅ Login success
                		
                    res.sendRedirect("product-management.jsp");
                } else {
                    // ❌ Password incorrect
                    res.sendRedirect("loginUser.jsp?status=invalid");
                }
            } else {
                // ❌ Email not found
                res.sendRedirect("loginUser.jsp?status=invalid");
            }

        } catch (Exception e) {
            e.printStackTrace();
            res.sendRedirect("loginUser.jsp?status=error");
        }
    }
}
