<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>MovieInfo</title>

<!-- Custom fonts for this template-->
<link href="${pageContext.request.contextPath }/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

<!-- Custom styles for this template-->
<link href="${pageContext.request.contextPath }/resources/css/sb-admin-2.css" rel="stylesheet">

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
					<div class="form-group row">
						<div class="col-sm-3 ml-0">
							<img class="img-fit" src="${mvInfo.mvpos}" style="max-width: 250px; max-height: 350px">
						</div>
						<div class="col-9" style="word-break: normal;">
							<div class="infoTitlt">
								<strong class="mvtitle" style="font-size: 25px; ">${mvInfo.mvtitle }</strong>
							</div>
							<hr>
							<div class="infoSpec">
								<div class="mb-3">감독: ${mvInfo.mvdir } / 배우: ${mvInfo.mvact }</div>
								<div class="mb-3">장르: ${mvInfo.mvgenre } / 기본: ${mvInfo.mvinfo }</div>
								<div class="mb-3">개봉: ${mvInfo.mvdate }</div>
							</div>
							<div class="mb-0">
								<a href="${pageContext.request.contextPath }/mvReservationForm">
									<button type="button" class="btn-reservation">예매하기</button>
								</a>
							</div>
						</div>

					</div>

				</div>
				<!-- End of Main Content -->

				<!-- Footer -->
				<footer class="sticky-footer bg-white">
					<div class="container my-auto">
						<div class="copyright text-center my-auto">
							<span>Copyright &copy; Your Website 2020</span>
						</div>
					</div>
				</footer>
				<!-- End of Footer -->

			</div>
			<!-- End of Content Wrapper -->
		</div>
	</div>
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top">
		<i class="fas fa-angle-up"></i>
	</a>

	<%@ include file="/WEB-INF/views/includes/logoutModal.jsp"%>

	<!-- Bootstrap core JavaScript-->
	<script src="${pageContext.request.contextPath }/resources/vendor/jquery/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath }/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="${pageContext.request.contextPath }/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="${pageContext.request.contextPath }/resources/js/sb-admin-2.min.js"></script>
</body>

</html>