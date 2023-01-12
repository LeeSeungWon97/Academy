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

<title>SocketTest02</title>

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
					<h2>SocketTest02</h2>
					<!-- Page Heading -->
					<div class="row">
						<div class="chatBox col-xl-6">

							<div id="c_Window" class="chatWindow">
								<div style="margin-bottom: 10px;"></div>
							</div>

							<div class="inputMsg row">
								<div class="col">
									<input type="text" id="msg" class="form-control" style="height: 100%; text-align: left;" onkeypress="keyevent(this)">
								</div>
								<div class="sendBtn">
									<button class="col-auto btn btn-primary" onclick="sendMsg()">send</button>
								</div>

							</div>

						</div>
						<div class="userBox col-auto">
							접속중인 User
							<hr>
							<div id="u_Window"></div>
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
		var sock = new SockJS(
				'${pageContext.request.contextPath }/chatMessage02');
		sock.onopen = function() {
			console.log('open');
		}

		sock.onmessage = function(e) {
			console.log('받은 메세지: ' + e.data);
			var msgData = JSON.parse(e.data);
			var chatOutput = '';
			var userOutput = '';

			switch (msgData.type) {
			case 'connectUserList':
				console.log(msgData.userList);
				for(var userInfo of msgData.userList){
					console.log(userInfo.userId);
					if(userInfo.userId != msgData.userid){
					userOutput += '<div id="' + userInfo.userId + '" class="p-1">'
					+ userInfo.userId + '</div>';						
					}
				}
				$("#u_Window").append(userOutput);
				break;

			case 'connectUser':
				console.log("공지사항");
				console.log(msgData.userid);
				// 채팅창
				chatOutput += '<div class="notice">';
				chatOutput += '<span>' + msgData.userid + msgData.sending
						+ '</span>';
				chatOutput += '</div>';
				$('#c_Window').append(chatOutput);
				// 유저목록
				userOutput += '<div id="' + msgData.userid + '" class="p-1">'
						+ msgData.userid + '</div>';
				$("#u_Window").append(userOutput);
				$('#c_Window').scrollTop($('#c_Window')[0].scrollHeight);
				break;
			case 'chat':
				console.log("chat");
				console.log(msgData.sendId);
				console.log(msgData.msg);
				chatOutput += '<div class="r_Data">';
				chatOutput += '<p>';
				chatOutput += msgData.sendId;
				chatOutput += '<br>';
				chatOutput += '<span>' + msgData.msg + '</span>';
				chatOutput += '</p>';
				chatOutput += '</div>';
				$('#c_Window').append(chatOutput);
				$('#c_Window').scrollTop($('#c_Window')[0].scrollHeight);
				break;

			case 'disconnectUser':
				console.log("공지사항");
				console.log(msgData.userid);
				chatOutput += '<div class="notice">';
				chatOutput += '<span>' + msgData.userid + msgData.sending
						+ '</span>';
				chatOutput += '</div>';
				$('#c_Window').append(chatOutput);
				$('#c_Window').scrollTop($('#c_Window')[0].scrollHeight);

				// 접속 중 목록 삭제
				$("#" + msgData.userid).remove();
				break;

			}

		}

		sock.onclose = function(e) {
			console.log('close');
		}

		function sendMsg() {
			var inputMsg = document.getElementById('msg').value;
			console.log(inputMsg);
			sock.send(inputMsg);
			var output = '<div class="s_Data">';
			output += '<p>';
			output += '<span>' + inputMsg + '</span>';
			output += '</p>';
			output += '</div>';
			$('#c_Window').append(output);
			$('#c_Window').scrollTop($('#c_Window')[0].scrollHeight);
			document.getElementById('msg').value = '';
		}
		
		function keyevent(){
			var keycode = event.keyCode;
			if(keycode == 13){
				sendMsg();
			}
		}
		
		
	</script>

</body>

</html>