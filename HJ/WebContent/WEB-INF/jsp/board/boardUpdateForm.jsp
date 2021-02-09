<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../main/main.jsp" />
<!-- ------------------------------------------------------------------- -->
<div class="container">
<form id="frm" name="frm" action="updateBoard.do" method="post">
        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
            
                <!-- Nested Row within Card Body -->
                <div class="row">
                     <div class="col-lg-5 d-none d-lg-block">
						<div class="form-group row">
							<div class="col-sm-12 mb-3 mb-sm-0">
								<input type="text" class="form-control form-control-user"
									name="boardTitle" value="${vos.boardTitle }">
							</div>
						</div>
						<div class="card o-hidden border-0 shadow-lg my-5">
								<div class="card-body p-0">
									<img src="image/${vo.productImage }" width=60% height=40%>
								</div>
							</div>
						<div class="form-group row">
							<div class="col-sm-12 mb-3 mb-sm-0">
								<textarea class="form-control"
									name="boardContent" 
									style="margin-top: 0px; margin-bottom: 0px; height: 500px;">${vos.boardContent }</textarea>
							</div>
						</div>
					
					</div>
                    <div class="col-lg-7">
                        <div class="p-5">
                            <div class="text-right">
                                <div>
                                    <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                          <input readonly style="text-align:right; background-color:white;" type="hidden" class="form-control form-control-user" id="exampleFirstName"
                                                value="#">
                                        </div>
                                        <div class="col-sm-3" style="text-align: left; color:black;">
                                            <h5>조회수&nbsp;&nbsp;:</h5>
                                        </div>
                                        <div class="col-sm-3" style="text-align: center; color:black;">
                                            <h5>${vos.boardView }&nbsp;</h5>
                                        </div>
                                    </div>                        
                                        </div>
                                    <div class="form-group row">
                                     <div class="col-sm-6">
                                            <input readonly style="text-align:center; background-color:white;" type="hidden" class="form-control form-control-user" id="exampleFirstName"
                                                value="#">
                                       </div>
                                        <c:if test="${vos.tradeProcess eq 'NotComplete' }">
                                        <div class="col-sm-1" style="text-align: center; color: red;">
                                            <input name="tradeProcess" style="text-align:center;" value="${vos.tradeProcess }">
                                           
                                        </div>
                                        </c:if>
                                        <c:if test="${vos.tradeProcess eq 'Complete' }">
                                        <div class="col-sm-3" style="text-align: center; color: green;">
                                            <input name="tradeProcess" style="text-align:center;" value="${vos.tradeProcess }">
                                        </div>
                                        </c:if>
                                    </div>
                                    <div class="form-group row">
                                        <div class="col-sm-6 mb-3 mb-sm-0">
                                            <input readonly style="text-align:center; background-color:white;" type="hidden" class="form-control form-control-user" id="exampleFirstName"
                                                value="#">
                                        </div>
                                        <div class="col-sm-6" style="text-align: right; color: black;">
                                            <h6>작성날짜&nbsp;&nbsp;:&nbsp;&nbsp;${vos.boardDate }</h6>
                                        </div>
                                    </div>
                                </div>
                            </div>
                                <hr>
								<div class="form-group row">
								<div class="col-sm-2">
                                        <input readonly style="text-align:center; background-color:white; color:#9400d3;" type="text" class="form-control form-control-user" id="exampleLastName"
                                            value="지역">
                                    </div>
									<div class="col-sm-4">
									<label>
										<input type="text" class="form-control form-control-user"
											list="siAddress" name="memberSiAddress" value="${vos.memberSiAddress }">
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
									<div class="col-sm-4">
										<input type="text" class="form-control form-control-user"
											name="memberGuAddress" value="${vos.memberGuAddress }">
									</div>
								</div>
                                <div class="form-group row">
                                	 <div class="col-sm-3">
                                        <input readonly style="text-align:center; background-color:white; color:#9400d3;" type="text" class="form-control form-control-user" id="exampleLastName"
                                            value="연 락 처">
                                    </div>
									<div class="col-sm-9">
										<input type="text" class="form-control form-control-user"
											name="memberPhoneNumber" value="${vos.memberPhoneNumber }">
									</div>
								</div>
                                <hr>
                                
								<div class="form-group row">
									<div class="col-sm-2">
                                        <input readonly style="text-align:center; background-color:white; color:#9400d3;" type="text" class="form-control form-control-user" id="exampleLastName"
                                            value="기종">
                                    </div>
									<div class="col-sm-9">
										<input type="text" class="form-control form-control-user"
											name="productName" value="${vos.productName}">
									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-2">
                                        <input readonly style="text-align:center; background-color:white; color:#9400d3;" type="text" class="form-control form-control-user" id="exampleLastName"
                                            value="색상">
                                    </div>
									<div class="col-sm-6">
										<input type="text" class="form-control form-control-user"
											name="productColor" value="${vos.productColor}">
									</div>
								</div>
								<div class="form-group row">
								<div class="col-sm-2">
                                        <input readonly style="text-align:center; background-color:white; color:#9400d3;" type="text" class="form-control form-control-user" id="exampleLastName"
                                            value="용량">
                                    </div>
									<div class="col-sm-6">
										<input type="text" class="form-control form-control-user"
											name="productVolume" list="volume" value="${vos.productVolume}">
											<datalist id="volume">
											<option value="16">GB</option>
											<option value="32">GB</option>
											<option value="64">GB</option>
											<option value="128">GB</option>
											<option value="256">GB</option>
											<option value="512">GB</option>
											</datalist>
									</div>
								</div>
                                <hr>

								<div class="form-group row">
								<div class="col-sm-2">
                                        <input readonly style="text-align:center; background-color:white; color:#9400d3;" type="text" class="form-control form-control-user" id="exampleLastName"
                                            value="가격">
                                    </div>
									<div class="col-sm-9">
										<input type="text" class="form-control form-control-user"
											name="price" value="${vos.price }">
									</div>
                                </div>
                                <hr>
                                <br /> <br />
								<div>

								<div class="form-group row">
									<div class="col-sm-3">
                                        <input readonly style="text-align:center; background-color:white; color:#9400d3;" type="text" class="form-control form-control-user" id="exampleLastName"
                                            value="첨부파일">
                                    </div>
									<div class="col-sm-6">
										<input type="text" class="form-control form-control-user" name="productImage" value="${vo.productImage }">											
									</div>
									<div class="col-sm-3">
											<input type="button" class="btn btn-primary btn-user btn-block" 
													onClick="window.open('fileUpload.do','파일업로드','width=400,height=400,location=no,status=no,scrollbars=no')" value="파일업로드">
									</div>
								</div>
								</div>
                                <hr>
                                <div class="form-group row">
                                <div class="col-sm-2 mb-3 mb-sm-0">
                                    <input type="hidden" >
                                </div>
                                <c:if test="${vos.memberId eq memberId }">
                                <div class="col-sm-4 mb-3 mb-sm-0">
                                    <input type="submit" class="btn btn-primary btn-user btn-block" value="수정완료">

                                </div>
                                </c:if>
                                <div class="col-sm-1 mb-3 mb-sm-0">
                                    <input type="hidden" >
                                </div>
                                <div class="col-sm-4 mb-3 mb-sm-0">
                                    <a href="boardList.do" class="btn btn-facebook btn-user btn-block">
                                        뒤로가기
                                    </a>
                                </div>
                                 </div>
                                <hr>
                                </div>
                                
<div>
	<input name="buyMemberId" type="hidden" value="${memberId }">
	<input name="boardDate" type="hidden" value="${vos.boardDate }">
	<input name="productName" type="hidden" value="${vos.productName }">
	<input name="price" type="hidden" value="${vos.price }">
	<input name="memberId" type="hidden" value="${vos.memberId }">
	<input name="memberSiAddress" type="hidden" value="${vos.memberSiAddress }">
	<input name="memberGuAddress" type="hidden" value="${vos.memberGuAddress }">
	<input name="memberPhoneNumber" type="hidden" value="${vos.memberPhoneNumber }">
</div>
                            
                        </div>
                    </div>
                </div>
                </form>
            </div>

           <!-- Footer -->
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright &copy; Your Website 2021</span>
                    </div>
                </div>
            </footer>
            <!-- End of Footer -->


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


<script type="text/javascript">
	function updateAlert(str){
		location.href="UpdateBoard.do?boardDate=" + str;
	}
</script>
</body>
</html>