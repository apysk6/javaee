<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="storage" class="com.example.servletjspdemo.service.StorageService" scope="application" />
<jsp:useBean id="guitar" class="com.example.servletjspdemo.domain.Guitar" scope="session" />

<% 
	int size = storage.getAllGuitars().size() +1;
%>
 <%java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy"); %>
<form action="addGuitarFinal.jsp">
  
  ID: <input type="text" name="id" value=<%=size%>  /><br />
  Producer: <input type="text" name="producer" value="${guitar.producer}" /><br />
  Make date: <input type="text" name="makeDate" value="${guitar.makeDate}" /><br />
  Price: <input type="text" name="price" value="${guitar.price}" /><br />
  <input type="submit" value=" OK ">
  
  </form>

</body>
</html>