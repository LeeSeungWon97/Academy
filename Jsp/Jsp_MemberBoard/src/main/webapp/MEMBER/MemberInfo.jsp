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

input[type=submit], input[type=reset] {
	font-size: 15px;
	padding: 10px;
	background-color: white;
	border-color: gray;
	font-weight: bold;
}

input[type=submit]:hover, input[type=reset]:hover {
	cursor: pointer;
	background-color: gray;
	color: white;
}
</style>
</head>

<body>

	<div class="header">
		<h1>MemberInfo.jsp</h1>
	</div>

	<%@ include file="/Menu.jsp"%>

	<div class="contents">
		<table>
			<tr>
				<th>아이디</th>
				<td>${loginMember.mid }</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>${loginMember.mpw }</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>${loginMember.mname }</td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td>${loginMember.mbirth }</td>
			</tr>
			<tr>
				<th>주소</th>
				<td>${loginMember.maddr }</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>${loginMember.memail }</td>
			</tr>
			<tr>
				<th colspan="2">활동 내역</th>
			</tr>
			<tr>
				<th>작성글</th>
				<td>
				전체: ${boardCount}
				<br>
				삭제: ${deleteCount}
				<br>
				정상: ${boardCount - deleteCount }
				</td>
			</tr>
		</table>
	</div>

	<div class="footer">
		<h2>회원게시판</h2>
	</div>



	<script type="text/javascript">
		var msg = '${param.msg}';
		if (msg.length > 0) {
			alert(msg);
		}

		var loginCheck = '${sessionScope.loginId}';
		if (loginCheck.length == 0) {
			alert('로그인 후 이용 가능 합니다.');
			location.href = "${pageContext.request.contextPath }/MEMBER/MemberLogin.jsp";
		}
	</script>
</body>

</html>