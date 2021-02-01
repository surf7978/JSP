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
				<td>${vo.bookName}</td>
			</tr>
			<tr>
				<th>기본수량</th>
				<td>${vo.quatity }</td>
			</tr>
			<tr>
				<th>현재수량</th>
				<td>${vo.bCount }</td>
			</tr>
		</table>
		<br />
		<div>
			<button type="button" onclick="location.href='bookRentalList.do'">목록가기</button>
			&nbsp;&nbsp;
			<button type="button" onclick="location.href='rentalBook.do?bookCode2=${vo.bookCode }&memberId2=${memberId }'">도서대여</button>
		</div>
	</div>




</div>
</body>
</html>