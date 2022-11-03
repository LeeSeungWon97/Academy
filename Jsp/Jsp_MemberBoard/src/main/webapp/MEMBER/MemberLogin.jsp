<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/CSS/Main.css">
</head>

<body>

	<div class="header">
		<h1>MemberLogin.jsp</h1>
	</div>

	<%@ include file="/Menu.jsp"%>

	<div class="contents">
		<h2>콘텐츠영역</h2>
		<form action="${pageContext.request.contextPath }/memberLogin"
			method="get">
			<input type="submit" value="로그인">
		</form>
	</div>

	<div class="footer">
		<h2>회원게시판</h2>
	</div>

</body>

</html>