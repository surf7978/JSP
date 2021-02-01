<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../main/menu.jsp" />

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

<!-- Page content -->
<div class="w3-content" style="max-width:2000px;margin-top:46px">

<div align="center">
		<div>
			<h1>도서 목록</h1>
		</div>
		<div>
			<table border="1">
				<tr>
					<th>도서코드</th>
					<th>도서명</th>
					<th>기본수량</th>
					<th>현재수량</th>
				</tr>
				<c:choose>
					<c:when test="${empty list }">
						<tr>
							<td colspan="9">도서가 없습니다.</td>
						</tr>
					</c:when>
					<c:when test="${not empty list }">
						<c:forEach var="vo" items="${list }">
							<tr id="${vo.bookCode }" onclick="location.href='bookView.do?bookCode=${vo.bookCode }'">
								<td align="center">${vo.bookCode }</td>
								<td align="center">${vo.bookName }</td>
								<td align="center">${vo.quantity }</td>
								<td align="center">${vo.bCount }</td>
							</tr>
						</c:forEach>
					</c:when>
				</c:choose>
			</table>
		</div><br />
		<div>
			<button type="button" onclick="location.href='insertBookForm.do'">도서등록</button>
		</div>
	</div>


</div>
</body>
</html>