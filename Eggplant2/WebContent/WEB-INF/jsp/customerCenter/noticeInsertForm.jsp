<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../main/main.jsp" />
<script>
function insert(){
	var check = confirm("등록하시겠습니까?");
	if(check){
		frm.action="noticeInsert.do";
		frm.submit();
	}else{
		return false;
	}
}
</script>
<div id="wrapper">

	<!-- Begin Page Content -->
	<div class="container-fluid">

		<!-- Page Heading -->
		<c:if test="${memberAuth eq 'ADMIN' }">
			<h1 class="h3 mb-2 text-gray-800">Notice</h1>
		<p class="mb-4">
			공지사항
		</p>
		</c:if>
		<c:if test="${memberAuth eq 'USER' }">
			<h1 class="h3 mb-2 text-gray-800">Note</h1>
		<p class="mb-4">
			쪽지
		</p>
		</c:if>
		
		<!-- DataTales Example -->
		<div class="card shadow mb-4">
			<div class="card-header py-3">
				<h6 class="m-0 font-weight-bold text-primary"></h6>
			</div>
			<form id="frm" name="frm" method="post">
			<div class="card-body">
				<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%"
						cellspacing="0">
					<tr>
						<th>TITLE </th>
						<td><input type="text" id="nTitle" name="nTitle" style="border:1;width:100%;"/></td>
					</tr>
					<tr>
						<th>CONTENT</th>
						<td colspan="5"><textarea rows="20"style="width: 100%; max-width: 100%;" name="nContent" id="nContent"></textarea></td>
					</tr>
				</table>
				</div></div>
				<div align="center" id="noticebtn">
					<c:if test="${memberAuth eq 'ADMIN' }">
						<button type="button" onclick="insert()" class="btn btn-primary btn-user btn-block">등록</button>
					</c:if>
					<c:if test="${memberAuth eq 'USER' }">
						<button type="button" onclick="insert()" class="btn btn-primary btn-user btn-block">전달</button>
					</c:if>
					<button type="reset" class="btn btn-google btn-user btn-block">취소</button>
				</div>
				<div>
					<c:if test="${memberAuth eq 'ADMIN' }">
						<input type="hidden" name="memberId" value="notice">
					</c:if>
					<c:if test="${memberAuth eq 'USER' }">
						<input type="hidden" name="memberId" value="${nMemberId }">
					</c:if>
					<input type="hidden" name="nWriter" value="${memberId }">
				</div>
			</form>
		
		</div>
	</div>
</div>
<!--  -->
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