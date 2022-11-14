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
		<h1>Main.jsp</h1>
	</div>

	<%@ include file="/Menu.jsp"%>

	<div class="contents">
		<h2>콘텐츠영역</h2>
		<h3>로그인 아이디: ${loginId }</h3>
	</div>

	<div class="footer">
		<h2>Order</h2>
	</div>

</body>

</html>