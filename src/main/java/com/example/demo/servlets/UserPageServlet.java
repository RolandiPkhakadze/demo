package com.example.demo.servlets;

import com.example.demo.controllers.User;
import com.example.demo.daos.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UserPageServlet", value = "/UserPageServlet")
public class UserPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String mail = request.getParameter("mail");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String password = request.getParameter("password");
        String repeatedPassword = request.getParameter("reppassword");
        String profession = request.getParameter("profession");

        User user = (User) request.getSession().getAttribute("user");

        if(!username.isEmpty()){
            user.setUsername(username);
        }
        if(!firstname.isEmpty()){
            user.setFirstName(firstname);
        }
        if(!lastname.isEmpty()){
            user.setLastName(lastname);
        }
        if(!mail.isEmpty()){
            user.setMail(mail);
        }
        if(!profession.isEmpty()){
            user.setProfession(profession);
        }
        if(!password.isEmpty()){
            if(password.equals(repeatedPassword)) {
                user.setPassword(password);
            }else {
                request.setAttribute("updateStatus", "not same passwords idiot");
                request.getRequestDispatcher("user-page.jsp").forward(request,response);
            }
        }

        UserDao userDao = new UserDao();
        try {
            userDao.updateUser(user);
            request.getRequestDispatcher("user-page.jsp").forward(request,response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
