<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../main/main.jsp" />

<c:if test="${vo.memberId ne memberId }">
	<div class="container">
        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                <div class="row">
                    <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
                    <div class="col-lg-7">
                        <div class="p-5">
                            <div class="text-center">
                                <h1 class="h1 text-gray-900 mb-4">${vo.boardTitle }</h1>
                            </div>
                            <div class="text-right">
                                <div>
                                    <div class="form-group row">
                                        <div class="col-sm-6 mb-3 mb-sm-0">
                                            <input readonly style="text-align:left; border:0; background-color:white;" type="hidden" class="form-control form-control-user" id="exampleFirstName"
                                                value="공란용">
                                        </div>
                                        <div class="col-sm-3" style="text-align: right; color:black;">
                                            <h5>조회수&nbsp;&nbsp;:</h5>
                                        </div>
                                        <div class="col-sm-3" style="text-align: center; color:black;">
                                            <h5>${vo.boardView }&nbsp;</h5>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <div class="col-sm-6 mb-3 mb-sm-0">
                                            <input readonly style="text-align:center; background-color:white;" type="hidden" class="form-control form-control-user" id="exampleFirstName"
                                                value="통신사">
                                        </div>
                                        <div class="col-sm-3" style="text-align: right; color: black;">
                                            <h6>거래상태 : </h6>
                                        </div>
                                        <c:if test="${vo.tradeProcess eq 'NotComplete' }">
                                        <div class="col-sm-3" style="text-align: center; color: red;">
                                            <h6>${vo.tradeProcess }</h6>
                                        </div>
                                        </c:if>
                                        <c:if test="${vo.tradeProcess eq 'Complete' }">
                                        <div class="col-sm-3" style="text-align: center; color: green;">
                                            <h6>${vo.tradeProcess }</h6>
                                        </div>
                                        </c:if>
                                    </div>
                                    <div class="form-group row">
                                        <div class="col-sm-6 mb-3 mb-sm-0">
                                            <input readonly style="text-align:center; background-color:white;" type="hidden" class="form-control form-control-user" id="exampleFirstName"
                                                value="통신사">
                                        </div>
                                        <div class="col-sm-6" style="text-align: right; color: black;">
                                            <h6>작성날짜&nbsp;&nbsp;:&nbsp;&nbsp;${vo.boardDate }</h6>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <form action="buySend.do" method="post">
                                <hr>
                                <div class="form-group row">
                                	<div class="col-sm-3 mb-3 mb-sm-0">
                                        <input readonly style="text-align:center; background-color:white; color:#9400d3;" type="text" class="form-control form-control-user" id="exampleFirstName"
                                            value="내 용">
                                    </div>
                                    <div class="col-sm-9 mb-3 mb-sm-0">
                                        <input readonly style="text-align:center; background-color:white;" type="text" class="form-control form-control-user" id="exampleFirstName"
                                            value="${vo.boardContent }">
                                    </div>
                                </div>
                                
                                <hr>
                                
                                <div class="form-group row">
                                    <div class="col-sm-3">
                                        <input readonly style="text-align:center; background-color:white; color:#9400d3;" type="text" class="form-control form-control-user" id="exampleLastName"
                                        value="품 명">
                                    </div>
                                    <div class="col-sm-9">
                                        <input readonly style="text-align:center; background-color:white;" type="text" class="form-control form-control-user" id="exampleLastName"
                                            value="${vo.productName }">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-3">
                                        <input readonly style="text-align:center; background-color:white; color:#9400d3;" type="text" class="form-control form-control-user" id="exampleLastName"
                                            value="가 격">
                                    </div>
                                    <div class="col-sm-9">
                                        <input readonly style="text-align:center; background-color:white;" type="text" class="form-control form-control-user" id="exampleLastName"
                                            value="${vo.price }">
                                    </div>
                                </div>
                                
                                <hr>
                                
                                <div class="form-group row">
	                                <div class="col-sm-3">
                                        <input readonly style="text-align:center; background-color:white; color:#9400d3;" type="text" class="form-control form-control-user" id="exampleLastName"
                                            value="판 매 자">
                                    </div>
                                    <div class="col-sm-9">
                                        <input readonly style="text-align:center; background-color:white;" type="text" class="form-control form-control-user" id="exampleLastName"
                                            value="${vo.memberId }">
                                    </div>
                                </div>
                                <div class="form-group row">
	                                <div class="col-sm-3">
                                        <input readonly style="text-align:center; background-color:white; color:#9400d3;" type="text" class="form-control form-control-user" id="exampleLastName"
                                            value="연 락 처">
                                    </div>
                                    <div class="col-sm-9">
                                        <input readonly style="text-align:center; background-color:white;" type="text" class="form-control form-control-user" id="exampleLastName"
                                            value="${vo.memberPhoneNumber }">
                                    </div>
                                </div>
                                <div class="form-group row">
	                                <div class="col-sm-3">
                                        <input readonly style="text-align:center; background-color:white; color:#9400d3;" type="text" class="form-control form-control-user" id="exampleLastName"
                                            value="주 소">
                                    </div>
                                    <div class="col-sm-9">
                                        <input readonly style="text-align:center; background-color:white;" type="text" class="form-control form-control-user" id="exampleLastName"
                                            value="${vo.memberSiAddress }  ${vo.memberGuAddress }">
                                    </div>
                                </div>
                                <hr>
                                <div class="form-group row">
                                <div class="col-sm-2 mb-3 mb-sm-0">
                                    <input type="hidden" >
                                </div>
                                <c:if test="${vo.memberId ne memberId }">
                                <div class="col-sm-4 mb-3 mb-sm-0">
                                    <button onclick="submit" class="btn btn-google btn-user btn-block">
                                        구매하기
                                    </button>
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

                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</c:if>
    
