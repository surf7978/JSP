<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:include page="../main/main.jsp" />
<body>
	<div align="center">
		<div>
			<h1>글 쓰 기</h1>
		</div>
		<form id="frm" name="frm" action="insertBoard.do">
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
			</div>
			<br />
			<div>
				<button type="submit">저장</button>
				<button type="reset" onclick="main.do">취소</button>
			</div>
		</form>

	</div>
</body>
</html>