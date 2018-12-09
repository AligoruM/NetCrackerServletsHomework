<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.text.DateFormat" %>
<!DOCTYPE html>
<html>
<head>
    <title>Some data about you</title>
    <meta charset="UTF-8">
</head>
<body>
<center>
    <h1>
        <% out.println("Some information:");%>
    </h1>
        <%
            DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            out.println("<br>Datetime = " + sdf.format(new Date()));
            out.println("<br>You use = " + request.getHeader("User-Agent"));
        %>
</center>
</body>
</html>