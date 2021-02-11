<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../main/main.jsp" />

<script>
	function noticeDelete(){
		var yn= confirm("정말 삭제할까요?");
		if(yn){
			frm.action = "noticedelete.do";
			frm.submit();
		}else{
			return false;
		}
	}
	function update(){
		frm.action="noticeUpdateForm.do";		
		frm.submit();
	}
</script>
<div id="wrapper">

	<!-- Begin Page Content -->
	<div class="container-fluid">

		<!-- Page Heading -->
		
		<!-- DataTales Example -->
		<div class="card shadow mb-4">
			<div class="card-header py-3">
				<h6 class="m-0 font-weight-bold text-primary">DataTables
					Example</h6>
			</div>
			<form id="frm" name="frm" method="post">
		<input type="hidden" id="nNumber" name="nNumber" value="${vo.nNumber }" />
			<div class="card-body">
				<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%"
						cellspacing="0">
					<tr>
						<th>NO </th>
						<td>${vo.nNumber }</td>
						<th>NAME </th>
						<td>${vo.nWriter }</td>
						<th>DATE </th>
						<td><input readonly style="border:0; color:gray;" name="nDate" type="text" value="${vo.nDate }"></td>
					</tr>
					<tr>
						<th>TITLE</th>
						<td colspan="5">${vo.nTitle}</td>
					</tr>
					<tr>
						<th>CONTENT</th>
						<td colspan="5"><textarea style="resize:none; border:0; color:gray;" rows="20" cols="100" style="border:none;" readonly="readonly">${vo.nContent }</textarea></td>
					</tr>
				</table>
				</div></div>
				<div align="center" id="noticebtn">
					<c:if test="${memberAuth eq 'ADMIN' }">
						<button type="button" onclick="update()" class="btn btn-primary btn-user btn-block">수정하기</button>
						<button type="button" onclick="noticeDelete()"  class="btn btn-google btn-user btn-block">삭제하기</button>
					</c:if>
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