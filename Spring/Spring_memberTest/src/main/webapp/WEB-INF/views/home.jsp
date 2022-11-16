<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>

	<P>The time on the server is ${serverTime}.</P>
	<a href="testPage">테스트 페이지</a>
	<hr>
	<a href="${pageContext.request.contextPath }/testPage">테스트 페이지</a>
	<hr>
	<a href="${pageContext.request.contextPath }/mavTest">mav 테스트</a>
	<hr>
	
	<h2>데이터 전송</h2>
	<form action="${pageContext.request.contextPath }/submitTest" method="get">
		<input type="text" name="testId" placeholder="아이디"><br>
		<input type="text" name="testPw" placeholder="비밀번호"><br>
		<input type="submit">
	</form>
	
	<hr>
	
	<form action="${pageContext.request.contextPath }/submitTest2" method="get">
		<input type="submit">
	</form>
	
	<hr>
	
	<form action="${pageContext.request.contextPath }/submitDto" method="get">
		<input type="text" name="testId" placeholder="아이디"><br>
		<input type="text" name="testPw" placeholder="비밀번호"><br>
		<input type="text" name="testName" placeholder="이름"><br>
		<input type="date" name="testBirth" placeholder="생년월일"><br>
		<input type="submit">
	</form>
</body>
</html>
