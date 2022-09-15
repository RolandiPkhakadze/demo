package com.example.demo.servlets;

import com.example.demo.controllers.User;
import com.example.demo.daos.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String unameOrmail = request.getParameter("username");
        String password = request.getParameter("password");

        UserDao userDao = new UserDao();
        try {
            User currUser = userDao.getUserDataByUsernameOrMail(unameOrmail);
            if(currUser == null) {
                request.setAttribute("loginStatus", "wrong uname");
                request.getRequestDispatcher("index.jsp").forward(request,response);
                return;
            }
            if(!currUser.getPassword().equals(password)){
                request.setAttribute("loginStatus", "incorrect pass");
                request.getRequestDispatcher("index.jsp").forward(request,response);
                return;
            }
            request.getSession().setAttribute("user", currUser);
            request.setAttribute("user", currUser);
            request.getRequestDispatcher("user-page.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
