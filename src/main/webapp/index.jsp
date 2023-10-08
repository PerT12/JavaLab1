<%@ page import="db.UserDB" %>
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
    String user = request.getParameter("username");
    String pass = request.getParameter("password");
    UserDB.addUser(user, pass);
%>

<br/>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>