<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 실패</title>
</head>
<jsp:include page="../common/menu.jsp"></jsp:include>
<body>
<div align="center">
	<h3>로그인 실패</h3>
	<h3>${param.mId }님이 존재하지 않거나 비밀번호가 틀렸습니다.</h3>
</div>
</body>
</html>