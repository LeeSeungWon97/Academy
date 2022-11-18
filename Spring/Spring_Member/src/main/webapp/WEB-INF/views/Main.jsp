<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Main.jsp</h1>
	<h2>메인페이지</h2>
	<hr>
	<a href="${pageContext.request.contextPath}/memberJoinForm">회원가입</a>
	<a href="${pageContext.request.contextPath}/memberList">회원목록</a>
	<hr>

	<script type="text/javascript">
		var msg = '${msg}';
		if (msg.length > 0) {
			alert(msg);
		}
	</script>
</body>
</html>