<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../main/main.jsp" />

<div id="wrapper">

	<!-- Begin Page Content -->
	<div class="container-fluid">

		<!-- Page Heading -->
		<h1 class="h3 mb-2 text-gray-800">Member</h1>
		<p class="mb-4">
			회원관리
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
								<th>권한</th>
								<th>아이디</th>
								<th>비밀번호</th>
								<th>이름</th>
								<th>주소</th>
								<th>전화번호</th>
								<th>관리</th>
							</tr>
							<c:choose>
					<c:when test="${empty list }">
						<tr>
							<td colspan="9">가입된 회원이 없습니다.</td>
						</tr>
					</c:when>
					<c:when test="${not empty list }">
						<c:forEach var="vo" items="${list }">
							<tr>
								<td align="center" width="10%">${vo.memberAuth }</td>
								<td align="center">${vo.memberId }</td>
								<td align="center">${vo.memberPassword }</td>
								<td align="center">${vo.memberName }</td>
								<td align="center">${vo.memberSiAddress }  ${vo.memberGuAddress }</td>
								<td align="center">${vo.memberPhoneNumber }</td>
								<td align="center">
									<!-- <button style="background-color: yellow; padding:3px; font-size:15px;" onclick="location.href='updateMember.do?memberId=${vo.memberId }&memberPassword=${vo.memberPassword }&memberName=${vo.memberName }&memberSiAddress=${vo.memberSiAddress }&memberGuAddress=${vo.memberGuAddress }&memberPhoneNumber=${vo.memberPhoneNumber }'">
									수정</button>
									&nbsp;&nbsp;&nbsp;&nbsp; -->
									<button style="background-color: red; padding:3px; color:white; font-size:15px;" onclick="location.href='deleteMember.do?memberId=${vo.memberId }'">
									삭제</button>
								</td>
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