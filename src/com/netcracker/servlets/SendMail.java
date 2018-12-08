package com.netcracker.servlets;

import com.netcracker.util.MailUtil;
import com.netcracker.util.Validation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class SendMail extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("mail");
        String subject = req.getParameter("title");
        String text = req.getParameter("message");
        switch (Validation.checkAllForMail(email, subject, text)) {
            case IS_OK:
                MailUtil.sendMessage(email, subject, text);
                req.getRequestDispatcher("emailSuccess.html").forward(req, resp);
                break;
            case MAIL_IS_EMPTY:
                req.setAttribute("TypeError", Validation.MailErrors.MAIL_IS_EMPTY);
                break;
            case MAIL_IS_NOT_VALID:
                req.setAttribute("TypeError", Validation.MailErrors.MAIL_IS_NOT_VALID);
                break;
            case SUBJECT_IS_EMPTY:
                req.setAttribute("TypeError", Validation.MailErrors.SUBJECT_IS_EMPTY);
                break;
            case TEXT_IS_EMPTY:
                req.setAttribute("TypeError", Validation.MailErrors.TEXT_IS_EMPTY);
                break;
        }
        req.getRequestDispatcher("emailFail.jsp").forward(req, resp);
    }


}
