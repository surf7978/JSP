<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script>
<c:if test="${lo ne null}">
alert("${msg}");
location.href = "main.do";
</c:if>
<c:if test="${lo eq null}">
console.log("lo not null");
</c:if>

</script>

<jsp:include page="../main/menu.jsp" />

<div class="w3-content" style="max-width: 2000px; margin-top: 296px;">

	<div align="center">
		<table>
			<tr>
				<th>대출코드</th>
				<th>도서코드</th>
				<th>도서명</th>
				<th class="date">대여일</th>
				<th class="date">반납일</th>
				<th>반납</th>

			</tr>
			<c:forEach var="vo" items="${RentalList }">
				<tr class="row">


					<td align="center">${vo.rentalCode}</td>
					<td>${vo.bookCode}</td>
					<td class="bname">${vo.bookName}</td>
					<td>${vo.rentalDate}</td>
					<td>${vo.returnDate}</td>
					<td>
					<c:if test="${vo.returnDate eq null}">
						<form id="frm" name="frm" action="return.do"
								method="post">
								<input type="hidden" name="rentalCode" value="${vo.rentalCode}">
								<button type="submit">반납</button>
							</form>
					</c:if>
					<c:if test="${vo.returnDate ne null}">
						<button type="button" disabled="disabled">반납완료</button>
					</c:if>
					</td>

				</tr>
			</c:forEach>
			<c:if test="${msg ne null }">
				<tr align="center">
					<td colspan="6">${msg }</td>
				</tr>
			</c:if>
		</table>
	</div>
	<div align="center">
		<h4 style="color: gray;">반납한 지 30일이 지난 자료는 출력되지 않습니다.</h4>
	</div>

</div>
</body>
</html>