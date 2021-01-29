<!-- 스크립트 작업영역 -->
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
<!-- 글 상세보기 post 전달 -->
<script type="text/javascript">
	function formSubmit(str){
		frm.bId.value=str;
		frm.submit();
	}
</script>


<!-- Page content -->
<div class="w3-content" style="max-width:2000px;margin-top:46px">

<div align="center">
		<div>
			<h1>게시글 목록</h1>
		</div>
		<div>
			<form id="frm" name="frm" action="boardView.do" method="post">
				<input type="hidden" id="bId" name="bId"><!-- 히든타입으로 함 -->
			</form>
		</div>
		<div>
			<table border="1">
				<tr style="background-color:white;">
					<th>No</th>
					<th>작성자</th>
					<th>제목</th>
					<!-- <th width="300">내용</th> -->
					<th>작성일</th>
					<th>조회수</th>
				</tr>
				<c:choose>
					<c:when test="${empty list }">
						<tr>
							<td colspan="9">게시글이 없습니다.</td>
						</tr>
					</c:when>
					<c:when test="${not empty list }">
						<c:forEach var="vo" items="${list }">
							<tr id="tr${vo.bId }" class="row" onclick="formSubmit(${vo.bId })">
								<td align="center" id="td${vo.bId }">${vo.bId }</td>
								<td align="center">${vo.bName }</td>
								<td align="center">${vo.bTitle }</td>
								<!-- <td align>&nbsp;${vo.bContent }</td> -->
								<td align="center">${vo.bDate }</td>
								<td align="center">${vo.bHit }</td>
							</tr>
						</c:forEach>
					</c:when>
				</c:choose>
			</table>
		</div><br />
		<div>
			<button type="button" onclick="location.href='insertBoardForm.do'">글쓰기</button>
		</div>
	</div>

</div>
</body>
</html>