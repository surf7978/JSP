<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
​
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

<div align="center">
	<div><h1>도서 목록</h1></div>
		<table border="1" class="table">
			<tr >
				<th width="150">도서 코드</th>
				<th width="150">도서 이름</th>
				<th width="150">도서 총수량</th>
				<th width="150">도서 현재수량</th>
				<th width="80">도서 수정</th>
				<th width="80">도서 삭제</th>
				
			</tr>
			<c:forEach var="vo" items="${list }">
			<tr>
				<td width="150">${vo.bookCode}</td>
				<td width="150">${vo.bookName }</td>
				<td width="150">${vo.quantity }</td>
				<td width="150">${vo.bCount }</td>
				<td width="80"><button type="button" id="update" name="update" onclick="location.href='selectRow.do?row='+${vo.bookCode}">수정</button> </td>
				<td width="80"><button type="button" id="delete" name="delete" onclick="location.href='selectRowdelete.do?row='+${vo.bookCode}">삭제</button> </td>
			</tr>	
			</c:forEach>
			
		</table><br/>
		<div>
			<button type="button" id="rentalbook" name="rentalbook" onclick="location.href='managebook.do'">대여 도서 목록</button>&nbsp;&nbsp;
			<button type="button" id="add" name="add" onclick="location.href='insertbAdmin.do'">도서 등록</button>
			
		</div>
		<br>
		<div align="center"><button type="button" onclick="location.href='index.jsp'">홈으로</button></div>
		
</div>

</div>
</body>
</html>