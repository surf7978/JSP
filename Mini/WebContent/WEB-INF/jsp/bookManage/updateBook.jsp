<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
​

<script LANGUAGE="JavaScript">
function savefunc(){
	var f = document.frm;
	var bookName = document.frm.bookName.value;
	var quantity = document.frm.quantity.value;
	var bCount = document.frm.bCount.value;
	
	if(bookName == "" || quantity == "" || bCount == ""){
	      alert("입력해주세요.");
	  }else{
		  f.submit();
	  }
}
	
    
</script>

<style>
.button {
	color: white;
	text-align: center;
	font-size: 12px;
	margin: 0px;
	box-sizing: border-box;
	background-color: darkgrey;
}

.table {
	color: black;
	border: 1px solid #444444;
	border-collapse: collapse;
}

th {
	background-color: darkgrey;
}

td {
	text-align: center;
}
</style>

<jsp:include page="../main/menu.jsp" />

<div class="w3-content" style="max-width: 2000px; margin-top: 296px;">

	<div align="center">
		<div>
			<h1>도서 수정하기</h1>
		</div>
		<form id="frm" name="frm" action="updateexec.do" method="post">
			<table border="1" class="table">
				<tr>
					<th width="150">도서 코드</th>
					<th width="150">도서 이름</th>
					<th width="150">도서 총수량</th>
					<th width="150">도서 현재수량</th>

				</tr>
				<tr>
					<td width="150"><input type="text" id="bookCode"
						name="bookCode" class="input" value="${vo.bookCode}" readonly></td>
					<td width="150"><input type="text" id="bookName"
						name="bookName" class="input" value="${vo.bookName}"></td>
					<td width="150"><input type="text" id="quantity"
						name="quantity" class="input" value="${vo.quantity}"></td>
					<td width="150"><input type="text" id="bCount" name="bCount"
						class="input" value="${vo.bCount}"></td>
				</tr>

			</table>
			<br />
			<div>
				<input type="button" id="save" name="save" onclick="savefunc()"
					value="저장"> &nbsp;&nbsp;&nbsp; <input type="reset"
					value="취소" onclick="location.href='listadmin.do'">
				&nbsp;&nbsp;&nbsp; <input type="button" value="도서 목록으로 돌아가기"
					onclick="location.href='listadmin.do'">
			</div>
		</form>
	</div>
</div>

