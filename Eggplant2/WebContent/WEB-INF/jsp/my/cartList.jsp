<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<jsp:include page="../main/main.jsp" />

<div id="wrapper">

	<!-- Begin Page Content -->
	<div class="container-fluid">

		<!-- Page Heading -->
		<h1 class="h3 mb-2 text-gray-800">Cart</h1>
		<p class="mb-4">
			장바구니
		</p>

		<!-- DataTales Example -->
		<div class="card shadow mb-4">
			<div class="card-header py-3">
				<h6 class="m-0 font-weight-bold text-primary">DataTables
					Example</h6>
			</div>
			<div class="card-body">
				<div class="table-responsive">
					<table class="table table-bordered" id="dataTable" width="100%"
						cellspacing="0">
						<thead>
							<tr>
								<th>찜한 날짜</th>
								<th>품명</th>
								<th>판매가격</th>
								<th>판매자</th>
								<th>판매자 연락처</th>
								<th>판매지역</th>
								<th>판매날짜</th>
								<th>판매상태</th>
							</tr>
							<c:choose>
					<c:when test="${empty list }">
						<tr>
							<td colspan="9">찜한 제품이 없습니다.</td>
						</tr>
					</c:when>
					<c:when test="${not empty list }">
						<c:forEach var="vo" items="${list }">
							<c:if test="${vo.cartMemberId eq memberId }">
							<tr onclick="location.href='boardView.do?boardDate=${vo.boardDate}'">
								<td align="center">${vo.cartDate }</td>
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