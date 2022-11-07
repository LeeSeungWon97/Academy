<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="menu">
	<ul>
		<li><a href="${pageContext.request.contextPath }/Main.jsp">메인페이지</a></li>

		<li><a href="${pageContext.request.contextPath }/boardList">게시판</a></li>

		<c:choose>
			<c:when test="${sessionScope.loginId != null }">
				<li><a href="">내정보확인</a></li>
				<li><a href="${pageContext.request.contextPath }/memberLogout">로그아웃</a>
				</li>
			</c:when>

			<c:otherwise>
				<li><a
					href="${pageContext.request.contextPath }/MEMBER/MemberLogin.jsp">로그인</a></li>
				<li><a
					href="${pageContext.request.contextPath }/MEMBER/MemberJoin.jsp">회원가입</a></li>
			</c:otherwise>

		</c:choose>


	</ul>
</div>