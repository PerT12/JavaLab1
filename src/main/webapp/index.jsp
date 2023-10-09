<%@ page import="db.UserDB" %>
<%@ page import="bo.UserHandler" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>DB Test</title>
</head>
<body>
<h1><%= "SQL Database" %>
    <a href="items.jsp">DB</a>
</h1>
Welcome ${param.username}
<%
    String message = (String) request.getAttribute("message");
    out.println("<p>" + message + "</p>");
%>
<%
    UserHandler.logIn(request.getParameter("username"), request.getParameter("password"));
%>

<br/>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>