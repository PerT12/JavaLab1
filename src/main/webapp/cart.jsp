<%@ page import="java.util.List" %>
<%@ page import="ui.ItemInfo" %>
<%@ page import="java.util.Iterator" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Shopping Cart</title>
</head>
<body>
<%
    List<ItemInfo> shoppingCart = (List<ItemInfo>) session.getAttribute("cart");
    Iterator<ItemInfo> it = shoppingCart.iterator();
    while (it.hasNext()) {
        ItemInfo item = it.next();
%>
Id: <%= item.getId() %><br>
Item name: <%= item.getName() %><br>
Item description: <%= item.getDescription() %><br>
Price: <%= item.getPrice() %> USD<br>

<%
    }
%>
</body>
</html>
