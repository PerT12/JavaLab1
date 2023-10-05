<%@ page import="java.util.Collection" %>
<%@ page import="ui.ItemInfo" %>
<%@ page import="bo.ItemHandler" %>
<%@ page import="java.util.Iterator" %><%--
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
<% Collection<ItemInfo> items = ItemHandler.getItemsWithGroup("components");
    Iterator<ItemInfo> it = items.iterator();
    for( ; it.hasNext() ; ) {
        ItemInfo item = it.next();%>
    <%= item.getName()%> :
    <%= item.getDescription()%>
<%  }%>
</body>
</html>