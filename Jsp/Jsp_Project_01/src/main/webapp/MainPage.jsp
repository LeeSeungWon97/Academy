<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String loginId = (String) session.getAttribute("loginId");
	System.out.println("MainPage: " + loginId);
	%>

	<h1>MainPage.jsp</h1>
	<hr>
	<a href="MainPage.jsp">메인페이지</a>
	<c:choose>

		<c:when test="${sessionScope.loginId == null }">
			<a href="MemberLoginForm.jsp">로그인</a>
			<a href="MemberJoinForm.jsp">회원가입</a>
		</c:when>

		<c:otherwise>
			<a href="memberInfo?loginId=<%=loginId%>">내정보확인</a>
			<a href="">로그아웃</a>
		</c:otherwise>

	</c:choose>

	<hr>

	<a href="memberList">회원목록</a>
	<h2><%=loginId%></h2>
	<h2>${sessionScope.loginid }</h2>

</body>
</html>