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
<style>
table>caption {
	font-weight: bold;
}

table {
	border-collapse: collapse;
}

th, td {
	padding: 8px;
	border: 1px solid black;
}
</style>
</head>

<body>
	<div class="header">
		<h1>BoardList.jsp</h1>
	</div>

	<%@ include file="/Menu.jsp"%>

	<div class="contents">
		<h2>글목록페이지</h2>
		<!-- 글번호, 글제목, 글작성자, 작성일, 조회수 -->
		<table>
			<thead>
				<tr>
					<th>글번호</th>
					<th>글제목</th>
					<th>글작성자</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${boardList }" var="board">
					<tr>
						<td>${board.bno }</td>
						<td><a
							href="${pageContext.request.contextPath }/boardView?viewBno=${board.bno }">${board.btitle }</a></td>
						<td>${board.bwriter }</td>
						<td>${board.bdate }</td>
						<td>${board.bhits }</td>
					</tr>
				</c:forEach>
			</tbody>

			<tfoot>
				<tr>
					<th colspan="5">
						<form action="" method="get" style="display: inline-block;">
							<select>
								<option value="title">제목</option>
								<option value="content">내용</option>
								<option value="titleContent">제목+내용</option>
								<option value="writer">작성자</option>
							</select> <input type="text" name="searchText" placeholder="검색어 입력">
							<input type="submit" value="검색">
						</form>


						<button type="button" onclick="boardWrite()">글작성</button>

					</th>
				</tr>
			</tfoot>
		</table>

	</div>

	<div class="footer">
		<h2>회원게시판</h2>
	</div>

	<script type="text/javascript">
		function boardWrite() {
			location.href = "${pageContext.request.contextPath }/BOARD/BoardWrite.jsp";
		}

		var msg = '${param.msg}';
		if (msg.length > 0) {
			alert(msg);
		}
	</script>
</body>

</html>