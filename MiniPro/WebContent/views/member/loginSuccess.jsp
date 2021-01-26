<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 성공</title>
</head>
<jsp:include page="../common/menu.jsp"></jsp:include>
<body>
<div align="center">
	<h3>로그인 성공</h3>
	<h3>${vo.mName }님은 ${vo.mAuth } 권한을 갖습니다.</h3>
	<button type="button" onclick="location.href='main.do'">홈으로</button>
</div>
</body>
</html>