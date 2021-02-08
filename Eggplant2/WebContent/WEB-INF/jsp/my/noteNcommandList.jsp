<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../main/main.jsp" />

<div id="wrapper">

	<!-- Begin Page Content -->
	<div class="container-fluid">

		<!-- Page Heading -->
		<h1 class="h3 mb-2 text-gray-800">Note & Command List</h1>
		<p class="mb-4">
			활동 내역
		</p>
	<!-- DataTales Example -->
		<div class="card shadow mb-4">
			<div class="card-header py-3">
				<c:if test="${memberAuth ne 'ADMIN'}">
				<h6 class="m-0 font-weight-bold text-primary">구매 내역</h6>
				</c:if>
				<c:if test="${memberAuth eq 'ADMIN'}">
				<h6 class="m-0 font-weight-bold text-primary">유저 거래 내역</h6>
				</c:if>
			</div>
			<div class="card-body">
				<div class="table-responsive">
					<table class="table table-bordered" id="dataTable" width="100%"
						cellspacing="0">
						<thead>
							<tr>
								<c:if test="${memberAuth ne 'USER'}">
									<th>구매자</th>
								</c:if>
								<th>구매날짜</th>
								<th>품명</th>
								<th>판매가격</th>
								<th>판매자</th>
								<th>판매자연락처</th>
								<th>판매지역</th>
								<th>판매날짜</th>
								<!-- <c:if test="${memberAuth eq 'ADMIN'}"></c:if> -->
								<th>진행상태</th>
							</tr>
							<c:choose>
					<c:when test="${empty list1 }">
						<tr>
							<td colspan="9">구입한 제품이 없습니다.</td>
						</tr>
					</c:when>
					<c:when test="${not empty list1 }">
					<c:if test="${memberAuth eq 'ADMIN'}">
						<c:forEach var="vo" items="${list1 }">
							<tr onclick="location.href='boardView.do?boardDate=${vo.boardDate}'">
								<td align="center">${vo.buyMemberId }</td>
								<td align="center">${vo.buyDate }</td>
								<td align="center">${vo.productName }</td>
								<td align="center">${vo.price }</td>
								<td align="center">${vo.memberId }</td>
								<td align="center">${vo.memberPhoneNumber }</td>
								<td align="center">${vo.memberSiAddress }&nbsp;&nbsp;${vo.memberGuAddress }</td>
								<td align="center">${vo.boardDate }</td>
								<c:if test="${vo.tradeProcess eq 'NotComplete' }">
									<td style="text-align:center; color:red;">${vo.tradeProcess }</td>
								</c:if>
								<c:if test="${vo.tradeProcess eq 'Complete' }">
									<td style="text-align:center; color:green;">${vo.tradeProcess }</td>
								</c:if>
							</tr>
						</c:forEach>
					</c:if>
					<c:if test="${memberAuth ne 'ADMIN'}">
						<c:forEach var="vo" items="${list1 }">
							<c:if test="${vo.buyMemberId eq memberId }">
							<tr>
								<c:if test="${memberAuth ne 'USER'}">
									<td align="center">${vo.buyMemberId }</td>
								</c:if>
								<td align="center">${vo.buyDate }</td>
								<td align="center">${vo.productName }</td>
								<td align="center">${vo.price }</td>
								<td align="center">${vo.memberId }</td>
								<td align="center">${vo.memberPhoneNumber }</td>
								<td align="center">${vo.memberSiAddress }&nbsp;&nbsp;${vo.memberGuAddress }</td>
								<td align="center">${vo.boardDate }</td>
								<c:if test="${vo.tradeProcess eq 'NotComplete' }">
									<td style="text-align:center; color:red;">${vo.tradeProcess }</td>
								</c:if>
								<c:if test="${vo.tradeProcess eq 'Complete' }">
									<td style="text-align:center; color:green;">${vo.tradeProcess }</td>
								</c:if>
							</tr>
							</c:if>
						</c:forEach>
					</c:if>
					</c:when>
				</c:choose>
						</thead>
						<tbody id="show">
						</tbody>
					</table>
				</div>
			</div>
		</div>
		
		<c:if test="${memberAuth ne 'ADMIN' }">
		<div class="card shadow mb-4">
			<div class="card-header py-3">
				<h6 class="m-0 font-weight-bold text-primary">판매 내역</h6>
			</div>
			<div class="card-body">
				<div class="table-responsive">
					<table class="table table-bordered" id="dataTable" width="100%"
						cellspacing="0">
						<thead>
							<tr>
								<th>구매자</th>
								<th>구매날짜</th>
								<th>품명</th>
								<th>판매가격</th>
								<th colspan="2">진행상태</th>
							</tr>
							<c:choose>
					<c:when test="${empty list3 }">
						<tr>
							<td colspan="9">판매한 제품이 없습니다.</td>
						</tr>
					</c:when>
					<c:when test="${not empty list3 }">
					<c:if test="${memberAuth ne 'ADMIN'}">
						<c:forEach var="vo" items="${list3 }">
							<c:if test="${vo.memberId eq memberId }">
							<tr>
								<td align="center" width="10%">${vo.buyMemberId }</td>
								<td align="center" width="15%">${vo.buyDate }</td>
								<td align="center">${vo.productName }</td>
								<td align="center">${vo.price }</td>
								<c:if test="${vo.tradeProcess eq 'NotComplete'}">
								<td align="center" style="width=20%; color:red">${vo.tradeProcess }</td>
								<td align="center" width="10%">
									<button style="background-color: green; color:white; font-size:15px;" onclick="location.href='updateTradeProcess.do?tradeProcess=Complete&buyDate=${vo.buyDate }'">
									판매완료</button>
								</td>
								</c:if>
								<c:if test="${vo.tradeProcess eq 'Complete'}">
								<td align="center" style="width=20%; color:green;">${vo.tradeProcess }</td>
								<td align="center" width="10%">
									판매완료
								</td>
								</c:if>
							</tr>
							</c:if>
						</c:forEach>
					</c:if>
					</c:when>
				</c:choose>
						</thead>
						<tbody id="show">
						</tbody>
					</table>
				</div>
			</div>
		</div>
		</c:if>
		
		<!-- DataTales Example -->
		<div class="card shadow mb-4">
			<div class="card-header py-3">
				<h6 class="m-0 font-weight-bold text-primary">작성한 글</h6>
			</div>
			<div class="card-body">
				<div class="table-responsive">
					<table class="table table-bordered" id="dataTable" width="100%"
						cellspacing="0">
						<thead>
							<tr>
								<th>조회수</th>
								<th>제목</th>
								<th>품명</th>
								<th>판매가격</th>
								<th>판매지역</th>
								<th>작성자</th>
								<th>작성날짜</th>
								<th>진행상태</th>
							</tr>
							<c:choose>
					<c:when test="${empty list }">
						<tr>
							<td colspan="9">등록된 글이 없습니다.</td>
						</tr>
					</c:when>
					<c:when test="${not empty list }">
						<c:if test="${memberAuth eq 'ADMIN'}">
						<c:forEach var="vo1" items="${list }">
							<tr onclick="location.href='boardView.do?boardDate=${vo1.boardDate }'">
								<td align="center">${vo1.boardView }</td>
								<td align="center">${vo1.boardTitle }</td>
								<td align="center">${vo1.productName }</td>
								<td align="center">${vo1.price }</td>
								<td align="center">${vo1.memberSiAddress }&nbsp;&nbsp;${vo1.memberGuAddress }</td>
								<td align="center">${vo1.memberId }</td>
								<td align="center">${vo1.boardDate }</td>
								<c:if test="${vo1.tradeProcess eq 'NotComplete'}">
								<td align="center" style="width=20%; color:red">${vo1.tradeProcess }</td>
								</c:if>
								<c:if test="${vo1.tradeProcess eq 'Complete'}">
								<td align="center" style="width=20%; color:green;">${vo1.tradeProcess }</td>
								</c:if>
							</tr>
						</c:forEach>
						</c:if>
						<c:if test="${memberAuth ne 'ADMIN'}">
						<c:forEach var="vo1" items="${list }">
						<c:if test="${memberId eq vo1.memberId }">
							<tr onclick="location.href='boardView.do?boardDate=${vo1.boardDate }'">
								<td align="center">${vo1.boardView }</td>
								<td align="center">${vo1.boardTitle }</td>
								<td align="center">${vo1.productName }</td>
								<td align="center">${vo1.price }</td>
								<td align="center">${vo1.memberSiAddress }&nbsp;&nbsp;${vo1.memberGuAddress }</td>
								<td align="center">${vo1.memberId }</td>
								<td align="center">${vo1.boardDate }</td>
								<c:if test="${vo1.tradeProcess eq 'NotComplete'}">
								<td align="center" style="width=20%; color:red">${vo1.tradeProcess }</td>
								</c:if>
								<c:if test="${vo1.tradeProcess eq 'Complete'}">
								<td align="center" style="width=20%; color:green;">${vo1.tradeProcess }</td>
								</c:if>
							</tr>
						</c:if>
						</c:forEach>
					</c:if>
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
				<h6 class="m-0 font-weight-bold text-primary">댓글 내역</h6>
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
					<c:when test="${empty list2 }">
						<tr>
							<td colspan="9">등록된 댓글이 없습니다.</td>
						</tr>
					</c:when>
					<c:when test="${not empty list2 }">
						<c:if test="${memberAuth eq 'ADMIN'}">
						<c:forEach var="vo2" items="${list2 }">
							<tr onclick="location.href='boardView.do?boardDate=${vo2.boardDate }'">
								<td align="center">${vo2.memberId }</td>
								<td align="center">${vo2.commentContent }</td>
								<td align="center">${vo2.commentDate }</td>
							</tr>
						</c:forEach>
						</c:if>
						<c:if test="${memberAuth ne 'ADMIN'}">
						<c:forEach var="vo2" items="${list2 }">
							<c:if test="${memberId eq vo2.memberId }">
							<tr onclick="location.href='boardView.do?boardDate=${vo2.boardDate }'">
								<td align="center">${vo2.memberId }</td>
								<td align="center">${vo2.commentContent }</td>
								<td align="center">${vo2.commentDate }</td>
							</tr>
							</c:if>
						</c:forEach>
					</c:if>
					</c:when>
				</c:choose>
						</thead>
						<tbody id="show">
						</tbody>
					</table>
				</div>
			</div>
		</div>

	</div>
	<!-- /.container-fluid -->

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