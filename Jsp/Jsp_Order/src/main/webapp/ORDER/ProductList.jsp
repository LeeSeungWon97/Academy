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
	margin: auto;
}

td {
	padding: 8px;
	border: 1px solid black;
	text-align: center;
}

.prTitle {
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
	display: inline-block;
	width: 400px;
}
</style>
</head>

<body>

	<div class="header">
		<h1>ProductList.jsp</h1>
	</div>

	<%@ include file="/Menu.jsp"%>

	<div class="contents">
		<h2>상품목록</h2>
		<table>
			<c:forEach items="${prList }" var="pr">
				<tr>
					<td><img src="${pr.primg }" alt=""
						style="width: 100px; height: 100px;"></td>
					<td><span class="prTitle" title="${pr.prname}">
							[${pr.prbrand }]&nbsp;${pr.prname } </span></td>
					<td>${pr.prprice }원</td>
					<td><button type="button">주문하기</button></td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<div class="footer">
		<h2>Order</h2>
	</div>

</body>

</html>