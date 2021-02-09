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
                                <h1 class="h1 text-gray-900 mb-4">입력한 제목</h1>
                            </div>
                            <div class="text-right">
                                <div>
                                    <div class="form-group row">
                                        <div class="col-sm-6 mb-3 mb-sm-0">
                                            <input type="hidden" class="form-control form-control-user" id="exampleFirstName"
                                                placeholder="통신사">
                                        </div>
                                        <div class="col-sm-4" style="text-align: right; color:black;">
                                            <h5>조회수&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;</h5>
                                        </div>
                                        <div class="col-sm-2 mb-3 mb-sm-0" style="text-align: left; color:black;">
                                            <h5>99</h5>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <div class="col-sm-6 mb-3 mb-sm-0">
                                            <input type="hidden" class="form-control form-control-user" id="exampleFirstName"
                                                placeholder="통신사">
                                        </div>
                                        <div class="col-sm-4" style="text-align: right; color: blue;">
                                            <h6>좋아요&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;</h6>
                                        </div>
                                        <div class="col-sm-2 mb-3 mb-sm-0" style="text-align: left; color: blue;">
                                            <h6>99</h6>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <form class="user">
                                <hr>
                                <div class="form-group row">
                                    <div class="col-sm-4 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user" id="exampleFirstName"
                                            placeholder="통신사">
                                    </div>
                                    <div class="col-sm-4">
                                        <input type="text" class="form-control form-control-user" id="exampleLastName"
                                            placeholder="제조사">
                                    </div>
                                    <div class="col-sm-4 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user"
                                            id="exampleInputPassword" placeholder="색상">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control form-control-user" id="exampleLastName"
                                        placeholder="품명">
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control form-control-user" id="exampleLastName"
                                            placeholder="용량">
                                    </div>
                                </div>
                                <hr>
                                <div class="form-group row">
                                    <div class="col-sm-12 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user" id="exampleFirstName"
                                            placeholder="내용">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control form-control-user" id="exampleLastName"
                                            placeholder="판매가격">
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control form-control-user" id="exampleLastName"
                                            placeholder="판매지역">
                                    </div>
                                </div>
                                
                                <div class="form-group row">
                                <div class="col-sm-4 mb-3 mb-sm-0">
                                    <a href="login.html" class="btn btn-primary btn-user btn-block">
                                        구매하기
                                    </a>
                                </div>
                                <div class="col-sm-4 mb-3 mb-sm-0">
                                    <a href="index.html" class="btn btn-google btn-user btn-block">
                                        판매자 문의
                                    </a>
                                </div>
                                <div class="col-sm-4 mb-3 mb-sm-0">
                                    <a href="index.html" class="btn btn-facebook btn-user btn-block">
                                        뒤로가기
                                    </a>
                                </div>
                                 </div>
                                <hr>
                                
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