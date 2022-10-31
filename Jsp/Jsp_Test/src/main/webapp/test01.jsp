<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% String tData01 = (String) request.getAttribute("tData01"); %>

	<h1>test01</h1>
	<h2><%=tData01 %></h2>
</body>
</html>