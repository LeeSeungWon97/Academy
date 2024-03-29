<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

	<!-- Sidebar Toggle (Topbar) -->
	<button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
		<i class="fa fa-bars"></i>
	</button>

	<!-- Topbar Search -->
	<form class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
		<div class="input-group">
			<input type="text" class="form-control bg-light border-0 small" placeholder="Search for..."
				aria-label="Search" aria-describedby="basic-addon2">
			<div class="input-group-append">
				<button class="btn btn-primary" type="button">
					<i class="fas fa-search fa-sm"></i>
				</button>
			</div>
		</div>
	</form>

	<!-- Topbar Navbar -->
	<ul class="navbar-nav ml-auto">

		<!-- Nav Item - Search Dropdown (Visible Only XS) -->
		<li class="nav-item dropdown no-arrow d-sm-none"><a class="nav-link dropdown-toggle" href="#"
				id="searchDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i
					class="fas fa-search fa-fw"></i>
			</a> <!-- Dropdown - Messages -->
			<div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
				aria-labelledby="searchDropdown">
				<form class="form-inline mr-auto w-100 navbar-search">
					<div class="input-group">
						<input type="text" class="form-control bg-light border-0 small" placeholder="Search for..."
							aria-label="Search" aria-describedby="basic-addon2">
						<div class="input-group-append">
							<button class="btn btn-primary" type="button">
								<i class="fas fa-search fa-sm"></i>
							</button>
						</div>
					</div>
				</form>
			</div>
		</li>

		<!-- Nav Item - Alerts -->

		<!-- Nav Item - Messages -->

		<div class="topbar-divider d-none d-sm-block"></div>

		<c:choose>
			<%-- 로그인이 되어있지 않을 경우 --%>
			<c:when test="${sessionScope.loginInfo.mid == null }">
				<!-- Nav Item - User Information -->
				<li class="nav-item dropdown no-arrow">
					<a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false">
						<span class="mr-2 d-none d-lg-inline text-gray-600 small">비회원</span>
						<img class="img-profile rounded-circle"
							src="${pageContext.request.contextPath }/resources/img/undraw_profile.svg">
					</a>
					<!-- Dropdown - User Information -->
					<div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
						aria-labelledby="userDropdown">
						<a class="dropdown-item" href="#"> <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
							회원가입</a>
						<a class="dropdown-item" href="#"> <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
							로그인 </a>
					</div>
				</li>
			</c:when>

			<%-- 로그인이 되어있을 경우 --%>
			<c:otherwise>
				<!-- Nav Item - User Information -->
				<li class="nav-item dropdown no-arrow"><a class="nav-link dropdown-toggle" href="#" id="userDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> 
						<span class="mr-2 d-none d-lg-inline text-gray-600 small">
						<c:if test="${sessionScope.loginInfo.mstate == 'k' }">kakao_</c:if> ${sessionScope.loginInfo.mid }
						</span>
				

						<c:choose>
							<%-- 프로필이 등록되어 있을 경우 --%>
							<c:when test="${loginInfo.mprofile != null }">
							<c:choose>
								<c:when test="${sessionScope.loginInfo.mstate == 'k' }">
									<img class="img-profile rounded-circle"
									src="${sessionScope.loginInfo.mprofile}">
								</c:when>
								
								<c:otherwise>
								<img class="img-profile rounded-circle"
									src="${pageContext.request.contextPath }/resources/memberProfile/${loginInfo.mprofile}">
								</c:otherwise>
							</c:choose>
							</c:when>
							
							<%-- 프로필이 등록되어있지 않을 경우 --%>
							<c:otherwise>
								<img class="img-profile rounded-circle"
									src="${pageContext.request.contextPath }/resources/img/undraw_profile.svg">
							</c:otherwise>
						</c:choose>



					</a> <!-- Dropdown - User Information -->
					<div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
						aria-labelledby="userDropdown">
						<a class="dropdown-item" href="#"> <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
							내정보확인
						</a>
						<!-- <a class="dropdown-item" href="#">
							<i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i> Settings
						</a>
						<a class="dropdown-item" href="#"> <i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
							Activity Log
						</a> -->
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="${pageContext.request.contextPath }/memberLogout" data-toggle="modal" data-target="#logoutModal"> <i
								class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
							로그아웃
						</a>
					</div>
				</li>
			</c:otherwise>
		</c:choose>
	</ul>

</nav>