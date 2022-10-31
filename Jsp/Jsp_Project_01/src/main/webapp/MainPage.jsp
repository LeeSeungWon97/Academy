<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>MainPage.jsp</h1>
	<hr>
	<a href="MainPage.jsp">메인페이지</a>
	<a href="MemberLoginForm.jsp">로그인</a>
	<hr>
	<%String loginId = (String) session.getAttribute("loginId");%>
	<%String reLoginId = (String) request.getAttribute("reLoginId");%>
	<h2>session: <%=loginId%></h2>
	<h2>request: <%=reLoginId %></h2>


</body>
</html>