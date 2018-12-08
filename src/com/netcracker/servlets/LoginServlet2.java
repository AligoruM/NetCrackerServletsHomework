package com.netcracker.servlets;

import com.netcracker.util.CreateResponse;
import com.netcracker.util.Validation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet2 extends LoginServlet1 {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String password = req.getParameter("password");
        String login = req.getParameter("login");
        if(Validation.checkPassword(password)) {
            CreateResponse.loginSuccessful(resp, login);
        }else{
            resp.sendError(406);
        }

    }
}
