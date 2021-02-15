<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../main/main.jsp" />

<style>
	textarea{
		resize:none;
	}
</style>
<!-- ------------------------------------------------------------------------------ -->
<div class="container">
	<c:if test="${vo.memberId eq memberId }">
		<form id="frm" name="frm" method="post">
	</c:if>
		<input type="hidden" class="form-control form-control-user" name="productImage" value="${vo.productImage }">
			<div class="card o-hidden border-0 shadow-lg my-5">
				<div class="card-body p-0">
				
					<!-- Nested Row within Card Body -->
					<div class="row">
						<div class="col-lg-5 d-none d-lg-block">
							<div class="form-group row">
								<div class="col-sm-12 mb-3 mb-sm-0">
									<input type="text" class="form-control form-control-user"
										id="boardTitle" name="boardTitle" readonly="readonly"
										style="text-align:center; font-size:40px;"
										value="${vo.boardTitle }">
								</div>
							</div>
							<div class="card o-hidden border-0 shadow-lg my-5">
								<div class="card-body p-0">
									<img src="image/${vo.productImage }" width=60% height=40%>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-sm-12 mb-3 mb-sm-0">
									<textarea class="form-control" name="boardContent"
										readonly="readonly" 
										style="margin-top: 0px; margin-bottom: 0px; height: 340px;">${vo.boardContent }</textarea>
								</div>
							</div>
							<!-- 
							<div class="form-group row">
							<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d51727.01416109143!2d128.51365602113924!3d35.875026768137076!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3565e469c3001c79%3A0xfceaf22c62461ab4!2z64yA6rWs6rSR7Jet7IucIOyEnOq1rA!5e0!3m2!1sko!2skr!4v1612883064148!5m2!1sko!2skr" 
							width="430" height="300" frameborder="0" style="border:0; padding-left:15px;" allowfullscreen="" aria-hidden="false" tabindex="0"></iframe>
							</div>
							 -->
						</div>
						<div class="col-lg-7">
							<div class="p-5">
								<div class="text-right">
									<div>
										<div class="form-group row">
											<div class="col-sm-6 mb-3 mb-sm-0">
												<input readonly
													style="text-align: right; background-color: white;"
													type="hidden" class="form-control form-control-user"
													id="exampleFirstName" value="#">
											</div>
											<div class="col-sm-3" style="text-align: right; color: black;">
												<h5>조회수&nbsp;&nbsp;:&nbsp;&nbsp;</h5>
											</div>
											<div class="col-sm-3"
												style="text-align: center; color: black;">
												<h5>${vo.boardView }&nbsp;</h5>
											</div>
										</div>
									</div>
									<div class="form-group row">
										<div class="col-sm-3">
											<input readonly
												style="text-align: center; background-color: white;"
												type="hidden" class="form-control form-control-user"
												id="exampleFirstName" value="#">
										</div><div class="col-sm-6">
											<input readonly
												style="text-align: right; background-color: white; border:0; color:black;"
												type="text" class="form-control form-control-user"
												id="exampleFirstName" value="판매상태  :">
										</div>
										<c:if test="${vo.tradeProcess eq 'NotComplete' }">
											<div class="col-sm-1" style="text-align: center;">
												<input name="tradeProcess"  id="blinkEle" style="text-align: left; border:0; color: red; padding-top:7px;"
													value="${vo.tradeProcess }" readonly>

											</div>
										</c:if>
										<c:if test="${vo.tradeProcess eq 'Complete' }">
											<div class="col-sm-3"
												style="text-align: center;">
												<input name="tradeProcess"  id="blinkEle" style="text-align: left; border:0; color: green; padding-top:7px;"
													value="${vo.tradeProcess }" readonly>
											</div>
										</c:if>
									</div>
									<div class="form-group row">
										<div class="col-sm-6 mb-3 mb-sm-0">
											<input readonly
												style="text-align: center; background-color: white;"
												type="hidden" class="form-control form-control-user"
												id="exampleFirstName" value="#">
										</div>
										<div class="col-sm-6" style="text-align: right; color: black;">
											<h6>작성날짜&nbsp;&nbsp;:&nbsp;&nbsp;${vo.boardDate }</h6>
										</div>
									</div>
								</div>
							</div>
							<hr>
							<div class="form-group row">
								<div class="col-sm-2">
									<input readonly
										style="text-align: center; background-color: white; color: #9400d3;"
										type="text" class="form-control form-control-user"
										id="exampleLastName" value="지 역">
								</div>
								<div class="col-sm-6">
									<input type="text"
										class="form-control form-control-user" style="text-align:center;"
										readonly
										value="${vo.memberSiAddress }  ${vo.memberGuAddress }">
								</div>
								<div class="col-sm-3">
									<a target="_blank" onClick="window.open(this.href, '', 'width=1000, height=430'); return false;"
									class="btn btn-facebook btn-user btn-block"  
									href="https://www.google.co.kr/maps/place/${vo.memberSiAddress }+${vo.memberGuAddress }/">지도보기</a>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-sm-3">
									<input readonly
										style="text-align: center; background-color: white; color: #9400d3;"
										type="text" class="form-control form-control-user"
										id="exampleLastName" value="연 락 처">
								</div>
								<div class="col-sm-8">
									<input type="text" class="form-control form-control-user"
										name="memberPhoneNumber" readonly="readonly"
										value="${vo.memberPhoneNumber }">
								</div>
							</div>
							<div class="form-group row">
								<div class="col-sm-3">
									<input readonly
										style="text-align: center; background-color: white; color: #9400d3;"
										type="text" class="form-control form-control-user"
										id="exampleLastName" value="판 매 자">
								</div>
								<div class="col-sm-8">
									<input type="text" class="form-control form-control-user"
										name="memberPhoneNumber" readonly="readonly"
										value="${vo.memberId }">
								</div>
							</div>
							<hr>
							
							<div class="form-group row">
								<div class="col-sm-2">
									<input readonly
										style="text-align: center; background-color: white; color: #9400d3;"
										type="text" class="form-control form-control-user"
										id="exampleLastName" value="분 류">
								</div>
								<div class="col-sm-9">
									<input type="text" class="form-control form-control-user"
										 readonly="readonly"
										value="${vo.category1} > ${vo.category2}">
								</div>
							</div>
							<div class="form-group row">
								<div class="col-sm-2">
									<input readonly
										style="text-align: center; background-color: white; color: #9400d3;"
										type="text" class="form-control form-control-user"
										id="exampleLastName" value="품 명">
								</div>
								<div class="col-sm-9">
									<input type="text" class="form-control form-control-user"
										name="productName" readonly="readonly"
										value="${vo.productName}">
								</div>
							</div>
							<div class="form-group row">
								<div class="col-sm-2">
									<input readonly
										style="text-align: center; background-color: white; color: #9400d3;"
										type="text" class="form-control form-control-user"
										id="exampleLastName" value="색 상">
								</div>
								<div class="col-sm-6">
									<input type="text" class="form-control form-control-user"
										name="productColor" readonly="readonly"
										value="${vo.productColor}">
								</div>
								</div>
							<div class="form-group row">
							<div class="col-sm-2">
									<input readonly
										style="text-align: center; background-color: white; color: #9400d3;"
										type="text" class="form-control form-control-user"
										id="exampleLastName" value="용 량">
								</div>
								
								<div class="col-sm-6">
									<input type="text" class="form-control form-control-user"
										readonly="readonly" name="productVolume" list="volume"
										value="${vo.productVolume} GB">
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
									<input readonly
										style="text-align: center; background-color: white; color: #9400d3;"
										type="text" class="form-control form-control-user"
										id="exampleLastName" value="가 격">
								</div>
								<div class="col-sm-9">
									<input type="text" class="form-control form-control-user"
										readonly="readonly" name="price" value="${vo.price }">
								</div>
							</div>
							<hr>
							<br /> <br />
							<hr>
							<div class="form-group row">
							<c:if test="${vo.memberId eq memberId }">
								<div class="col-sm-2 mb-3 mb-sm-0">
									<input type="hidden">
								</div>
							</c:if>
							<c:if test="${vo.memberId ne memberId }">
								<div class="col-sm-1 mb-3 mb-sm-0">
									<input type="hidden">
								</div>
							</c:if>								
	<div class="col-sm-3 mb-3 mb-sm-0">
		<a href="boardList.do" class="btn btn-facebook btn-user btn-block">
			뒤로가기 </a>
	</div>
								<c:if test="${vo.memberId eq memberId || memberAuth eq 'ADMIN'}">
									<div class="col-sm-3 mb-3 mb-sm-0">
										<button type="button"
											class="btn btn-primary btn-user btn-block"
											onclick="updateAlert('${vo.boardDate }')">수 정</button>
									</div>
									<div class="col-sm-3 mb-3 mb-sm-0">
										<button type="button"
											class="btn btn-google btn-user btn-block"
											onclick="deleteAlert('${vo.boardDate }')">삭 제</button>
									</div>
								</c:if>
							<c:if test="${memberAuth eq 'ADMIN'}">
								<div class="col-sm-2 mb-3 mb-sm-0">
									<input type="hidden">
								</div>
								<div class="col-sm-2 mb-3 mb-sm-0">
									<input type="hidden">
								</div>
							</c:if>
				<c:if test="${vo.memberId ne memberId }">
				<div class="col-sm-2 mb-3 mb-sm-0">
									<form action="insertCart.do" method="post">
										<button type="submit"
											class="btn btn-google btn-user btn-block"
											>찜하기</button>
										<div>
		<input name="cartMemberId" type="hidden" value="${memberId }">
		<input name="boardDate" type="hidden" value="${vo.boardDate }">
		<input name="productName" type="hidden" value="${vo.productName }">
		<input name="price" type="hidden" value="${vo.price }"> 
		<input name="memberId" type="hidden" value="${vo.memberId }">
		<input name="memberSiAddress" type="hidden" value="${vo.memberSiAddress }">
		<input name="memberGuAddress" type="hidden" value="${vo.memberGuAddress }">
		<input name="memberPhoneNumber" type="hidden" value="${vo.memberPhoneNumber }">
		<input name="tradeProcess" type="hidden" value="${vo.tradeProcess }">
	</div>	
											
									</form>
				</div>
								<div class="col-sm-2 mb-3 mb-sm-0">
	<form action="buySend.do" method="post">
										<button type="submit"
											class="btn btn-primary btn-user btn-block"
											>구매</button>
										<div>
		<input name="buyMemberId" type="hidden" value="${memberId }">
		<input name="boardDate" type="hidden" value="${vo.boardDate }">
		<input name="productName" type="hidden" value="${vo.productName }">
		<input name="price" type="hidden" value="${vo.price }"> 
		<input name="memberId" type="hidden" value="${vo.memberId }">
		<input name="memberSiAddress" type="hidden" value="${vo.memberSiAddress }">
		<input name="memberGuAddress" type="hidden" value="${vo.memberGuAddress }">
		<input name="memberPhoneNumber" type="hidden" value="${vo.memberPhoneNumber }">
		<input name="tradeProcess" type="hidden" value="${vo.tradeProcess }">
	</div>	
											
									</form>
								</div>
								<div class="col-sm-3 mb-3 mb-sm-0">
	<form action="note.do" method="post">
										<button type="submit"
											class="btn btn-facebook btn-user btn-block"
											>문의하기</button>
										<div>
		<input name="buyMemberId" type="hidden" value="${memberId }">
		<input name="boardDate" type="hidden" value="${vo.boardDate }">
		<input name="productName" type="hidden" value="${vo.productName }">
		<input name="price" type="hidden" value="${vo.price }"> 
		<input name="memberId" type="hidden" value="${vo.memberId }">
		<input name="memberSiAddress" type="hidden" value="${vo.memberSiAddress }">
		<input name="memberGuAddress" type="hidden" value="${vo.memberGuAddress }">
		<input name="memberPhoneNumber" type="hidden" value="${vo.memberPhoneNumber }">
		<input name="tradeProcess" type="hidden" value="${vo.tradeProcess }">
		<input name="nMemberId" type="hidden" value="${vo.memberId }">
	</div>	
											
									</form>
								</div>
								</c:if>
			
			
	</div>
							</div>
								</div>
	</div>
	
	
	
	</div>
		<div>
		<input name="buyMemberId" type="hidden" value="${memberId }">
		<input name="boardDate" type="hidden" value="${vo.boardDate }">
		<input name="productName" type="hidden" value="${vo.productName }">
		<input name="price" type="hidden" value="${vo.price }"> 
		<input name="memberId" type="hidden" value="${vo.memberId }">
		<input name="memberSiAddress" type="hidden" value="${vo.memberSiAddress }">
		<input name="memberGuAddress" type="hidden" value="${vo.memberGuAddress }">
		<input name="memberPhoneNumber" type="hidden" value="${vo.memberPhoneNumber }">
	</div>
	<c:if test="${vo.memberId eq memberId }">
	</form>
	</c:if>

	
	</div>
	
	
	
								
