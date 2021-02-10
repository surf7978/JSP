<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../main/main.jsp" />
	 <div class="container">

        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                <div class="row">
                    <!-- <div class="col-lg-5 d-none d-lg-block bg-register-image"></div> -->
                    <div class="col-lg-12">
                        <div class="p-5">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4">회원가입</h1>
                            </div>
                            <form class="user" action="insertMember.do" method="post">
                                <div class="form-group row">
                               		 <div class="col-sm-2 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user"
                                            style="text-align:center; font-size:15px; color: #9400d3; background-color:white;" value="아이디 입력" readonly>
                                    </div>
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user" name="memberId"
                                            placeholder="아이디 입력">
                                    </div>
                                    <div class="col-sm-1 mb-3 mb-sm-0">
                                        <input type="hidden" class="form-control form-control-user" 
                                            placeholder="아이디 입력">
                                    </div>
                                    <div class="col-sm-3 mb-3 mb-sm-0">
									<a target="_blank" onClick="window.open(this.href, '', 'width=500, height=100'); return false;"style="font-size:15px;"
									class="btn btn-facebook btn-user btn-block"  
									href="idCheck.do">중 복 체 크</a>
								</div>
                                </div>
                                <div class="form-group row">
                                	<div class="col-sm-2 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user"
                                            style="text-align:center; font-size:15px; color: #9400d3; background-color:white;" value="패스워드 입력" readonly>
                                    </div>
                                    <div class="col-sm-5">
                                        <input type="text" class="form-control form-control-user" name="memberPassword"
                                            placeholder="패스워드 입력">
                                    </div>
                                    <div class="col-sm-5">
                                        <input type="text" class="form-control form-control-user" id="exampleLastName"
                                            placeholder="패스워드 확인">
                                    </div>
                                </div>
                                <hr>
                                <div class="form-group row">
                                	<div class="col-sm-2 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user"
                                            style="text-align:center; font-size:15px; color: #9400d3; background-color:white;" value="이름 입력" readonly>
                                    </div>
                                    <div class="col-sm-4 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user"
                                            name="memberName" placeholder="홍길동">
                                    </div>
                                    <div class="col-sm-2 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user"
                                            style="text-align:center; font-size:15px; color: #9400d3; background-color:white;" value="전화번호 입력" readonly>
                                    </div>
                                    <div class="col-sm-4">
                                        <input type="text" class="form-control form-control-user"
                                            name="memberPhoneNumber" placeholder="010-XXXX-YYYY">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-2 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user"
                                            style="text-align:center; font-size:15px; color: #9400d3; background-color:white;" value="주소 (시, 구) 입력" readonly>
                                    </div>
                                    <div class="col-sm-3">
									<label>
										<input type="text" class="form-control form-control-user"
											list="siAddress" name="memberSiAddress" placeholder="시">
											<datalist id="siAddress">
												<option value="서울특별시"></option>
												<option value="부산광역시"></option>
												<option value="대구광역시"></option>
												<option value="인천광역시"></option>
												<option value="광주광역시"></option>
												<option value="대전광역시"></option>
												<option value="울산광역시"></option>
												<option value="세종특별자치시"></option>
												<option value="경기도"></option>
												<option value="강원도"></option>
												<option value="충청북도"></option>
												<option value="충청남도"></option>
												<option value="전라북도"></option>
												<option value="전라남도"></option>
												<option value="경상북도"></option>
												<option value="경상남도"></option>
												<option value="제주특별자치도"></option>											
											</datalist>
											</label>
									</div>
                                    <div class="col-sm-5 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user"
                                            name="memberGuAddress" placeholder="구">
                                    </div>
                                </div>
                                <hr>
                                <button onclick="submit" class="btn btn-primary btn-user btn-block">
                                    가입하기
                                </button>
                                <hr>
                                <a href="loginForm.do" class="btn btn-google btn-user btn-block">
                                    로그인
                                </a>
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