<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

	<!-- Sidebar - Brand -->
	<a class="sidebar-brand d-flex align-items-center justify-content-center"
		href="${pageContext.request.contextPath }/">
		<div class="sidebar-brand-icon rotate-n-15">
			<i class="fas fa-laugh-wink"></i>
		</div>
		<div class="sidebar-brand-text mx-3">
			MEMBERBOARD <sup></sup>
		</div>
	</a>

	<!-- Divider -->
	<hr class="sidebar-divider my-0">

	<!-- Nav Item - Dashboard -->
	<li class="nav-item active"><a class="nav-link" href="${pageContext.request.contextPath }/"> <i
				class="fas fa-fw fa-tachometer-alt"></i> <span>메인페이지로</span></a></li>

	<!-- Divider -->
	<hr class="sidebar-divider">

	<!-- Heading -->
	<div class="sidebar-heading">Interface</div>

	<!-- Nav Item - Pages Collapse Menu -->
	<li class="nav-item"><a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo"
			aria-expanded="true" aria-controls="collapseTwo"> <i class="fas fa-fw fa-cog"></i> <span>회원메뉴</span>
		</a>
		<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<h6 class="collapse-header">Custom Components:</h6>

				<c:choose>
					<c:when test="${sessionScope.loginInfo.mid == null}">
						<a class="collapse-item" href="${pageContext.request.contextPath }/memberJoinForm">회원가입</a>
						<a class="collapse-item" href="${pageContext.request.contextPath }/memberLoginForm">로그인</a>
					</c:when>

					<c:otherwise>
						<a class="collapse-item" href="">내정보확인</a>
						<a class="collapse-item" href="${pageContext.request.contextPath }/memberLogout">로그아웃</a>
					</c:otherwise>
				</c:choose>
				<!-- 로그인이 되어 있지 않을 경우 표시될 메뉴 -->

				<!-- 로그인이 되어 있을 경우 경우 표시될 메뉴 -->


			</div>
		</div>
	</li>

	<!-- Nav Item - Utilities Collapse Menu -->
	<li class="nav-item">
		<a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities"
			aria-expanded="true" aria-controls="collapseUtilities"> <i class="fas fa-fw fa-wrench"></i>
			<span>게시판메뉴</span>
		</a>
		<div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<h6 class="collapse-header">boards</h6>
				<a class="collapse-item" href="${pageContext.request.contextPath }/boardList">전체글목록</a> <a
					class="collapse-item" href="${pageContext.request.contextPath }/boardWriteForm">글작성</a>
			</div>
		</div>
	</li>

	<!-- Sidebar Toggler (Sidebar) -->
	<div class="text-center d-none d-md-inline">
		<button class="rounded-circle border-0" id="sidebarToggle"></button>
	</div>

	<!-- Sidebar Message -->

</ul>