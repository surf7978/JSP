<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../common/menu.jsp" />
<div align="center">
	<h1>로그인 결과</h1>
	<%= request.getParameter("id") %><br />
	<%= request.getParameter("pw") %><br />
	<%= request.getAttribute("msg") %><br />
	<!-- 자바코드 없애고 싶을때 jQuery문 사용 = EL표현식 -->
	입력한 아이디 : ${param.id } <br />
	입력한 패스워드 : ${param.pw } <br />
	입력한 메세지 : ${param.id }${msg } <br /> <!-- msg는 세션에 담긴 값이라 param. 없어도 됨 -->
</div>
</body>
</html>