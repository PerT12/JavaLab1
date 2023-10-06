<%--
  Created by IntelliJ IDEA.
  User: albin
  Date: 05/10/2023
  Time: 09:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login information</title>
</head>
<body>
<%
    // Hämta data från HTML-formuläret
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    // Gör något med data (t.ex. visa det)
%>

<p>Username: <%= username %></p>
<p>Password: <%= password %></p>
</body>
</html>
