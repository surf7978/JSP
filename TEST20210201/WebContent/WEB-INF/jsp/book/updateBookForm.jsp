<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="../main/menu.jsp" />
<style>
	th, td{
		padding: 10px;
		text-align: center;
	}
	input{
		border:0;
		text-align: center;
		background-color: gold;
	}
</style>

<script>
	function emptyCheck(){
		if(bName.value == ""){
			alert("도서명을 입력하세요.");
			bName.focus();
			return false;
		}else if(qnT.value == ""){
			alert("기본수량을 입력하세요.");
			qnT.focus();
			return false;
		}else if(bCt.value == ""){
			alert("기본수량을 입력하세요.");
			bCt.focus();
			return false;
		}else{
			bCode.submit();
			bName.submit();
			qnT.submit();
			bCt.submit();
			return true;
		}
	}
</script>

<!-- Page content -->
<div class="w3-content" style="max-width:2000px;margin-top:46px">

	<div align="center">
		<h1>도서정보 변경</h1>
		<form id="frm" name="frm" onsubmit="return emptyCheck()" action="updateBook.do" method="post">
		<table border="1">
			<tr>
				<th>도서코드</th>
				<td><input id="bCode" name="bCode" value="${vo.bookCode }" style="background-color:white;" readonly></td>
			</tr>
			<tr>
				<th>도서명</th>
				<td><input type="text" id="bName" name="bName" value="${vo.bookName }"></td>
			</tr>
			<tr>
				<th>기본수량</th>
				<td><input type="text" id="qnT" name="qnT" value="${vo.quantity }"></td>
			</tr>
			<tr>
				<th>현재수량</th>
				<td><input type="text" id="bCt" name="bCt" value="${vo.bCount }"></td>
			</tr>
		</table>
		<br />
		<div>
			<button type="button" onclick="location.href='bookList.do'">목록가기</button>
			&nbsp;&nbsp;
			<button type="submit">변경</button>
		</div>
		</form>
	</div>



</div>
</body>
</html>