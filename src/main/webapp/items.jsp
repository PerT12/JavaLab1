<%@ page import="ui.ItemInfo" %>
<%@ page import="bo.ItemHandler" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Items</title>
</head>
<body>
<% List<ItemInfo> items = ItemHandler.getAllItems();
    Iterator<ItemInfo> it = items.iterator();
    for( ; it.hasNext() ; ) {
        ItemInfo item = it.next();%>
    <a href="">Add to shopping cart</a><br>
    Id: <%= item.getId()%><br>
    Name: <%= item.getName()%><br>
    Description: <%= item.getDescription()%><br>
    Price: <%= item.getPrice()%> USD<br><br>
<%  }%>
</body>
</html>