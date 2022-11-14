<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/CSS/Main.css">

<style type="text/css">
table>caption {
	font-weight: bold;
}

th, td {
	padding: 8px;
}

input[type=text], input[type=date] {
	width: 220px;
	font-size: 18px;
	border: 0px;
	border-bottom: 3px solid gray;
}

input[type=text]:focus {
	outline: none;
}

div.contents>form>table {
	margin-left: auto;
	margin-right: auto;
	width: 680;
}

input[type=submit] {
	font-size: 15px;
	padding: 10px;
	background-color: white;
	border-color: gray;
	font-weight: bold;
}

input[type=submit]:hover {
	cursor: pointer;
	background-color: gray;
	color: white;
}
</style>
</head>

<body>

	<div class="header">
		<h1>MemberLogin.jsp</h1>
	</div>

	<%@ include file="/Menu.jsp"%>

	<div class="contents">

		<h3 style="text-align: center;">로그인</h3>
		<form action="${pageContext.request.contextPath}/memberLogin"
			method="post">

			<table>
				<tr>
					<th>아이디</th>
					<td><input type="text" name="mid" placeholder="아이디"></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="text" name="mpw" placeholder="비밀번호"></td>
				</tr>
				<tr>
					<th colspan="3"><input type="submit" value="로그인"></th>
				</tr>
			</table>
		</form>
	</div>

	<div class="footer">
		<h2>Order</h2>
	</div>

</body>

</html>