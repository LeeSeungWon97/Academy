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

<title>WebSocketTest</title>

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

					<!-- Page Heading -->
					<h2>WebSocketTest</h2>

					<hr>

					<!-- 페이지 목록 창 -->
					<div class="card mx-auto" style="background-color: #86c5e5; width: 600px;">
						<div class="row mt-5 mb-5">
							<div id="chatList" class="col">
								<div>
									<span class="ml-3 p-3" style="background-color: white;">받은 메세지</span>

								</div>
								<div class="text-right" style="text-align: right;">
									<span class="mr-3 p-3" style="background-color: yellow;">보낸 메세지</span>
								</div>
							</div>
						</div>
						<div class="row" style="background-color:white;">
							<div class="col">
								<input type="text" id="msg" class="form-control">
							</div>
							<div class="col-auto">
								<button class="btn btn-primary" onclick="sendMsgTest()">메세지 보내기</button>
							</div>
						</div>
					</div>
					<!-- /.container-fluid -->


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

	<script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
	<script type="text/javascript">
		var sock = new SockJS('${pageContext.request.contextPath }/chatMessage');
		sock.onopen = function() {
			console.log('open');
			/* sock.send('test 메세지'); */
		};

		sock.onmessage = function(e) {
			console.log('받은 메세지', e.data);
			var msgData = JSON.parse(e.data);
			var output = '';
			if(msgData.type == 'notice'){
				console.log("공지사항");
				output += '<div class="text-center my-4">';
				output += '<span class="ml-3 p-3" style="background-color: white;">'+msgData.msg+'</span>';
				output += '</div>';
			}else{
				console.log("일반메세지");
				console.log(msgData.msg);
				output += '<div class="text-left my-4">';
				output += '<span class="ml-3 p-3" style="background-color: white;">'+msgData.msg+'</span>';
				output += '</div>';
			}
			$("#chatList").append(output);
		};

		sock.onclose = function() {
			console.log('close');
		};

		function sendMsgTest() {
			var inputValue = document.getElementById('msg').value;
			console.log("입력한 메세지: " + inputValue);
			sock.send(inputValue);
			var output = '<div class="text-right my-4 mr-3" style="text-align: right;">';
			output += '<span class="p-3" style="background-color: yellow;">'+inputValue+'</span>';
			output += '</div>';
			$("#chatList").append(output);
			document.getElementById('msg').value="";
		}
	</script>

</body>

</html>