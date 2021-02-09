<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../main/main.jsp" />

<input type="hidden" id="tNumber" name="tNumber" value="${vos.tNumber }">
<div class="container">

	<div class="card o-hidden border-0 shadow-lg my-5">
		<div class="card-body p-0">
			<!-- Nested Row within Card Body -->
			<div class="row">
				<div class="col-lg-5 d-none d-lg-block">
					<div class="text-center">
						<h1 class="h1 text-gray-900 mb-4">판매글 수정</h1>
					</div>
					<hr>
					<br />
					<div class="form-group row">
						<div class="col-sm-12 mb-3 mb-sm-0">
							<input type="text" class="form-control form-control-user"
								id="tTitle" name="tTitle" value="${vo.tTitle }">
						</div>
					</div>
					<div class="form-group row">
						<div class="col-sm-12 mb-4 mb-sm-10">
							<textarea class="form-control form-control-user"
								id="tContent" name="tContent" value="${vo.tContent }"
								style="margin-top: 0px; margin-bottom: 0px; height: 340px;"></textarea>
						</div>
					</div>
					<form action="FileUpload" method="post"
						enctype="multipart/form-data">
						<!-- FileUpLoad 서블릿 실행 -->
						<hr>
						<input type="file" class="form-control form-control-user"
							id="tImage" name="tImage" value="${vo.tImage }"><br> 
						<input	class="btn btn-primary btn-user btn-block" type="submit" value="첨부">
						<p>
							<hr>
					</form>
				</div>
				<div class="col-lg-7">
					<div class="p-5">
						<form class="user" id="frm" name="frm" method="post">
						<hr>
							<br />
							<div class="form-group row">
								<div class="col-sm-3">
									<input type="text" class="form-control form-control-user"
										id="tId" name="tId" readonly="readonly" value="${vo.tId}">
								</div>
								<div class="col-sm-5">
									<input type="text" class="form-control form-control-user"
										id="tDate" name="tDate" readonly="readonly"
										value="${vo.tDate }">
								</div>
									<div class="col-sm-3">
									<input type="text" class="form-control form-control-user"
										id="tAddress" name="tAddress" value="${vo.tAddress}">
								</div>
							</div>
							<hr>
							<br />
							<div class="form-group row">
								<div class="col-sm-10">
									<input type="text" class="form-control form-control-user"
										id="pName" name="pName" value="${vo.pName }">
								</div>
							</div>

							<br /><br />
							<div class="form-group row">
								<div class="col-sm-6">
									<input type="text" class="form-control form-control-user"
										id="pVolume" name="pVolume" value="${vo.pVolume }">
								</div>
								<div class="col-sm-6 mb-3 mb-sm-0">
									<input type="text" class="form-control form-control-user"
										id="pColor" name="pColor" value="${vo.pColor }">
								</div>
								
								<div class="col-sm-6">
									<input type="hidden" class="form-control form-control-user"
										id="exampleRepeatPassword" name="exampleRepeatPassword"
										placeholder="Repeat Password">
								</div>
							</div>
							<br />
							<hr>
							<br /><br /><br />
							<div class="form-group row">
								<div class="col-sm-6">
									<input type="text" class="form-control form-control-user"
										id="tPrice" name="tPrice" value="${vo.tPrice }">
								</div>
								<div class="form-group row">
									<div class="col-sm-12 mb-3 mb-sm-0">
										<input type="text" class="form-control form-control-user"
											id="tDiscount" name="tDiscount" value="${vo.tDiscount}">
									</div>
								</div>
							
							</div>
							<br />
						
							<hr>
							<br />
							<div class="form-group row">
								<div class="col-sm-6 mb-3 mb-sm-0">
									<button type="button" onclick="location.href='sellUpload.do'"
										class="btn btn-primary btn-user btn-block">수정완료</button>
								</div>
								<div class="col-sm-6 mb-3 mb-sm-0">
									<button type="button" onclick="location.href='sellList.do'"
										class="btn btn-primary btn-user btn-block">뒤로가기</button>

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


<!-- Footer -->
<footer class="sticky-footer bg-white">
	<div class="container my-auto">
		<div class="copyright text-center my-auto">
			<span>Copyright &copy; Your Website 2021</span>
		</div>
	</div>
</footer>

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

