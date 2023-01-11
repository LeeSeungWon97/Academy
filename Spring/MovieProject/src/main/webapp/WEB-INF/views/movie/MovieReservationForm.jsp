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

<title>MovieReservation</title>

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

					<h1>Reservation Page</h1>

					<div class="col-lg-11 col-xl-11 col-xm-11 row">

						<div class="mv-reservation">
							<div class="caption">
								<span>영화</span>
							</div>
							<div class="reservation-content">
								<c:forEach items="${movieList }" var="mvList" varStatus="status">
									<div class="info">
										<button class="titleBtn" onclick="callTheater('${mvList.mvcode}',this)">
											<span>${age[status.index] } ${mvList.mvtitle }</span>
										</button>
									</div>
								</c:forEach>
							</div>
						</div>

						<div class="th-reservation">
							<div class="caption">
								<span>극장</span>
							</div>
						</div>

						<div class="day-reservation">
							<div class="caption">
								<span>날짜</span>
							</div>
						</div>

						<div class="time-reservation">
							<div class="caption">
								<span>시간</span>
							</div>
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
	<script type="text/javascript">
		var selectMovie = "";
		var selectTheater = "";

		function callTheater(mvcode, btnObj) {
			var titleBtn = document.getElementsByClassName('titleBtn');
			for (var i = 0; i < titleBtn.length; i++) {
				titleBtn[i].classList.remove('d_none');
			}
			btnObj.classList.add('d_none');

			selectMovie = mvcode;
			$
					.ajax({
						type : "get",
						url : "${pageContext.request.contextPath }/callTheater",
						data : {
							"mvcode" : mvcode
						},
						async : false,
						dataType : "json",
						success : function(result) {
							var output = '<div class="caption"><span>극장</span></div><div class="reservation-content">';
							if (result.length != 0) {
								for (var i = 0; i < result.length; i++) {
									output += '<div class="info">';
									output += '<button class="theatorBtn" onclick = "callDate(\''
											+ result[i] + '\',this)">';
									output += '<span>' + result[i] + '</span>';
									output += '</button>';
									output += '</div>';
								}
								output += '</div>';
							}
							$(".th-reservation").html(output);
						}
					});
		}

		function callDate(thname, btnObj) {
			var theatorBtn = document.getElementsByClassName('theatorBtn');
			for (var i = 0; i < theatorBtn.length; i++) {
				theatorBtn[i].classList.remove('d_none');
			}
			btnObj.classList.add('d_none');

			selectTheater = thname;
			$
					.ajax({

						type : "get",
						url : "${pageContext.request.contextPath }/callDate",
						data : {
							"mvcode" : selectMovie,
							"thname" : selectTheater
						},
						async : false,
						dataType : "json",
						success : function(result) {
							console.log(result);
							var today = new Date();
							var output = '<div class="caption"><span>날짜</span></div><div class="reservation-content">';
							var month = result[0][1];

							console.log(month);
							output += '<div class="info"><p class = monthBtn>'
									+ month + '월</p></div>'
							for (var i = 0; i < result.length; i++) {
								console.log(result[i]);
								if (today.getFullYear() <= result[i][0]) {
									if (today.getMonth() + 1 <= result[i][1]) {
										if (month != result[i][1]) {
											month = result[i][1];
											output += '<div class="info"><p class = monthBtn>'
													+ month + '월</p></div>';
										}
										if (today.getDate() <= result[i][2]) {
											output += '<div class="info">';
											output += '<button class="dateBtn" onclick="callTime(\''
													+ result[i] + '\',this)">';
											output += '<span>' + result[i][2]
													+ '</span>';
											output += '</button>';
											output += '</div>';
										}
									}
								}
							}
							output += '</div>'
							$(".day-reservation").html(output);
						}
					});
		}

		function callTime(scdate, btnObj) {
			var dateBtn = document.getElementsByClassName('dateBtn');
			for (var i = 0; i < dateBtn.length; i++) {
				dateBtn[i].classList.remove('d_none');
			}
			btnObj.classList.add('d_none');

			var date = scdate.replace(/,/g, '-');
			$
					.ajax({
						type : "get",
						url : "${pageContext.request.contextPath }/callTime",
						data : {
							"mvcode" : selectMovie,
							"thname" : selectTheater,
							"scdate" : date
						},
						async : false,
						dataType : "json",
						success : function(result) {
							console.log(result);
							var roomArray = new Array();
							var idx = 0;
							for (var i = 0; i < result.length; i++) {
								var check = false;
								for (var j = 0; j < roomArray.length; j++) {
									if (roomArray[j] == result[i][1]) {
										check = true;
									}
								}
								if (!check) {
									roomArray[idx] = result[i][1];
									idx++;
								}
							}

							var output = '<div class="caption"><span>시간</span></div><div class="reservation-content">';
							for (var i = 0; i < roomArray.length; i++) {
								output += '<div><span>' + roomArray[i]
										+ '</span></div>';
								output += '<div class="info row">';
								for (var j = 0; j < result.length; j++) {

									if (result[j][1] == roomArray[i]) {

										output += '<button class="timeBtn" onclick = "test(\''
												+ result[j][0] + '\',this)">';
										output += '<span>' + result[j][0]
												+ '</span>';
										output += '</button>';

									}

								}
								output += '</div>';
								output += '<hr>';
							}

							console.log(roomArray);
							output += '</div>'
							$(".time-reservation").html(output);
						}

					});
		}

		function test(time, btnObj) {
			var timeBtn = document.getElementsByClassName('timeBtn');
			for (var i = 0; i < timeBtn.length; i++) {
				timeBtn[i].classList.remove('d_none');
			}
			btnObj.classList.add('d_none');

			console.log("영화시간:" + time);
		}
	</script>
</body>

</html>