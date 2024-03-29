<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

	<!-- Sidebar Toggle (Topbar) -->
	<button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
		<i class="fa fa-bars"></i>
	</button>

	<!-- Topbar Search -->
	<form class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search"
	action="${pageContext.request.contextPath }/movieSearch">
		<div class="input-group">
			<input name = mvtitle type="text" class="form-control bg-light border-0 small" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
			<div class="input-group-append">
				<button class="btn btn-primary" type="submit">
					<i class="fas fa-search fa-sm"></i>
				</button>
			</div>
		</div>
	</form>

	<!-- Topbar Navbar -->
	<ul class="navbar-nav ml-auto">

		<!-- Nav Item - Search Dropdown (Visible Only XS) -->
		<li class="nav-item dropdown no-arrow d-sm-none"><a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				<i class="fas fa-search fa-fw"></i>
			</a> <!-- Dropdown - Messages -->
			<div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in" aria-labelledby="searchDropdown">
				<form class="form-inline mr-auto w-100 navbar-search">
					<div class="input-group">
						<input type="text" class="form-control bg-light border-0 small" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
						<div class="input-group-append">
							<button class="btn btn-primary" type="button">
								<i class="fas fa-search fa-sm"></i>
							</button>
						</div>
					</div>
				</form>
			</div></li>

		<!-- Nav Item - Messages -->

		<div class="topbar-divider d-none d-sm-block"></div>

		<!-- Nav Item - User Information -->
		<li class="nav-item dropdown no-arrow"><a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				<c:choose>
					<c:when test="${sessionScope.loginInfo.mprofile == null }">
						<img class="img-profile rounded-circle" src="${pageContext.request.contextPath }/resources/img/undraw_profile.svg">
					</c:when>
					<c:otherwise>
						<img class="img-profile rounded-circle" src="${pageContext.request.contextPath }/resources/memberProfileUpload/${sessionScope.loginInfo.mprofile}">
					</c:otherwise>
				</c:choose>
				
				<span class="mlr-1 mr-2 d-none d-lg-inline text-gray-600 small">
					<c:choose>
						<c:when test="${sessionScope.loginInfo.mname == null }">비회원	</c:when>
						<c:otherwise>${sessionScope.loginInfo.mname }</c:otherwise>
					</c:choose>
				</span>


			</a>
			<div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">

				<c:choose>
					<c:when test="${sessionScope.loginInfo.mid == null }">
						<a class="dropdown-item" href="${pageContext.request.contextPath }/memberLoginForm">
							<i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i> Login
						</a>
					</c:when>
					<c:otherwise>
						<a class="dropdown-item" href="${pageContext.request.contextPath }/memberLoginout">
							<i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i> Logout
						</a>
					</c:otherwise>

				</c:choose>
				<div class="dropdown-divider"></div>
			</div></li>

	</ul>

</nav>
