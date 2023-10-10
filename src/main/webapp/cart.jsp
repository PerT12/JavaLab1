<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Shopping Cart</title>
</head>
<body>
<%
    List<String> shoppingCart = (List<String>) session.getAttribute("cart");
    for (String element : shoppingCart) {
        out.println(element);
        out.println("<br>");
    }
%>
</body>
</html>