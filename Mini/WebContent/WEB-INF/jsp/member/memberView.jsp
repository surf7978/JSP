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
<
	<div align="center"><div>
<h1 style="font-weight: bolder;font-size: 50; padding: 10px;">회원관리</h1></div>
		<table>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>전화번호</th>
				<th>주소</th>
				<th>권한</th>
				<th>수정</th>
				<th>삭제</th>


			</tr>
			<c:forEach var="vo" items="${list }">

				<tr class="row">


					<td align="center">${vo.memberId}</td>
					<td>${vo.memberName}</td>
					<td>${vo.memberTel}</td>
					<td>${vo.memberAddress}</td>
					<td>${vo.memberAuth}</td>
					<td>
					<form name="frm" action="memberUpdateView.do" method="post">
							<input type="hidden" name="memberId" value="${vo.memberId}">
						<button type="submit">수정</button>
						</form>

					</td>
					<td><c:if test="${vo.memberAuth eq 'user'}">
						<form name="${vo.memberId}" action="memberDelete.do" method="post">
							<input type="hidden" name="memberId" value="${vo.memberId}">
							<button type="button" onclick="Mdelete('${vo.memberId}')">삭제</button>
						</form>
						</c:if>
						<c:if test="${vo.memberAuth eq 'admin'}">
							<button type="button" onclick="cantDel()">삭제</button>
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


</div>
</body>
<script>


function Mdelete(id){
	let really = confirm("정말 삭제하시겠습니까?");
	console.log(id);
	if(really){
		document.querySelector("[name="+id+"]").submit();
	}
	else{
		alert("취소하였습니다.");
	}
	
}

function cantDel(){
	
	alert("관리자는 삭제할 수 없습니다");
}
</script>
</html>