</div>

<div class="container">
<!--댓글영역-->
<div class="card shadow mb-4">
	<div class="card-header py-3">
		<h6 class="m-0 font-weight-bold text-primary">달린 댓글</h6>
	</div>
	<div class="card-body">
		<div class="table-responsive">
			<table class="table table-bordered" id="dataTable" width="100%"
				cellspacing="0">
				<thead>
					<tr>
						<th width="10%">작성자</th>
						<th width="70%">댓글 내용</th>
						<th width="20%">작성날짜</th>
					</tr>
					<c:choose>
						<c:when test="${empty list1 }">
							<tr>
								<td colspan="9">등록된 댓글이 없습니다.</td>
							</tr>
						</c:when>
						<c:when test="${not empty list1 }">
							<c:forEach var="vo1" items="${list1 }">
								<tr>
									<td align="center">${vo1.memberId }</td>
									<td align="center">${vo1.commentContent }</td>
									<td align="center">${vo1.commentDate }</td>
								</tr>
							</c:forEach>
						</c:when>
					</c:choose>
				</thead>
				<tbody id="show">
				</tbody>
			</table>
		</div>
	</div>
</div>

<div class="card shadow mb-4">
	<div class="card-header py-3">
		<h6 class="m-0 font-weight-bold text-primary">댓글 달기</h6>
	</div>
	<form action="insertComment.do" method="post">
		<table class="table table-bordered" id="dataTable" width="100%"
			cellspacing="0">
			<tr>
				<th><input type="text" name="commentContent"
					class="form-control form-control-user"></th>
				<th width="20%"><button type="submit"
						class="btn btn-google btn-user btn-block">댓글달기</button></th>
			</tr>
		</table>
		<div>
			<input name="commentMemberId" type="hidden" value="${memberId }">
			<input name="boardDate" type="hidden" value="${vo.boardDate }">
		</div>
	</form>
</div>

<div>
	<input name="boardDate" type="hidden" id="boardDate"
		value="${vo.boardDate }"> <input name="productName"
		type="hidden" value="${vo.productName }"> <input name="price"
		type="hidden" value="${vo.price }"> <input name="memberId"
		type="hidden" value="${vo.memberId }"> <input
		name="memberSiAddress" type="hidden" value="${vo.memberSiAddress }">
	<input name="memberGuAddress" type="hidden"
		value="${vo.memberGuAddress }"> <input
		name="memberPhoneNumber" type="hidden"
		value="${vo.memberPhoneNumber }">
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
<!-- End of Footer -->


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


<script type="text/javascript">
	function updateAlert(str) {
		location.href = "boardUpdateForm.do?boardDate="+str;
	}

	function deleteAlert(str) {
		var yn = confirm("정말 삭제할까요?");
		if (yn) {
			location.href = "boardDelete.do?boardDate="+str;
		} else {
			alert("삭제하지 못하였습니다.  ");
		}
	}
	
	setInterval(function() {
		$(".blinkEle").toggle();
	}, 250);
</script>
</body>

</html>