<c:if test="${vo.memberId eq memberId }">
    <div class="container">
        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                <div class="row">
                    <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
                    <div class="col-lg-7">
                        <div class="p-5">
                            <form action="updateBoard.do" method="post">
                            <div class="text-center">
                            	<input readonly style="text-align:center; border:0;" value="제목">
                                <input name="updateBoardTitle" class="h1 text-gray-900 mb-4" style="text-align:center;" value="${vo.boardTitle }">
                            </div>
                            <div class="text-right">
                                <div>
                                    <div class="form-group row">
                                        <div class="col-sm-6 mb-3 mb-sm-0">
                                            <input readonly style="text-align:left; border:0; background-color:white;" type="hidden" class="form-control form-control-user" id="exampleFirstName"
                                                value="공란용">
                                        </div>
                                        <div class="col-sm-3" style="text-align: right; color:black;">
                                            <h5>조회수&nbsp;&nbsp;:</h5>
                                        </div>
                                        <div class="col-sm-3" style="text-align: center; color:black;">
                                            <h5>${vo.boardView }&nbsp;</h5>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <div class="col-sm-3 mb-3 mb-sm-0">
                                            <input readonly style="text-align:center; background-color:white;" type="hidden" class="form-control form-control-user" id="exampleFirstName"
                                                value="통신사">
                                        </div>
                                        <div class="col-sm-3" style="text-align: right; color: black;">
                                            <input readonly style="text-align:left; border:0;" value="  거래상태 : ">
                                        </div>
                                        <c:if test="${vo.tradeProcess eq 'NotComplete' }">
                                        <div class="col-sm-3" style="text-align: center; color: red;">
                                            <input name="tradeProcess" style="text-align:center;" value="${vo.tradeProcess }">
                                        </div>
                                        </c:if>
                                        <c:if test="${vo.tradeProcess eq 'Complete' }">
                                        <div class="col-sm-3" style="text-align: center; color: green;">
                                            <input name="tradeProcess" style="text-align:center;" value="${vo.tradeProcess }">
                                        </div>
                                        </c:if>
                                    </div>
                                    <div class="form-group row">
                                        <div class="col-sm-6 mb-3 mb-sm-0">
                                            <input readonly style="text-align:center; background-color:white;" type="hidden" class="form-control form-control-user" id="exampleFirstName"
                                                value="통신사">
                                        </div>
                                        <div class="col-sm-6" style="text-align: right; color: black;">
                                            <h6>작성날짜&nbsp;&nbsp;:&nbsp;&nbsp;${vo.boardDate }</h6>
                                        </div>
                                    </div>
                                </div>
                            </div>
                                <hr>
                                <div class="form-group row">
                                	<div class="col-sm-3 mb-3 mb-sm-0">
                                        <input readonly style="text-align:center; background-color:white; color:#9400d3;" type="text" class="form-control form-control-user" id="exampleFirstName"
                                            value="내 용">
                                    </div>
                                    <div class="col-sm-9 mb-3 mb-sm-0">
                                        <input style="text-align:center; background-color:white;" type="text" class="form-control form-control-user" name="updateBoardContent"
                                            value="${vo.boardContent }">
                                    </div>
                                </div>
                                
                                <hr>
                                
                                <div class="form-group row">
                                    <div class="col-sm-3">
                                        <input readonly style="text-align:center; background-color:white; color:#9400d3;" type="text" class="form-control form-control-user" id="exampleLastName"
                                        value="품 명">
                                    </div>
                                    <div class="col-sm-9">
                                        <input readonly style="text-align:center;" type="text" class="form-control form-control-user" id="exampleLastName"
                                            value="${vo.productName }">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-3">
                                        <input readonly style="text-align:center; background-color:white; color:#9400d3;" type="text" class="form-control form-control-user" id="exampleLastName"
                                            value="가 격">
                                    </div>
                                    <div class="col-sm-9">
                                        <input style="text-align:center; background-color:white;" type="text" class="form-control form-control-user" name="updatePrice"
                                            value="${vo.price }">
                                    </div>
                                </div>
                                
                                <hr>
                                
                                <div class="form-group row">
	                                <div class="col-sm-3">
                                        <input readonly style="text-align:center; background-color:white; color:#9400d3;" type="text" class="form-control form-control-user" id="exampleLastName"
                                            value="판 매 자">
                                    </div>
                                    <div class="col-sm-9">
                                        <input readonly style="text-align:center;" type="text" class="form-control form-control-user" id="exampleLastName"
                                            value="${vo.memberId }">
                                    </div>
                                </div>
                                <div class="form-group row">
	                                <div class="col-sm-3">
                                        <input readonly style="text-align:center; background-color:white; color:#9400d3;" type="text" class="form-control form-control-user" id="exampleLastName"
                                            value="연 락 처">
                                    </div>
                                    <div class="col-sm-9">
                                        <input readonly style="text-align:center;" type="text" class="form-control form-control-user" id="exampleLastName"
                                            value="${vo.memberPhoneNumber }">
                                    </div>
                                </div>
                                <div class="form-group row">
	                                <div class="col-sm-3">
                                        <input readonly style="text-align:center; background-color:white; color:#9400d3;" type="text" class="form-control form-control-user" id="exampleLastName"
                                            value="주 소">
                                    </div>
                                    <div class="col-sm-9">
                                        <input readonly style="text-align:center;" type="text" class="form-control form-control-user" id="exampleLastName"
                                            value="${vo.memberSiAddress }  ${vo.memberGuAddress }">
                                    </div>
                                </div>
                                <hr>
                                <div class="form-group row">
                                <div class="col-sm-2 mb-3 mb-sm-0">
                                    <input type="hidden" >
                                </div>
                                <c:if test="${vo.memberId eq memberId }">
                                <div class="col-sm-4 mb-3 mb-sm-0">
                                    <button type="submit" class="btn btn-primary btn-user btn-block">
                                        수정하기
                                    </button>
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
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</c:if>

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
								<th>작성자</th>
								<th>댓글 내용</th>
								<th>작성날짜</th>
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
								<td align="center" width="80%">${vo1.commentContent }</td>
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
			<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
				<tr>
					<th><input type="text" name="commentContent" class="form-control form-control-user"></th>
					<th width="20%"><button type="submit" class="btn btn-google btn-user btn-block">댓글달기</button></th>
				</tr>
			</table>
<div>
	<input name="commentMemberId" type="hidden" value="${memberId }">
	<input name="boardDate" type="hidden" value="${vo.boardDate }">
</div>
		</form>
	</div>
	
<div>
	<input name="boardDate" type="hidden" value="${vo.boardDate }">
	<input name="productName" type="hidden" value="${vo.productName }">
	<input name="price" type="hidden" value="${vo.price }">
	<input name="memberId" type="hidden" value="${vo.memberId }">
	<input name="memberSiAddress" type="hidden" value="${vo.memberSiAddress }">
	<input name="memberGuAddress" type="hidden" value="${vo.memberGuAddress }">
	<input name="memberPhoneNumber" type="hidden" value="${vo.memberPhoneNumber }">
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

</body>

</html>