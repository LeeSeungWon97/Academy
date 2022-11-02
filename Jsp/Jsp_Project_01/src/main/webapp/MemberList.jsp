<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
	padding: 10px;
}
</style>
</head>
<body>
	<h1>MemberList.jsp</h1>
	<hr>
	<a href="MainPage.jsp">메인페이지</a>
	<hr>
	<table>
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>생년월일</th>
		</tr>

		<c:forEach items="${memberList }" var="member">

			<tr>
				<td>${member.mid }</td>
				<td>${member.mpw }</td>
				<td>${member.mname }</td>
				<td>${member.mbirth }</td>
			</tr>

		</c:forEach>

	</table>
</body>
</html>