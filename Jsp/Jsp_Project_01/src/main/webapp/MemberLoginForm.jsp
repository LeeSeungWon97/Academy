<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
table {
	border-collapse: collapse;
}

th, td {
	border: 1px solid black;
	padding: 10px;
	text-align: center;
}
</style>
</head>
<body>
	<h1>MemberLoginForm.jsp</h1>
	<a href="MainPage.jsp">메인페이지</a>
	<form action="memberLogin" method="post">
		<table>
			<tr>
				<th colspan="2">로그인</th>
			</tr>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="mid"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="text" name="mpw"></td>
			</tr>
			<tr>
				<th colspan="2"><input type="submit" value="로그인"></th>
			</tr>
		</table>
	</form>
</body>
</html>