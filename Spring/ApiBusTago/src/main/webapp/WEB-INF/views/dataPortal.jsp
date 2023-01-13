<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>dataPortal</title>
</head>
<body>
	<h1>dataPortal.jsp</h1> <a href = "${pageContext.request.contextPath }/">Main</a>
	<hr>
	<form action="${pageContext.request.contextPath }/stationPath">
		<label for=start_st>출발역</label>
		<select id="start_st" name="dept_station_code">
			<option value="2728">부평</option>
			<option value="3110">계양</option>
			<option value="3124">인천시청</option>
		</select>
		<label for=end_st>도착역</label>
		<select id="end_st" name="dest_station_code">
			<option value="0214">서울역</option>
			<option value="0212">건대입구</option>
			<option value="0222">강남</option>
		</select>
		<input type="submit" value="경로찾기">
	</form>
</body>
</html>