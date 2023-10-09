<%@ page import="java.util.Collection" %>
<%@ page import="ui.ItemInfo" %>
<%@ page import="bo.ItemHandler" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
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

<form action="Servlet" method="POST">
    <input type="hidden" name="dataToAdd" value="<%= item.getName() %>">
    <button type="submit">Add to shopping cart</button>
</form>

<%
    }
%>
<%
    List<String> shoppingCart = (List<String>) session.getAttribute("cart");
    for (String element : shoppingCart) {
        out.println(element +"\n");
    }
%>
</body>
</html>