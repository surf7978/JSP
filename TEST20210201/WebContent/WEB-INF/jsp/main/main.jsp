<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
	tr:hover{
		background-color: yellow;
	}
	td:hover{
		background-color: gold;
	}
	td{
		padding:10px;
	}
</style>

<jsp:include page="menu.jsp" />

<!-- Page content -->
<div class="w3-content" style="max-width:2000px;margin-top:46px">

		<div align="center">
		<div>
			<h1>미반납 도서 목록</h1>
		</div>
		<div>
			<table border="1">
				<tr>
					<th>대여일자</th>
					<th>도서코드</th>
					<th>회원아이디</th>
					<th>반납일자</th>
				</tr>
				<c:choose>
					<c:when test="${empty list1 }">
						<tr>
							<td colspan="9">미반납 된 도서가 없습니다.</td>
						</tr>
					</c:when>
					<c:when test="${not empty list1 }">
						<c:forEach var="vo1" items="${list1 }">
							<tr>
								<td align="center">${vo1.rentalDate }</td>
								<td align="center">${vo1.bookCode }</td>
								<td align="center">${vo1.memberId }</td>
								<td align="center">${vo1.returnDate }</td>
							</tr>
						</c:forEach>
					</c:when>
				</c:choose>
			</table>
		</div><br />

		<div>
			<input type="hidden" value="${memberId }">
		</div>
		</div>

</div>
</body>
</html>