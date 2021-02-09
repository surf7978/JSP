<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../main/main.jsp" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
<!-- 수정 삭제 -->
<script type="text/javascript">
	function deleteAlert(str) {
		var yn = confirm("정말 삭제할까요?");
		if (yn) {
			location.href = "sellDelete.do?row=" + str;
		} else {

		}
	}
	function updateAlert(str){
		location.href="sellUpdateForm.do?tNumber=" + str;
	}
</script>
</head>
<body>
<div class="container">

	<div class="card o-hidden border-0 shadow-lg my-5">
		<div class="card-body p-0">
			<!-- Nested Row within Card Body -->
			<div class="row">
				<div class="col-lg-5 d-none d-lg-block">
					<input type="image" id="tImage" name="tImage" value="${vo.tImage }">
				</div>
				<div class="col-lg-7">
					<div class="p-5">
						<div class="text-center">
							<h1 class="h1 text-gray-900 mb-4">판매글 상세보기</h1>
						</div>
						<div class="text-right">
							<div>
								<div class="form-group row">
									<div class="col-sm-4" style="text-align: right; color: black;">
										<h5>조회수&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;</h5>
									</div>
									<div class="col-sm-2 mb-3 mb-sm-0"
										style="text-align: left; color: black;">
										<h5>99</h5>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-4" style="text-align: right; color: blue;">
										<h6>좋아요&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;</h6>
									</div>
									<div class="col-sm-2 mb-3 mb-sm-0"
										style="text-align: left; color: blue;">
										<h6>99</h6>
									</div>
								</div>
							</div>
						</div>
						<form class="user">
				<div class="col-lg-11">
					<div class="p-5">
							<div class="form-group row">
								<div class="col-sm-3">
									<input type="text" class="form-control form-control-user"
										id="tId" name="tId" value="${vo.tId }" readonly="readonly">
								</div>
								<div class="col-sm-5">
									<input type="text" class="form-control form-control-user"
										id="tDate" name="tDate" value="${vo.tDate }" readonly="readonly">
								</div>
								<div class="col-sm-3">
									<input type="text" class="form-control form-control-user"
										id="tAddress" name="tAddress" value="${vo.tAddress }" readonly="readonly">
								</div>
							</div>
							<hr>
							<div class="form-group row">
								<div class="col-sm-12 mb-3 mb-sm-0">
									<input type="text" class="form-control form-control-user"
										id="tTitle" name="tTitle" value="${vo.tTitle }" readonly="readonly">
								</div>
							</div>
							<div class="form-group row">
								<div class="col-sm-12 mb-3 mb-sm-0">
									<input type="text" class="form-control form-control-user"
										id="tContent" name="tContent" value="${vo.tContent }" readonly="readonly">
								</div>
							</div>
							<div class="form-group row">
								<div class="col-sm-6">
									<input type="text" class="form-control form-control-user"
										id="tPrice" name="tPrice" value="${vo.tPrice }" readonly="readonly">
								</div>
								<div class="form-group row">
									<div class="col-sm-12 mb-3 mb-sm-0">
										<input type="text" class="form-control form-control-user"
											id="tDiscount" name="tDiscount" value="${vo.tDiscount }" readonly="readonly">
									</div>
								</div>
							</div>
							<hr>
							<div class="form-group row">
								<div class="col-sm-6">
									<input type="text" class="form-control form-control-user"
										id="pName" name="pName" value="${vo.pName }" readonly="readonly">
								</div>
								<div class="col-sm-6">
									<input type="text" class="form-control form-control-user"
										id="tVolume" name="tVolume" value="${vo.pVolume }" readonly="readonly">
								</div>
							</div>
							<div class="form-group row">
								<div class="col-sm-6 mb-3 mb-sm-0">
									<input type="text" class="form-control form-control-user"
										id="tColor" name="tColor" value="${vo.pColor}" readonly="readonly">
								</div>
								<div class="col-sm-6">
									<input type="hidden" class="form-control form-control-user"
										id="exampleRepeatPassword" name="exampleRepeatPassword"
										placeholder="Repeat Password">
								</div>
							</div>
							<hr>
							<div class="form-group row">
								<div class="col-sm-6 mb-3 mb-sm-0">
									<button type="button" onclick="updateAlert(${vo.tNumber})"
										class="btn btn-primary btn-user btn-block">수정</button>
								</div>
								<div class="col-sm-6 mb-3 mb-sm-0">
									<button type="button" onclick="deleteAlert('${vo.tNumber}')"
									class="btn btn-google btn-user btn-block">삭제</button>
								</div>
							</div>
							<hr>
					</div>
				</div>
						</form>
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

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top"> <i
	class="fas fa-angle-up"></i>
</a>
</body>
</html>