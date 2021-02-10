<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<jsp:include page="../main/main.jsp" />

<div id="wrapper">

	<!-- Begin Page Content -->
	<div class="container-fluid">

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