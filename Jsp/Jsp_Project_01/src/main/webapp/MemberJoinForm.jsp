<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
table {
	border: 1px solid black;
	border-collapse: collapse;
}

th, td {
	border: 1px solid black;
	padding: 10px;
}
</style>
</head>

<body>
	<h1>MemberJoinForm.jsp</h1>
	<a href="MainPage.jsp">메인페이지</a>
	<form action="memberJoin" method="post">
		<table>
			<tr>
				<th colspan="2">회원가입</th>
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
				<th>이름</th>
				<td><input type="text" name="mname"></td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td><input type="date" name="mbirth"></td>
			</tr>
			<tr>
				<th colspan="2"><input type="submit" value="회원가입"></th>
			</tr>
		</table>
	</form>
</body>

</html>