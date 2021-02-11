<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="../main/main.jsp" />
<style>
	textarea{
		resize:none;
	}
</style>
<div class="container">
	<div class="card o-hidden border-0 shadow-lg my-5">
		<div class="card-body p-0">
			<!-- Nested Row within Card Body -->
			<form action="insertBoard.do" method="post">
			<div class="row">
				
					<div class="col-lg-5 d-none d-lg-block">
						<hr>
						<div class="form-group row">
							<div class="col-sm-12 mb-3 mb-sm-0">
								<input type="text" class="form-control form-control-user"
									name="boardTitle" placeholder="제목 입력">
							</div>
						</div>
						<div class="form-group row">
							<div class="col-sm-12 mb-3 mb-sm-0">
								<textarea class="form-control" 
									name="boardContent" placeholder="내용 입력"
									style="margin-top: 0px; margin-bottom: 0px; height: 500px;"></textarea>
							</div>
						</div>
					
					</div>
					<div class="col-lg-6">
						<div class="p-5">
							<div class="text-center">

								<hr>
								<div class="form-group row">
									<div class="col-sm-6">
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
									<div class="col-sm-6">
										<input type="text" class="form-control form-control-user"
											name="memberGuAddress" placeholder="구">
									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-12">
										<input type="text" class="form-control form-control-user"
											name="memberPhoneNumber" placeholder="연락처">
									</div>
								</div>
								<hr>
								<div class="form-group row">
									<div class="col-sm-6">
										<input type="text" class="form-control form-control-user"
											name="category1" list="category1" placeholder="분류1">
											<datalist id="category1">
											<option value="의류"></option>
											<option value="전자기기"></option>
											</datalist>
									</div>
									<div class="col-sm-6">
										<input type="text" class="form-control form-control-user"
											name="category2" placeholder="분류2">
									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-12">
										<input type="text" class="form-control form-control-user"
											name="productName" placeholder="제품명">
									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-6">
									<input type="text" class="form-control form-control-user"
										name="productColor" 
										value="색상 입력">
									</div>
									<div class="col-sm-6">
									<input type="text" class="form-control form-control-user"
										name="productVolume" list="volume"
										value="용량 입력">
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
									<div class="col-sm-6">
										<input type="text" class="form-control form-control-user"
											name="price" placeholder="판매가격">
									</div>

								</div>
								<hr>
								<div>
									<input type="hidden" name="memberId" value="${memberId }">
									<input type="hidden" name="memberSiAddress"
										value="${memberSiAddress }"> <input type="hidden"
										name="memberGuAddress" value="${memberGuAddress }"> <input
										type="hidden" name="memberPhoneNumber"
										value="${memberPhoneNumber }">
								</div>
								<br /> <br />
								<div>
									<form action="FileUpload" method="post" enctype="multipart/form-data">
										<!-- FileUpLoad 서블릿 실행 -->
										<input type="file" class="form-control" style="padding-bottom:35px;"
											id="productImage" name="productImage"><br> 
										<p>
									</form>
								</div>
								<hr>
								<div class="form-group row" align="center">
									<div class="col-sm-4 mb-3 mb-sm-0">
										<button type="submit"
											class="btn btn-primary btn-user btn-block">판매글등록</button>
									</div>
									<div class="col-sm-4 mb-3 mb-sm-0">
										<a href="boardList.do"
											class="btn btn-google btn-user btn-block"> 뒤로가기 </a>
									</div>
									<div class="col-sm-4">
										<button class="btn btn-facebook btn-user btn-block"
											type="reset">취소</button>
									</div>
								</div>

							</div>
						</div>
					</div>
			</div>
		</form>

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
<a class="scroll-to-top rounded" href="#page-top"> <i
	class="fas fa-angle-up"></i>
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