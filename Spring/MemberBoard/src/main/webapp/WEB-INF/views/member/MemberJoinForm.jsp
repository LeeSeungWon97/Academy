<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>MemberBoard-Join</title>

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
						<h1 class="h3 mb-0 text-gray-800">MemberJoinForm.jsp</h1>

					</div>

					<!-- Content Row -->
					<h2>회원가입 페이지</h2>
					<div class="row">
						<div class="col-lg-7 ml-auto mr-auto">
							<div class="p-5">
								<div class="text-center">
									<h1 class="h4 text-gray-900 mb-4">회원가입</h1>
								</div>
								<form class="user" action="${pageContext.request.contextPath }/memberJoin" method="get">
									<div class="form-group row">
										<div class="col-sm-6 mb-3 mb-sm-0">
											<input type="text" class="form-control form-control-user"
												name="mid" placeholder="아이디">
										</div>
										<div class="col-sm-6">
											<input type="text" class="form-control form-control-user"
												name="mpw" placeholder="비밀번호">
										</div>
									</div>
									<div class="form-group row">
										<div class="col-sm-6 mb-3 mb-sm-0">
											<input type="text" class="form-control form-control-user"
												name="mname" placeholder="이름">
										</div>
										<div class="col-sm-6">
											<input type="date" class="form-control form-control-user"
												name="mbirth" placeholder="연도.월.일">
										</div>
									</div>
									<div class="form-group">
										<input type="text" class="form-control form-control-user"
											name="maddr" placeholder="주소">
									</div>
									<div class="form-group">
										<input type="email" class="form-control form-control-user"
											name="memail" placeholder="이메일">
									</div>
									<div class="form-group">
										<input type="file" class="form-control form-control-user"
											name="mfile" placeholder="선택된 파일 없음"
											style="padding-top: 11px; height: 48px;">
									</div>
									<button type="submit"
										class="btn btn-primary btn-user btn-block">회원가입</button>
									<hr>
									<!-- <a href="index.html" class="btn btn-google btn-user btn-block">
										<i class="fab fa-google fa-fw"></i> Register with Google
									</a> <a href="index.html"
										class="btn btn-facebook btn-user btn-block"> <i
										class="fab fa-facebook-f fa-fw"></i> Register with Facebook
									</a> -->
								</form>
								<hr>
								<div class="text-center">
									<a class="small" href="forgot-password.html">Forgot
										Password?</a>
								</div>
								<div class="text-center">
									<a class="small" href="login.html">Already have an account?
										Login!</a>
								</div>
							</div>
						</div>
					</div>
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