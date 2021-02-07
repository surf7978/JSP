<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="../main/main.jsp" />


	<div class="container">

        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                <div class="row">
                    <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
                    <div class="col-lg-7">
                        <div class="p-5">
                            <div class="text-center">
                            	<div class="form-group row">
                                    <div class="col-sm-12 mb-3 mb-sm-0">
                                        <input type="text" style="border:0;" readonly>
                                    </div>
                                </div>
                                <h1 class="h4 text-gray-900 mb-4">판매글 등록</h1>
                            </div>
                            <form class="user" action="insertBoard.do" method="post">
                                <div class="form-group row">
                                    <div class="col-sm-12 mb-3 mb-sm-0">
                                        <input type="text" style="border:0;" readonly>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-12 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user" name="boardTitle"
                                            placeholder="제목 입력">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-12 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user" name="boardContent"
                                            placeholder="내용 입력">
                                    </div>
                                </div>
                                <hr>
                                <div class="form-group row">
                                	<div class="col-sm-6">
                                        <input type="text" class="form-control form-control-user" name="category1"
                                        placeholder="분류1">
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control form-control-user" name="category2"
                                        placeholder="분류2">
                                    </div>
                                </div>
                                <div class="form-group row">
                                	<div class="col-sm-6">
                                        <input type="text" class="form-control form-control-user" name="productName"
                                        placeholder="제품명">
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control form-control-user" name="price"
                                            placeholder="판매가격">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control form-control-user" name="image"
                                        placeholder="사진첨부">
                                    </div>
                                    <div class="col-sm-6">
                                        <button class="btn btn-facebook btn-user btn-block">찾아보기</button>
                                    </div>
                                </div>
                                <hr>
                                <div class="form-group row">
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                    <button type="submit" class="btn btn-primary btn-user btn-block">
                                        판매글 등록
                                    </button>
                                </div>
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                    <a href="mainPage.do" class="btn btn-google btn-user btn-block">
                                        뒤로가기
                                    </a>
                                </div>
                                 </div>
                                <hr>
                                <div>
                                	<input type="hidden" name="memberId" value="${memberId }">
                                	<input type="hidden" name="memberSiAddress" value="${memberSiAddress }">
                                	<input type="hidden" name="memberGuAddress" value="${memberGuAddress }">
                                	<input type="hidden" name="memberPhoneNumber" value="${memberPhoneNumber }">
                                </div>
                            </form>
                        </div>
                    </div>
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
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>



    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="vendor/chart.js/Chart.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="js/demo/chart-area-demo.js"></script>
    <script src="js/demo/chart-pie-demo.js"></script>

</body>

</html>