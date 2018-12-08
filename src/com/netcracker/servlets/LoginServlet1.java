package com.netcracker.servlets;

import com.netcracker.util.Validation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String password = req.getParameter("password");
        String login = req.getParameter("login");
        PrintWriter writer = resp.getWriter();
        resp.setContentType("text/html");
        writer.print("<html>\n<body> <h1> You have sent: </h1></br></br>");
        writer.print("login = " + login + "</br> password = " + password);
        writer.print("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
