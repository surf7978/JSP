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
			<h1>회원 목록</h1>
		</div>
		<div>
			<table border="1">
				<tr>
					<th>아이디</th>
					<th>이름</th>
					<th>권한</th>
					<!-- <th>비밀번호</th> -->
				</tr>
				<c:choose>
					<c:when test="${empty list }">
						<tr>
							<td colspan="9">회원이 없습니다.</td>
						</tr>
					</c:when>
					<c:when test="${not empty list }">
						<c:forEach var="vo" items="${list }">
							<tr id="${vo.mId }" onclick="location.href='memberView.do?mId=${vo.mId }'">
								<td align="center">${vo.mId }</td>
								<td align="center">${vo.mName }</td>
								<td align="center">${vo.mAuth }</td>
								<!-- <td align="center">${vo.mPassword }</td> -->
							</tr>
						</c:forEach>
					</c:when>
				</c:choose>
			</table>
		</div><br />
		<div>
			<button type="button" onclick="location.href='insertMemberForm.do'">회원등록</button>
		</div>
	</div>


</div>
</body>
</html>