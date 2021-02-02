<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<jsp:include page="../main/menu.jsp" />
<style>
	th, td{
		padding: 10px;
		text-align: center;
	}
</style>

<!-- Page content -->
<div class="w3-content" style="max-width:2000px;margin-top:46px">
	<div align="center">
		<h1>도서정보 상세보기</h1>
		<table border="1">
			<tr>
				<th>도서코드</th>
				<td>${vo.bookCode }</td>
			</tr>
			<tr>
				<th>도서명</th>
				<td>${vo.bookName }</td>
			</tr>
			<tr>
				<th>총 수량</th>
				<td>${vo.quantity}</td>
			</tr>
			<tr>
				<th>재고수량</th>
				<td>${vo.bCount }</td>
			</tr>
		</table>
		<br />
		<div>
			<button type="button" onclick="location.href='bookList.do'">목록가기</button>
			&nbsp;&nbsp;
			<button type="button" onclick="location.href='updatebookForm.do?bookCode1=${vo.bookCode }'">정보수정</button>
			&nbsp;&nbsp;
			<button type="button" onclick="location.href='deletebook.do?bookCode2=${vo.bookCode }'">도서삭제</button>
		</div>
		<br />
	</div>




</div>
</body>
</html>