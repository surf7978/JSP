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
		<div>
			<h1>로 그 인</h1>
		</div>
		<div>
			<form id="frm" name="frm" action="LoginResult.jsp" method="post">
				<div>
					<table border="1">
						<tr>
							<th width="150">아 이 디</th>
							<td><input type="text" id="id" name="id" size="20"
								value="hong"></td>
						</tr>
						<tr>
							<th width="150">패스워드</th>
							<td><input type="password" id="pw" name="pw" size="20"
								value="1234"></td>
						</tr>
					</table>
				</div>
				<br /> <input type="submit" value="로그인"> &nbsp;&nbsp;&nbsp;
				<input type="reset" value="취 소">
			</form>
		</div>
		<div align="center">
			<a href="../../index.jsp">홈가기</a>
		</div>
	</div>
</body>
</html>