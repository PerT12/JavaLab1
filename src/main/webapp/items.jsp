<%@ page import="java.util.Collection" %>
<%@ page import="ui.ItemInfo" %>
<%@ page import="bo.ItemHandler" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: albin
  Date: 04/10/2023
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DB Test</title>
</head>
<body>
<%
    Collection<ItemInfo> items = ItemHandler.getItems();
    Iterator<ItemInfo> it = items.iterator();
    while (it.hasNext()) {
        ItemInfo item = it.next();
%>
Id: <%= item.getId() %><br>
Item name: <%= item.getName() %><br>
Item description: <%= item.getDescription() %><br>
Price: <%= item.getPrice() %> USD<br>
<form action="HelloServlet" method="POST">
    <input type="hidden" name="dataToAdd" value="<%= item.getName() %>">
    <p>Item name: <%= item.getName() %></p>
    <button type="submit">Lägg till i session</button>
</form>

<%
    }
%>
<%List<String> shoppingCart = (List<String>) session.getAttribute("cart");
    for (String element : shoppingCart) {
        out.println(element +"\n");
    }%>
</body>
</html>






