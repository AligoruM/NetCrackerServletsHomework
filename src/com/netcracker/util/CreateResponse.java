package com.netcracker.util;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CreateResponse {
    public static void loginSuccessful(HttpServletResponse resp, String login) throws IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        out.print("<html>\n<body> <center><h1> You have been logged as: </h1></br></br>");
        out.print(login);
        out.print("</center></body></html>");
    }
}
