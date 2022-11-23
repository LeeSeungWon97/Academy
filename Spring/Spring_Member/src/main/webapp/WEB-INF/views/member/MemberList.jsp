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
	<h1>member/MemberList.jsp</h1>
	<h2>회원리스트</h2>
	<hr>
	<a href="${pageContext.request.contextPath }/">메인페이지</a>
	<hr>
		<table>
			<tr>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
				<th>생년월일</th>
			</tr>
			<c:forEach items="${memberList }" var="memberList">
				<tr>
					<td>${memberList.mid}</td>
					<td>${memberList.mpw}</td>
					<td>${memberList.mname}</td>
					<td>${memberList.mbirth}</td>
				</tr>
			</c:forEach>
		</table>
</body>
</html>