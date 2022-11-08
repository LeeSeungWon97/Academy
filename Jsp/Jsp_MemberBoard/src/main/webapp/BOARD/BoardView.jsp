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
		<table>
			<tr>
				<th><input readonly="readonly" type="text" name="btitle"
					value="${boardView.btitle }"></th>
				<td><input readonly="readonly" type="text" name="bhits"
					value="${boardView.bhits }"></input></td>
			</tr>
			<tr>
				<td><textarea readonly="readonly" name="bcontent" cols="30"
						rows="10">${boardView.bcontent }</textarea></td>
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
	</script>
</body>

</html>