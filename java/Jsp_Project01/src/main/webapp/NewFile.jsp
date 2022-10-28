<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test01</title>
</head>
<body>
	<%String str = "테스트 페이지 입니다."; %>
	<h1><%=str %></h1>
	
	<% int number = 5;
	if(number >= 10){%>
	  <h2>10보다 크거나 같다.</h2>
	<%} else {%>
		<h2>10보다 작다</h2>
	<% }%>
	
	<a href="TestController">TestController </a>
	
</body>
</html>