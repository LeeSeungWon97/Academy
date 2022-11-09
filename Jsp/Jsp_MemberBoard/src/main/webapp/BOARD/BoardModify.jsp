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
		<h1>BoardModify.jsp</h1>
	</div>

	<%@ include file="/Menu.jsp"%>

	<div class="contents">
		<h3 style="text-align: center">글작성</h3>

		<form action="${pageContext.request.contextPath }/boardModify"
			method="post">
			<table>
				<tr>
					<th>작성자</th>
					<td><input type="text" name="bwriter"
						value="${boardView.bwriter}" readonly="readonly"></td>
				</tr>
				<tr>
					<th>수정글제목</th>
					<td><input type="text" name="btitle"
						value="${boardView.btitle}"></td>
				</tr>
				<tr>
					<th>수정글내용</th>
					<td><textarea name="bcontent" cols="25" rows="10">${boardView.bcontent}</textarea></td>
				</tr>
				<tr>
					<th colspan="2"><input type="hidden" name="bno"
						value="${boardView.bno}"> <input type="submit"
						value="수정하기"> <input type="button" value="글목록"></th>
				</tr>
			</table>
		</form>
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