<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>MemberBoard-Main</title>

<!-- Custom fonts for this template-->
<link
	href="${pageContext.request.contextPath }/resources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link
	href="${pageContext.request.contextPath }/resources/css/sb-admin-2.min.css"
	rel="stylesheet">

</head>

<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<%@ include file="/WEB-INF/views/includes/sideBar.jsp"%>
		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Topbar -->
				<%@ include file="/WEB-INF/views/includes/topBar.jsp"%>
				<!-- End of Topbar -->

				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- Page Heading -->
					<div
						class="d-sm-flex align-items-center justify-content-between mb-4">
						<h1 class="h3 mb-0 text-gray-800">Main.jsp</h1>

					</div>

					<!-- Content Row -->
					<table>

						<tr>
							<th>
								<c:choose>
									<%-- 프로필이 등록되어 있을 경우 --%>
									<c:when test="${loginInfo.mprofile != null }">
										<c:choose>
											<c:when test="${sessionScope.loginInfo.mstate == 'k' }">
												<img style="width: 150px; height: 150px;" class="img-profile rounded-circle"
													src="${sessionScope.loginInfo.mprofile}">
											</c:when>

											<c:otherwise>
												<img style="width: 150px; height: 150px;" class="img-profile rounded-circle"
													src="${pageContext.request.contextPath }/resources/memberProfile/${loginInfo.mprofile}">
											</c:otherwise>
										</c:choose>
									</c:when>

									<%-- 프로필이 등록되어있지 않을 경우 --%>
									<c:otherwise>
										<img style="width: 150px; height: 150px;" class="img-profile rounded-circle"
											src="${pageContext.request.contextPath }/resources/img/undraw_profile.svg">
									</c:otherwise>
								</c:choose>
							</th>
							<td>
								아이디: <c:if test="${sessionScope.loginInfo.mstate == 'k' }">kakao_</c:if>${sessionScope.loginInfo.mid} <br> 
								이름: ${sessionScope.loginInfo.mname} <br> 
								이메일: ${sessionScope.loginInfo.memail}
							</td>

						</tr>

					</table>


					<!-- Content Row -->


					<!-- Content Row -->


				</div>
				<!-- /.container-fluid -->

			</div>
			<!-- End of Main Content -->

			<!-- Footer -->
			<footer class="sticky-footer bg-white">
				<div class="container my-auto">
					<div class="copyright text-center my-auto">
						<span>Copyright &copy; Your Website 2021</span>
					</div>
				</div>
			</footer>
			<!-- End of Footer -->

		</div>
		<!-- End of Content Wrapper -->

	</div>
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Logout Modal-->
	<%@ include file="/WEB-INF/views/includes/logoutModal.jsp"%>

	<!-- Bootstrap core JavaScript-->
	<script
		src="${pageContext.request.contextPath }/resources/vendor/jquery/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script
		src="${pageContext.request.contextPath }/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script
		src="${pageContext.request.contextPath }/resources/js/sb-admin-2.min.js"></script>

</body>

</html>