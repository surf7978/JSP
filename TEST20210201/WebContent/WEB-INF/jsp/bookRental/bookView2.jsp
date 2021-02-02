<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
			<tr>
				<th>반납일자</th>
				<td>${vo.returnDate }</td>
			</tr>
		</table>
		<br />
		<div>
			<button type="button" onclick="location.href='bookRentalList.do'">목록가기</button>
			<c:if test="${vo.returnDate eq null }">
				&nbsp;&nbsp;
				<button type="button" onclick="location.href='returnBook.do?bookCode3=${vo.bookCode }&memberId3=${memberId }&rentalDate3=${vo.rentalDate }'">도서반납</button>
			</c:if>
			<c:if test="${memberId eq 'admin' }">
				&nbsp;&nbsp;
				<button type="button" onclick="location.href='returnBookListDelete.do?bookCode3=${vo.bookCode }&memberId3=${memberId }&rentalDate3=${vo.rentalDate }'">삭제</button>
			</c:if>
		</div>
	</div>

	<div align="center">
		<input type="hidden" value="${memberId}">
	</div>


</div>
</body>
</html>