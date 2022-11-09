<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<h1>BoardView.jsp</h1>
	</div>

	<%@ include file="/Menu.jsp"%>

	<div class="contents">
		<table>
			<tr>
				<th>제목</th>
				<td colspan="2">"${boardView.btitle }"</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>"${boardView.bwriter }"</td>
				<th>작성일</th>
				<td>"${boardView.bdate }"</td>
				<th>조회수</th>
				<td>${boardView.bhits }</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>${boardView.bcontent }</td>
			</tr>

			<tr>
				<th colspan="2"><input type="button" value="글목록"></th>

				<c:if test="${sessionScope.loginId == boardView.bwriter}">
					<th colspan="2"><input type="button" value="글수정"
						onclick="modifyPage('${boardView.bno}')"></th>
					<th colspan="2"><input type="button" value="글삭제"
						onclick="deleteBoard('${boardView.bno}')"></th>
				</c:if>
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

		function modifyPage(bno) {
			location.href = "${pageContext.request.contextPath }/boardModifyPage?bno="
					+ bno;
		}

		function deleteBoard(bno) {
			location.href = "${pageContext.request.contextPath }/boardDelete?bno="
					+ bno;
		}
	</script>
</body>

</html>