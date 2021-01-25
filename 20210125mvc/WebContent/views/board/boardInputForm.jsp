<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
	<jsp:include page="../common/menu.jsp" />
		<div>
			<h1>게시글 작성</h1>
		</div>
		<div>
			<form id="frm" name="frm" action="/20210125mvc/BoardInput.do" method="post">
				<table border="1">
					<tr>
						<th width="70">글번호</th>
						<td align="center" width="50"><input type="text" id="boardNo"
							name="boardNo"></td>
						<th width="70">작성자</th>
						<td align="center" width="150"><input type="text" id="writer"
							name="writer"></td>
						<th width="80">작성일자</th>
						<td align="center" width="150"><input type="date"
							id="creationDate" name="creationDate"></td>
					</tr>
					<tr>
						<th>제목</th>
						<td colspan="5"><input type="text" id="title" name="title"
							size="92"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="5"><textarea id="content" name="content" rows="7" cols="94"></textarea></td>
					</tr>
				</table>
				<div>
					<button type="submit">저장하기</button>
					&nbsp;&nbsp;
					<button type="reset">취소</button>
				</div>
			</form>
		</div>
		<br />

	</div>
</body>
</html>