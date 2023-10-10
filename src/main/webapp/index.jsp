<%@ page import="bo.UserHandler" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>DB Test</title>
</head>
<body>
Welcome ${param.username}
<%
    String message = (String) request.getAttribute("message");
    out.println("<p>" + message + "</p>");
%>
<%
    UserHandler.logIn(request.getParameter("username"), request.getParameter("password"));
%>
<a href="items.jsp">View products</a>
</body>
</html>