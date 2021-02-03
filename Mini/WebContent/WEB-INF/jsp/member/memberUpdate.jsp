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
		<form id="frm" name="frm" action="memberUpdate.do" method="post">
			<table>
				<tr>
					<th>아이디</th>
					<th>이름</th>
					<th>전화번호</th>
					<th>주소</th>
					<th>권한</th>

				</tr>
				<c:forEach var="vo" items="${list }">
					<tr>


						<td align="center"><input type="text" name="memberId"
							value="${vo.memberId}" readonly></td>
						<td><input type="text" name="memberName"
							value="${vo.memberName}"></td>
						<td><input type="text" name="memberTel"
							value="${vo.memberTel}"></td>
						<td><input type="text" name="memberAddress"
							value="${vo.memberAddress}"></td>
						<td><select name="memberAuth">
							<option value="admin" <c:if test="${vo.memberAuth eq 'admin'}">selected</c:if>>admin</option>
							<option value="user" <c:if test="${vo.memberAuth eq 'user'}">selected</c:if>>user</option></select></td>
						<td>
							<button type="submit">수정</button>
						</td>

					</tr>
				</c:forEach>
			</table>
		</form>
	</div>
	<div align="center"></div>

</div>
</body>
</html>