<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기</title>
<style>
	textarea{
		border:0;
		resize:none;
	}
</style>
<!-- resize="none" = textarea 크기고정 -->
<script type="text/javascript">
	function deleteConfirm(str){
		var YnN = confirm("정말 삭제할까요?")
		if(YnN){
			frm.bId.value = str;
			frm.submit();
			//location.href="deleteBoard.do?bId="+${vo.bId }; 
			//이게 더 편함 form 안 만들고 그 안에 id값 안 주고 파라미터값 줄 수 있음
		}
	}
</script>
</head>
<jsp:include page="../main/main.jsp" />
<body>
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
				<td colspan="7">&nbsp;${vo.bTitle }</td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="7"><textarea type="text" id="bContent" name="bContent"
					rows="7"cols="45" readonly>${vo.bContent}</textarea></td>
			</tr>
		</table>
		<div>
			<button type="button" onclick="location.href='boardList.do'">목록가기</button>
			&nbsp;&nbsp;
			<button type="button" onclick="location.href='updateBoardForm.do?bId1=${vo.bId }'">수정</button>
			&nbsp;&nbsp;
			<button type="button" onclick="deleteConfirm(${vo.bId })">삭제</button>
		</div>
	</div>
</body>
</html>