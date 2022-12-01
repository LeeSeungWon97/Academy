<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>

	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">

	<title>MemberBoard-Join</title>

	<!-- Custom fonts for this template-->
	<link href="${pageContext.request.contextPath }/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
		type="text/css">
	<link
		href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
		rel="stylesheet">

	<!-- Custom styles for this template-->
	<link href="${pageContext.request.contextPath }/resources/css/sb-admin-2.min.css" rel="stylesheet">

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
					<div class="d-sm-flex align-items-center justify-content-between mb-4">
						<h1 class="h3 mb-0 text-gray-800">MemberJoinForm.jsp</h1>

					</div>

					<!-- Content Row -->
					<div class="row">
						<div class="col-lg-7 ml-auto mr-auto" style="background-color: white;">
							<div class="p-5">
								<div class="text-center">
									<h1 class="h4 text-gray-900 mb-4">내정보 확인</h1>
								</div>
									<div class="row">
										<div class="col-6">
											<button class="btn">
												<i class="far fa-sticky-note">작성한글</i>
												<span>${boList.size() }개</span>
											</button>
										
										</div>									
									</div>
						
									<div class="form-group row">
										<div class="col-sm-6 mb-3 mb-sm-0">
											<input type="text" class="form-control form-control-user" name="mid"
												value="${memberInfo.mid }">
										</div>
										<div class="col-sm-6">
											<input type="text" class="form-control form-control-user" name="mpw"
												value="${memberInfo.mpw }">
										</div>
									</div>
									<div class="form-group row">
										<div class="col-sm-6 mb-3 mb-sm-0">
											<input type="text" class="form-control form-control-user" name="mname"
												value="${memberInfo.mname }">
										</div>
										<div class="col-sm-6">
											<input type="text" class="form-control form-control-user" name="mbirth"
												value="${memberInfo.mbirth }">
										</div>
									</div>
									<div class="form-group">
										<input type="text" class="form-control form-control-user" name="maddr"
											value="${memberInfo.maddr }">
									</div>
									<div class="form-group">
										<input type="email" class="form-control form-control-user" name="memail"
											value="${memberInfo.memail }">
									</div>
									<div class="form-group">
										<input type="file" class="form-control form-control-user" name="mfile"
											value="${memberInfo.mprofile }" style="padding-top: 11px; height: 48px;">
									</div>
									<button type="submit" class="btn btn-primary btn-user btn-block">회원가입</button>
									
							

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
	<a class="scroll-to-top rounded" href="#page-top"> <i class="fas fa-angle-up"></i>
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

	<script type="text/javascript">
		function joinFormCheck(formObj) {
			var mid = formObj.mid;
			var mpw = formObj.mpw;
			var mname = formObj.mname;

			if (mid.value.length == 0) {
				alert('아이디를 입력해주세요');
				mid.focus();
				return false;
			} else if (mpw.value.length == 0) {
				alert('비밀번호를 입력해주세요');
				mpw.focus();
				return false;
			} else if (mname.value.length == 0) {
				alert('이름을 입력해주세요');
				mname.focus();
				return false;
			} else if (!idCheckVal) {
				alert('중복확인값을 확인해주세요');
				mid.focus();
				return false;
			} else {
				return true;
			}
		}

		var idCheckVal = false;

		function joinIdCheck(idVal) {
			idCheckVal = false;
			console.log("입력한 아이디 :" + idVal);
			if (idVal.length == 0) {
				document.getElementById('idCheckMsg').style.color = 'red';
				document.getElementById('idCheckMsg').innerText = "아이디를 입력 해주세요!";
			} else {
				$.ajax({
					type: "get",
					url: "${pageContext.request.contextPath }/memberIdCheck",
					data: {
						"inputId": idVal
					},
					success: function (checkResult) {
						console.log("checkResult: " + checkResult);
						if (checkResult == 'OK') {
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
	</script>
</body>

</html>