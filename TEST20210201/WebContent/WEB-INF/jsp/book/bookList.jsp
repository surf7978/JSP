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
	th, td{
		padding:10px;
	}
</style>

<!-- Page content -->
<div class="w3-content" style="max-width:2000px;margin-top:46px">

<div align="center">
		<div>
			<h1>도서 대여 통계</h1>
		</div>
		<div>
			<table border="1">
				<tr style="background-color:beige;">
					<th align="center">조회수</th>
					<th align="center">총 대출수</th>
					<th align="center">도서코드</th>
					<th align="center">도서명</th>
					<th align="center">총 수량</th>
					<th align="center">재고수량</th>
					<th style="color:blue; text-algin:center;">좋아요</th>
					<th style="color:red; text-algin:center;">싫어요</th>
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
								<td align="center">${vo.viewCount }</td>
								<td align="center">${vo.rentalCount }</td>
								<td align="center">${vo.bookCode }</td>
								<td align="center">${vo.bookName }</td>
								<td align="center">${vo.quantity }</td>
								<td align="center">${vo.bCount }</td>
								<td align="center">${vo.likeIt }</td>
								<td align="center">${vo.hateIt }</td>
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