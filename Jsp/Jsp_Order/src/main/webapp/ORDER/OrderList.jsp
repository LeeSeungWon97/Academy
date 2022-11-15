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

th,td {
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
		<h1>OrderList.jsp</h1>
	</div>

	<%@ include file="/Menu.jsp"%>

	<div class="contents">
		<h2>주문내역</h2>
		<table>
			<tr>
				<th>주문코드</th>
				<th>브랜드명</th>
				<th>상품이름</th>
				<th>상품가격</th>
				<th>주문일</th>
			</tr>
			<c:forEach items="${orderInfo }" var="orderInfo">
				<tr>
					<td>${orderInfo.orcode}</td>
					<td>${orderInfo.prbrand}</td>
					<td>${orderInfo.prname}</td>
					<td>${orderInfo.prprice}원</td>
					<td>${orderInfo.ordate}</td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<div class="footer">
		<h2>Order</h2>
	</div>
</body>

</html>