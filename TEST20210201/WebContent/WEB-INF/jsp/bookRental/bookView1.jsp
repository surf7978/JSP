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

<script type="text/javascript">
	function canNotRental(){
		alert("남은 재고가 없어서 대여할 수 없습니다.");
	}
</script>

<!-- Page content -->
<div class="w3-content" style="max-width:2000px;margin-top:46px">
	<div align="center">
		<h1>도서정보 상세보기</h1>
		<form id="frm" name="frm" onsubmit="return bCountCheck()" action="" method="post">
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
			<c:if test="${vo.bCount ne '0' }">
				<button type="button" onclick="location.href='rentalBook.do?bookCode2=${vo.bookCode }&memberId2=${memberId }'">도서대여</button>
			</c:if>
			<c:if test="${vo.bCount eq '0' }">
				<button type="button" onclick="canNotRental()" style="backgrount-color:red; font-color:yellow;">대여불가</button>
			</c:if>
		</div>
		</form>
	</div>




</div>
</body>
</html>