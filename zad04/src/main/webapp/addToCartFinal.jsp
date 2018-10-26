<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "java.io.*,java.util.*, javax.servlet.*, com.example.servletjspdemo.domain.Guitar" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:setProperty name="id" property="*" /> 
<jsp:useBean id="storage" class="com.example.servletjspdemo.service.StorageService" scope="application" />
<jsp:useBean id="guitar" class="com.example.servletjspdemo.domain.Guitar" scope="session" />

<% 
	List<Guitar> availableGuitars = storage.getAllGuitars();
	Guitar guitarToCart = availableGuitars.get(Integer.parseInt(id - 1));

	storage.addToCart(guitarToCart);
	response.sendRedirect("cart");
%>
</body>
</html>