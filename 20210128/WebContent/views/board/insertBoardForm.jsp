<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기 화면</title>
<script>
	function emptyCheck(){
		if(frm.bName.value == ""){
			alert("작성자를 입력하세요.");
			return false;
		}else if(frm.bTitle.value == ""){
			alert("제목을 입력하세요.");
			return false;
		}else if(frm.bContent.value == ""){
			alert("내용을 입력하세요.");
			return false;
		}
		return true;
	}
</script>
</head>
<jsp:include page="../main/main.jsp" />
<body>
	<div align="center">
		<div>
			<h1>게시글 목록</h1>
		</div>
		<form id="frm" name="frm" onsubmit="return emptyCheck()" action="insertBoard.do" method="post">
		<div>
			<table border="1">
				<tr>
					<th>작성자</th>
					<td><input type="text" id="bName" name="bName"></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" id="bTitle" name="bTitle"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><input type="text" id="bContent" name="bContent"></td>
				</tr>
			</table>
		</div><br />
		<div>
			<button type="submit">저장</button>
			&nbsp;&nbsp;
			<button type="reset">취소</button>
			&nbsp;&nbsp;
			<button type="button" onclick="location.href='boardList.do'">뒤로가기</button>
		</div>
		</form>
	</div>
</body>
</html>