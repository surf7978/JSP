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
		<h1>대여정보 상세보기</h1>
		<table border="1">
			<tr>
				<th>대여일자</th>
				<td>${vo.rentalDate }</td>
			</tr>
			<tr>
				<th>도서코드</th>
				<td>${vo.bookCode}</td>
			</tr>
			<tr>
				<th>회원아이디</th>
				<td>${vo.memberId }</td>
			</tr>
		</table>
		<br />
		<div>
			<button type="button" onclick="location.href='bookRentalList.do'">목록가기</button>
			&nbsp;&nbsp;
			<button type="button" onclick="location.href='rentalbook.do?bookCode2=${vo.bookCode }&memberId2=${memberId }'">도서대여</button>
		</div>
	</div>




</div>
</body>
</html>