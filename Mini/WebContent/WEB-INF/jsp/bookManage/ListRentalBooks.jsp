<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>​


<style>
	.button{
		color:white;
  		text-align: center;
  		font-size: 12px;
        margin: 0px;
        box-sizing: border-box;
        background-color: darkgrey;
	}
	.table{
		color:black;
		border: 1px solid #444444;
		border-collapse: collapse;
	}
	th{
		background-color: darkgrey;
	}
	td{
		text-align:center;
	}

</style>
<jsp:include page="../main/menu.jsp" />

<div class="w3-content" style="max-width: 2000px; margin-top: 296px;">
<script>
function myfunction(){
	var viewPage=null;
	var checkBox = document.getElementById("myCheck");
	 if (checkBox.checked == true) viewPage="update.do";
}

</script>

<div align="center">
	<div><h1>대여 목록</h1></div>
		<table border="1" class="table">
			<tr >
				<th width="150">대여 일자</th>
				<th width="150">도서 코드</th>
				<th width="150">회원 아이디</th>
				<th width="150">반납 코드</th>
				<th width="150">도서 이름</th>
				<th width="150">반납 입자</th>

			</tr>
			<c:forEach var="vo" items="${list }">
			<tr>
				<td width="150">${vo.rentalDate}</td>
				<td width="150">${vo.bookCode }</td>
				<td width="150">${vo.memberId }</td>
				
				<td width="150">${vo.rentalCode }</td>
				<td width="150">${vo.bookName }</td>
				<td width="150"><c:if test="${vo.returnDate ne null}"> ${vo.returnDate }</c:if></td>

			</tr>	
			</c:forEach>
		</table><br/>
		<button type="button" id="add" name="add" onclick="location.href='listadmin.do'">도서 목록으로 돌아가기</button>&nbsp;&nbsp;
		
</div>
</div>

