package com.hcl_jdbc_and_servlet_crud_project.ui.controller;

import java.io.IOException;

import com.hcl_jdbc_and_servlet_crud_project.dao.UserDao;
import com.hcl_jdbc_and_servlet_crud_project.dto.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/register")
public class RegisterUserController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        try {
            String email = req.getParameter("email");

            UserDao userDao = new UserDao();

            // ✅ check email already exists
            if (userDao.isEmailExists(email)) {
                res.sendRedirect("register.jsp?status=emailExists");
                return;
            }

            User user = new User(
                Integer.parseInt(req.getParameter("id")),
                req.getParameter("name"),
                email,
                req.getParameter("password")
            );

            User savedUser = userDao.register(user);

            if (savedUser != null) {
                res.sendRedirect("register.jsp?status=success");
            } else {
                res.sendRedirect("register.jsp?status=error");
            }

        } catch (Exception e) {
            e.printStackTrace();
            res.sendRedirect("register.jsp?status=error");
        }
    }
}

