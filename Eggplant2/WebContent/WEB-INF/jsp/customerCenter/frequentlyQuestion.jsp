<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="../main/main.jsp" />

<div id="wrapper">

	<!-- Begin Page Content -->
	<div class="container-fluid">

		<!-- Page Heading -->
		<h1 class="h3 mb-2 text-gray-800">Frequently Question</h1>
		<p class="mb-4">
			자주 묻는 질문
		</p>

		<!-- DataTales Example -->
		<div class="card shadow mb-4">
			<div class="card-header py-3">
				<h6 class="m-0 font-weight-bold text-primary">원하는 질문 선택</h6>
			</div>
			<div class="card-body">
				<div class="table-responsive">
					<table class="table table-bordered" id="dataTable" width="100%"
						cellspacing="0">
						<thead>
							<tr>
								<th>
								<div class="nav-item">
                					<a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages" aria-expanded="true" aria-controls="collapsePages">
				                		<span style="color:black;">Q1. 비밀번호를 잊어버렸어요.</span>
            						</a>
            						<div id="collapsePages" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
                						<div class="bg-white py-2 collapse-inner rounded">
                    						<a class="collapse-item" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;A1. 나가 뒤지세요.^^</a>
                						</div>
            						</div>
        						</div>
        						</th>
        					</tr>
        					<tr>
        						<th>
								<div class="nav-item">
                					<a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages" aria-expanded="true" aria-controls="collapsePages">
				                		<span style="color:black;">Q2. 판매자에게 사기를 당했어요.</span>
            						</a>
            						<div id="collapsePages" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
                						<div class="bg-white py-2 collapse-inner rounded">
                    						<a class="collapse-item" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;A2. 저런... 어쩌면 그걸 당한 사람도 잘못이 있지 않을까요?</a>
                						</div>
            						</div>
        						</div>
        						</th>
        					</tr>
        					<tr>
        						<th>
								<div class="nav-item">
                					<a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages" aria-expanded="true" aria-controls="collapsePages">
				                		<span style="color:black;">Q3. 회원탈퇴 하고 저장된 개인정보를 폐기하고 싶어요.</span>
            						</a>
            						<div id="collapsePages" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
                						<div class="bg-white py-2 collapse-inner rounded">
                    						<a class="collapse-item" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;A3. 꺼~~~억 ! ^^</a>
                						</div>
            						</div>
        						</div>
        						</th>
							</tr>
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
    <script type="text/javascript">
	$(function(){
		$.ajax({		
			type:'post',
			url:'<%=request.getContextPath()%>/memberList',
			dataType : "json",
			success : function(result) {
				console.log(result);
				console.log('ajax GET 통신 성공');
				for (let i = 0; i < result.length; i++) {
	                let tr = document.createElement('tr');
	                console.log(result[i]);
	                tr.setAttribute("id", result[i].mId);
	                tr.setAttribute("name", result[i].mId);
	                tr.setAttribute("onclick", "myPage.do");
	                let tbody = document.getElementById("show").append(tr);
	                console.log(result[i]);
	                for(filed in result[i]){	    
	                	let td = document.createElement('td');
	                	td.innerHTML = result[i][filed];
                        tr.appendChild(td);	                	
	                }
                }
			}
		})
	})
</script>

</body>

</html>