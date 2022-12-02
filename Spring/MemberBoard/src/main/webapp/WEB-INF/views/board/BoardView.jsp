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

<title>MemberBoard-BoardView</title>

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

<style>
textarea {
	resize: none;
}
</style>


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
						<h1 class="h3 mb-0 text-gray-800">BoardView.jsp</h1>

					</div>

					<!-- Content Row -->
					<div class="row">
						<div class="col-lg-7 ml-auto mr-auto"
							style="background-color: white;">
							<div class="p-5">
								<div class="text-center">
									<h1 class="h4 text-gray-900 mb-4">글상세보기</h1>
								</div>
								<form class="user"
									action="${pageContext.request.contextPath }/boardModify"
									enctype="multipart/form-data" method="post">
									<input type="hidden" name="bno" value="${boardView.bno}">
									<div class="form-group row">
										<label for="#inputTitle">글제목</label> <input id="inputTitle"
											type="text" class="form-control form-control-user"
											name="btitle" value="${boardView.btitle }"
											readonly="readonly">
									</div>

									<div class="form-group row">
										<div class="col-sm-4 mb-3 mb-sm-0">
											<label for="#inputWriter">작성자</label> <input
												id="intputWriter" type="text"
												class="form-control form-control-user"
												value="${boardView.bwriter }" readonly="readonly">
										</div>
										<div class="col-sm-4 mb-3 mb-sm-0">
											<label for="#inputDate">작성일</label> <input id="inputDate"
												type="text" class="form-control form-control-user"
												value="${boardView.bdate }" readonly="readonly">
										</div>
										<div class="col-sm-4 mb-3 mb-sm-0">
											<label for="#inputHits">조회수</label> <input id="inputHits"
												type="text" class="form-control form-control-user"
												value="${boardView.bhits }" readonly="readonly">
										</div>
									</div>
									<div class="form-group row">
										<label for="#inputContent">글내용</label>
										<textarea class="form-control" id="inputContent"
											name="bcontent" readonly="readonly" rows="10">${boardView.bcontent }</textarea>
									</div>
									<div class="form-group">
										<label for="#inputFile">첨부파일</label> <img id="inputFile"
											src="${pageContext.request.contextPath }/resources/boardUpload/${boardView.bfilename}"
											alt="">
									</div>
									<div class="form-group row">
										<div class="col-sm-6 mb-3 mb-sm-0 modifyCol">
											<c:if
												test="${sessionScope.loginInfo.mid == boardView.bwriter }">
												<button id="modifyBtn" type="button"
													class="btn btn-primary btn-user btn-block"
													onclick="toggleModForm('open')">글수정</button>
											</c:if>
										</div>

										<c:if
											test="${sessionScope.loginInfo.mid == boardView.bwriter }">
											<div class="col-sm-3 mb-3 mb-sm-0 modifyCol d-none">
												<button type="submit"
													class="btn btn-success btn-user btn-bloc">수정</button>
											</div>
											<div class="col-sm-3 modifyCol d-none">
												<button type="button" onclick="toggleModForm('close')"
													class="btn btn-danger btn-user">취소</button>
											</div>

										</c:if>

										<div class="col-sm-6 mb-3 mb-sm-0">
											<button type="button"
												class="btn btn-primary btn-user btn-block">글목록</button>
										</div>
									</div>
									<hr>
								</form>
							</div>
						</div>
					</div>

					<!-- 게시글 추천 버튼 -->
					<div class="row">
						<div
							class="col-lg-7 ml-auto mr-auto align-items-center text-center pb-3"
							style="background-color: white;">
							<button id="likeBtn"
								class="btn border-primary btn-user text-primary"
								onclick="boardLike('${boardView.bno }')">
								<i class="p-0 far fa-thumbs-up ">추천</i> <span id="like_count">${blikeCount}</span>
							</button>
						</div>
					</div>

					<!-- 댓글 출력 -->
					<div class="row">
						<div class="col-lg-7 ml-auto mr-auto"
							style="background-color: white;">
							<div id="replyListArea"></div>
						</div>
					</div>



					<!-- Content Row -->
					<c:if test="${sessionScope.loginInfo.mid != null }">
						<div class="row">
							<div class="col-lg-7 ml-auto mr-auto"
								style="background-color: white;">
								<div class="pt-1 px-5 pb-1">
									<form class="user" onsubmit="return replyWrite(this)">
										<input type="hidden" name="rebno" value="${boardView.bno}">
										<input type="hidden" name="rewriter"
											value="${sessionScope.loginInfo.mid}">
										<div class="form-group row">
											<label for="#inputrecontent">댓글내용</label>
											<textarea class="form-control" id="inputrecontent"
												name="recontent" rows="3"></textarea>
										</div>
										<button type="submit"
											class="btn btn-primary btn-user btn-block">댓글작성</button>
									</form>
								</div>
							</div>
						</div>
					</c:if>
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

	<script type="text/javascript">
		$(document).ready(function() {
			replyList(viewBno);
			boardLikeCount_ajax(viewBno)
		});

		function toggleModForm(btnType) {
			$(".modifyCol").toggleClass("d-none");

			if (btnType == 'open') {
				titleVal = $("#inputTitle").val();
				contentVal = $("#inputContent").val();
				$("#inputTitle").removeAttr("readonly");
				$("#inputContent").removeAttr("readonly");
			} else {
				$("#inputTitle").val(titleVal);
				$("#inputContent").val(contentVal);
				$("#inputTitle").attr("readonly", "readonly");
				$("#inputContent").removeAttr("readonly", "readonly");
			}
		}

		var viewBno = '${boardView.bno}';
		var loginId = '${sessionScope.loginInfo.mid}';

		function replyLike(renum, btnObj) {
			console.log("replyLike()호출");
			if (loginId.length > 0) {
				$.ajax({
					type : "get",
					url : "${pageContext.request.contextPath }/replyLike",
					data : {
						"renum" : renum,
						"remid" : loginId
					},
					async : false,
					dataType : "json",
					success : function(result) {
						console.log(result.reLikeResult);
						console.log(result.reLikeCount);
						if (result.reLikeResult == '1') {
							alert("추천 되었습니다.");
						} else{
							alert("추천 취소되었습니다.");
						}
					}
				});
			} else {
				alert('로그인 후 추천 가능합니다.');
			}
		}

		function boardLike(bno) {
			if (loginId.length > 0) {
				$.ajax({
					type : "get",
					url : "${pageContext.request.contextPath }/boardLike",
					data : {
						"lbno" : bno,
						"lmid" : loginId
					},
					async : false,
					dataType : "json",
					success : function(result) {
						console.log(result.likeResult);
						if (result.likeResult == '1') {
							alert("추천 되었습니다.");
							$("#likeBtn").removeClass("text-primary");
							$("#likeBtn").addClass("text-white");
							$("#likeBtn").addClass("bg-primary");
						} else {
							alert("추천이 취소되었습니다.");
							$("#likeBtn").addClass("text-primary");
							$("#likeBtn").removeClass("text-white");
							$("#likeBtn").removeClass("bg-primary");
						}

						$("#like_count").text(result.likeCount);
					}
				});
			} else {
				alert('로그인 후 추천 가능합니다.');
			}
		}

		function boardLikeCount_ajax(bno) {
			$
					.ajax({
						type : "get",
						url : "${pageContext.request.contextPath }/boardLikeCount_ajax",
						data : {
							"lbno" : bno,
							"lmid" : loginId
						},
						async : false,
						dataType : "json",
						success : function(result) {
							console.log(result);
							if (result.likeCheck != null) {
								$("#likeBtn").removeClass("text-primary");
								$("#likeBtn").addClass("text-white");
								$("#likeBtn").addClass("bg-primary");
							}

							$("#like_count").text(result.likeCount);
						}
					});
		}

		function replyList(rebno) {
			console.log('댓글 목록 조회 replyList(rebno)호출');
			$
					.ajax({
						type : "get",
						url : "${pageContext.request.contextPath }/replyList",
						data : {
							"rebno" : rebno
						},
						dataType : "json",
						async : false,
						success : function(reList) {
							var output = "";
							for (var i = 0; i < reList.length; i++) {
								output += '<div class="card shadow">';
								output += '<div class="card-body p-3">';
								output += '<div class="row no-gutters align-items-center text-xs font-weight-bold">';
								output += '<div class="col">';
								output += '<div class="text-xs font-weight-bold">';
								output += '<img alt="" class="mr-2" style="height:25px;" src="${pageContext.request.contextPath }/resources/img/undraw_profile.svg">';
								output += '<span class="text-primary">'
										+ reList[i].rewriter + '</span>';
								output += '<span class="text-uppercase pl-2">'
										+ reList[i].redate + '</span>';
								output += '<button class="text-xs btn btn-sm border-primary btn-user text-primary" onclick="replyLike('
										+ "'"
										+ reList[i].renum
										+ "'"
										+ ',this)">';
								output += '추천 <span>' + reList[i].relikecount
										+ '</span>';
								output += '</button>';
								output += '</div>';
								output += '<hr class="my-1">';
								output += '</div>'
								output += '<textarea readonly="readonly" class="retext mb-2 border-0 font-weight-bold text-gray-800 w-100">'
										+ reList[i].recontent + '</textarea>';
								output += '</div>';
								output += '<div class="col-auto">';

								if (reList[i].rewriter == loginId) {
									output += '<button type="button" onclick="deleteReply('
											+ reList[i].renum
											+ ')" class="btn btn-danger btn-user">삭제</button>';
								}

								output += '</div>';
								output += '</div>';
								output += '</div>';
							}
							$("#replyListArea").html(output);
						}
					});
		}

		function deleteReply(replyObj) {
			console.log("삭제요청");
			var renum = replyObj;
			console.log(renum);

			$.ajax({
				type : "get",
				url : "${pageContext.request.contextPath }/replyDelete",
				data : {
					"renum" : renum
				},
				success : function(checkResult) {
					console.log(checkResult);
					if (checkResult == "OK") {
						alert("댓글 삭제 성공");
						replyList(viewBno);

					} else {
						alert("댓글 삭제 실패");
					}
				}
			});
		}

		function replyWrite(formObj) {
			console.log("replyWrite(formObj)호출");
			var rebno = formObj.rebno;
			console.log("댓글작성 글번호: " + rebno.value);
			var rewriter = formObj.rewriter;
			console.log("댓글작성자: " + rewriter.value);
			var recontent = formObj.recontent;
			console.log("댓글내용: " + recontent.value);

			$.ajax({
				type : "get",
				url : "${pageContext.request.contextPath }/replyWriter",
				data : {
					"rebno" : rebno.value,
					"rewriter" : rewriter.value,
					"recontent" : recontent.value
				},
				success : function(checkResult) {
					console.log(checkResult);
					if (checkResult == "OK") {
						alert("댓글 등록 성공");
						replyList(rebno.value);

					} else {
						alert("댓글 등록 실패");
					}
				}
			});

			return false;
		}
	</script>
</body>

</html>