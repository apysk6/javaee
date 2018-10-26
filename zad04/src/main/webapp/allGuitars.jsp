<%@page import="com.example.servletjspdemo.domain.Guitar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="storage" class="com.example.servletjspdemo.service.StorageService" scope="application" />
<%
for (Guitar guitar: storage.getAllGuitars()) {
	out.println("<p>Id: " + guitar.getId() + "</p>");
	out.println("<p>Producer: " + guitar.getProducer() + "</p>");
	out.println("<p>Made date: " + guitar.getMakeDate() + "</p>");
	out.println("<p>Price: " + guitar.getPrice() + "</p>");
	out.println("<p>Is Reserved: " + guitar.getIsReserved() + "</p>");
	out.println("<form action='addGuitarToCartData'><input type='hidden' name='add' value='" + guitar.getId() +"' ><button type='submit'>Add to cart</button></form>");
}
%>
<p>
  <a href="addGuitarData.jsp">Add another guitar</a>
</p>

</body>
</html>