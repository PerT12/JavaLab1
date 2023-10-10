<%@ page import="java.util.Collection" %>
<%@ page import="ui.ItemInfo" %>
<%@ page import="bo.ItemHandler" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products</title>
</head>
<body>
<a href="cart.jsp">View shopping cart</a><br><br>
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

<form action="Servlet" method="POST">
        <input type="hidden" name="itemId" placeholder="<%= item.getId() %>">
        <input type="hidden" name="itemName" placeholder="<%= item.getName() %>">
        <input type="hidden" name="itemPrice" placeholder="<%= item.getPrice() %>">
    <button type="submit">Add to shopping cart</button>
</form>

<%
    }
%>
</body>
</html>