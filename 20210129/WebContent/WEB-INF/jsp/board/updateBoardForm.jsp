<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="../main/menu.jsp" />

<style>
textarea {
	border: 0;
	background-color: gold;
}
</style>
<script type="text/javascript">
	function updateConfirm() {
		var YnN = confirm("정말 수정할까요?")
		if (YnN) {
			return true;
		}
		return false;
	}
</script>

<!-- Page content -->
<div class="w3-content" style="max-width:2000px;margin-top:46px">

<div align="center">
		<h1>게시글 상세보기</h1>
		<div>
			<form id="frm" name="frm" onsubmit="return updateConfirm()" action="updateBoard.do?bId=${vo.bId }" method="post">
				<table border="1">
					<tr>
						<th>작성번호</th>
						<td>${vo.bId }</td>
						<th>작성자</th>
						<td>${vo.bName }</td>
						<th>작성일자</th>
						<td>${vo.bDate }</td>
						<th>조회수</th>
						<td>${vo.bHit }</td>
					</tr>
					<tr>
						<th>제목</th>
						<td colspan="7">${vo.bTitle }</td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="7"><textarea id="bContent1"
								name="bContent1" rows="7" cols="45">${vo.bContent}</textarea></td>
					</tr>
				</table>
				<div>
					<button type="submit">수정</button>
					&nbsp;&nbsp;
					<button type="button" onclick="location.href='boardList.do'">목록가기</button>
				</div>
			</form>
		</div>
	</div>

</div>
</body>
</html>