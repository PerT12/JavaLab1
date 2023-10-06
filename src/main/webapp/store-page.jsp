<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Store Front</title>
</head>
<body>
<h1>Store</h1>
 Welcome ${param.username}
<ul>
    <%
        List<String> myList = new ArrayList<>();
        myList.add("Badboll");
        myList.add("Guppy");
        myList.add("Pjäxor");

        for (String element : myList) {
            out.println("<li>" + element + "</li>");
        }
    %>
</ul>
</body>
</html>
