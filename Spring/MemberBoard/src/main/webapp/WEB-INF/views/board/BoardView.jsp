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

    <title>MemberBoard-BoardView</title>

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
                        <h1 class="h3 mb-0 text-gray-800">BoardView.jsp</h1>

                    </div>

                    <!-- Content Row -->
                    <div class="row">
                        <div class="col-lg-7 ml-auto mr-auto" style="background-color: white;">
                            <div class="p-5">
                                <div class="text-center">
                                    <h1 class="h4 text-gray-900 mb-4">글상세보기</h1>
                                </div>
                                <form class="user" action="${pageContext.request.contextPath }/boardModify"
                                    enctype="multipart/form-data" method="post">
                                    <input type="hidden" name="bno" value="${boardView.bno}">
                                    <div class="form-group row">
                                        <label for="#inputTitle">글제목</label>
                                        <input id="inputTitle" type="text" class="form-control form-control-user"
                                            name="btitle" value="${boardView.btitle }" readonly="readonly">
                                    </div>

                                    <div class="form-group row">
                                        <div class="col-sm-4 mb-3 mb-sm-0">
                                            <label for="#inputWriter">작성자</label>
                                            <input id="intputWriter" type="text" class="form-control form-control-user"
                                                value="${boardView.bwriter }" readonly="readonly">
                                        </div>
                                        <div class="col-sm-4 mb-3 mb-sm-0">
                                            <label for="#inputDate">작성일</label>
                                            <input id="inputDate" type="text" class="form-control form-control-user"
                                                value="${boardView.bdate }" readonly="readonly">
                                        </div>
                                        <div class="col-sm-4 mb-3 mb-sm-0">
                                            <label for="#inputHits">조회수</label>
                                            <input id="inputHits" type="text" class="form-control form-control-user"
                                                value="${boardView.bhits }" readonly="readonly">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="#inputContent">글내용</label>
                                        <textarea class="form-control" id="inputContent" name="bcontent"
                                            readonly="readonly" rows="10">${boardView.bcontent }</textarea>
                                    </div>
                                    <div class="form-group">
                                        <label for="#inputFile">첨부파일</label>
                                        <img id="inputFile"
                                            src="${pageContext.request.contextPath }/resources/boardUpload/${boardView.bfilename}"
                                            alt="">
                                    </div>
                                    <div class="form-group row">
                                        <div class="col-sm-6 mb-3 mb-sm-0">
                                            <c:if test="${sessionScope.loginInfo.mid == boardView.bwriter }">
                                                <button id="modifyBtn" type="button"
                                                    class="btn btn-primary btn-user btn-block"
                                                    onclick="modify(isCheck)">글수정</button>
                                            </c:if>
                                        </div>
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

                    <div class="row">
                        <div class="col-lg-7 ml-auto mr-auto" style="background-color: white;">
                            <div class="pt-1 px-5 pb-1">
                                <h2>댓글출력</h2>
                            </div>
                        </div>
                    </div>



                    <!-- Content Row -->
                    <c:if test="${sessionScope.loginInfo.mid != null }">
                        <div class="row">
                            <div class="col-lg-7 ml-auto mr-auto" style="background-color: white;">
                                <div class="p-5">
                                    <form class="user" action="" method="post">
                                        <div class="form-group row">
                                            <label for="#inputComment">댓글내용</label>
                                            <textarea class="form-control" id="inputContent" name="bcontent"
                                                rows="3"></textarea>
                                        </div>
                                        <button type="submit" class="btn btn-primary btn-user btn-block">댓글작성</button>
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
        var isCheck = false;

        function modify(isCheck) {
            if (!isCheck) {
                $("#inputTitle").removeAttr("readonly");
                $("#inputContent").removeAttr("readonly");
                isCheck = true;
            } else {
                $("#modifyBtn").attr('type', 'submit');
            }
        }
    </script>
</body>

</html>