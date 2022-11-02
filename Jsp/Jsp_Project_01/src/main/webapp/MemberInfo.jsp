<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ page import="dto.MemberDto"%>
<%
MemberDto memberInfo = (MemberDto) request.getAttribute("memberInfo");
System.out.println("회원정보: " + memberInfo.getMid());
%>

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
	<h1>MemberInfo.jsp</h1>
	<form action="" method="post">
		<table>
			<tr>
				<th colspan="2">내정보</th>
			</tr>
			<tr>
				<th>아이디</th>
				<td><input readonly="readonly" type="text" name="mid"
					value="<%=memberInfo.getMid()%>"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input readonly="readonly" type="text" name="mpw"
					value="<%=memberInfo.getMpw()%>"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input readonly="readonly" type="text" name="mname"
					value="<%=memberInfo.getMname()%>"></td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td><input readonly="readonly" type="text" name="mbirth"
					value="<%=memberInfo.getMbirth()%>"></td>
			</tr>
			<tr>
				<th colspan="2"><input type="submit" value="정보수정"></th>
			</tr>
		</table>
	</form>
</body>

</html>