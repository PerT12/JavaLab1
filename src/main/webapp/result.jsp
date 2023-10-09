<%--
  Created by IntelliJ IDEA.
  User: albin
  Date: 09/10/2023
  Time: 18:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Resultat</title>
</head>
<body>
<p>Data i sessionsvariabeln:</p>
<%
    // Hämta värdet från sessionsvariabeln och skriv ut det
    String sessionData = (String) session.getAttribute("sessionData");
    out.println("<p>" + sessionData + "</p>");
%>
</body>
</html>

