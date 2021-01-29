<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
	textarea{
		border:0;
		resize:none;
	}
</style>
<jsp:include page="../main/menu.jsp" />
<script type="text/javascript">
	function deleteConfirm(str){
		var YnN = confirm("정말 삭제할까요?")
		if(YnN){
			location.href="deleteBoard.do?bId="+${vo.bId }; 
		}
	}
</script>
<!-- Page content -->
<div class="w3-content" style="max-width:2000px;margin-top:46px">
	<div align="center">
		<h1>게시글 상세보기</h1>
		<div>
			<form id="frm" name="frm" action="deleteBoard.do" method="post">
				<input type="hidden" id="bId" name="bId"><!-- 히든타입으로 함 -->
			</form>
		</div>
		<table border="1">
			<tr>
				<th>작성번호</th>
				<td style="text-align:center;">${vo.bId }</td>
				<th>작성자</th>
				<td style="text-align:center;">${vo.bName }</td>
				<th>작성일자</th>
				<td style="text-align:center;">${vo.bDate }</td>
				<th>조회수</th>
				<td style="text-align:center;">${vo.bHit }</td>
			</tr>
			<tr>
				<th>제목</th>
				<td colspan="7">&nbsp;${vo.bTitle }</td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="7"><textarea type="text" id="bContent" name="bContent"
					rows="7"cols="45" readonly>${vo.bContent}</textarea></td>
			</tr>
		</table>
		<div>
		<c:if test="${not empty list }">
			<c:forEach var="rvo" items="${list }">
				<table border="1">
					<tr>
					</tr>
					<tr>
						<td style="text-align:center; width:30;">${rvo.rnum }</td>
						<td width="319">&nbsp;${rvo.subject }</td>
						<td style="text-align:center; width:100;">${rvo.rdate }</td>
					</tr>
				</table>
			</c:forEach>
		</c:if>
		</div><br />
		<div>
			<button type="button" onclick="location.href='boardList.do'">목록가기</button>
			&nbsp;&nbsp;
			<button type="button" onclick="location.href='updateBoardForm.do?bId1=${vo.bId }'">수정</button>
			&nbsp;&nbsp;
			<button type="button" onclick="deleteConfirm()">삭제</button>
		</div>
	</div>

</div>
</body>
</html>