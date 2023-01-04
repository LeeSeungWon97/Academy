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

<title>MemberJoin</title>

<!-- Custom fonts for this template-->
<link href="${pageContext.request.contextPath }/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

<!-- Custom styles for this template-->
<link href="${pageContext.request.contextPath }/resources/css/sb-admin-2.css" rel="stylesheet">

<script type="text/javascript">
	var idCheckVal = false;

	function idCheck() {
		var id = document.getElementById('inputId');
		var idVal = id.value;
		if (idVal.length == 0) {
			document.getElementById('idCheckMsg').style.color = "red";
			document.getElementById('idCheckMsg').innerText = "아이디를 입력해 주세요";
		} else {
			$.ajax({
				type : "get",
				url : "${pageContext.request.contextPath }/memberIdCheck",
				data : {
					"inputId" : idVal
				},
				success : function(checkResult) {
					if (checkResult == 'ok') {
						idCheckVal = true;
						document.getElementById('idCheckMsg').style.color = 'green';
						document.getElementById('idCheckMsg').innerText = "사용가능한 아이디";
					} else {
						idCheckVal = false;
						document.getElementById('idCheckMsg').style.color = 'red';
						document.getElementById('idCheckMsg').innerText = "이미 사용중인 아이디";
						
					}
				}
			});
					
		}
	}
	function joinFormCheck(formObj) {
		var mid = formObj.mid;
		var mpw = formObj.mpw;
		var mname = formObj.mname;
		var mbirth = formObj.mbirth;
		var maddr = formObj.maddr;
		var memail = formObj.memail;

		if (mid.value.length == 0) {
			alert("아이디를 입력해 주세요");
			mid.focus();
			return false;
		} else if (mpw.value.length == 0) {
			alert("비밀번호를 입력해 주세요");
			mpw.focus();
			return false
		} else if (mname.value.length == 0) {
			alert("이름을 입력해 주세요");
			mname.focus();
			return false;
		} else if (mbirth.value.length == 0) {
			alert("생년월일을 설정해주세요");
			mbirth.focus();
			return false;
		} else if (maddr.value.length == 0) {
			alert("주소를 입력해 주세요");
			maddr.focus();
			return false;
		} else if (memail.value.length == 0) {
			alert("이메일을 입력해 주세요");
			memail.focus();
			return false;
		} else if (!idCheckVal) {
			alert("중복확인 버튼을 눌러주세요");
			return false;
		} else {
			return true;
		}

	}
</script>
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
					<div class="row">
						<div class="col-lg-7 ml-auto mr-auto" style="background-color: white;">
							<div class="p-5">
								<div class="text-center">
									<h1 class="h4 text-gray-900 mb-4">회원가입</h1>
								</div>
								<form  class="user" action="${pageContext.request.contextPath }/memberJoin" enctype="multipart/form-data" method="post" onsubmit="return joinFormCheck(this)">
									<div class="form-group row" >
										<div class="col-sm-6 m-auto">
											<input id=inputId type="text" class="form-control form-control-user inline-block" name="mid" placeholder="아이디">
											<button type="button" onclick="idCheck()">중복확인</button>
											<p class="pl-3 m-0 text-xs" id="idCheckMsg"></p>
										</div>
									</div>
									<div class="form-group row">
										<div class="col-sm-6 m-auto">
											<input type="text" class="form-control form-control-user" name="mpw" placeholder="비밀번호">
										</div>
									</div>
									<div class="form-group row">
										<div class="col-sm-6 m-auto">
											<input type="text" class="form-control form-control-user" name="mname" placeholder="이름">
										</div>
									</div>
									<div class="form-group row">
										<div class="col-sm-6 m-auto">
											<input type="date" class="form-control form-control-user" name="mbirth" placeholder="연도.월.일">
										</div>
									</div>
									<div class="form-group row">
										<div class="col-sm-6 m-auto">
											<input type="text" class="form-control form-control-user" name="maddr" placeholder="주소">
										</div>
									</div>
									<div class="form-group row">
										<div class="col-sm-6 m-auto">
											<input type="email" class="form-control form-control-user" name="memail" placeholder="이메일">
										</div>
									</div>
									<div class="form-group row">
										<div class="col-sm-6 m-auto">
											<input type="file" class="form-control form-control-user" name="mfile" placeholder="선택된 파일 없음" style="padding-top: 11px; height: 48px;">
										</div>
									</div>
									<div class="row">
										<div class="col-sm-6 m-auto">
											<button type="submit" class="btn btn-primary btn-user btn-block ">회원가입</button>
										</div>
									</div>

									<hr>
								</form>

								<hr>
								<div class="text-center">
									<a class="small" href="${pageContext.request.contextPath }/memberLoginForm">Already have an account? Login!</a>
								</div>
							</div>
						</div>
					</div>


				</div>
				<!-- /.container-fluid -->

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
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top">
		<i class="fas fa-angle-up"></i>
	</a>

	<!-- Logout Modal-->
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