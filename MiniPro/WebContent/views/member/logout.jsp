<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:include page="../common/menu.jsp" />
<body>
<div align="center">
	<h3>${mid }님은 정상적으로 로그아웃 되었습니다.</h3>
	<button type="button" onclick="location.href='main.do'">홈으로</button><!-- 걍 바로 로그아웃되게 하는게 좋을 듯 -->
	 <!-- 이거 로그아웃 페이지 출력해도 logout메뉴는 안사라지는데 이거 누르면 다른 작업 진행되서 사라짐 -->
</div>
</body>
</html>