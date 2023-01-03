<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<ul	class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
	id="accordionSidebar">

	<!-- Sidebar - Brand -->
	<a class="sidebar-brand d-flex align-items-center justify-content-center"
		href="${pageContext.request.contextPath }/">
		<div class="sidebar-brand-text mx-3">
			Movie reservation
		</div>
	</a>

	<!-- Divider -->
	<hr class="sidebar-divider my-0">

	<!-- Nav Item - Dashboard -->
	<li class="nav-item">
		<span class="nav-link">Menu</span>
	</li>

	<!-- Divider -->
	<hr class="sidebar-divider">

	<!-- Heading -->
	<!-- Nav Item - Pages Collapse Menu -->
	<li class="nav-item">
		<a class="nav-link collapsed" href="#" data-toggle="collapse"
		data-target="#collapseTwo" aria-expanded="true"
		aria-controls="collapseTwo"><span>회원메뉴</span> </a>
		<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
			data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<h6 class="collapse-header">Custom Components:</h6>
				<c:choose>
					<c:when test="${sessionScope.loginInfo.mid == null }">
						<a class="collapse-item" href="${pageContext.request.contextPath }/memberJoinForm">회원가입</a>
						<a class="collapse-item" href="${pageContext.request.contextPath }/memberLoginForm">로그인</a>
					</c:when>
					<c:otherwise>
						<a class="collapse-item" href="${pageContext.request.contextPath }/memberLoginout">로그아웃</a>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</li>

	<!-- Nav Item - Utilities Collapse Menu -->
	<li class="nav-item">
		<a class="nav-link collapsed" href="#" data-toggle="collapse"
			data-target="#collapseUtilities" aria-expanded="true"
			aria-controls="collapseUtilities"> <span>영화예매</span>
		</a>
		<div id="collapseUtilities" class="collapse"
			aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<h6 class="collapse-header">Custom Utilities:</h6>
				<a class="collapse-item" href="utilities-color.html">예매</a>
			</div>
		</div>
	</li>
</ul>