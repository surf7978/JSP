
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="../main/main.jsp" />

<style>
h2{
	font-size: 30px;
	text-align: center
}

.button1{
	background-color: #4dff88;
		 border: none;
		  color: black;
		  padding: 16px 32px;
		  text-align: center;
		  font-size: 16px;
		  margin: 4px 2px;
		  opacity: 0.6;
		  transition: 0.3s;
		  display: inline-block;
		  text-decoration: none;
		  cursor: pointer;
		  border-radius: 12px;
}
.button2{
	background-color: #a64dff;
		border: none;
		  color: black;
		  padding: 16px 32px;
		  text-align: center;
		  font-size: 16px;
		  margin: 4px 2px;
		  opacity: 0.6;
		  transition: 0.3s;
		  display: inline-block;
		  text-decoration: none;
		  cursor: pointer;
		  border-radius: 12px;
}						

</style>

<script>
	function emptyCheck(){
		if(nTitle.value == ""){
			alert("제목을 입력하세요.");
			nTitle.focus();
			return false;
		}else if(nContent.value == ""){
			alert("내용을 입력하세요.");
			nContent.focus();
			return false;
		}else{
			nTitle.submit();
			memberId.submit();
			nContent.submit();
			return true;
		}
		
	}


</script>

<div class="container">
	
	<div align="center">
	<h2 >쪽지보내기</h2>
	<form id="frm" name="frm" onsubmit="return emptyCheck()" action="sendNote.do?tId=${vo.tId}" method="post">
																			
		<br/><br/>
		<h7>제목</h7> <br>
		<br/>
		<input type="text"  id="nTitle"	 name="nTitle" class="form-control form-control-user"
		placeholder="제목을 입력하세요!" style="width: 300px; height: 20px; font-size: 15px;">
		<br/>
		<h7>받는사람</h7> <br>	<!--   -->
		<br/>
		<input type="text" value="${vo.memberId}" class="form-control form-control-user" id="memberId" 	name="memberId"
		 style="width: 300px; height: 20px; font-size: 15px;" readonly>
		<br/>
		<h7>내용</h7> <br>
		<br/>
		<input type="text" 	id="nContent" name="nContent" class="form-control form-control-user"
		placeholder="메세지를 입력하세요!" style="width: 300px; height: 200px; font-size: 15px; word-break:break-all;">
			
	
		
		<br/><br/><br/>
		
		<div align="center">
			<button type="submit" class="button1" >보내기</button> &nbsp;&nbsp;&nbsp;
			<button type="button" class="button2" onclick="location.href='noteList.do'" >받은 쪽지 내역</button>
		</div>
	</form>

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
<!-- End of Footer -->





<!-- End of Content Wrapper -->


<!-- End of Page Wrapper -->

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

</body>

</html>