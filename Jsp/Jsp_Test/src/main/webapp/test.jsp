<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String str = "String 변수";
	%>
	<h1>테스트 페이지</h1>
	<h2><%=str%></h2>
	<a href="test01.jsp">test01 페이지</a>
	<hr>
	<a href="TestController">TestController 페이지</a>
	<a href="TestController02">TestController02 페이지</a>
</body>
</html>